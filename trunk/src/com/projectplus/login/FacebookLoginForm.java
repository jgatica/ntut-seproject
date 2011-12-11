package com.projectplus.login;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class FacebookLoginForm extends ActionForm {

	public String accesstoken = "";
	public String uid = "";

	public String getAccesstoken() {
		return accesstoken;
	}

	public void setAccesstoken(String accesstoken) {
		this.accesstoken = accesstoken;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}
