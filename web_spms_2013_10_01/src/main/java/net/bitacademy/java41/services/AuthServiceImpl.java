package net.bitacademy.java41.services;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
	@Autowired MemberDao memberDao;

	public Member getUserInfo(String email, String password) throws Exception {
		HashMap<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("email", email);
		paramMap.put("password", password);

		Member member =memberDao.getMember(paramMap);

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














