package iii.runninglife.controller.reportlist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import iii.runninglife.model.reportlist.ReportListDAO;
import iii.runninglife.model.reportlist.ReportListService;
import iii.runninglife.model.reportlist.ReportListVO;

@RestController
@RequestMapping("/reportController")
public class ReportController {
	
	@Autowired
	ReportListService reportListSvc;
	
	@RequestMapping(value = "/reportList.do", method = RequestMethod.POST)
	public ModelAndView reportList(HttpServletRequest req) {
		List<ReportListVO> reportListVO = reportListSvc.getAll();
		List<ReportListVO> untreatedReportListVO = reportListSvc.getUntreatedReportList();
		List<ReportListVO> finishReportListVO = reportListSvc.getFinishReportList();
		Map<String, Object> map = new HashMap<>();
		map.put("reportListVO",reportListVO);
		map.put("untreatedReportListVO",untreatedReportListVO);
		map.put("finishReportListVO",finishReportListVO);
		return new ModelAndView("report",map);
	}
	
	@RequestMapping(value = "/oneReportList.do", method = RequestMethod.POST)
	public ModelAndView oneReportList(HttpServletRequest req) {
		String postID = req.getParameter("postID");
		String reporterID = req.getParameter("reporterID");
		ReportListVO oneReportList = reportListSvc.getOneReportList(postID, reporterID);
		return new ModelAndView("report","oneReportList",oneReportList);
	}
}


