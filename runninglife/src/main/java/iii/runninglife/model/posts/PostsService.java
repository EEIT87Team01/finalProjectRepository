package iii.runninglife.model.posts;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import iii.runninglife.globalservice.GlobalService;
import iii.runninglife.model.goodstatus.GoodStatusDAO;
import iii.runninglife.model.goodstatus.GoodStatusPK;
import iii.runninglife.model.goodstatus.GoodStatusService;
import iii.runninglife.model.goodstatus.GoodStatusVO;
import iii.runninglife.model.members.MembersInterface;
import iii.runninglife.model.members.MembersVO;
import iii.runninglife.model.reportlist.ReportListService;
import iii.runninglife.model.reportlist.ReportListVO;

@Service
public class PostsService {

	@Autowired
	GlobalService glovbalService;
	@Autowired
	ReportListService reportListService;
	@Autowired
	private PostsDAO_interface postsDAO;
	@Autowired
	GoodStatusService goodStatusService;
	@Autowired
	private MembersInterface mdao;
	
	static MembersVO membersVO = new MembersVO();
	static PostsVO postsVO = new PostsVO();
	static PostsVO postsVO2 = new PostsVO();
	static GoodStatusPK goodStatusPK = new GoodStatusPK();
	static GoodStatusVO goodStatusVO = new GoodStatusVO();
	static GoodStatusDAO goodStatusDAO = new GoodStatusDAO();

	
	
	public PostsVO newPosts(String postMemberID, String content, String imgPath) {
		String postID = glovbalService.findMaxSeq("postID", new PostsVO());
		membersVO = mdao.selectOne(postMemberID);
		postsVO.setPostID(postID);
		postsVO.setPostMemberID(membersVO);
		postsVO.setTime(new Timestamp(System.currentTimeMillis()));
		postsVO.setContent(content);
		postsVO.setGood(0);
		postsVO.setStatus("1");
		postsVO.setResponsed("0");
		postsVO.setParent(null);
		postsVO.setImgPath(imgPath);
		postsDAO.insert(postsVO);
		return postsVO;
	}

	public PostsVO newPostsWithImages(String postMemberID, String content, String imgPath, ArrayList<String> list,String contextPath) {
		String postID = glovbalService.findMaxSeq("postID", new PostsVO());
		String contentTemplate = null;
		switch (list.size()) {
		case 1:
			contentTemplate = "<div class='col-md-12'>" + content + "</div>"
					+ "<div class='col-md-12' style=';text-align:center'><img src="+contextPath+"/photoController/getPhoto.do?photoID="
					+ list.get(0) + " " + "style='width:40%' /></div>";
			break;
		case 2:
			contentTemplate = "<div class='col-md-12'>" + content + "</div>"
					+ "<div class='col-md-6' style='padding:0px;text-align:right'><img src="+contextPath+"/photoController/getPhoto.do?photoID="
					+ list.get(0) + " style='width:65%' /></div>"
					+ "<div class='col-md-6' style='padding:0px;'><img src="+contextPath+"/photoController/getPhoto.do?photoID="
					+ list.get(1) + " " + "style='width:65%' /></div>";
			break;
		case 3:
			contentTemplate = "<div class='col-md-12'>" + content + "</div>" + "<div class='col-md-12'>"
					+ "<div class='col-md-6' style='padding:0px;text-align:right'><img src="+contextPath+"/photoController/getPhoto.do?photoID="
					+ list.get(0) + " " + "style='width:70%' /></div>"
					+ "<div class='col-md-6' style='padding:0px;'><img src="+contextPath+"/photoController/getPhoto.do?photoID="
					+ list.get(1) + " "
					+ "style='width:51%' /><img src="+contextPath+"/photoController/getPhoto.do?photoID=" + list.get(2)
					+ " " + "style='width:51%' /></div>" + "</div>";
			break;
		case 4:
			contentTemplate = "<div class='col-md-12'>" + content + "</div>" + "<div class='col-md-12'>"
					+ "<div class='col-md-6' style='padding:0px;text-align:right'><img src="+contextPath+"/photoController/getPhoto.do?photoID="
					+ list.get(0) + " "
					+ "style='width:51%' /><img src="+contextPath+"/photoController/getPhoto.do?photoID=" + list.get(1)
					+ " " + "style='width:51%' /></div>"
					+ "<div class='col-md-6' style='padding:0px;'><img src="+contextPath+"/photoController/getPhoto.do?photoID="
					+ list.get(2) + " "
					+ "style='width:51%' /><img src="+contextPath+"/photoController/getPhoto.do?photoID=" + list.get(3)
					+ " " + "style='width:51%' /></div>" + "</div>";
			break;
		}
		membersVO = mdao.selectOne(postMemberID);
		postsVO.setPostID(postID);
		postsVO.setPostMemberID(membersVO);
		postsVO.setTime(new Timestamp(System.currentTimeMillis()));
		postsVO.setContent(contentTemplate);
		postsVO.setGood(0);
		postsVO.setStatus("1");
		postsVO.setResponsed("0");
		postsVO.setParent(null);
		postsVO.setImgPath(imgPath);
		postsDAO.insert(postsVO);
		return postsVO;
	}

