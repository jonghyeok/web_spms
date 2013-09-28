package net.bitacademy.java41.dao;

import java.util.List;

import net.bitacademy.java41.vo.Task;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class TaskDao {
	@Autowired SqlSessionFactory sqlSessionFactory;

	public TaskDao() {}
	
	public int updateTask(Task task)throws Exception{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
		
			int rsn = sqlSession.update("net.bitacademy.java41.dao.TaskMapper.updateTask",task);
			sqlSession.commit();
			return rsn;
		}catch(Exception e){
			sqlSession.rollback();
			throw e;
			
		}finally{
			try {sqlSession.close();} catch (Exception e) {}
		}
	}
	
	public int deleteTask(int no)throws Exception{
		
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
			sqlSession.delete("net.bitacademy.java41.dao.TaskMapper.deleteMemberTask",no);
			sqlSession.commit();
			int rsn =sqlSession.delete("net.bitacademy.java41.dao.TaskMapper.deleteTask",no);
			sqlSession.commit();
			
			return rsn;
		}catch(Exception e){
			sqlSession.rollback();
			throw e;
		}finally{
			try {sqlSession.close();} catch (Exception e) {}
		}
	}
	
	
	public List<Task> listTask(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.selectList("net.bitacademy.java41.dao.TaskMapper.listTask", no);

		} catch (Exception e) {
			throw e;

		} finally {
			try {
				sqlSession.close();
			} catch (Exception e) {}
		}
	}
	
		
	
	public Task getTask(int no) throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			return sqlSession.selectOne("net.bitacademy.java41.dao.TaskMapper.getTask", no);
		
		} catch (Exception e) {
			throw e;

		} finally {
			try {
				sqlSession.close();
			} catch (Exception e) {}
		}
	}
	
	
	
	public int addTask(Task task){

		SqlSession sqlSession = sqlSessionFactory.openSession();
				
		System.out.println(task.getPno() + " - " + task.getEmail());
		
		try {
			sqlSession.insert("net.bitacademy.java41.dao.TaskMapper.addTask",task);
			sqlSession.commit();			
			int result =sqlSession.insert("net.bitacademy.java41.dao.TaskMapper.addMemberTask",task);
			sqlSession.commit();
			
			return result;
			
		} catch (Exception e) {
			System.out.println("테스크 에러" + e);
			return 1;
			//throw e;

		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}
	
	
	
	
	
	
}
