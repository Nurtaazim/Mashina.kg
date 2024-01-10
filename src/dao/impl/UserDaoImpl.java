package dao.impl;

import dao.UserDao;
import database.Database;

public class UserDaoImpl implements UserDao {
    private final Database database;

    public UserDaoImpl(Database database) {
        this.database = database;
    }
}
