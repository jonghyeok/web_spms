package net.bitacademy.java41.dao;

import java.util.List;

import net.bitacademy.java41.vo.Feed;

public interface FeedDao {

	public List<Feed> list(int pno) ;

	public int add(Feed feed) ;

	public int delete(int fno);
	
	
	

}
