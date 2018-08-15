package org.framestudy.webservices.client.soap;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.junit.Before;
import org.junit.Test;

public class LoginWebServiceTest {

	private static final QName SERVICE_NAME = new QName("http://soap.webservices.framestudy.org", "LoginWebService");
	private static final QName PORT_NAME = new QName("http://soap.webservices.framestudy.org", "LoginWebServicePort");
	String endpointAddress = "http://localhost/webservices/services/loginService";
	private ILoginWebService loginWebServiceImpl;
	
	
	@Before
	public void before() {
		//与后台服务器建立连接对象
		Service service = Service.create(SERVICE_NAME);
		service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
		//通过连接对象，与本地的接口建立代理关系
		loginWebServiceImpl = service.getPort(ILoginWebService.class);
	}
	
	@Test
	public void meth01() {
		System.out.println(loginWebServiceImpl.meth02("小明"));
	}

	@Test
	public void meth02() {
		System.out.println(loginWebServiceImpl.meth01("xiaoming", "123456"));
	}

}
