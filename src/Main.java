import dao.impl.UserDaoImpl;
import database.Database;
import enums.Role;
import generateId.ID;
import models.Announcement;
import models.User;
import service.impl.UserServiceImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();
        UserDaoImpl userDao = new UserDaoImpl(database);
        UserServiceImpl userService = new UserServiceImpl(userDao);
        User user = new User();
        MainLoop:
        while (true){
            System.out.println("""
                    1 - Войти
                    2 - Зарегистрироваться
                    3 - Выйти из сайта
                    """);
            switch (scanner.nextLine()){
                case "1" ->{
                    System.out.println("Ввыведите эл.почту:");
                    String gmail = scanner.nextLine();
                    System.out.println("Ввыведите пароль:");
                    String pass = scanner.nextLine();
                    user = userService.login(gmail, pass);
                    if (user == null) break ;
                    System.out.println("Wellcome");
                    Loop:
                    while (true) {

                        System.out.println("""
                                1 - Избранные
                                2 - Добавить рекламу
                                3 - Рекламы
                                4 - Удалить рекламу
                                5 - Мои обьявление
                                6 - Добавить в избранные
                                0 - Выйти
                                """);
                        switch (scanner.nextLine()) {
                            case "1" -> {
                                System.out.println(user.getFavorites());
                            }
                            case "2" -> {
                                if (user.getRole().equals(Role.USER)) {
                                    System.out.println("Вы не можете опубликовать обьявление!");
                                } else {
                                    Announcement announcement = new Announcement();
                                    System.out.println("Напишите название машины:");
                                    announcement.setName(scanner.nextLine());
                                    System.out.println("Напишите описание:");
                                    announcement.setDescription(scanner.nextLine());
                                    System.out.println(":");
                                    announcement.setPrice(new Scanner(System.in).nextDouble());
                                    announcement.setOwner(user);
                                    announcement.setId(ID.generateId());
                                    userService.addAnnouncement(announcement, user);
                                }
                            }
                            case "3" ->{
                                System.out.println(database.getAnnouncements());
                            }
                            case "4" ->{
                                System.out.println("Напишите id рекламы которого хотите удалить:");
                                long id = new Scanner(System.in).nextLong();
                                System.out.println(userService.deleteAnnouncement(id, user));
                            }
                            case "5" ->{
                                for (Announcement announcement : user.getAnnouncements()) {
                                    System.out.println(announcement);
                                }
                            }
                            case "6" ->{
                                System.out.println("Напишите айди рекламы чтобы добавить в избранные:");
                                long id = new Scanner(System.in).nextLong();
                                userService.addAnnouncementToFovarite(id, user);
                            }
                            case "0" -> {
                                user = null;
                                break Loop;
                            }
                        }
                    }
                }
                case "2" ->{
                    User newUser = new User();
                    System.out.println("Напишите свое имя:");
                    newUser.setName(scanner.nextLine());
                    System.out.println("Напишите свою эл.почту:");
                    newUser.setGmail(scanner.nextLine());
                    System.out.println("Напишите пароль:");
                    newUser.setPassword(scanner.nextLine());
                    System.out.println("""
                            Если вы продавец нажмите 1
                            Если вы покупатель нажмите 2
                            """);
                    switch (scanner.nextLine()){
                        case "1" ->{
                            newUser.setRole(Role.VENDOR);
                        }
                        case "2" ->{
                            newUser.setRole(Role.USER);
                        }
                    }
                    System.out.println(userService.register(newUser));
                }
                case "3" ->{
                    break MainLoop;
                }
                default -> {
                    System.err.println("Не правильная команда!");
                }
            }
        }
    }
}