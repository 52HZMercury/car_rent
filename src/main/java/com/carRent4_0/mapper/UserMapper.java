package com.carRent4_0.mapper;


import com.carRent4_0.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


//代表了这是一个mybatis的mapper类
@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();

    User queryUserListById(String id);

    User loadUserByUsername(String name);

    int addUser(User user);

    int upDateUser(User user);

    int deleteUser(String id);
}
