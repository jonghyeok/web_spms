package net.bitacademy.java41.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.vo.Project;
import net.bitacademy.java41.vo.ProjectMember;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ProjectMemberDao {
	@Autowired SqlSessionFactory sqlSessionFactory;

	public ProjectMemberDao(){}
	
	public ArrayList<ProjectMember> getView(String email) throws Exception {

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<ProjectMember> data = new ArrayList<ProjectMember>();

		try {
			ProjectMember pm;
			stmt = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");

			stmt = con
					.prepareStatement("select * from SPMS_PRJMEMB where EMAIL=?;");
			stmt.setString(1, email);

			rs = stmt.executeQuery();

			while (rs.next()) {
				pm = new ProjectMember();
				pm.setPno(rs.getInt("PNO"));
				pm.setLevel(rs.getInt("LEVEL"));
				data.add(pm);
				System.out.println(pm.getPno() + " " + pm.getLevel());
			}
			return data;

		} catch (Exception e) {
			throw e;

		} finally {
			try {
				rs.close();
			} catch (Exception e) {
			}
			try {
				stmt.close();
			} catch (Exception e) {
			}
		}

	}

	public List<ProjectMember> getView(int no) throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			return sqlSession.selectList("net.bitacademy.java41.dao.ProjectMapper.getView", no);	

		} catch (Exception e) {
			throw e;

		} finally {
			try {
				sqlSession.close();
			} catch (Exception e) {
			}			
		}
	}
	
	public int add(String email, int projectNo, int level) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			HashMap<String,Object> paramMap = new HashMap<String,Object>();
			
			paramMap.put("email", email);
			paramMap.put("projectNo", projectNo);
			paramMap.put("memberLevel", level);
			
			int count = 
					sqlSession.insert("net.bitacademy.java41.dao.ProjectMapper.addProjectMember", paramMap);
			
			sqlSession.commit();
			return count;
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}
}
