package org.framestudy.webservices.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6636517368176729128L;
	
	private Long id;
	private String customerName;
	private String loginName;
	private String password;
	private Integer age;
	private Integer gender;
	public CustomerBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@XmlAttribute
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@XmlElement
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	@XmlElement
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	@XmlElement
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@XmlElement
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@XmlElement
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "CustomerBean [id=" + id + ", customerName=" + customerName + ", loginName=" + loginName + ", password="
				+ password + ", age=" + age + ", gender=" + gender + "]";
	}
}
