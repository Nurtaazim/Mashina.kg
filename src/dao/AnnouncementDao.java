package dao;

import models.Announcement;

import java.util.List;

public interface AnnouncementDao {
    String add (Announcement announcement);
    String delete (long id);
    Announcement findById(long id);
    List<Announcement> getAll();


}
