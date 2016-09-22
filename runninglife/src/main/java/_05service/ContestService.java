package _05service;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import _05controller.ContestFormValidator;
import _05model.clothes.ClothesDAO;
import _05model.clothes.ClothesDAOimpl;
import _05model.contest.ContestDAO;
import _05model.contest.ContestDAOimpl;
import _05model.contest.ContestVO;
import _05model.event.EventDAO;
import _05model.event.EventDAOimpl;
import _05model.runner.RunnerDAO;
import _05model.runner.RunnerDAOimpl;
import _05model.team.TeamDAO;
import _05model.team.TeamDAOimpl;
import _05service.email.MailService;
import _05validator.EventValidator;
import _05validator.FileValidator;

@Service
public class ContestService {

	@Resource
	private ContestDAO contestDAO;
	@Autowired
	private EventDAO eventDAO;
	@Autowired
	private TeamDAO teamDAO;
	@Autowired
	private RunnerDAO runnerDAO;
	@Autowired
	private ClothesDAO clothesDAO;
	@Autowired
	private MailService mailService;
	@Autowired
	private ContestFormValidator contestFormValidator;
	@Autowired
	private FileValidator fileValidator;
	@Autowired
	private EventValidator eventValidator;

	public String createContest(ContestVO contest) {
		contestDAO.insert(contest);
		return null;
	}

	public String updateContest(ContestVO contest) {
		contestDAO.update(contest);
		return null;
	}

	public List<ContestVO> QueryContest(Date date) {
		List<ContestVO> list = contestDAO.getAll();
		List<ContestVO> contests = new ArrayList<>();
		String dateStr = date.toString();
		System.out.println(dateStr);
		Integer year = Integer.valueOf(dateStr.substring(0, 4));
		Integer month = Integer.valueOf(dateStr.substring(5, 7));
		System.out.println("年:" + year);
		System.out.println("月:" + month);
		Date begin = Date.valueOf(year + "-" + month + "-01");
		if (month == 12) {
			year++;
			month = 0;
		}
		Date end = Date.valueOf(year + "-" + (month + 1) + "-01");
		System.out.println("開始搜尋符合賽事");
		System.out.println("開始:" + begin);
		System.out.println("結束:" + end);
		for (ContestVO a : list) {
			a.getStartDate().getTime();
			if (begin.getTime() <= a.getStartDate().getTime() && a.getStartDate().getTime() < end.getTime()) {
				contests.add(a);
				System.out.println("搜尋到符合的賽事");
				System.out.println(a.getContestName());
			}

		}
		return contests;
	}
	public List<ContestVO>QueryContest2(Integer year,Integer month,Integer page){
		Date stDate = Date.valueOf(year+"-"+month+"-01");
		if(month==12){
			year++;
			month=0;
		}
		Date edDate = Date.valueOf(year+"-"+(month+1)+"-01");
		List<ContestVO> list=contestDAO.date2(stDate, edDate, page);
		return list;
	}

	public List<ContestVO> pagination(List<ContestVO> queryContests,Integer page) {
		Integer pageSize = 5;
		List<ContestVO>contests=new ArrayList<ContestVO>();
		if (queryContests.size() >= pageSize * page) {
			for (int i = pageSize * (page - 1); i < pageSize * page; i++) {
				contests.add(queryContests.get(i));
			}
		}else{
			for (int i = pageSize * (page - 1); i < queryContests.size(); i++) {
				contests.add(queryContests.get(i));
			}
		}
		return contests;
	}

	// 賽事新增圖片
	public String photo(CommonsMultipartFile[] fileUpload, ContestVO contest) {
		String path = "c:/run/";

		if (fileUpload != null && fileUpload.length > 0) {
			// 小圖
			if (fileUpload[0].getSize() > 0) {
				System.out.println("Saving file: " + path + contest.getContestID() + fileUpload[0].getOriginalFilename()
						.substring(fileUpload[0].getOriginalFilename().indexOf(".")));

				try {
					fileUpload[0].transferTo(new File(path + contest.getContestID() + fileUpload[0]
							.getOriginalFilename().substring(fileUpload[0].getOriginalFilename().indexOf("."))));
					contest.setContestPhotoPath(contest.getContestID() + fileUpload[0].getOriginalFilename()
							.substring(fileUpload[0].getOriginalFilename().indexOf(".")));
					contestDAO.update(contest);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			// 橫幅
			if (fileUpload[1].getSize() > 0) {
				System.out.println("Saving file: " + path + contest.getContestID() + "banner" + fileUpload[1]
						.getOriginalFilename().substring(fileUpload[1].getOriginalFilename().indexOf(".")));
				try {
					fileUpload[1].transferTo(new File(path + contest.getContestID() + "banner" + fileUpload[1]
							.getOriginalFilename().substring(fileUpload[1].getOriginalFilename().indexOf("."))));
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return null;
	}
	public void test(){
	}

}
