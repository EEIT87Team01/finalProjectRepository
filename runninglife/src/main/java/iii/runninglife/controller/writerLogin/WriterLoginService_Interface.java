package iii.runninglife.controller.writerLogin;

import java.util.Map;

import iii.runninglife.model.writer.WriterVO;

public interface WriterLoginService_Interface {
	public Map<String ,Object> CheckPassword(String wirterAccount,String password);
	public WriterVO InsertWriter(Map<String ,Object> loginInfo);
}
