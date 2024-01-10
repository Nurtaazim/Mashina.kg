package service.impl;

import dao.impl.AnnouncementDaoImpl;
import service.AnnouncementService;

public class AnnouncementServiceImpl implements AnnouncementService {
    private final AnnouncementDaoImpl announcementDao;

    public AnnouncementServiceImpl(AnnouncementDaoImpl announcementDao) {
        this.announcementDao = announcementDao;
    }
}
