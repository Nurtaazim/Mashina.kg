package dao;

import models.Announcement;

import java.util.List;

public interface AnnouncementDao {
    String add (Announcement announcement);
    String update ();
    String delete ();
    Announcement findById(long id);
    List<Announcement> getAll();


}