	public PostsVO deletePosts(String postMemberID, String postID) {
		postsVO = postsDAO.findByPrimaryKey(postID);
		postsVO.setPostID(postID);
		postsVO.setPostMemberID(postsVO.getPostMemberID());
		postsVO.setTime(postsVO.getTime());
		postsVO.setContent(postsVO.getContent());
		postsVO.setGood(postsVO.getGood());
		postsVO.setStatus("0");
		postsVO.setParent(postsVO.getParent());
		postsVO.setResponsed((postsVO.getResponsed()));
		postsDAO.update(postsVO);
		postsDAO.changeStatus(postsVO);
		return postsVO;
	}

	public PostsVO updatePosts(String postID, String content) {
		postsVO = postsDAO.findByPrimaryKey(postID);
		postsVO.setPostID(postID);
		postsVO.setPostMemberID(postsVO.getPostMemberID());
		postsVO.setTime(new Timestamp(System.currentTimeMillis()));
		postsVO.setContent(content);
		postsVO.setGood(postsVO.getGood());
		postsVO.setStatus(postsVO.getStatus());
		postsVO.setResponsed(postsVO.getResponsed());
		postsVO.setParent(postsVO.getParent());
		postsVO.setImgPath(postsVO.getImgPath());
		postsDAO.update(postsVO);
		return postsVO;
	}

	public void goodOperation(String postMemberID, String postID) {
		membersVO = mdao.selectOne(postMemberID);
		goodStatusPK.setMemberID(membersVO);
		goodStatusPK.setPostID(postsDAO.findByPrimaryKey(postID));
		if ((goodStatusVO = goodStatusService.findByPrimaryKey(goodStatusPK)) == null) {
			goodStatusVO = goodStatusService.findByPrimaryKey(goodStatusPK);
			goodStatusVO = new GoodStatusVO();
			goodStatusVO.setGoodStatusPK(goodStatusPK);
			goodStatusService.insert(goodStatusVO);	
		} else {
			goodStatusService.delete(goodStatusVO);
		}
		postsVO = postsDAO.findByPrimaryKey(postID);
		postsVO.setPostID(postID);
		postsVO.setGood(goodStatusService.goodCount(postID).intValue());
		postsDAO.update(postsVO);
	}

	public PostsVO reportPosts(String postID, String reporterID, String typeID, String comment) {
		reportListService.newReport(postID, reporterID, typeID, comment);
		return postsVO;
	}

	public PostsVO responsePosts(String parentPostID, String postMemberID, String content) {
		String postID = glovbalService.findMaxSeq("postID", new PostsVO());
		membersVO = mdao.selectOne(postMemberID);
		postsVO.setPostID(postID);
		postsVO.setPostMemberID(membersVO);
		postsVO.setTime(new Timestamp(System.currentTimeMillis()));
		postsVO.setContent(content);
		postsVO.setGood(0);
		postsVO.setStatus("1");
		postsVO.setParent(parentPostID);
		postsVO.setResponsed("0");
		postsDAO.insert(postsVO);
		postsVO2 = postsDAO.findByPrimaryKey(parentPostID);
		postsVO2.setPostID(parentPostID);
		postsVO2.setPostMemberID(postsVO2.getPostMemberID());
		postsVO2.setTime(postsVO2.getTime());
		postsVO2.setContent(postsVO2.getContent());
		postsVO2.setGood(postsVO2.getGood());
		postsVO2.setStatus(postsVO2.getStatus());
		postsVO2.setParent(postsVO2.getParent());
		postsVO2.setResponsed(("1"));
		postsDAO.update(postsVO2);
		return postsVO;
	}

	public PostsVO deleteResponsePosts(String postID, String postMemberID) {
		postsVO = postsDAO.findByPrimaryKey(postID);
		postsVO.setPostID(postID);
		postsVO.setPostMemberID(postsVO.getPostMemberID());
		postsVO.setTime(postsVO.getTime());
		postsVO.setContent(postsVO.getContent());
		postsVO.setGood(postsVO.getGood());
		postsVO.setStatus("0");
		postsVO.setParent(postsVO.getParent());
		postsVO.setResponsed(("0"));
		postsDAO.update(postsVO);
		return postsVO;
	}

	public String goodCount(String postID) {
		postsVO = postsDAO.findByPrimaryKey(postID);
		postsVO.getGood();
		String gson = new Gson().toJson(postsVO.getGood());
		return gson;
	}
	
	public PostsVO getOnePost(String postID){		
		return postsDAO.findByPrimaryKey(postID);
	}
	
	public List<PostsVO> getResponseAll() {		
		return postsDAO.getResponseAll();
	}

	
	public List<PostsVO> getMemberPostAll(String memberID) {
		return postsDAO.getMemberPostAll(memberID);
	}

	public List<PostsVO> getAll() {
		return postsDAO.getAll();
	}
}
