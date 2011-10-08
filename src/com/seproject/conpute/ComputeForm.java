package com.seproject.conpute;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class ComputeForm extends ActionForm {
	
	private int op;			// 操作編號
	private double arg1;	
	private double arg2;
	
	public double getArg1() {
		return arg1;
	}
	public void setArg1(double arg1) {
		this.arg1 = arg1;
	}
	public double getArg2() {
		return arg2;
	}
	public void setArg2(double arg2) {
		this.arg2 = arg2;
	}
	public int getOp() {
		return op;
	}
	public void setOp(int op) {
		this.op = op;
	}
	
}
