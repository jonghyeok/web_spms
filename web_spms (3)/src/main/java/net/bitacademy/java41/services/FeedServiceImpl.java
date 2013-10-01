package net.bitacademy.java41.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import net.bitacademy.java41.dao.FeedDao;
import net.bitacademy.java41.vo.Feed;

@Service
public class FeedServiceImpl implements FeedService{
	
	@Autowired PlatformTransactionManager txManager;
	@Autowired FeedDao feedDao;
	
	public List<Feed>listFeed(int pno)throws Exception{
		return feedDao.list(pno);
	}

	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public int addFeed(Feed feed)throws Exception{
		return feedDao.add(feed);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, rollbackFor=Throwable.class)
	public int deleteFeed(int fno)throws Exception{
		return feedDao.delete(fno);
	}
	
	
	

}
