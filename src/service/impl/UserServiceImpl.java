package service.impl;

import dao.impl.UserDaoImpl;
import service.UserService;

public class UserServiceImpl implements UserService {
    private final UserDaoImpl userDao;

    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }
}
