package dao.impl;

import dao.AnnouncementDao;
import database.Database;
import models.Announcement;

import java.util.List;

public class AnnouncementDaoImpl implements AnnouncementDao {
    private final Database database ;

    public AnnouncementDaoImpl(Database database) {
        this.database = database;
    }

    @Override
    public String add(Announcement announcement) {

        database.getAnnouncements().add(announcement);
        return "Successfully added!";
    }

    @Override
    public String delete(long id) {
        return null;
    }

    @Override
    public Announcement findById(long id) {
        return null;
    }

    @Override
    public List<Announcement> getAll() {
        return null;
    }
}
