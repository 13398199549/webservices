package org.framestudy.webservices.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MessagerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5729531655800645358L;

	private boolean status;
	private Integer code;
	private String information;
	public MessagerBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public MessagerBean(boolean status, Integer code, String information) {
		super();
		this.status = status;
		this.code = code;
		this.information = information;
	}

	@XmlElement
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	@XmlElement
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	
	@XmlElement
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	
	@Override
	public String toString() {
		return "MessagerBean [status=" + status + ", code=" + code + ", information=" + information + "]";
	}
}
