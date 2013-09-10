package net.bitacademy.java41.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import net.bitacademy.java41.Util.DBConnectionPool;
import net.bitacademy.java41.vo.Member;


public class MemberDao {
	DBConnectionPool conPool;
	
	
	public MemberDao(DBConnectionPool conPool) {
		this.conPool = conPool;
	}
	
	public Member getMember(String email,String password)throws Exception{
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = conPool.getConnection();
			stmt = con.prepareStatement("select EMAIL,MNAME,TEL,LEVEL from SPMS_MEMBS" +
					" where EMAIL=? and PWD=?;");
			//? = inparameter
			stmt.setString(1, email);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			System.out.println("id : " + email + "\tpw : " + password);
			if (rs.next()) {
				Member member = new Member();
				member.setName(rs.getString("MNAME"));
				member.setEmail(rs.getString("EMAIL"));
				member.setTel(rs.getString("TEL"));
				member.setLevel(rs.getInt("LEVEL"));
				return member;
				
			} else {
				return null;
			}
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
	
	
	public List<Member> list() throws Exception {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		ArrayList<Member> list = new ArrayList<Member>();

		try {
			con = conPool.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(
					"select * from SPMS_MEMBS order by EMAIL");
			
			Member m = null;
			while(rs.next()) {
				m = new Member();
				m.setEmail(rs.getString("EMAIL"));
				m.setName(rs.getString("MNAME"));
				m.setTel(rs.getString("TEL"));
				m.setLevel(rs.getInt("LEVEL"));
				list.add(m);
			}
			
			return list;
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

	public int add(Member member) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		
		System.out.println("add 결과 : "+member.getEmail() + member.getName() );
	
		try {
			
		
			Member m = getMember(member.getEmail(),member.getPassword());
	
			
			if(m == null){
				
			con = conPool.getConnection();
			stmt = con.prepareStatement(
				"insert into SPMS_MEMBS(EMAIL,MNAME,PWD,TEL,BLOG,DET_ADDR,REG_DATE,LEVEL)"
				+ " values(?,?,?,?,?,?,now(),?)");
			stmt.setString(1, member.getEmail());
			stmt.setString(2, member.getName());
			stmt.setString(3, member.getPassword());
			stmt.setString(4, member.getTel());
			stmt.setString(5, member.getBlog());
			stmt.setString(6, member.getDetailAddress());
			stmt.setInt(7, member.getLevel());
			return stmt.executeUpdate();
			
			}else{
				return -4;
			}
			
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			try {stmt.close();} catch(Exception e) {}
			if (con != null) {
				conPool.returnConnection(con);
			}
		}
	}


	public Member get(String email) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = conPool.getConnection();
			stmt = con.prepareStatement("select EMAIL,MNAME,PWD,TEL,BLOG,DET_ADDR,REG_DATE,LEVEL from SPMS_MEMBS" +
					" where EMAIL=?;");
			//? = inparameter
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			System.out.println("관리자가 다음 맴버를 조회함.. id : " + email );
			if (rs.next()) {
				Member member = new Member();
				member.setName(rs.getString("MNAME"));
				member.setEmail(rs.getString("EMAIL"));
				member.setTel(rs.getString("TEL"));
				member.setPassword(rs.getString("PWD"));
				member.setBlog(rs.getString("BLOG"));
				member.setDetailAddress(rs.getString("DET_ADDR"));
				member.setRegDate(rs.getDate("REG_DATE"));
				member.setLevel(rs.getInt("LEVEL"));
				return member;
						
			} else {
				return null;
			}
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

	
	/*

	public int change(Member member) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = conPool.getConnection();
			stmt = con.prepareStatement(
				"update MEMBERS set"
				+ " MNAME=?,PHONE=?,BLOG=?,AGE=?,REG_DATE=now()"
				+ " where EMAIL=?");
			stmt.setString(1, member.getName());
			stmt.setString(2, member.getPhone());
			stmt.setString(3, member.getBlog());
			stmt.setInt(4, member.getAge());
			stmt.setString(5, member.getEmail());
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

	public int remove(String email) throws Exception {
		Connection con = null;
		Statement stmt = null;
		
		try {
			con = conPool.getConnection();
			stmt = con.createStatement();
			
			return stmt.executeUpdate(
				"delete from MEMBERS"
				+ " where EMAIL='" + email + "'");
			
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
	
	public String findPWD(String email)throws Exception{
		
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			con = conPool.getConnection();
			stmt = con.prepareStatement("select EMAIL,PWD from SPMS_MEMBS" +
					" where EMAIL=?;");
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			System.out.println("id : " + email + "님이 PWD 찾기를 신청합니다. ");
			if (rs.next()) {
				Member member = new Member();
				member.setPassword(rs.getString("PWD"));
				member.setEmail(rs.getString("EMAIL"));
				return member.getPassword();
			} else {
				return null;
			}
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




