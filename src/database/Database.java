package database;


import models.Announcement;
import models.User;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<User> users = new ArrayList<>();


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Announcement> getAnnouncements() {
        List<Announcement> announcements = new ArrayList<>();
        for (User user : users) {
            announcements.addAll(user.getAnnouncements());
        }
        return announcements;
    }
}
