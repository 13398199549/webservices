package org.framestudy.webservices.rest.impl;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.framestudy.webservices.bean.CustomerBean;
import org.framestudy.webservices.bean.MessagerBean;
import org.framestudy.webservices.rest.ICustomerWebService;

public class CustomerWebServiceImpl implements ICustomerWebService {

	Map<Long,CustomerBean> customers = new HashMap<Long,CustomerBean>();

	@Override
	public Response saveCustomerInfo(CustomerBean customer) {
		// TODO Auto-generated method stub
		long id = (long) (Math.random() *1000);//得到1个3位数ID
		System.out.println(id);
		customer.setId(id);
		customers.put(id, customer);
		MessagerBean msg = new MessagerBean(true,0,"操作成功");
		return Response.ok(msg).build();
	}

	@Override
	public Response updateCustomerInfo(CustomerBean customer, Long id) {
		// TODO Auto-generated method stub
		customers.put(id, customer);
		MessagerBean msg = new MessagerBean(true,0,"操作成功");
		return Response.ok(msg).build();
	}

	@Override
	public Response deleteCustomerInfoById(Long id) {
		// TODO Auto-generated method stub
		if(customers.containsKey(id)) {
			customers.remove(id);
		}
		return Response.ok().build();
	}

	@Override
	public Response getCustomerInfoById(Long id) {
		// TODO Auto-generated method stub
		CustomerBean customer = null;
		if(customers.containsKey(id)) {
			customer = customers.get(id);
		}
		return Response.ok(customer).build();
	}

}
