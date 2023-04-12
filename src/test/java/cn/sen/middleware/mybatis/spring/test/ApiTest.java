package cn.sen.middleware.mybatis.spring.test;


import cn.sen.middleware.mybatis.Resources;
import cn.sen.middleware.mybatis.spring.test.dao.IUserDao;
import cn.sen.middleware.mybatis.spring.test.po.User;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.Reader;
import java.util.Map;

/**
 * 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    ApplicationContext context;

    @Test
    public void test_ClassPathXmlApplicationContext() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");

        IUserDao userDao = beanFactory.getBean("IUserDao", IUserDao.class);


        User user = userDao.queryUserInfoById(1L);
        logger.info("测试结果：{}", JSON.toJSONString(user));
    }

    @Test
    public void test_yml() throws IOException {
        Reader reader = Resources.getResourceAsReader("application.yml");
        Map map = (Map) new Yaml().load(reader);
        System.out.println(map.toString());
        System.out.println(((Map)((Map)map.get("mybatis")).get("datasource")).get("basePackage"));
    }

}
