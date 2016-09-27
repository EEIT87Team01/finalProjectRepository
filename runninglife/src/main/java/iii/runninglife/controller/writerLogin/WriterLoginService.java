package iii.runninglife.controller.writerLogin;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iii.runninglife.globalservice.GlobalService;
import iii.runninglife.model.writer.WriterInterface;
import iii.runninglife.model.writer.WriterVO;
@Service
public class WriterLoginService implements WriterLoginService_Interface{

	WriterVO writerVO = new WriterVO();
	@Autowired
	WriterInterface writerDAO;
	@Autowired
	GlobalService globalservice;
	//管理者登入
	@Override
	public Map<String, Object> CheckPassword(String writerAccount, String password) {
		MessageDigest mDigest = null;
		try {
			mDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String message = null;
		byte[] insetPswd = null;
		Map<String ,Object> InfoMsg = new HashMap<String ,Object>();
		/***************************2.開始查詢資料*****************************************/
				//輸入帳號CO Hibernate
				writerVO = writerDAO.selectOne(writerAccount);
				//確認資料庫有此帳號
				if(writerVO != null){
					//轉碼
					insetPswd= globalservice.changeMD5Encoding(password);
					//取出byte[]
					for  (byte e : insetPswd) 
						System.out.print(e);
					//從DB取出
					byte[] dbPassword = writerVO.getPassword();
					//取出byte[]
					for  (byte e : dbPassword) 
						System.out.print(e);
												
					//確認密碼正確
					if(dbPassword != null && Arrays.equals(dbPassword, insetPswd)){
						writerVO.setWriterAccount(writerAccount);
						writerVO.setPassword(dbPassword);
						message = "登入成功";
						InfoMsg.put("Msg",message);
						InfoMsg.put("Info",writerVO);
					    
						return InfoMsg;
						/***************************其他可能的錯誤處理*************************************/
					}else{
						message = "密碼錯誤";
						InfoMsg.put("Msg",message);
						InfoMsg.put("Info",writerVO);
						return InfoMsg;
					}
				}else{
					message = "帳號不存在";
					InfoMsg.put("Msg",message);
					return InfoMsg;
				}
	}
	
	//作家放入Session
	@Override
	public WriterVO InsertWriter(Map<String ,Object> loginInfo){
		String writerAccount = null;
		writerAccount = ((WriterVO)loginInfo.get("Info")).getWriterAccount();
		writerVO = writerDAO.selectOne(writerAccount);
		return writerVO;
	}
	
	//新增作家
	public WriterVO CreateWriter(String writerAccount,String password,String name,String email,String address,String status) throws UnsupportedEncodingException{
			
		MessageDigest mDigest = null;
		try {
			mDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
			
		writerVO.setWriterAccount(writerAccount);
		byte[] temp = password.getBytes("UTF-8");	//明碼  //使用者輸入byte[]
		temp = mDigest.digest(temp); 		//亂碼
		writerVO.setPassword(temp);
		writerVO.setName(name);
		writerVO.setEmail(email);
		writerVO.setStatus(status);
		
		writerDAO.insert(writerVO);
		return writerVO;
		}
		
}
