package com.xhx.webapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;
import java.util.Map;

import sun.misc.BASE64Decoder;


public class GetTest {
	final static String AuthorizationKey = "53a6423f321820d1729cc4460e6f01b3";

	public String testGet(String address) throws UnsupportedEncodingException {

		BASE64Decoder decoder = new BASE64Decoder();
		StringBuffer sb = new StringBuffer();

		//base64编码
		String basicEncoded = Base64.getEncoder().encodeToString(AuthorizationKey.getBytes("utf-8"));  
		try {
			
			URL url = new URL(address);
			URLConnection con = url.openConnection();

			//HEADER
			con.addRequestProperty("X-KAISAKU-Authorization", "NTNhNjQyM2YzMjE4MjBkMTcyOWNjNDQ2MGU2ZjAxYjM=");
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			con.connect();
            // 
			BufferedReader bw = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String line;
			while ((line = bw.readLine()) != null) {
				sb.append(line + "\n");
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
