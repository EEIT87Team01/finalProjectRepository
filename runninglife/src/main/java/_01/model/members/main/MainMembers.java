package _01.model.members.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import _01.model.city.CityDAO;
import _01.model.city.CityPK;
import _01.model.city.CityVO;
import _01.model.competence.CompetenceVO;
import _01.model.country.CountryDAO;
import _01.model.country.CountryVO;
import _01.model.emergencyRelation.EmergencyRelationVO;
import _01.model.location.LocationDAO;
import _01.model.location.LocationPK;
import _01.model.location.LocationVO;
import _01.model.members.MembersDAO;
import _01.model.members.MembersVO;

public class MainMembers {

	public static void main(String[] args) {
		//hibernateDAO test
		MembersDAO membersDAO = new MembersDAO();
		LocationDAO locationDAO = new LocationDAO();
		CityDAO cityDAO = new CityDAO();
		CountryDAO countryDAO = new CountryDAO();
		
		CountryVO countryVO = new CountryVO();
		CityPK cityPK = new CityPK();
		CityVO cityVO = new CityVO();
		LocationVO locationVO = new LocationVO();
		LocationPK locationPK = new LocationPK();
		
		CompetenceVO competenceVO = new CompetenceVO();
		MembersVO membersVO = new MembersVO();
		//insert or update
		//-------------
		String photoName = "chngstar.gif";
		File photo = new File("E:\\EEIT87-1P\\FinalProject\\images",photoName);
		InputStream fin = null;
		try {
			fin = new FileInputStream(photo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long flen = photo.length();
//		membersVO.setMemberID(memberID);
		membersVO.setFirstName("Allen");
		membersVO.setLastName("Jiang");
		membersVO.setNickname("喵");
		membersVO.setEmail("abc@gmail.com");
		membersVO.setGender("1");
		membersVO.setBirthday("2013-08-30");
		
		cityPK.setCountryID(countryDAO.selectOne("TWN"));
		cityPK.setCityID("TPE");
		cityVO.setCityID(cityPK);
		locationPK.setCityID(cityDAO.selectOne(cityPK));
		locationPK.setLocationID("777");
		locationVO.setLocationID(locationPK);
		locationVO.setLocationName("東京都");
		membersVO.setLocationID(locationVO);
	
		membersVO.setAddress("亞特蘭提斯");
		membersVO.setHeight(200.0);
		membersVO.setWeight(250.0);
//		membersBean.setPhoto(photo);
		competenceVO.setCompetenceID(1);
		membersVO.setCompetenceID(competenceVO);
		membersVO.setIdentityID("B987987987");
		membersVO.setEmergencyContact("Noya");
		membersVO.setEmergencyPhone("1987987987");
		EmergencyRelationVO eBean = new EmergencyRelationVO();
		eBean.setRelationID(10);
		membersVO.setEmergencyRelation(eBean);
		membersVO.setCreateDate("2015-09-21");
		membersVO.setLastOnlineDateTime("2015-10-25 12:30:00");
		
		membersDAO.insert(membersVO);
		//----------------

		
		//delete
//		membersDAO.delete("F349A8E2-DE67-4F70-838B-C099C687D57F");
		//selectOne
//		membersDAO.selectOne("F349A8E2-DE67-4F70-838B-C099C687D57F");
		//selectAll
//		membersDAO.selectAll();
		
		//Unit JDBC 架構 
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction tx = null;
//		try{
//			tx = session.beginTransaction();
//			
//			
//			tx.commit();
//		}catch(RuntimeException ex){
//			if (tx != null){
//				tx.rollback();
//				System.out.println("runtime error!");
//				throw ex;
//			}
//		} finally{
//			HibernateUtil.getSessionFactory().close();
//		}

	}

}
