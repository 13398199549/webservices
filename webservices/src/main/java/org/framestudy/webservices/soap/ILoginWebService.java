package org.framestudy.webservices.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
/**
 * 使用@WebService注解，将该接口声明成WEB 服务接口
 * @author puxubo
 *
 */

@WebService(targetNamespace="http://soap.webservices.framestudy.org",serviceName="LoginWebService",portName="LoginWebServicePort")
public interface ILoginWebService {
	
	@WebMethod(operationName="meth01")
	String login(String loginName,String password);
	@WebMethod(operationName="meth02")
	String hello(String userName);
	
	
	
}
