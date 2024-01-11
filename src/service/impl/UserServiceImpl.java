package service.impl;

import dao.impl.UserDaoImpl;
import models.Announcement;
import models.User;
import service.UserService;

public class UserServiceImpl implements UserService {
    private final UserDaoImpl userDao;

    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public String register(User newUser) {
        return userDao.register(newUser);
    }

    @Override
    public User login(String gmail, String password) {
        return userDao.login(gmail, password);
    }

    @Override
    public String addAnnouncement(Announcement announcement, User user) {
        return userDao.addAnnouncement(announcement, user);
    }

    @Override
    public String deleteAnnouncement(long id, User user) {
        return userDao.deleteAnnouncement(id, user);
    }

    @Override
    public void addAnnouncementToFovarite(long id, User user) {
        userDao.addAnnouncementToFovarite(id, user);
    }
}
