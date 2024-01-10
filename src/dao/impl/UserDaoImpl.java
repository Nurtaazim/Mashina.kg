package dao.impl;

import dao.UserDao;
import database.Database;
import generateId.ID;
import models.Announcement;
import models.User;

public class UserDaoImpl implements UserDao {
    private final Database database;

    public UserDaoImpl(Database database) {
        this.database = database;
    }

    @Override
    public String register(User newUser) {
        newUser.setId(ID.generateId());
        database.getUsers().add(newUser);
        return "Successfully saved!";
    }

    @Override
    public User login(String gmail, String password) {
        for (User user : database.getUsers()) {
            if (user.getGmail().equals(gmail) && user.getPassword().equals(password)) return user;
        }
        return null;
    }

    @Override
    public String addAnnouncement(Announcement announcement, User user) {
        announcement.setId(ID.generateId());
        user.getAnnouncements().add(announcement);
        return "Successfully added!";
    }

    @Override
    public String deleteAnnouncement(long id, User user) {
        for (Announcement announcement : user.getAnnouncements()) {
            if (announcement.getId() == id){
                user.getAnnouncements().remove(announcement);
                return "Successfully deleted!";
            }
        }
        return "Обьявление с таким id не найдено!";
    }

    @Override
    public void addAnnouncementToFovarite(long id, User user) {
        for (Announcement announcement : database.getAnnouncements()) {
            if (announcement.getId() == id){
                user.getFavorites().add(announcement);
            }
        }
    }
}
