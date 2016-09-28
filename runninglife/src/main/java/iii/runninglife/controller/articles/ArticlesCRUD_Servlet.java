package iii.runninglife.controller.articles;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import iii.runninglife.model.articles.ArticlesCRUDService;
import iii.runninglife.model.articles.ArticlesVO;


@Controller
@RequestMapping("/article")
public class ArticlesCRUD_Servlet{
	@Autowired
	ArticlesCRUDService articlesCRUDService;
	
	@RequestMapping(value = "/page")
	public String articlePage(){ return "article/articleList"; }
	
	@RequestMapping(value = "/detail/{articleID}", produces = "text/plain;charset=UTF-8;")
	public ModelAndView articleDetailPage(@PathVariable String articleID){
		Map<String, Object> model = new HashMap<>();
		ArticlesVO article = articlesCRUDService.searchOneService(articleID);
		model.put("article", article);
		try {
			model.put("content", article.getContent().getSubString(1, (int) article.getContent().length()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ModelAndView("article/articleDetail", model); 
	}
	
    
	@RequestMapping(value = "/searchArticles.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8;")
	public @ResponseBody String searchArticles() {
		List<ArticlesVO> allarticles = articlesCRUDService.searchAllService();
		String articlesjson = new Gson().toJson(allarticles);
		return articlesjson;
	}
	
	@RequestMapping(value = "/searchArticle.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8;")
	public @ResponseBody String searchArticle(@RequestParam String ArticleID) {
		ArticlesVO aarticle = articlesCRUDService.searchOneService(ArticleID);
		String articlesjson = new Gson().toJson(aarticle);
		return articlesjson;
	}
	
	@RequestMapping(value = "/searchWriterArticles.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8;")
	public @ResponseBody String searchWriterArticles(@RequestParam String writerAccount) {
		List<ArticlesVO> aarticle = articlesCRUDService.searchWriterService(writerAccount);
		String articlesjson = new Gson().toJson(aarticle);
		return articlesjson;
	}
	
	@RequestMapping(value = "/createArticle.do", method = RequestMethod.POST)
	public void createArticle(@RequestParam String writerAccount,@RequestParam String content,@RequestParam String title) throws ParseException {
		articlesCRUDService.insertService(writerAccount,content,title); 
	}
	
	@RequestMapping(value = "/updateArticle.do", method = RequestMethod.GET)
	public void updateArticle(@RequestParam String ArticleID,@RequestParam String writerAccount,@RequestParam String content,@RequestParam String title,@RequestParam String photoPath,@RequestParam String createTime,@RequestParam String status,@RequestParam String good) throws ParseException, SerialException, SQLException {
		int ArticleIDINT=Integer.valueOf(ArticleID);
		java.sql.Clob c = new javax.sql.rowset.serial.SerialClob(content.toCharArray());
		SimpleDateFormat datetimeFormatter1 = new SimpleDateFormat("yyyy-MM-dd");
        Date lFromDate1 = (Date) datetimeFormatter1.parse(createTime);
        java.sql.Timestamp createTimeT = new java.sql.Timestamp(lFromDate1.getTime());
		int goodInt=Integer.valueOf(good);
		articlesCRUDService.updateService(ArticleIDINT,writerAccount,c,title,photoPath,createTimeT,status,goodInt);
	}
	
}
