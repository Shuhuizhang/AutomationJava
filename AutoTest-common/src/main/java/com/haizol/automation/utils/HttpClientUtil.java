package com.haizol.automation.utils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @Classname HttpClientUtil
 * @Date 2019/10/16 22:51
 * @Created by StevenZsh
 * @Description TODO
 */
@Component
public class HttpClientUtil {

    private PoolingHttpClientConnectionManager cm;

    public HttpClientUtil(){
        cm = new PoolingHttpClientConnectionManager();

        this.cm.setMaxTotal(20);

        this.cm.setDefaultMaxPerRoute(10);
    }

    /**
     * 发送POST请求
     * @param url 请求地址
     * @param paramJson json 格式的请求参数
     * @return
     */
    public String doPost(String url,String paramJson){
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(this.cm).build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(this.getConfig());
        StringEntity requestEntity = new StringEntity(paramJson,"utf-8");
        requestEntity.setContentEncoding("UTF-8");

        httpPost.setHeader("Content-type", "application/json;charset=UTF-8");
        httpPost.setEntity(requestEntity);
        CloseableHttpResponse httpResponse = null;

        try {
            httpResponse = httpClient.execute(httpPost);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
                System.out.println(content);
                return "发送请求成功";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (httpResponse != null){
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "发送请求失败";

    }

    private RequestConfig getConfig() {

        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(1000)
                .setConnectionRequestTimeout(500)
                .setSocketTimeout(10000).build();
        return config;
    }


//    public static void main(String[] args) {
//        HttpClientUtil client = new HttpClientUtil();
//        String url = "http://localhost:9101/"+ "create_test_plan";
//        String param = "{\"hell\":\"fjloe\"}";
//        client.doPost(url, param);
//    }


}
