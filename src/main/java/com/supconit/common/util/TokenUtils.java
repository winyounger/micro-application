package com.supconit.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: chenxuankai
 * @Date: 2019/7/19
 * @Description:
 * @Version: 1.0.0
 */
@Component
public class TokenUtils {

    public String TOKEN_SECRET = "micro_app";
    public String TOKEN_ISSUER = "micro";
    public String TOKEN_SUBJECT = "system admin operator";
    public String TOKEN_CLAIM= "user_name";


    public String createToken(String openid,Date expiresAt) throws Exception{
        Algorithm algorithmHS = Algorithm.HMAC256(TOKEN_SECRET);
        String token = JWT.create()
                .withIssuer(TOKEN_ISSUER).withIssuedAt(new Date())
                .withSubject(TOKEN_SUBJECT).withExpiresAt(expiresAt)
                .withClaim(TOKEN_CLAIM, openid)
                .sign(algorithmHS);
        return token;
    }


    public  String getOpenid(String token) throws Exception{
        DecodedJWT decodedJWT = JWT.decode(token);
        Claim claim = decodedJWT.getClaim(TOKEN_CLAIM);
        String openid = claim.asString();
        if (System.currentTimeMillis() > decodedJWT.getExpiresAt().getTime()) {
            throw new Exception(openid + " token expired!");
        }
        return  openid;
    }

/*    public static void main(String[] args) throws Exception{
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzeXN0ZW0gYWRtaW4gb3BlcmF0b3IiLCJ1c2VyX25hbWUiOiIxODc1ODEyNzMwMiIsImlzcyI6ImZhbmJlaSIsImV4cCI6MTUyNzY3NjA0NiwiaWF0IjoxNTI3NjY4ODQ2fQ.eajFcAowZBmWFxHKCyD-IWKey4Fxqkwx-rryWBAVUh0";
        TokenUtils tokenUtils = new TokenUtils();
        String userName = tokenUtils.getUserName(token);
    }*/
}
