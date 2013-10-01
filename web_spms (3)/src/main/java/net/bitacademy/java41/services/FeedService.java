package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.vo.Feed;

public interface FeedService {
	
	
	List<Feed>listFeed(int pno)throws Exception;
	
	int addFeed(Feed feed)throws Exception;
	
	int deleteFeed(int fno)throws Exception;
	
	
	

}
