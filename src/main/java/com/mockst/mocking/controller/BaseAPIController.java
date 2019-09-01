package com.mockst.mocking.controller;
import com.esnotary.framework.util.RedisKeyConstants;
import com.esnotary.framework.util.RedisUtil;
import com.mockst.mocking.module.role.service.RoleService;
import com.mockst.mocking.module.user.entity.UserEntity;
import com.mockst.mocking.module.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * @author linzhiwei
 * @Description:
 * @date 2019/4/11 19:19
 */
public abstract class BaseAPIController {

    Logger LOGGER = LoggerFactory.getLogger(BaseAPIController.class);

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    /**
     * 导出（文件下载）
     * @param response
     * @param fileName 下载文件名
     * @param data 文件流
     */
    protected void downloadFile(HttpServletResponse response, String fileName,byte[] data){
        try {
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "utf-8"));
            OutputStream out = response.getOutputStream();
            out.write(data);
            out.flush(); // 缓冲
            out.close();
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

    }

    protected String getTokenKey(String token){
        return RedisKeyConstants.getRedisKey(RedisKeyConstants.USER_SESSION_KEY,token);
    }

    /**
     * 设置用户缓存
     * @param token
     * @param userEntity
     */
    protected void setCurrentUser(String token, UserEntity userEntity){
        if (userEntity == null){
            LOGGER.warn( " ->> 当前userEntity为空 <<- ");
            return;
        }
        String key = getTokenKey(token);
        redisUtil.set(key,userEntity.getId());
    }

    /**
     * 获取缓存的用户
     * @param request
     * @return
     */
    protected UserEntity getCurrentUser(HttpServletRequest request){
        String token = request.getParameter("token");
        String key = getTokenKey(token);
        String userId = (String) redisUtil.get(key);
        if (userId == null){
            LOGGER.warn(" ->> 当前userId不存在 <<- ");
            return null;
        }
        return userService.selectByKey(userId);
    }

    /**
     * 清除缓存的用户
     * @param request
     */
    protected void delCurrentUser(HttpServletRequest request){
        String token = request.getParameter("token");
        String key = getTokenKey(token);
        redisUtil.del(key);
    }
}
