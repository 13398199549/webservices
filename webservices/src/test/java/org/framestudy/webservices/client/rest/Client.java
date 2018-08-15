package org.framestudy.webservices.client.rest;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.junit.Test;

public class Client {

	
	
	
	
	@Test
	public void deleteCustomerInfoById() {
		DeleteMethod delete = new DeleteMethod("http://localhost/webservices/services/customermag/customers/67");
		handleHttpMethod(delete);
		try {
			String content = delete.getResponseBodyAsString();
			System.out.println(content);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void updateCustomerInfo() {
		PutMethod put = new PutMethod("http://localhost/webservices/services/customermag/customers/67");
		// 定义数据
		CustomerBean customer = new CustomerBean();
		customer.setCustomerName("葬爱家族");
		customer.setAge(15);
		customer.setGender(1);
		customer.setLoginName("zajz");
		customer.setPassword("123456");

		String xmls = "";
		try {
			// 将JAVA对象，转换成xml格式的字符串数据
			xmls = JAXBTools.java2Xml(CustomerBean.class, customer);
			System.out.println(xmls);

			// 使用输入流，将xml格式的字符串数据，转换成 请求实体类
			RequestEntity entity = new InputStreamRequestEntity(new ByteArrayInputStream(xmls.getBytes("UTF-8")));
			put.setRequestEntity(entity);
			handleHttpMethod(put);

			System.out.println(put.getResponseBodyAsString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void getCustomerInfoById() {
		GetMethod get = new GetMethod("http://localhost/webservices/services/customermag/customers/67");
		handleHttpMethod(get);
		try {
			String content = get.getResponseBodyAsString();
			System.out.println(content);
			CustomerBean customer = (CustomerBean) JAXBTools.xml2Java(CustomerBean.class, content);
			System.out.println(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void saveCustomerInfo() {
		PostMethod post = new PostMethod("http://localhost/webservices/services/customermag/customers/-1");
		// 定义数据
		CustomerBean customer = new CustomerBean();
		customer.setCustomerName("杀马特");
		customer.setAge(14);
		customer.setGender(1);
		customer.setLoginName("smt");
		customer.setPassword("123456");

		String xmls = "";
		try {
			// 将JAVA对象，转换成xml格式的字符串数据
			xmls = JAXBTools.java2Xml(CustomerBean.class, customer);
			System.out.println(xmls);

			// 使用输入流，将xml格式的字符串数据，转换成 请求实体类
			RequestEntity entity = new InputStreamRequestEntity(new ByteArrayInputStream(xmls.getBytes("UTF-8")));
			post.setRequestEntity(entity);
			handleHttpMethod(post);

			System.out.println(post.getResponseBodyAsString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 执行Http请求方法
	 * 
	 * @param method
	 */
	private static void handleHttpMethod(HttpMethod method) {
		// TODO Auto-generated method stub
		setMethodHeaders(method);
		HttpClient client = new HttpClient();
		int ret = 0;
		try {
			// 向后台发起Http请求
			ret = client.executeMethod(method);
			Response.Status status = Response.Status.fromStatusCode(ret);
			// 当返回等于200时
			if (status == Response.Status.OK) {
				System.out.println("调用后台接口成功");
			}
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 设置HTTP的请求头
	 */
	private static void setMethodHeaders(HttpMethod method) {
		if (method instanceof PostMethod || method instanceof PutMethod) {
			method.setRequestHeader("Content-Type", "application/xml;charset=UTF-8");
		}
		method.setRequestHeader("Accept", "application/xml;charset=UTF-8");
	}
}
