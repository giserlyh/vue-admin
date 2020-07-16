package com.lu.controller;

import com.lu.common.R;
import com.lu.mapper.LoginMapper;
import com.lu.pojo.Menu;
import com.lu.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "登录管理")
@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    private LoginMapper loginMapper;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public R login(@RequestBody Map<String, String> person) {
        String username = person.get("username");
        List<User> users = loginMapper.queryUserList(username);
        int password = Integer.parseInt(person.get("password"));
        System.out.println(users);
        if (users.size() > 0) {
            int Cpassword = Integer.parseInt(users.get(0).getPassWord());
            if (password == Cpassword) {
                return R.ok().data("token", "token" + username + password);
            } else {
                return R.error();
            }
        } else {
            return R.error();
        }
    }


    @ApiOperation(value = "菜单")
    @GetMapping("/menu")
    public R Menu() {
        List<Menu> menus = loginMapper.queryMenu();
        return R.ok().data("items", menus);
    }

    @ApiOperation(value = "分页")
    @GetMapping("/page/{current}/{limit}")
    public R pageList(@PathVariable int current, @PathVariable int limit) {
        int total = 0;
        List<User> users = loginMapper.queryPage(current - 1, limit);
        List<User> users1 = loginMapper.queryPage(0, 1000000);
        for (int i = 0; i < users1.size(); i++) {
            total++;
        }
        return R.ok().data("total", total).data("pagenum", current).data("users", users);
    }

    @ApiOperation(value = "修改")
    @PutMapping("/update")
    public R updateUser(@RequestBody User user) {
        loginMapper.updateUser(user);
        return R.ok();

    }

    @ApiOperation(value = "增加")
    @PostMapping("/add")
    public R addUser(@RequestBody User user) {
        loginMapper.addUser(user);
        return R.ok();
    }

    @ApiOperation(value = "根据id进行查询")
    @GetMapping("/addById/{id}")
    public R selectUser(@PathVariable int id) {
        List<User> users = loginMapper.queryUserById(id);
        return R.ok().data("users", users);
    }

    @ApiOperation(value = "根据id进行删除")
    @DeleteMapping("/deleteById/{id}")
    public R deleteUser(@PathVariable int id) {
        loginMapper.deleteById(id);
        return R.ok();
    }

}
