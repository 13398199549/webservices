package org.framestudy.webservices.soap.impl;

import javax.jws.WebService;

import org.framestudy.webservices.soap.ILoginWebService;

@WebService(endpointInterface="org.framestudy.webservices.soap.ILoginWebService")
public class LoginServiceImpl implements ILoginWebService {

	@Override
	public String login(String loginName, String password) {
		// TODO Auto-generated method stub
		return loginName + "，登录成功！";
	}

	@Override
	public String hello(String userName) {
		// TODO Auto-generated method stub
		return userName + "，你好！";
	}

}
