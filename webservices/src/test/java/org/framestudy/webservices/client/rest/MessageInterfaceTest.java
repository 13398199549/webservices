package org.framestudy.webservices.client.rest;

import java.io.IOException;

import javax.ws.rs.core.Response;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.junit.Test;

public class MessageInterfaceTest {

	@Test
	public void testSendMessage() {
	
		/*	
	 * GetMethod get = new GetMethod("https://way.jd.com/turing/turing");
		NameValuePair mes01 = new NameValuePair("info", "冷笑话");
		NameValuePair mes02 = new NameValuePair("loc", "四川成都市");
		NameValuePair mes03 = new NameValuePair("userid", "222");
		NameValuePair mes04 = new NameValuePair("appkey", "bd536f5d104dfde585e4aac97693b7be");

		get.setQueryString(new NameValuePair[]{mes01,mes02,mes03,mes04});
		//执行方法的提交
		handleHttpMethod(get);
		
		try {
			System.out.println(get.getResponseBodyAsString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		//创建一个POST的请求对象
		PostMethod post = new PostMethod("https://way.jd.com/turing/turing");
		NameValuePair mes01 = new NameValuePair("info", "冷笑话");
		NameValuePair mes02 = new NameValuePair("loc", "四川成都市");
		NameValuePair mes03 = new NameValuePair("userid", "222");
		NameValuePair mes04 = new NameValuePair("appkey", "bd536f5d104dfde585e4aac97693b7be");
		
		post.setRequestBody(new NameValuePair[]{mes01,mes02,mes03,mes04});
		//执行方法的提交
		handleHttpMethod(post);
		try {
			System.out.println(post.getResponseBodyAsString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void handleHttpMethod(HttpMethod method) {
		// TODO Auto-generated method stub
		HttpClient client = new HttpClient();
		int ret = 0;
		try {
			ret = client.executeMethod(method);
			Response.Status status = Response.Status.fromStatusCode(ret);
			//当返回等于200时
			if(status == Response.Status.OK){
				System.out.println("Authorication true");
			}else if(status == Response.Status.FORBIDDEN){
				System.out.println("Authorication failure");
			}
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
