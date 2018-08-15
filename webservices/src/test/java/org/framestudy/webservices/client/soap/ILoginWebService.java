package org.framestudy.webservices.client.soap;

import javax.jws.WebService;

@WebService(targetNamespace="http://soap.webservices.framestudy.org",serviceName="LoginWebService",portName="LoginWebServicePort")
public interface ILoginWebService {

	String meth01(String arg0,String arg1);
	
	String meth02(String arg0);
}
