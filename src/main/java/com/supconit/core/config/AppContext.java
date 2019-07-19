package com.supconit.core.config;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月19日 10:44:32
 * @Description:
 * @Version: 1.0.0
 */
public class AppContext implements AutoCloseable {

    private static final ThreadLocal<String> CURRENT_CONSUMER_WECHAT_OPENID = new ThreadLocal<>();

    @Override
    public void close() {
        CURRENT_CONSUMER_WECHAT_OPENID.remove();
    }

    public AppContext(String wechatOpenid) {
        CURRENT_CONSUMER_WECHAT_OPENID.set(wechatOpenid);
    }

    public static String getCurrentUserWechatOpenId() {
        return CURRENT_CONSUMER_WECHAT_OPENID.get();
    }


}
