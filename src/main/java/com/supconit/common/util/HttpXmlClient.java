package com.supconit.common.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月18日 10:05:54
 * @Description:
 * @Version: 1.0.0
 */
public class HttpXmlClient {
    private static final Logger logger = LoggerFactory.getLogger(HttpXmlClient.class);
    /**
     * 返回请求接口回复的json数据
     * @param url
     * @param params
     * @return
     */
    public static String post(String url, Map<String, String> params) {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        String body = null;

        logger.info("create httppost:" + url);
        HttpPost post = postForm(url, params);
        body = invoke(httpclient, post);
        try {
            httpclient.close();
        } catch (final IOException ex) {
            logger.error("httpclient.close() throw ioexception=" + ex);
        }
        return body;
    }

    public static String get(String url) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String body = null;

        logger.info("create httpget:" + url);
        HttpGet get = new HttpGet(url);
//        get.setProtocolVersion(HttpVersion.HTTP_1_0);
        body = invoke(httpclient, get);

        try {
            httpclient.close();
        } catch (final IOException ex) {
            logger.error("httpclient.close() throw ioexception=" + ex);
        }

        return body;
    }


    private static String invoke(CloseableHttpClient httpclient, HttpUriRequest httpost) {
        HttpResponse response = sendRequest(httpclient, httpost);
        String body = paseResponse(response);
        return body;
    }

    private static String paseResponse(HttpResponse response) {
        logger.info("get response from http server..");
        HttpEntity entity = response.getEntity();
        logger.info("response status: " + response.getStatusLine());
        try {
            String charset = ContentType.getOrDefault(entity).getCharset().name();
            logger.info(charset);
        }catch (NullPointerException e) {
            e.printStackTrace();
            logger.error("charset is null");
        }

        String body = null;
        try {
            body = EntityUtils.toString(entity);
            logger.info(body);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return body;
    }

    private static HttpResponse sendRequest(CloseableHttpClient httpclient, HttpUriRequest httpost) {
        logger.info("execute post...");
        HttpResponse response = null;
        try {
            response = httpclient.execute(httpost);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private static HttpPost postForm(String url, Map<String, String> params){

        HttpPost httpost = new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList<>();

        if (params == null) {
            return httpost;
        }
        else
        {
            Set<String> keySet = params.keySet();

            for(String key : keySet) {
                nvps.add(new BasicNameValuePair(key, params.get(key)));
            }
            try {
                logger.info("set utf-8 form entity to httppost");
                httpost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            return httpost;
        }
    }

    public static void main(String[] args) {
        String s = get("https://www.sogou.com");
    }
}
