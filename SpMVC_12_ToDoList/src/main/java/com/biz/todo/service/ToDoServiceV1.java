package com.biz.todo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.todo.domain.ToDoList;
import com.biz.todo.repsitory.ToDoListDao;

@Service("toServiceV1")
public class ToDoServiceV1 implements ToDoService {

	@Autowired
	protected ToDoListDao todoDao;
	
		
	
	@Override
	public List<ToDoList> selectAll() {
	
		return todoDao.selectAll();
	}

	@Override
	public int insert(ToDoList toDoList) {

		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat st = new SimpleDateFormat("hh:mm:ss");
		
		String curDate = sd.format(date); // 문자열형 날짜 생성
		String curTime = st.format(date); // 문자열혈 시간 생성
		
		String strTdComp = toDoList.getTdComplete();
		if(strTdComp == null || strTdComp.isEmpty()) {
			toDoList.setTdComplete("N");
		}
		String strTdAlarm= toDoList.getTdAlarm();
		if(strTdAlarm == null || strTdAlarm.isEmpty()) {
			toDoList.setTdAlarm("N");
		}
		toDoList.setTdDate(curDate);
		toDoList.setTdTime(curTime);
		
		int ret = todoDao.insert(toDoList);
		
		return ret;
	}

	@Override
	public ToDoList findBySeq(long tdSeq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ToDoList> findBySubject(String tdSubject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(ToDoList todoList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long tdSeq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int complete(String strSeq, String tdComplete) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int alarm(String strSeq, String tdAlarm) {
		// TODO Auto-generated method stub
		return 0;
	}

}
