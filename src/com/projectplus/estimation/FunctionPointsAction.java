package com.projectplus.estimation;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.projectplus.project.ProjectActionForm;
import com.projectplus.util.JSONWriter;

public class FunctionPointsAction extends Action{
	public static final int CAL_FUNTIONPOINTS = 0;
	
	
	public ActionForward execute(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		FunctionPointsActionForm form = (FunctionPointsActionForm)actionForm;
		return calculatePoints(mapping, form, request, response, session);
	
		//return null;
	}
	
	
	private ActionForward calculatePoints(ActionMapping mapping,
			FunctionPointsActionForm form, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		
		//1.先計算未調整功能點UDP
		int UDF = (form.EI * form.EI_WF) + (form.EIF *form.EIF_WF) + (form.EO *form.EO_WF) + (form.EQ * form.EQ_WF) ;
		System.out.println("VAF = " + String.valueOf(UDF));
		//2.再計算數值調整因子VAF 透過14個通用系統特性GSC’s
		double VAF = 0.65 + (double)(form.f1 + form.f2 + form.f3 + form.f4 + form.f5 + form.f6 + form.f7 + form.f8 + form.f9 +form.f10 +form.f11+form.f12 +form.f13 +form.f14) /100;
		System.out.println("VAF = " + String.valueOf(VAF));
		//3.Function points(FP) = UAF *VAF
		int FP = UDF * (int)VAF;
		System.out.println("FP = " + String.valueOf(FP));
		FunctionPointsDataStructure functionPointsDataStructure = new FunctionPointsDataStructure();
		functionPointsDataStructure.setUDF(UDF);
		functionPointsDataStructure.setVAF(VAF);
		functionPointsDataStructure.setFP(FP);
		
		try {
			JSONWriter.sendJSONResponse(response, functionPointsDataStructure);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		// TODO Auto-generated method stub

	}
	
}
