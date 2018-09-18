package com.customs.dao.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.customs.entity.Person;
import com.customs.entity.PersonExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PersonMapper extends BaseMapper<Person> {
    long countByExample(PersonExample example);

    int deleteByExample(PersonExample example);

    int deleteByPrimaryKey(Long id);

    Integer insert(Person record);

    int insertSelective(Person record);

    List<Person> selectByExample(PersonExample example);

    Person selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Person record, @Param("example") PersonExample example);

    int updateByExample(@Param("record") Person record, @Param("example") PersonExample example);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);

    int addAge(Map<String, Object> updateMap);
}