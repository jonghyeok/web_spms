package net.bitacademy.java41.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import net.bitacademy.java41.util.DBConnectionPool;
import net.bitacademy.java41.vo.Task;

import com.mysql.jdbc.Statement;

public class TaskDao {

	DBConnectionPool conPool;

	public TaskDao setDBConnectionPool(DBConnectionPool conPool) {
		this.conPool = conPool;
		return this;
	}

	public TaskDao() {
	}

	public TaskDao(DBConnectionPool conPool) {
		this.conPool = conPool;
	}

	
	
	public int updateTask(Task task)throws Exception{
		
		System.out.println(task.getTno());
		Connection con = null;
		PreparedStatement stmt = null;

		String sql="update spms_tasks set  " +
				" TITLE=?, UIPROTOURL=?, CONTENT=?, " +
				" START_DATE=? ,END_DATE=?, DRAW_DATE=now()," +
				" STATUS=?  where TNO=?;";

		try {
			con = conPool.getConnection();
			con.setAutoCommit(false);
			stmt = con	.prepareStatement(sql);
			
			stmt.setString(1, task.getTitle());
			stmt.setString(2, task.getUiProtoUrl());
			stmt.setString(3, task.getContent());
			stmt.setDate(4, task.getStartDate());
			stmt.setDate(5, task.getEndDate());
			stmt.setInt(6, task.getStatus());
			stmt.setInt(7, task.getTno());
			
			System.out.println("update sql 완료.");
			
			return stmt.executeUpdate();
			
			
		}catch(Exception e){
			throw e;
		}finally{
			try {	stmt.close();} catch (Exception e) {}
		}
		
	}
	
	public int deleteTask(int no)throws Exception{
		System.out.println(no);
		Connection con = null;
		PreparedStatement stmt = null;

		String sql1="delete from SPMS_MEMBTASK where tno=?;";
		
		String sql2="delete from SPMS_TASKS where tno=?; ";
		
		try {
			con = conPool.getConnection();
			con.setAutoCommit(false);
			stmt = con	.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, no);
			stmt.executeUpdate();
			
			System.out.println("delete sql 1차 완료.(SPMS_MEMBTASK)");
			
			stmt.close();
			
			stmt = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
			stmt = con.prepareStatement(sql2);
			stmt.setInt(1, no);
			stmt.executeUpdate();
			con.commit();
			return stmt.executeUpdate();
		}catch(Exception e){
			throw e;
		}finally{
			try {	stmt.close();} catch (Exception e) {}
		}
	}
	
	
	public List<Task> listTask(int no) throws Exception {

		System.out.println(no);
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Task> list = new ArrayList<Task>();
		
		try {
			con = conPool.getConnection();
			stmt = con
				.prepareStatement("select t1.TNO,t1.TITLE,t2.EMAIL,t1.START_DATE,t1.END_DATE,t1.DRAW_DATE,t1.STATUS from spms_tasks t1, spms_membtask t2 " +
		                        		"where t1.TNO = t2.TNO and t1.PNO = ?;");
			
			stmt.setInt(1, no);
			rs = stmt.executeQuery();
			
			System.out.println("list sql들어옴");
			int qq=0;
			while(rs.next()) {
				list.add(new Task()
				.setTitle(rs.getString("TITLE"))
				.setEmail(rs.getString("EMAIL"))
				.setStartDate(rs.getDate("START_DATE"))
				.setEndDate(rs.getDate("END_DATE"))
				.setStatus(rs.getInt("STATUS"))
				.setPno(no)
				.setTno(rs.getInt("TNO"))
				.setDrawDate(rs.getDate("DRAW_DATE")));
				qq++;
			}
			
			System.out.println("list sql 나감"+qq);
			return list;

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
			if (con != null) {
				conPool.returnConnection(con);
			}
		}
	}
	
		
	
	public Task getTask(int no) throws Exception {

		System.out.println(no);
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select t1.TNO, t1.PNO, t1.TITLE, t2.EMAIL, t1.START_DATE, t1.UIPROTOURL, t1.CONTENT, t1.END_DATE, t1.DRAW_DATE, t1.STATUS " +
				" from spms_tasks t1, spms_membtask t2 where t1.PNO = t2.PNO and t1.TNO = ?;";

		try {
			con = conPool.getConnection();
			stmt = con
				.prepareStatement(sql);
			stmt.setInt(1, no);
			rs = stmt.executeQuery();
			System.out.println("ss");
			if (rs.next()) {
				return new Task()
						.setTno(rs.getInt("TNO"))
						.setPno(rs.getInt("PNO"))
						.setTitle(rs.getString("TITLE"))
						.setEmail(rs.getString("EMAIL"))
						.setUiProtoUrl(rs.getString("UIPROTOURL"))
						.setContent(rs.getString("CONTENT"))
						.setStartDate(rs.getDate("START_DATE"))
						.setEndDate(rs.getDate("END_DATE"))
						.setDrawDate(rs.getDate("DRAW_DATE"))
						.setStatus(rs.getInt("STATUS"));
			} else {
				return null;
			}

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
			if (con != null) {
				conPool.returnConnection(con);
			}
		}
	}
	
	
	
	public int addTask(Task task){

		System.out.println(task.getTitle());
		
		Connection con = null;
		PreparedStatement stmt = null;

		String sql1="insert into SPMS_TASKS(PNO,TITLE,UIPROTOURL,CONTENT,START_DATE,END_DATE,STATUS) " +
						 "values(?,?,?,?,?,?,?);";
		
		String sql2="insert into SPMS_MEMBTASK(TNO,EMAIL,PNO) value(?,?,?);";
		
		try {
			con = conPool.getConnection();
			con.setAutoCommit(false);
			stmt = con	.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, task.getPno());
			stmt.setString(2, task.getTitle());
			stmt.setString(3, task.getUiProtoUrl());
			stmt.setString(4, task.getContent());
			stmt.setDate(5, task.getStartDate());
			stmt.setDate(6, task.getEndDate());
			stmt.setInt(7, task.getStatus());
			stmt.executeUpdate();
			
			System.out.println("ss");
			
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				task.setTno( rs.getInt(1) );
			}
			rs.close();
			stmt.close();
			
			stmt = con.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
			stmt = con.prepareStatement(sql2);
			stmt.setInt(1, task.getTno());
			stmt.setString(2, task.getEmail());
			stmt.setInt(3, task.getPno());
			stmt.executeUpdate();
			
			con.commit();
	
			
			return stmt.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("테스크 에러" + e);
			return 1;
			//throw e;

		} finally {
				try {	stmt.close();} catch (Exception e) {}
				if (con != null) {
					try{con.setAutoCommit(true);}catch(Exception e){}
					conPool.returnConnection(con);
				}
		}
	}
	
	
	
	
	public int fileUpdateTask(Task task)throws Exception{

		System.out.println(task.getUiProtoUrl());
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		


		String sql="update spms_tasks set  " +
				" TUIPROTOURL=? DRAW_DATE=now()" +
				" where TNO=?;";

		try {
			con = conPool.getConnection();
			stmt = con	.prepareStatement(sql);
			
			stmt.setString(1, task.getUiProtoUrl());
			stmt.setInt(2, task.getTno());
			
			System.out.println("file update sql 완료.");
			
			return stmt.executeUpdate();
			
			
		}catch(Exception e){
			throw e;
		}finally{
			try {	stmt.close();} catch (Exception e) {}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
