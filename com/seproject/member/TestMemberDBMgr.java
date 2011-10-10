package com.seproject.member;

import com.seproject.meber.MemberDBMgr;

import junit.framework.Assert;
import junit.framework.TestCase;

public class TestMemberDBMgr extends TestCase {

	
	/**
	 * 每一個TestCase執行前此方法會被調用
	 */
	@Override
	protected void setUp() throws Exception {
	}
	
	/**
	 * 每一個TestCase結束前此方法會被調用
	 */
	@Override
	protected void tearDown() throws Exception {
		
	}

	public void testListOption() {
		int result = MemberDBMgr.listOption().size();
		Assert.assertEquals(5, result);
	}
	
}
