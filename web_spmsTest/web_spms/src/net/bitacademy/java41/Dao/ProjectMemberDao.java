package net.bitacademy.java41.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import net.bitacademy.java41.Util.DBConnectionPool;
import net.bitacademy.java41.vo.ProjectMember;

public class ProjectMemberDao {
	DBConnectionPool conPool;
	
	public ProjectMemberDao(DBConnectionPool conPool) {
		this.conPool = conPool;
	}
	
	
	public ArrayList<ProjectMember> getView(String email) throws Exception {
		
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList<ProjectMember> data = new ArrayList<ProjectMember>();
		
		try {
			ProjectMember pm;
			con = conPool.getConnection();
			stmt = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
			
			stmt = con.prepareStatement("select * from SPMS_PRJMEMB where EMAIL=?;");
			stmt.setString(1, email);
       
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
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
			try {rs.close();} catch (Exception e) {}
			try {stmt.close();} catch (Exception e) {}
			if (con != null) {
				conPool.returnConnection(con);
			}
		}
		
		
	}
	
	
	
	
public ArrayList<ProjectMember> getView(int no) throws Exception {
		
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		ArrayList<ProjectMember> data = new ArrayList<ProjectMember>();
		
		String sql = "select t1.email,t1.level,t2.MNAME,t2.TEL,t2.BLOG from SPMS_PRJMEMB t1, SPMS_MEMBS t2 where t1.PNO=? and t1.EMAIL=t2.EMAIL;";
		
		try {
			ProjectMember pm ;
			con = conPool.getConnection();
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, no);
       
			
			rs = stmt.executeQuery();
			
			String blog;
			
			while(rs.next()) {
				
				
				if(rs.getString("BLOG")==null){
					blog=" ";
				}else{
					blog=rs.getString("BLOG");
				}
				
				pm = new ProjectMember();
				pm.setPno(no);
				pm.setEmail(rs.getString("EMAIL"));
				pm.setLevel(rs.getInt("LEVEL"));
				pm.setName(rs.getString("MNAME"));
				pm.setTel(rs.getString("TEL"));
				pm.setBlog(blog);
				System.out.println(no+" "+pm.getEmail()+" "+ pm.getLevel()+" "+ pm.getName() +" " + pm.getBlog());
				data.add(pm);
			}
			
			return data; 

			
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {rs.close();} catch (Exception e) {}
			try {stmt.close();} catch (Exception e) {}
			if (con != null) {
				conPool.returnConnection(con);
			}
		}
		
		
	}
	
	
	
	
	
	
	
	
	
}
