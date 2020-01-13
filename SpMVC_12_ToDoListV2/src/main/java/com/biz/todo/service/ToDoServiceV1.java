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
		
//		
//		String strTdComp = toDoList.getTd_complete();
//		if(strTdComp == null || strTdComp.isEmpty()) {
//			toDoList.setTd_complete("N");
//		}
//		String strTdAlarm= toDoList.getTd_alarm();
//		if(strTdAlarm == null || strTdAlarm.isEmpty()) {
//			toDoList.setTd_alarm("N");
//		}
//		
//		toDoList.setTd_date(curDate);
//		toDoList.setTd_time(curTime);
//		
		int ret = todoDao.insert(toDoList);
		
		return ret;
	}

	@Override
	public ToDoList findBySeq(long td_seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ToDoList> findBySubject(String td_subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(ToDoList todoList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long td_seq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int complete(String strSeq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int alarm(String strSeq) {
		// TODO Auto-generated method stub
		return 0;
	}

}
