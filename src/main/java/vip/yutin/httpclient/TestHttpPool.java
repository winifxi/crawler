package vip.yutin.httpclient;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class TestHttpPool {


    public static void main(String[] args) throws IOException {

        //创建连接池管理器

        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();

        //设置最大连接数
        cm.setMaxTotal(100);

        //设置每个主机的最大连接数，避免饥饿  主机:远程主机
        cm.setDefaultMaxPerRoute(10);

        doGet(cm);
        doGet(cm);


        //使用连接池发起请求

    }

    private static void doGet(PoolingHttpClientConnectionManager cm) throws IOException {
        //使用连接池中获取的client

        CloseableHttpClient client = HttpClients.custom().setConnectionManager(cm).build();

        HttpGet httpGet = new HttpGet("http://www.baidu.com");

        //配置请求信息
        RequestConfig config = RequestConfig.custom()   //建造者模式
                .setConnectTimeout(1000)    //创建连接的最大时间,ms
                .setConnectionRequestTimeout(500)  //设置获取连接的最长时间,ms
                .setSocketTimeout(10 * 1000)  //设置传输数据的最长时间,ms
                .build();
        httpGet.setConfig(config);

        CloseableHttpResponse response = client.execute(httpGet);


        if (response.getStatusLine().getStatusCode() ==200 ){
            String content = EntityUtils.toString(response.getEntity(), "utf8");
            System.out.println(content.length());
        }
        //省略connection的关闭
        //不能关闭client
    }

}
