package vip.yutin.httpclient;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class TestHttpGetPost {

    public static void main(String[] args) throws IOException, URISyntaxException {
        //sendPostWithParam();
       // sendGetWithParam();
    }


    private static void sendGetWithParam() throws URISyntaxException, IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        URIBuilder uriBuilder = new URIBuilder("http://");
        //设置请求参数
        uriBuilder.setParameter("第一个参数", "值").setParameter("第二个参数", "值");
        //创建Get请求对象
        HttpGet httpGet = new HttpGet(uriBuilder.build());

        CloseableHttpResponse response = null;

        try {
            response = client.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "utf8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            response.close();
            client.close();
        }
    }


    private static void sendPostWithParam() throws IOException {
        //创建Http客户端和post请求
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://");

        //创建表单数据
        ArrayList<NameValuePair> params = new ArrayList<>();
        params.add(
                new BasicNameValuePair("参数","值")
        );

        //第一个参数是封装好的表单数据
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, "utf8");

        //给post请求设置请求体
        httpPost.setEntity(formEntity);

        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpPost);

            if (response.getStatusLine().getStatusCode() == 200 ){
                EntityUtils.toString(response.getEntity(),"utf8");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            response.close();
            client.close();
        }
    }
}
