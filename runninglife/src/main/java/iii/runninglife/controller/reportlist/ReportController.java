package iii.runninglife.controller.reportlist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import iii.runninglife.model.reportlist.ReportListService;
import iii.runninglife.model.reportlist.ReportListVO;

@RestController
@RequestMapping("/reportController")
public class ReportController {
	
	@Autowired
	ReportListService reportListSvc;
	
	@RequestMapping(value = "/reportList.do", method = RequestMethod.GET)
	public ModelAndView reportList() {
		List<ReportListVO> untreatedReportListVO = reportListSvc.getUntreatedReportList();
		List<ReportListVO> finishReportListVO = reportListSvc.getFinishReportList();
		Map<String, Object> map = new HashMap<>();
		map.put("untreatedReportListVO",untreatedReportListVO);
		map.put("finishReportListVO",finishReportListVO);
		return new ModelAndView("/report/report",map);
	}
	@RequestMapping(value = "/oneReportList.do", method = RequestMethod.POST)
	public ModelAndView oneReportList(@RequestParam String postID,@RequestParam String reporterID) {
		ReportListVO oneReportList = reportListSvc.getOneReportList(postID, reporterID);
		return new ModelAndView("report/report", "oneReportList", oneReportList);
	}
	@RequestMapping(value = "/reportListCheck.do", method = RequestMethod.POST)
	public ModelAndView reportListCheck(@RequestParam String postID,@RequestParam String reporterID ,@RequestParam String status ) {
		reportListSvc.checkReportList(postID, reporterID, status);
		return null;
	}
	@RequestMapping(value = "/newReport.do", method = RequestMethod.POST)
	public ModelAndView newReport(@RequestParam String reportPostID, @RequestParam String reporterID,@RequestParam String typeID, @RequestParam String reportComment) {
		reportListSvc.newReport(reportPostID, reporterID, typeID, reportComment);
		return new ModelAndView("redirect:/postsController/posts.do");
	}
	
}


