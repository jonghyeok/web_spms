package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.util.DBConnectionPool;
import net.bitacademy.java41.vo.Member;
@Component
public class MemberService {
	DBConnectionPool dbConnectionPool;
	MemberDao memberDao;


	public void setDbConnectionPool(DBConnectionPool dbConnetionPool) {
		this.dbConnectionPool = dbConnetionPool;
	}

	public MemberService setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}

	public void signUp(Member member) throws Exception {
		try {
			memberDao.add(member);
			String[] photos = member.getPhotos();
			if(photos != null) {
				for(String path : photos){
					memberDao.addPhoto(member.getEmail(), path);
				}
			}

		} catch (Exception e) {
			throw e;
		} finally {

		}
	}
	public List<Member> getMemberList() throws Exception {
		return memberDao.list();
	}

	public Member getMember(String email) throws Exception {
		return memberDao.get(email);
		
	}

	public boolean changePassword(
			String email, String oldPassword, String newPassword) throws Exception {
			if (memberDao.changePassword(email, oldPassword, newPassword) > 0) {
					return true;
				} else {
				return false;
			}
	
	}

	public int delete(String email)throws Exception{
		return 	memberDao.delete(email);
		
	}

	public int memberUpdate(String name, String tel, String blog,
			String detailAddress, String tag, String email, int level) throws Exception{
		return memberDao.memberUpdate(name, tel, blog, detailAddress, tag, email, level);
		
	}

}
