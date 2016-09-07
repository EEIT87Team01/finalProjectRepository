package _02.model.members;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("membersService")
@Transactional
public class MembersService implements MembersService_interface {

	@Autowired
	MembersDAO_interface membersDAO;
	
	@Override
	public void insert(MembersVO memberVo) {
		membersDAO.insert(memberVo);
	}

	@Override
	public void update(MembersVO memberVo) {
		membersDAO.update(memberVo);
	}

	@Override
	public void deleteByPrimaryKey(String memberID) {
		membersDAO.deleteByPrimaryKey(memberID);
	}

	@Override
	public MembersVO findByID(String memberID) {
		return membersDAO.findByID(memberID);
	}

	@Override
	public List<MembersVO> getAll() {
		return membersDAO.getAll();
	}

	@Override
	public MembersVO findByFirstName(String firstName) {
		return membersDAO.findByFirstName(firstName);
	}

	@Override
	public List<MembersVO> findByFirstNameOrLastName(String name) {
		return membersDAO.findByFirstNameOrLastName(name);
	}

	@Override
	public MembersVO findByAccount(String account) {
		return membersDAO.findByAccount(account);
	}
}
