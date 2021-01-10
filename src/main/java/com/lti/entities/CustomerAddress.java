package com.lti.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerAddress {

	private CustomerInfo customerId;
	private String cAddressLine1;
	private String pAddressLine1;
	private String cAddressLine2;
	private String pAddressLine2;
	private String cLandMark;
	private String pLandMark;
	private String cCity;
	private String pCity;
	private String cState;
	private String pState;
	private int cPincode;
	private int pPincode;

	public CustomerAddress() {

	}

	public CustomerAddress(CustomerInfo customerId, String cAddressLine1, String pAddressLine1, String cAddressLine2,
			String pAddressLine2, String cLandMark, String pLandMark, String cCity, String pCity, String cState,
			String pState, int cPincode, int pPincode) {
		super();
		this.customerId = customerId;
		this.cAddressLine1 = cAddressLine1;
		this.pAddressLine1 = pAddressLine1;
		this.cAddressLine2 = cAddressLine2;
		this.pAddressLine2 = pAddressLine2;
		this.cLandMark = cLandMark;
		this.pLandMark = pLandMark;
		this.cCity = cCity;
		this.pCity = pCity;
		this.cState = cState;
		this.pState = pState;
		this.cPincode = cPincode;
		this.pPincode = pPincode;
	}

	public CustomerInfo getCustomerId() {
		return customerId;
	}

	public void setCustomerId(CustomerInfo customerId) {
		this.customerId = customerId;
	}

	public String getcAddressLine1() {
		return cAddressLine1;
	}

	public void setcAddressLine1(String cAddressLine1) {
		this.cAddressLine1 = cAddressLine1;
	}

	public String getpAddressLine1() {
		return pAddressLine1;
	}

	public void setpAddressLine1(String pAddressLine1) {
		this.pAddressLine1 = pAddressLine1;
	}

	public String getcAddressLine2() {
		return cAddressLine2;
	}

	public void setcAddressLine2(String cAddressLine2) {
		this.cAddressLine2 = cAddressLine2;
	}

	public String getpAddressLine2() {
		return pAddressLine2;
	}

	public void setpAddressLine2(String pAddressLine2) {
		this.pAddressLine2 = pAddressLine2;
	}

	public String getcLandMark() {
		return cLandMark;
	}

	public void setcLandMark(String cLandMark) {
		this.cLandMark = cLandMark;
	}

	public String getpLandMark() {
		return pLandMark;
	}

	public void setpLandMark(String pLandMark) {
		this.pLandMark = pLandMark;
	}

	public String getcCity() {
		return cCity;
	}

	public void setcCity(String cCity) {
		this.cCity = cCity;
	}

	public String getpCity() {
		return pCity;
	}

	public void setpCity(String pCity) {
		this.pCity = pCity;
	}

	public String getcState() {
		return cState;
	}

	public void setcState(String cState) {
		this.cState = cState;
	}

	public String getpState() {
		return pState;
	}

	public void setpState(String pState) {
		this.pState = pState;
	}

	public int getcPincode() {
		return cPincode;
	}

	public void setcPincode(int cPincode) {
		this.cPincode = cPincode;
	}

	public int getpPincode() {
		return pPincode;
	}

	public void setpPincode(int pPincode) {
		this.pPincode = pPincode;
	}

	@Override
	public String toString() {
		return "CustomerAddress [customerId=" + customerId + ", cAddressLine1=" + cAddressLine1 + ", pAddressLine1="
				+ pAddressLine1 + ", cAddressLine2=" + cAddressLine2 + ", pAddressLine2=" + pAddressLine2
				+ ", cLandMark=" + cLandMark + ", pLandMark=" + pLandMark + ", cCity=" + cCity + ", pCity=" + pCity
				+ ", cState=" + cState + ", pState=" + pState + ", cPincode=" + cPincode + ", pPincode=" + pPincode
				+ "]";
	}

}
