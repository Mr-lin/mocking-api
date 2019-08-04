package com.mockst.mocking.controller;

import com.alibaba.fastjson.JSONObject;
import com.esnotary.framework.entity.PageInfo;
import com.esnotary.framework.result.APIResult;
import com.esnotary.framework.result.APIResultUtil;
import com.github.pagehelper.PageHelper;
import com.mockst.mocking.config.WebConfigurer;
import com.mockst.mocking.model.UserVO;
import com.mockst.mocking.module.user.entity.UserEntity;
import com.mockst.mocking.module.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Auther: zhiwei
 * @Date: 2019/8/3 15:38
 * @Description:
 */
@RestController
@RequestMapping(WebConfigurer.API_BASE_PATH+"/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("login")
    public APIResult login(@RequestParam String username,@RequestParam String password){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        userEntity.setPassword(md5Password);
        UserEntity dbUser = userService.selectOne(userEntity);
        if (dbUser==null){
            return APIResultUtil.responseBusinessFailedResult("用户名或者密码错误");
        }
        String token = UUID.randomUUID().toString().replace("-","");
        JSONObject object = new JSONObject();
        object.put("token",token);
        return APIResultUtil.returnSuccessResult(object);
    }

    @RequestMapping("logout")
    public APIResult logout(){
        return APIResultUtil.returnSuccessResult(null);
    }

    /**
     * 登录用户信息
     * @return
     */
    @RequestMapping("info")
    public APIResult info(){
        JSONObject object = new JSONObject();
        object.put("roles",new String[]{"admin"});
        object.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        object.put("name","Super Admin");
        return APIResultUtil.returnSuccessResult(object);
    }

    /**
     * 列表
     * @return
     */
    @RequestMapping("list")
    public APIResult list(@RequestParam Map<String,Object> param,
                          @RequestParam(defaultValue = "1")Integer pageNo,
                          @RequestParam(defaultValue = "10")Integer pageSize){
        PageHelper.startPage(pageNo,pageSize);
        List<Map<String,Object>> list = userService.findByCondition(param);
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(list);
        return APIResultUtil.returnSuccessResult(pageInfo);
    }

    @RequestMapping("addUser")
    public APIResult addUser(UserVO user){
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user,userEntity);
        userService.save(userEntity);
        return APIResultUtil.returnSuccessResult(null);
    }

    @RequestMapping("updateUser")
    public APIResult updateUser(UserVO user){
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user,userEntity);
        userService.updateSelective(userEntity);
        return APIResultUtil.returnSuccessResult(null);
    }

    @RequestMapping("deleteUser")
    public APIResult deleteUser(@RequestParam String id){
        userService.delete(id);
        return APIResultUtil.returnSuccessResult(null);
    }

    @RequestMapping("restPassword")
    public APIResult restPassword(@RequestParam String id,@RequestParam String password){
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setPassword(md5Password);
        userService.updateSelective(userEntity);
        return APIResultUtil.returnSuccessResult(null);
    }

}
