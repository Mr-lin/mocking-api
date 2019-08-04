package com.esnotary.framework.util;

import tk.mybatis.mapper.genid.GenId;

import java.util.UUID;

/**
 * @author linzhiwei
 * @Description:
 * @date 2019/3/29 15:37
 */
public class GenUtil implements GenId<String> {
    @Override
    public String genId(String s, String s1) {
        return UUID.randomUUID().toString().replace("-","");
    }
}
