package cn.wzz.util;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * @author houjq
 * @ClassName: HttpUtils
 * @Description: httpClient工具类
 * @date 2018年1月15日 下午3:56:38
 */
public class HttpUtils {
    /**
     * 将参数直接放到输出流
     *
     * @param
     * @return Exception
     */
    public static String httpPost(String url, String param) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);
        httppost.setEntity(new InputStreamEntity(new ByteArrayInputStream(param.getBytes())));
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity, StandardCharsets.UTF_8);
    }

    public static String httpGet(String url, Map<String, Object> params) throws Exception {
        if (params != null && !params.isEmpty()) {

            List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());

            for (String key : params.keySet()) {
                pairs.add(new BasicNameValuePair(key, params.get(key).toString()));
            }
            url += "?" + URLEncodedUtils.format(pairs, "UTF-8");
        }
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpclient.execute(httpGet);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            httpGet.abort();
            throw new RuntimeException("HttpClient,error status code :" + statusCode);
        }
        HttpEntity entity = response.getEntity();
        String result = null;
        if (entity != null) {
            result = EntityUtils.toString(entity, "utf-8");
            EntityUtils.consume(entity);
            response.close();
            return result;
        } else {
            return null;
        }
    }

    public static String httpGetElement(String url, String params) throws Exception {
        if (params != null && !params.isEmpty()) {
        	url += params;
        }
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpclient.execute(httpGet);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            httpGet.abort();
            throw new RuntimeException("HttpClient,error status code :" + statusCode);
        }
        HttpEntity entity = response.getEntity();
        String result = null;
        if (entity != null) {
            result = EntityUtils.toString(entity, "utf-8");
            EntityUtils.consume(entity);
            response.close();
            return result;
        } else {
            return null;
        }
    }

    public static String httpXMLPost(String url, String xmlData) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);
        httppost.setHeader("Content-type", "application/xml");
        StringEntity stringEntity = new StringEntity(xmlData, "UTF-8");
        stringEntity.setContentEncoding("UTF-8");
        httppost.setEntity(stringEntity);
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity, StandardCharsets.UTF_8);
    }
    public static String httpPost1(String url, String data) throws Exception {
    	CloseableHttpClient httpclient = HttpClients.createDefault();
    	HttpPost httppost = new HttpPost(url);
    	httppost.setHeader("Content-type", "application/json");
    	StringEntity stringEntity = new StringEntity(data, "UTF-8");
    	stringEntity.setContentEncoding("UTF-8");
    	httppost.setEntity(stringEntity);
    	HttpResponse response = httpclient.execute(httppost);
    	HttpEntity entity = response.getEntity();
    	return EntityUtils.toString(entity, StandardCharsets.UTF_8);
    }
}
