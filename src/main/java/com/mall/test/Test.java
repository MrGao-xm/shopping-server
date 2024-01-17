package com.mall.test;

import com.mall.dao.UserDao;
import com.mall.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Test {
    public static void main(String[] args) {
        InputStream inputStream = Test.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        for (User user : userDao.findAll()) {
//            System.out.println(user);
//        }
//        System.out.println(userDao.findById(4));
//         userDao.deleteById(1);
        User user = new User(3,"zhangsan","123456","151655645");
        userDao.add(user);
        sqlSession.close();
    }
}
