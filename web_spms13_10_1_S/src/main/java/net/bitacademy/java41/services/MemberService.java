package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.dao.ProjectDao;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public interface MemberService {


	 void signUp(Member member) throws Exception;
	
	 List<Member> getMemberList() throws Exception;
	
	 Member getMember(String email) throws Exception ;
	
	 boolean changePassword(
			String email, String oldPassword, String newPassword) throws Exception ;
	
	 void updateMember(Member member) throws Exception;
	
	 void deleteMember(String email) throws Exception ;
}
