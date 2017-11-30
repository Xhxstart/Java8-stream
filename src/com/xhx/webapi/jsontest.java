package com.xhx.webapi;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class jsontest {

	private static String url = "http://WIN2012SRV/kaisakuapi/v1/formats/000000005/reports/000000001.json ";
	private static String urlpost = "http://WIN2012SRV/kaisakuapi/v1/formats/000000005";
	private static String AuthorizationKey = "53a6423f321820d1729cc4460e6f01b3";

	private static InputStream GetInputStream() {
		InputStream is = null;
		String path = System.getProperty("user.dir")
				+ "\\json\\000000022.json";
		try {
			is = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return is;

	}

	public static void main(String[] args) throws JsonParseException,
			JsonMappingException, IOException {
		// TODO Auto-generated method stub

		//String rsp = httpGetRequest(url);

		String postresult = doHttpPost(GetInputStream(),urlpost);
		/*
		 * String path =
		 * System.getProperty("user.dir")+"\\json\\ajax_demo_children2.json";
		 * File file=new File(path);// 打开文件
		 *//**
		 * ObjectMapper支持从byte[]、File、InputStream、字符串等数据的JSON反序列化。
		 */
		/*
		 * ObjectMapper mapper = new ObjectMapper();
		 * 
		 * JavaType javaType =
		 * mapper.getTypeFactory().constructParametricType(List.class,JsonData.class); //如果是Map类型
		 * mapper.getTypeFactory().constructParametricType(HashMap.class,String.class, Bean.class); 
		 * List<JsonData> lst =　(List<JsonData>)mapper.readValue(file, javaType);
		 */
		System.out.println(postresult);
	}

	public static String httpGetRequest(String req_url)
			throws UnsupportedEncodingException {
		StringBuffer buffer = new StringBuffer();
		// base64编码
		String Key = Base64.getEncoder().encodeToString(
				AuthorizationKey.getBytes("utf-8"));
		try {
			URL url = new URL(req_url);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url
					.openConnection();

			httpUrlConn.setDoOutput(false);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);

			httpUrlConn.setRequestMethod("GET");
			httpUrlConn.setRequestProperty("X-KAISAKU-Authorization", Key);

			httpUrlConn.connect();

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(
					inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		return buffer.toString();
	}

	/**
	 * 发送Http post请求
	 * 
	 * @param xmlInfo
	 *            json转化成的字符串
	 * @param URL
	 *            请求url
	 * @return 返回信息
	 */
	public static String doHttpPost(InputStream xmlInfo, String URL) {

		// 1.获得一个httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 2.生成一个post请求
		HttpResponse response = null;
		HttpPost httpPost = new HttpPost(URL);
		String enCodedKey = Base64.getEncoder().encodeToString(
				AuthorizationKey.getBytes());
		try {
			httpPost.setHeader("X-KAISAKU-Authorization", enCodedKey);
			httpPost.setHeader("Accept", "application/json, text/plain, */*");
			httpPost.setHeader("Content-Type", "application/json");
			InputStreamEntity isEntity = new InputStreamEntity(xmlInfo);
			httpPost.setEntity(isEntity);

			response = httpclient.execute(httpPost);
			
			System.out.println(response.getStatusLine().getStatusCode() );
			System.out.println(response.getEntity().toString());
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		// 4.处理结果，这里将结果返回为字符串
		HttpEntity entity = response.getEntity();
		String result = null;
		try {
			result = EntityUtils.toString(entity);
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
		return result;

	}

}
