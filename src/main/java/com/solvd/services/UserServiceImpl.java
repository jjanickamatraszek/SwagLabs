package com.solvd.services;

import com.solvd.dao.interfaces.UserDao;
import com.solvd.model.User;
import com.solvd.utils.MyBatisDaoFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserServiceImpl implements UserService {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDaoFactory.getSqlSessionFactory();

    @Override
    public User getById(int id) {
        User user;
        try (SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            UserDao userDAO = sqlSession.getMapper(UserDao.class);
            user = userDAO.getById(id);
        }
        return user;
    }
}
