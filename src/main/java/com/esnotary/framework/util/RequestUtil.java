package com.esnotary.framework.util;

import com.alibaba.fastjson.JSONObject;
import com.esnotary.framework.result.APIResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Auther: zhiwei
 * @Date: 2019/8/8 23:24
 * @Description:
 */
public class RequestUtil {

    public static void returnJson(HttpServletResponse response, Object result) throws Exception{
        String json = JSONObject.toJSONString(result);
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0L);
        writer = response.getWriter();
        writer.print(json);
    }

    public static Map<String, Object> getParamterMap(HttpServletRequest request) {
        Map<String, Object> params = new LinkedHashMap<String, Object>();
        Map<String, String[]> map = request.getParameterMap();
        int len;
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            len = entry.getValue().length;
            if (len == 1) {
                params.put(entry.getKey(), entry.getValue()[0]);
            } else if (len > 1) {
                String[] vs = new String[entry.getValue().length];
                for (int i=0;i<vs.length;i++){
                    vs[i] = entry.getValue()[i];
                }
                params.put(entry.getKey(), vs);
            }
        }
        return params;
    }

}
