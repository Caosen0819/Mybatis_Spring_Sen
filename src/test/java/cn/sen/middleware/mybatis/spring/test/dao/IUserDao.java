package cn.sen.middleware.mybatis.spring.test.dao;

import cn.sen.middleware.mybatis.spring.test.po.User;

public interface IUserDao {

     User queryUserInfoById(Long id);

}
