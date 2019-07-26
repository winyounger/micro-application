package com.supconit.core.util;

import com.alibaba.druid.util.StringUtils;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    public String TOKEN_CLAIM= "openid";
    public String TOKEN_USERID = "userId";
    public String TOKEN_USERNAME = "userName";


    public String createToken(String openid,Long userId,String userName,Date expiresAt) throws Exception{
        Algorithm algorithmHS = Algorithm.HMAC256(TOKEN_SECRET);
        String token = JWT.create()
                .withIssuer(TOKEN_ISSUER).withIssuedAt(new Date())
                .withSubject(TOKEN_SUBJECT).withExpiresAt(expiresAt)
                .withClaim(TOKEN_CLAIM, openid)
                .withClaim(TOKEN_USERID, userId)
                .withClaim(TOKEN_USERNAME, userName)
                .sign(algorithmHS);
        return token;
    }


    public String getOpenid(String token) throws Exception{
        DecodedJWT decodedJWT = JWT.decode(token);
        Claim claim = decodedJWT.getClaim(TOKEN_CLAIM);
        String openid = claim.asString();
        if (System.currentTimeMillis() > decodedJWT.getExpiresAt().getTime()) {
            throw new Exception(openid + " token expired!");
        }
        return  openid;
    }

    /**
     * 获取userName
     *
     * @param token
     * @return
     */
    public String getUserInfoFromToken(String token, String tokenSecret, String claimName) {
        String value = null;
        if (StringUtils.isEmpty(token)) {
            return value;
        }
        Map<String, Claim> claims = verifyToken(token, tokenSecret);
        Claim claim = claims.get(claimName);

        if (null != claim) {
            value = claim.asString();
        }
        return value;
    }

    /**
     * 解密Token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public Map<String, Claim> verifyToken(String token, String tokenSecret) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(tokenSecret)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (null == jwt) ? new HashMap<>(1) : jwt.getClaims();
    }

    public Long getUserId(String token) {
        String userId = getUserInfoFromToken(token,TOKEN_SECRET,TOKEN_USERID);
        if(StringUtils.isEmpty(userId)){
            return 0l;
        }else{
            return Long.valueOf(userId);
        }
    }

/*    public static void main(String[] args) throws Exception{
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzeXN0ZW0gYWRtaW4gb3BlcmF0b3IiLCJ1c2VyX25hbWUiOiIxODc1ODEyNzMwMiIsImlzcyI6ImZhbmJlaSIsImV4cCI6MTUyNzY3NjA0NiwiaWF0IjoxNTI3NjY4ODQ2fQ.eajFcAowZBmWFxHKCyD-IWKey4Fxqkwx-rryWBAVUh0";
        TokenUtils tokenUtils = new TokenUtils();
        String userName = tokenUtils.getUserName(token);
    }*/
}
