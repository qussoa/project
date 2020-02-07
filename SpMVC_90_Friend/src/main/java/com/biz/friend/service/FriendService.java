package com.biz.friend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.friend.domain.FriendVO;
import com.biz.friend.persistence.FriendDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FriendService {

	private final FriendDao frDao;
	
	public List<FriendVO> selectAll() {
		// TODO Auto-generated method stub
		return frDao.selectAll();
	}

	public int save(FriendVO friendVO) {

		long fr_num = friendVO.getFr_num();
		if(fr_num > 0) {
			frDao.update(friendVO);
		}else {
			frDao.insert(friendVO);
		}
		return 0;
	}

	public int delete(long fr_num) {
		
		int ret = frDao.delete(fr_num);
		
		return ret;
	}

	public FriendVO findById(long fr_num) {
		
		FriendVO friendVO = frDao.findById(fr_num);		
		return friendVO;
	}

	public List<FriendVO> findByName(String fr_name) {

		List<FriendVO> frList = frDao.findByName(fr_name);
		
		return frList;
	}

}
