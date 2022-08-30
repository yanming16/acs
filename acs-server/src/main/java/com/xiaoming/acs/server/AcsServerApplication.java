package com.xiaoming.acs.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author yanming03
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)
@MapperScan(basePackages = {"com.xiaoming.acs.db.mapper"})
@SpringBootApplication(scanBasePackages = {"com.xiaoming.acs"})
public class AcsServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(AcsServerApplication.class)
                .web(WebApplicationType.SERVLET)
                .registerShutdownHook(true)
                .build().run(args);    }

}
