package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.Photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthService {
	@Autowired MemberDao memberDao;

	public Member getUserInfo(String email, String password) throws Exception {

		Member member =memberDao.getMember(email, password);

		String[] photos = null;
		List<String> list = memberDao.listPhoto(email);

		if(member !=null){
			if(list.size()>0){
				photos = new String[list.size()];
				int index = 0;
				for(String photo : list){
					photos[index++] = photo;
				}
				member.setPhotos(photos);
			}
		}


		return member;
	}
}














