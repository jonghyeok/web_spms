package net.bitacademy.java41.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.bitacademy.java41.annotations.Component;
import net.bitacademy.java41.util.DBConnectionPool;
import net.bitacademy.java41.vo.ProjectMember;
@Component
public class ProjectMemberDao {
	SqlSessionFactory sqlSessionFactory;
	
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	
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

}
