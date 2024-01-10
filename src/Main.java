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
                    else {
                        System.out.println("Wellcome");
                        System.out.println("""
                                1 - Избранные
                                2 - Добавить рекламу
                                3 - Рекламы
                                4 - Удалить рекламу
                                5 - Мои обьявление
                                """);
                        switch (scanner.nextLine()){
                            case "1"->{
                                System.out.println(user.getFavorites());
                            }
                            case "2"->{
                               if (user.getRole().equals(Role.USER)){
                                   System.out.println("Вы не можете опубликовать обьявление!");
                               }else {
                                   Announcement announcement = new Announcement();
                                   System.out.println("Напишите название машины:");
                                   announcement.setName(scanner.nextLine());
                               }
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
                            Если вы покупатель нажмите 1
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