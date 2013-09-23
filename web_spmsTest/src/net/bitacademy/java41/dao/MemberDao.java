package net.bitacademy.java41.dao;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.Photo;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
@Component
public class MemberDao {
	
	SqlSessionFactory sqlSessionFactory;
		
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public MemberDao() {	}

	public Member getMember(String email, String password) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			HashMap<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("email", email);
			paramMap.put("password", password);
			
			Member member = 
					sqlSession.selectOne("net.bitacademy.java41.dao.MemberMapper.getMember", paramMap);
			
			return member;
			
		} catch (Exception e) {
			throw e;

		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}		
	}

	public int add(Member member) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			
			int count= sqlSession.insert("net.bitacademy.java41.dao.MemberMapper.add", member);
			sqlSession.commit();
			
			return count;
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;

		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}

	public List<Member> list() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
		

			return sqlSession.selectList("net.bitacademy.java41.dao.MemberMapper.list");
		} catch (Exception e) {
			throw e;

		} finally {
			try {sqlSession.close();} catch (Exception e) {}

		}
	}

	public Member get(String email) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectOne("net.bitacademy.java41.dao.MemberMapper.get", email );
			
		} catch (Exception e) {
			throw e;

		} finally {
			try {sqlSession.close();} catch (Exception e) {}

		}
	}
	

	public int changePassword(
			String email, String oldPassword, String newPassword) throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		HashMap<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("email", email);
		paramMap.put("oldPassword", oldPassword);
		paramMap.put("newPassword", newPassword);
			
	
		try {
			int count = sqlSession.update("net.bitacademy.java41.dao.MemberMapper.changePassword", paramMap );
			sqlSession.commit();
			return count;
			
		} catch (Exception e) {
			
			sqlSession.rollback();
			throw e;
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
			}
		}


	public int delete(String email) throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		
		try {
			 sqlSession.delete("net.bitacademy.java41.dao.MemberMapper.delete", email );
			int count =	sqlSession.delete("net.bitacademy.java41.dao.MemberMapper.deleteMember", email );
			
			    sqlSession.commit();
			    return count;
			   
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;

		} finally {
			try {sqlSession.close();} catch(Exception e) {}

		}
	}

	public int memberUpdate
	(String name, String tel, String blog,
			String detailAddress, String tag, String email, int level) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		System.out.println(email +" - " + blog + " - " + tel);
		HashMap<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("detailAddress", detailAddress);
		paramMap.put("tag", tag);
		paramMap.put("email", email);
		paramMap.put("level", level);
		paramMap.put("name", name);
		paramMap.put("tel", tel);
		paramMap.put("blog", blog);
		
		try {
			int count = sqlSession.update("net.bitacademy.java41.dao.MemberMapper.memberUpdate", paramMap );
			  sqlSession.commit();
			return count;

		} catch (Exception e) {
			sqlSession.rollback();
			throw e;

		} finally {
			try {sqlSession.close();} catch(Exception e) {}

		}
	}
	
	
	public void addPhoto(String email, String path) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
				
		try {
			HashMap<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("email", email);
			paramMap.put("path", path);
			sqlSession.insert("net.bitacademy.java41.dao.MemberMapper.addPhoto", paramMap);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;

		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}

	}
	
	public List<Photo> listPhoto(String email) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();		
		
		try {
			return sqlSession.selectList("net.bitacademy.java41.dao.MemberMapper.listPhoto",email);
			
		} catch (Exception e) {
			throw e;

		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}		
	}
	
	
}








