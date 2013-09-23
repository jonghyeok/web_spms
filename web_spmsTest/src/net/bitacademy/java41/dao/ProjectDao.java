package net.bitacademy.java41.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.vo.MemberProject;
import net.bitacademy.java41.vo.Project;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
@Component
public class ProjectDao {
	SqlSessionFactory sqlSessionFactory;
		
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public ProjectDao() {}
	
	public List<Project> list() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectList("net.bitacademy.java41.dao.ProjectMapper.list");	
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}
	
	public Project get(int no) throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.selectOne("net.bitacademy.java41.dao.ProjectMapper.get", no);
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}
	
	public List<MemberProject> listByMember(String email) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			
			return sqlSession.selectList(
					"net.bitacademy.java41.dao.ProjectMapper.listByMember", email);
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}
	
	public int add(Project project) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			sqlSession.insert("net.bitacademy.java41.dao.ProjectMapper.add", project);
			
			HashMap<String,Object> paramMap = new HashMap<String,Object>();
			
			paramMap.put("email", project.getLeader());
			paramMap.put("projectNo", project.getNo());
			paramMap.put("memberLevel", 0);
			
			sqlSession.insert("net.bitacademy.java41.dao.ProjectMapper.addProjectMember", paramMap);
			
			sqlSession.commit();
			return project.getNo();
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}
	
	public int update
	(String title, String content, Date startDate, Date endDate, String tag, int no) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement(
				"update SPMS_PRJS set"
				+ " TITLE=?,CONTENT=?,START_DATE=?,END_DATE=?,TAG=?"
				+ " where PNO=?");
			stmt.setString(1, title);
			stmt.setString(2, content);
			stmt.setDate(3, startDate);
			stmt.setDate(4, endDate);
			stmt.setString(5, tag);
			stmt.setInt(6, no);
			return stmt.executeUpdate();

		} catch (Exception e) {
			throw e;
		
		} finally {
			try {stmt.close();} catch(Exception e) {}
		}
	}
	public int delete(int no) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			stmt=con.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
			stmt.executeUpdate();
			
			stmt = con.prepareStatement(
				"delete from SPMS_PRJS"
				+ " where PNO=?");
			stmt.setInt(1, no);
			
			return stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {stmt.close();} catch(Exception e) {}
		}
	}
/*
	
	
	
	
	public int change(Project project) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = conPool.getConnection();
			stmt = con.prepareStatement(
				"update PROJECTS set"
				+ " MGR=?,TITLE=?,CONTENT=?,"
				+ " START_DAT=?,END_DAT=?,CREATED_DAT=now()"
				+ " where PNO=?");
			stmt.setString(1, project.getManagerEmail());
			stmt.setString(2, project.getTitle());
			stmt.setString(3, project.getContent());
			stmt.setDate(4, project.getStartDate());
			stmt.setDate(5, project.getEndDate());
			stmt.setInt(6, project.getNo());
			return stmt.executeUpdate();

		} catch (Exception e) {
			throw e;
		
		} finally {
			try {stmt.close();} catch(Exception e) {}
			if (con != null) {
				conPool.returnConnection(con);
			}
		}
	}
	
	public int remove(int no) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = conPool.getConnection();
			stmt = con.prepareStatement(
				"delete from PROJECTS"
				+ " where PNO=?"	);
			stmt.setInt(1, no);
			
			return stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {stmt.close();} catch(Exception e) {}
			if (con != null) {
				conPool.returnConnection(con);
			}
		}
	}
*/
}