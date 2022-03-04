package com.carRent4_0.service;

import com.carRent4_0.mapper.UserMapper;
import com.carRent4_0.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: carRent4_0
 * @description:
 * @author: Mr.Like
 * @create: 2021-10-27 20:32
 **/

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 登录
     * 先通过登录的用户名查询用户，判断用户是否存在，不存在则返回null
     * 或者判断用户输入的密码和查询出的密码是否一致，不一致则返回null
     * 其他情况返回员工信息
     *
     * @param username 用户名
     * @param password 密码
     * @return 员工
     */
    public User doLogin(String username, String password)  {


        User user = userMapper.loadUserByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            return null;
        }
        return user;
    }
    /**
     * @Description: 判断是否有重复的username
     * @Param: username
     * @return:boolean
     */
    public Boolean isdoreg(String username){
        User user = userMapper.loadUserByUsername(username);//首先进行查询有没有这个用户
        if (user != null) {
            return false;
        }
        return  true;
    }

    /**
     * @Description:进行注册
     * @Param: user
     * @return: boolean
     */
    public Boolean doreg(User user){
        userMapper.addUser(user);
        return true;
    }

    /**
     * @Description: 对数据库中的对应的user信息进行修改
     * @Param: user
     * @return: boolean
     */
    public Boolean dochange(User user){
        userMapper.upDateUser(user);
        return true;
    }


    public List<User> getAllUsers(){
      return  userMapper.queryUserList();
    }

    public void deleteUser(String id){
        userMapper.deleteUser(id);
    }

    public User getUser(String id){
        return  userMapper.queryUserListById(id);
    }

    public void updateUser(User user){
        userMapper.upDateUser(user);
    }
}
