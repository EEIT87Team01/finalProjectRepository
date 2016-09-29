package iii.runninglife.controller.articles;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
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

import iii.runninglife.globalservice.GlobalService;
import iii.runninglife.model.articles.ArticlesCRUDService;
import iii.runninglife.model.articles.ArticlesVO;
import iii.runninglife.model.photobase.PhotoBaseService;
import iii.runninglife.model.photobase.PhotoBaseVO;


@Controller
@RequestMapping("/article")
public class ArticlesCRUD_Servlet{
	@Autowired
	ArticlesCRUDService articlesCRUDService;
	@Autowired
	PhotoBaseService photoSvc;
	@Autowired
	GlobalService globalSvc;
	
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
	public ModelAndView createArticle(HttpServletRequest req,@RequestParam String writerAccount,@RequestParam String content,@RequestParam String title) throws ParseException, IOException, ServletException {
		System.out.println(req.getPart("file1"));
		String fileName;
		String storePath = "c:/test/";
		String imgPath = null;
		String extension;
		File file ;
		if (req.getPart("file1") != null) {
			if (req.getPart("file1").getSize() != 0) {
				System.out.println("getPartStart");
				List<Part> fileParts = req.getParts().stream().filter(part -> "file1".equals(part.getName()))
						.collect(Collectors.toList());
				for (Part filePart : fileParts) {
					fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
					extension = fileName.substring(fileName.lastIndexOf(46));
					fileName = globalSvc.findMaxSeq("photoID", new PhotoBaseVO()) + extension;
					InputStream fileContent = filePart.getInputStream();
					
					file = new File(storePath, fileName);
					OutputStream out = new FileOutputStream(file);
					try {
						byte[] buffer = new byte[1024];
						int len = 0;
						while ((len = fileContent.read(buffer)) > -1)
							out.write(buffer, 0, len);

					} finally {
						out.close();
						fileContent.close();
					}
					imgPath = storePath + fileName;
					String photoID = photoSvc.newPhoto(imgPath);
					System.out.println(photoID);
					articlesCRUDService.insertService(writerAccount,content,title,photoID);
				}
			}
		}
		return new ModelAndView("article/articleList");
	}
	
	@RequestMapping(value = "/updateArticle.do", method = RequestMethod.GET)
	public void updateArticle(HttpServletRequest req,@RequestParam String ArticleID,@RequestParam String writerAccount,@RequestParam String content,@RequestParam String title,@RequestParam String photoPath,@RequestParam String createTime,@RequestParam String status,@RequestParam String good) throws ParseException, SerialException, SQLException, IOException, ServletException {
		System.out.println(req.getPart("file1"));
		String fileName;
		String storePath = "c:/test/";
		String imgPath = null;
		String extension;
		File file ;
		if (req.getPart("file1") != null) {
			if (req.getPart("file1").getSize() != 0) {
				System.out.println("getPartStart");
				List<Part> fileParts = req.getParts().stream().filter(part -> "file1".equals(part.getName()))
						.collect(Collectors.toList());
				for (Part filePart : fileParts) {
					fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
					extension = fileName.substring(fileName.lastIndexOf(46));
					fileName = globalSvc.findMaxSeq("photoID", new PhotoBaseVO()) + extension;
					InputStream fileContent = filePart.getInputStream();
					
					file = new File(storePath, fileName);
					OutputStream out = new FileOutputStream(file);
					try {
						byte[] buffer = new byte[1024];
						int len = 0;
						while ((len = fileContent.read(buffer)) > -1)
							out.write(buffer, 0, len);

					} finally {
						out.close();
						fileContent.close();
					}
					imgPath = storePath + fileName;
					String photoID = photoSvc.newPhoto(imgPath);
					System.out.println(photoID);
					int ArticleIDINT=Integer.valueOf(ArticleID);
					java.sql.Clob c = new javax.sql.rowset.serial.SerialClob(content.toCharArray());
					SimpleDateFormat datetimeFormatter1 = new SimpleDateFormat("yyyy-MM-dd");
			        Date lFromDate1 = (Date) datetimeFormatter1.parse(createTime);
			        java.sql.Timestamp createTimeT = new java.sql.Timestamp(lFromDate1.getTime());
					int goodInt=Integer.valueOf(good);
					articlesCRUDService.updateService(ArticleIDINT,writerAccount,c,title,photoPath,createTimeT,status,goodInt);
				}
			}
		}
	}
	
}
