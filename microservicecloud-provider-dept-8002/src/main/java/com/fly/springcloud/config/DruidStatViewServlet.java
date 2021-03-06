package com.fly.springcloud.config;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @author fly
 * @date 2018/6/30 17:03
 * @description Druid的Servlet
 **/
@WebServlet(urlPatterns = "/druid/*",
initParams = {
        /**IP白名单(没有配置或者为空，则允许所有访问*/
        @WebInitParam(name = "allow", value = ""),
        /**IP黑名单 (存在共同时，deny优先于allow)  */
        @WebInitParam(name = "deny", value = ""),
        /**用户名*/
        @WebInitParam(name = "loginUsername", value = "admin"),
        /**密码*/
        @WebInitParam(name = "loginPassword", value = "123456"),
        /**禁用HTML页面上的“Reset All”功能  */
        @WebInitParam(name = "resetEnable", value = "fasle")
})
public class DruidStatViewServlet extends StatViewServlet {

}
