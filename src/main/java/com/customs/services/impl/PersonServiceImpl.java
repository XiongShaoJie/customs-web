package com.customs.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.customs.dao.mapper.PersonMapper;
import com.customs.entity.Person;
import com.customs.services.IPersonService;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private PersonMapper personMapper;

    @Override
    public Person getById(Long id) {
	return personMapper.selectByPrimaryKey(id);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public int addAge(int age, Long id) throws Exception {
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("id", id);
	map.put("age", age);
	int i = 0;
	try {
	    i = personMapper.addAge(map);
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception("添加年龄出错");
	}

	return i;
    }

    @Override
    public List<Person> getAll() {
	return personMapper.selectPage(new Page<Person>(2,1),new EntityWrapper<>());
    }

}
