package dao.impl;

import dao.AnnouncementDao;
import database.Database;

public class AnnouncementDaoImpl implements AnnouncementDao {
    private final Database database ;

    public AnnouncementDaoImpl(Database database) {
        this.database = database;
    }
}
