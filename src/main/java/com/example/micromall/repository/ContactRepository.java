package com.example.micromall.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.micromall.entity.Contact;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 14760
 */
@Mapper
@Repository
public interface ContactRepository extends BaseMapper<Contact> {


}
