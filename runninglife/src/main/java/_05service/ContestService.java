package _05service;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import _05controller.ContestFormValidator;
import _05model.clothes.ClothesDAOimpl;
import _05model.contest.ContestDAOimpl;
import _05model.contest.ContestVO;
import _05model.event.EventDAOimpl;
import _05model.runner.RunnerDAOimpl;
import _05model.team.TeamDAOimpl;
import _05service.email.MailService;
import _05validator.EventValidator;
import _05validator.FileValidator;
@Service
public class ContestService {
	
	@Autowired
	private ContestDAOimpl contestDAO;
	@Autowired
	private EventDAOimpl eventDAO;
	@Autowired
	private TeamDAOimpl teamDAO;
	@Autowired
	private RunnerDAOimpl runnerDAO;
	@Autowired
	private ClothesDAOimpl clothesDAO;
	@Autowired
	private MailService mailService;
	@Autowired
	private ContestFormValidator contestFormValidator;
	@Autowired
	private FileValidator fileValidator;
	@Autowired
	private EventValidator eventValidator;
	
	public String createContest(ContestVO contest){
		contestDAO.insert(contest);
		return null;
	}
	
	public String updateContest(ContestVO contest){
		contestDAO.update(contest);
		return null;
	}
	
	
	//賽事新增圖片
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

}
