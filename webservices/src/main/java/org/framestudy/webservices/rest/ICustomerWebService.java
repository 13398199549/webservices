package org.framestudy.webservices.rest;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.framestudy.webservices.bean.CustomerBean;

@Path("/customers")
public interface ICustomerWebService {
	/**
	 * 新增
	 * @param customer
	 * @return
	 */
	@POST
	@Path("/{id}")
	Response saveCustomerInfo(CustomerBean customer);
	/**
	 * 修改
	 * @param customer
	 * @param id
	 * @return
	 */
	@PUT
	@Path("/{id}")
	Response updateCustomerInfo(CustomerBean customer,@PathParam("id") Long id);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/{id}")
	Response deleteCustomerInfoById(@PathParam("id") Long id);
	
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id}")
	Response getCustomerInfoById(@PathParam("id") Long id);
	
	
	
	
}
