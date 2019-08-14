package com.supconit.core.filter;

import com.supconit.core.config.AppContext;
import com.supconit.core.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月19日 10:39:55
 * @Description:
 * @Version: 1.0.0
 */
@Component
public class ThirdSessionAuthFilter extends OncePerRequestFilter {

    @Value("${jwt.header}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//    @Resource
//    private UserMapper userMapper;
    @Autowired
    private TokenUtils tokenUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        //获取请求头部分的Authorization
        String authHeader = request.getHeader(this.tokenHeader);
        String allowUrl = "/course/getAllCourseTotal,/user/getUserInfo," +
                "/course/getByDistrict,/driver/creatDriver";
        //如果请求路径为微信通知后台支付结果则不需要token（之后会在具体的controller中，对双方签名进行验证防钓鱼）
        String url = request.getRequestURI().substring(request.getContextPath().length());
        if (url.equals("/auth") || url.equals("/test") || url.contains("/test") || allowUrl.contains(url)) {
            chain.doFilter(request, response);
            return;
        }
        if (null == authHeader || !authHeader.startsWith("Bearer")) {
            throw new RuntimeException("非法访问用户");
        }
        // The part after "Bearer "
        final String thirdSessionId = authHeader.substring(tokenHead.length());
        String openid = "";
        try {
            openid = tokenUtils.getOpenid(thirdSessionId);
        } catch (Exception e) {
            throw new RuntimeException("用户身份已过期");
        }

//        String wxSessionObj = stringRedisTemplate.opsForValue().get(thirdSessionId);
//        if (StringUtils.isEmpty(wxSessionObj)) {
//            throw new RuntimeException("用户身份已过期");
//        }
        // 设置当前登录用户
        try (AppContext appContext = new AppContext(openid)) {
            chain.doFilter(request, response);
        }
    }
}
