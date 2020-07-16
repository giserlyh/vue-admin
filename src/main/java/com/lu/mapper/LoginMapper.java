package com.lu.mapper;

import com.lu.pojo.Menu;
import com.lu.pojo.MenuChildren;
import com.lu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginMapper {
    //登录接口
    List<User> queryUserList(String username);

    //菜单接口
    List<Menu> queryMenu();

    //分页查询
    List<User> queryPage(int current,int limit);

    //修改参数
    void updateUser(User user);

    //增加接口
    void addUser(User user);

    //根据id进行查询
    List<User> queryUserById(int id);

    //删除接口
    void deleteById(int id);

}
