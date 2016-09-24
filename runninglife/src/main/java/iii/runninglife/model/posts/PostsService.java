package iii.runninglife.model.posts;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import iii.runninglife.globalservice.GlobalService;
import iii.runninglife.model.goodstatus.GoodStatusDAO;
import iii.runninglife.model.goodstatus.GoodStatusPK;
import iii.runninglife.model.goodstatus.GoodStatusVO;
import iii.runninglife.model.members.MembersInterface;
import iii.runninglife.model.members.MembersVO;
import iii.runninglife.model.reportlist.ReportListService;

@Service
public class PostsService {
	
	@Autowired
	GlobalService glovbalService;
	@Autowired
	ReportListService reportListService;
	@Autowired
	private PostsDAO_interface postsDAO;
	@Autowired
	private MembersInterface mdao;
	
	static MembersVO memberVO = new MembersVO();
	static PostsVO postsVO = new PostsVO();
	static PostsVO postsVO2 = new PostsVO();
	static GoodStatusPK goodStatusPK = new GoodStatusPK();
	static GoodStatusVO goodStatusVO = new GoodStatusVO();
	static GoodStatusDAO goodStatusDAO = new GoodStatusDAO();


	public PostsVO newPosts(String postMemberID, String content, String imgPath) {
		System.out.println(postMemberID + "," + content + "," + imgPath);
		String postID = glovbalService.findMaxSeq("postID", new PostsVO());
		postsVO.setPostID(postID);
		postsVO.setPostMemberID(postMemberID);
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

	public PostsVO deletePosts(String postMemberID, String postID) {
		System.out.println(postMemberID + "," + postID);
		postsVO = postsDAO.findByPrimaryKey(postID);
		postsVO.setPostID(postID);
		postsVO.setPostMemberID(postMemberID);
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
		System.out.println(postID + "," + content);
		PostsVO postsVO = postsDAO.findByPrimaryKey(postID);
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
	public PostsVO goodOperation(String postMemberID, String postID) {
		System.out.println(postMemberID + "," + postID);
		goodStatusPK.setMemberID(mdao.selectOne(postMemberID));
		goodStatusPK.setPostID(postsDAO.findByPrimaryKey(postID));
		goodStatusVO.setGoodStatusPK(goodStatusPK);
		goodStatusDAO.insert(goodStatusVO);
		postsVO = postsDAO.findByPrimaryKey(postID);
		postsVO.setPostID(postID);
		postsVO.setGood(goodStatusDAO.goodCount(postID).intValue());
		postsDAO.update(postsVO);
		return postsVO;
	}
	public PostsVO reportPosts(String postID, String reporterID, String typeID, String comment) {
		System.out.println(postID + "," + reporterID + "," + typeID + "," + comment);
		reportListService.newReport(postID, reporterID, typeID, comment);
		return postsVO;
	}
	public PostsVO responsePosts(String parentPostID, String postMemberID, String content) {
		System.out.println(parentPostID + "," + postMemberID + "," + content);
		String postID = glovbalService.findMaxSeq("postID", "posts");
		postsVO.setPostID(postID);
		postsVO.setPostMemberID(postMemberID);
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
		System.out.println(postMemberID + "," + postID);
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
		System.out.println(postID);
		postsVO = postsDAO.findByPrimaryKey(postID);
		postsVO.getGood();
		System.out.println(postsVO.getGood());
		String gson = new Gson().toJson(postsVO.getGood());
		System.out.println(gson);
		return gson;	
	}
	
}
