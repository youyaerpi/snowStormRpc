package com.hzc.router.config;

import com.hzc.common.environment.ClassPathResource;
import com.hzc.common.environment.CommonEnvironment;
import com.hzc.common.environment.Environment;
import com.hzc.common.environment.Resource;

import java.io.IOException;

/**
 * @author: hzc
 * @Date: 2020/04/12  21:20
 * @Description:
 */
public class RouterConfigReader {
    /**
     * 获取配置集合
     *
     * @return
     */
    private static Environment readProperties() throws IOException {
        Resource classPathResource = new ClassPathResource();
        classPathResource.setResourceFile("router.properties");
        classPathResource.setClassLoader(Thread.currentThread().getContextClassLoader());
        Environment environment = new CommonEnvironment();
        environment.setResource(classPathResource);
        environment.loadProperties();
        return environment;
    }

    /**
     * 获取具体配置端口
     *
     * @return
     */
    public static Integer getServerPort() throws IOException {
        Environment environment = readProperties();
        String serverPort = environment.getPropertyValue("router.server.port");
        boolean matches = serverPort.matches("^[0-9]*$");
        if (!matches) {
            throw new RuntimeException("Illegal characters the" + serverPort + "is not integer type");
        }

        return Integer.valueOf(serverPort);
    }

    /**
     * 获取dispatcher地址
     *
     * @return
     */
    public static String getDispatcherAddr() throws IOException {
        Environment environment = readProperties();
        return environment.getPropertyValue("router.dispatcher.server.addr");
    }
}
