package com.supconit.common.util;


import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

/**
 * @Author: chenxuankai
 * @Date: 2019年07月18日 10:02:43
 * @Description:
 * @Version: 1.0.0
 */
public class XcxQRCode {

    static String  APPID = "wx29b9b27213275f5f";//小程序的appid
    static String  SECRET = "0a73e6497892b384ebd76fee9684f6c7";//小程序的secret
    /**
     * 生成二维码
     * Folder：文件夹路径
     * xcxUrl：小程序地址 必须已发布的小程序
     * @param folder
     * @param xcxUrl
     * @return
     */
    public static Object QRCode(String folder,String xcxUrl) {

        String accessToken = getAccessToken();//获取ACCESS_TOKEN
        String name = getQrCode(accessToken,folder,xcxUrl,300);
        System.out.println(name);
        return name;
    }

    public static String getAccessToken() {
        String requestStr = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=SECRET";
        requestStr = requestStr.replace("APPID",  APPID);
        requestStr = requestStr.replace("SECRET",SECRET);
        String oauth2_Token = HttpXmlClient.get(requestStr);
//        jsonObject = JSONObject.fromObject(oauth2_Token);
        JSONObject jsonObject = JSONObject.parseObject(oauth2_Token);
        return jsonObject.getString("access_token");
    }

    public static String getQrCode(String accessToken,String folder,String xcxPath,int width) {
        String createWxQrCodeStr = "https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token="+accessToken;
        InputStream is = postInputStream(createWxQrCodeStr, "{\"path\":\""+xcxPath+"\",\"width\":"+width+"}");
        String name = System.currentTimeMillis()+".png";
        int i = saveToImgByInputStream(is, folder, name);
        if(i==1) {
            return folder + "/" + name;
        }
        try {
            return null;
        }  catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 发送HttpPost请求 返回流
     *
     * @param strURL
     *            服务地址
     * @param params
     *            json字符串,例如: "{ \"id\":\"12345\" }" ;其中属性名必须带双引号<br/>
     * @return 成功:返回json字符串<br/>
     */
    public static InputStream postInputStream(String strURL, String params) {
        try {
            URL url = new URL(strURL);// 创建连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("POST"); // 设置请求方式
            connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
            connection.connect();
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8编码
            out.append(params);
            out.flush();
            out.close();
            InputStream is = connection.getInputStream();
            return is;

        } catch (IOException e) {

            e.printStackTrace();
        }
        return null; // 自定义错误信息
    }
    /**
     * 将二进制转换成文件保存
     * @param instreams 二进制流
     * @param imgPath 图片的保存路径
     * @param imgName 图片的名称
     * @return
     *      1：保存正常
     *      0：保存失败
     */
    public static int saveToImgByInputStream(InputStream instreams,String imgPath,String imgName){
        int stateInt = 1;
        if(instreams != null){
            try {
                createDir(imgPath);
                File file=new File(imgPath,imgName);//可以是任何图片格式.jpg,.png等
                FileOutputStream fos=new FileOutputStream(file);
                byte[] b = new byte[1024];
                int nRead = 0;
                while ((nRead = instreams.read(b)) != -1) {
                    fos.write(b, 0, nRead);
                }
                fos.flush();
                fos.close();
            } catch (Exception e) {
                stateInt = 0;
                e.printStackTrace();
            } finally {
            }
        }
        return stateInt;
    }
    /**
     * 创建文件夹
     *
     * @param destDirName
     * @return
     */
    public static boolean createDir(String destDirName) {
        try {
            destDirName = URLDecoder.decode(destDirName, "GB2312");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        File dir = new File(destDirName);
        if (dir.exists()) {
            System.out.println("创建目录" + destDirName + "失败，目标目录已经存在");
            return false;
        }
        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }
        // 创建目录
        if (dir.mkdirs()) {
            System.out.println("创建目录:" + destDirName + "成功！");
            return true;
        } else {
            System.out.println("创建目录:" + destDirName + "失败！");
            return false;
        }
    }

    public static void main(String[] args) {
        QRCode("d:/wechat/qrCode","pages/index/index");
    }

}
