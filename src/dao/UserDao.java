package dao;

import models.Announcement;
import models.User;

public interface UserDao {
    String register(User newUser);
    User login (String gmail, String password);
    String addAnnouncement(Announcement announcement, User user);
    String deleteAnnouncement(long id, User user);
    void addAnnouncementToFovarite(long id, User user);
}
