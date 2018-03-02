package com.lyj.test.GetImg;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @time:2018年3月1日下午2:31:07
 * @author:longyujia
 * @emial: longyujia@knowlegene.com
 */

public class GetImgFromHtml {

	/*
	 * <img id="MzImgExpPwd" alt="提示：请在下面输入图片校验码！"
	 * style="margin: 0; padding: 0; border: 0px none;float:left;"
	 * src="/CheckCodeYunSuan?currentTimeMillis=1519873999987"
	 * onclick="javascript:changeImage('MzImgExpPwd'); return false;" >
	 */

	public String GetHtml_002(String link) {
		URL url;
		String line;
		StringBuilder builder = new StringBuilder(); 
		try {
			url = new URL(link);
			BufferedReader reader=new BufferedReader(new InputStreamReader(url.openStream()));
			while((line = reader.readLine())!=null){
				builder.append(line);
//	            System.out.println(reader.readLine());
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			/**
			 * @time:2018年3月1日下午5:20:45
			 * @author:longyujia 
			 * @emial: longyujia@knowlegene.com
			 */
			e.printStackTrace();
		}
		
		System.out.println(builder);
		return builder.toString();
	}
	
	public String GetHtml_001(String link) {
		System.out.println("---BEGIN---");
		// String result = "";
		StringBuffer buffer = null;
		BufferedReader bufferedReader = null;
		InputStreamReader inputStreamReader = null;
		InputStream inputStream = null;
		HttpURLConnection httpUrlConn = null;

		// 建立get请求
		URL url;
		try {
			url = new URL(link);
			httpUrlConn = (HttpURLConnection) url.openConnection();
//			httpUrlConn.setDoInput(true);
//			httpUrlConn.setRequestMethod("POST");
			httpUrlConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; .NET CLR 3.0.04506)");  

			// 获取输入流
			inputStream = httpUrlConn.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			bufferedReader = new BufferedReader(inputStreamReader);

			// 从输入流读取结果
			buffer = new StringBuffer();
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				System.out.println(str);
				buffer.append(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (inputStreamReader != null) {
				try {
					inputStreamReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (httpUrlConn != null) {
				httpUrlConn.disconnect();
			}
		}

		System.out.println("---FINISHIED---");
		// return null;
//		System.out.println(buffer.toString());
		return buffer.toString();
	}

	public void HtmlFilter(String htmls){
		Pattern pattern = Pattern.compile("<img id=\"MzImgExpPwd\" alt=\"提示：请在下面输入图片校验码！\" style=\"margin: 0; padding: 0; border: 0px none;float:left;\" src=\"/CheckCodeYunSuan?currentTimeMillis=[\\s\\S]*\" onclick=\"javascript:changeImage('MzImgExpPwd');return false;\">");
		Matcher matcher = pattern.matcher(htmls);
		if(matcher.find()){
			for(int i=0; i<=matcher.groupCount(); i++){  
		        System.out.println(i+":"+matcher.group(i));  
		    }
		}
//		return matcher.toString();
	}
	
	public void SaveImg(String link, String savepath) {
		System.out.println("-----BEGIN-----");
		try {
			URL url = new URL(link);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			DataInputStream input = new DataInputStream(connection.getInputStream());
			DataOutputStream output = new DataOutputStream(new FileOutputStream(savepath));
			byte[] buffer = new byte[4096];
			int count = 0;
			while ((count = input.read(buffer)) > 0) { /*将输入流以字节的形式读取并写入buffer中 */
				output.write(buffer, 0, count);
			}
			output.close();
			input.close();
			connection.disconnect();
			System.out.println("-----SUCCESSED-----");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) throws IOException {
//		String link = "http://qyxy.baic.gov.cn/index.jsp";
		String link = "http://qyxy.baic.gov.cn/simple/dealSimpleAction!transport_ww.dhtml?fourth=fourth&sysid=0150008788304366b7d3903b5067bb8c&module=wzsy&styleFlag=sy";
		/*GetImgFromTest test_001 = new GetImgFromTest();
		String htmls = test_001.GetHtml(link);
		test_001.HtmlFilter(htmls);*/
//		System.out.println(System.currentTimeMillis());
		/*try {
			Document document = Jsoup.parse(new URL(link), 3000);
			GetImgFromTest test_001 = new GetImgFromTest();
			test_001.HtmlFilter(document.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		GetImgFromHtml test_001 = new GetImgFromHtml();
//		test_001.GetHtml_002(link);
		test_001.GetHtml_001(link);
	}
	
}
