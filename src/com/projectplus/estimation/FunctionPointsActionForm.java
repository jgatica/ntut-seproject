package com.projectplus.estimation;

import java.security.PublicKey;

import org.apache.struts.action.ActionForm;

@SuppressWarnings("serial")
public class FunctionPointsActionForm extends ActionForm{
	//-------------------------------------------------------will Cal Unadjusted Function Point
	// Measurement Parameter Count
	public int ILF; // Internal Logical File => number_of_files
	public int EIF; //External Logical File => number_of_external_interface
	public int EI; //External Input File => number_of_user_inputs
	public int EO; //External Output File => number_of_outputs
	public int EQ; //external Inquire File => number_of_inquires
	
	//Weighting Factor  --希望可以傳原來的值 ,但如果需要採用0,1,2的代號方式由後端來切換實際數值的話,到時候說一下 3q~ -- 
	public int ILF_WF;
	public int EIF_WF;
	public int EI_WF;
	public int EO_WF;
	public int EQ_WF; 
	//--------------------------------------------------------will Cal value adjustment factor
	//The ratings parameter is between 0 - 5
	public int f1; // Does the system require reliable backup and recovery?
	public int f2; // Are data communications required?
	public int f3; //Are there distributed processing functions?
	public int f4; // Is performance critical?
	public int f5; // Will the system run in a existing, heavily utilized operational environment?
	public int f6; //Does the system require on-line data entry?
	public int f7; // Does the on-line data entry require the input transaction to be built over multiple screens or operations?
	public int f8; // Are the master files updated on-line?
	public int f9; //Are the inputs, outputs, files or inquiries complex?
	public int f10;//Is the internal processing complex?
	public int f11;//Is the code designed to be reusable?
	public int f12;//Are conversion and installation included in the design?
	public int f13;//Is the system designed for multiple installations in different organizations?
	public int f14;// Is the application designed to facilitate change and ease of use by the user?
	
	//-------------------------------------------------------
	public int getILF() {
		return ILF;
	}
	public void setILF(int iLF) {
		ILF = iLF;
	}
	public int getEIF() {
		return EIF;
	}
	public void setEIF(int eIF) {
		EIF = eIF;
	}
	public int getEI() {
		return EI;
	}
	public void setEI(int eI) {
		EI = eI;
	}
	public int getEO() {
		return EO;
	}
	public void setEO(int eO) {
		EO = eO;
	}
	public int getEQ() {
		return EQ;
	}
	public void setEQ(int eQ) {
		EQ = eQ;
	}
	public int getILF_WF() {
		return ILF_WF;
	}
	public void setILF_WF(int iLF_WF) {
		ILF_WF = iLF_WF;
	}
	public int getEIF_WF() {
		return EIF_WF;
	}
	public void setEIF_WF(int eIF_WF) {
		EIF_WF = eIF_WF;
	}
	public int getEI_WF() {
		return EI_WF;
	}
	public void setEI_WF(int eI_WF) {
		EI_WF = eI_WF;
	}
	public int getEO_WF() {
		return EO_WF;
	}
	public void setEO_WF(int eO_WF) {
		EO_WF = eO_WF;
	}
	public int getEQ_WF() {
		return EQ_WF;
	}
	public void setEQ_WF(int eQ_WF) {
		EQ_WF = eQ_WF;
	}
	public int getF1() {
		return f1;
	}
	public void setF1(int f1) {
		this.f1 = f1;
	}
	public int getF2() {
		return f2;
	}
	public void setF2(int f2) {
		this.f2 = f2;
	}
	public int getF3() {
		return f3;
	}
	public void setF3(int f3) {
		this.f3 = f3;
	}
	public int getF4() {
		return f4;
	}
	public void setF4(int f4) {
		this.f4 = f4;
	}
	public int getF5() {
		return f5;
	}
	public void setF5(int f5) {
		this.f5 = f5;
	}
	public int getF6() {
		return f6;
	}
	public void setF6(int f6) {
		this.f6 = f6;
	}
	public int getF7() {
		return f7;
	}
	public void setF7(int f7) {
		this.f7 = f7;
	}
	public int getF8() {
		return f8;
	}
	public void setF8(int f8) {
		this.f8 = f8;
	}
	public int getF9() {
		return f9;
	}
	public void setF9(int f9) {
		this.f9 = f9;
	}
	public int getF10() {
		return f10;
	}
	public void setF10(int f10) {
		this.f10 = f10;
	}
	public int getF11() {
		return f11;
	}
	public void setF11(int f11) {
		this.f11 = f11;
	}
	public int getF12() {
		return f12;
	}
	public void setF12(int f12) {
		this.f12 = f12;
	}
	public int getF13() {
		return f13;
	}
	public void setF13(int f13) {
		this.f13 = f13;
	}
	public int getF14() {
		return f14;
	}
	public void setF14(int f14) {
		this.f14 = f14;
	}
	
}
