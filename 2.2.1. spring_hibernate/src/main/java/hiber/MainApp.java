package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import hiber.service.UserServiceImp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      UserService userService1 = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      User user5 = new User("User5", "Lastname5", "user5@mail.ru");
      Car Mazda = new Car("Mazda",3);
      user5.setCar(Mazda);

      User user6 = new User("User6", "Lastname6", "user6@mail.ru");
      Car Opel = new Car("Opel",6);
      user6.setCar(Opel);

      User user7 = new User("User7", "Lastname7", "user7@mail.ru");
      Car Renault = new Car("Renault",7);
      user7.setCar(Renault);

      userService1.add(user5);
      userService1.add(user6);
      userService1.add(user7);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      List<User> users1 = userService1.listUsersCar();
      for (User user : users1) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car_model = "+user.getCar().getModel());
         System.out.println("Car_serias = "+user.getCar().getSeries());
         System.out.println();
      }

      context.close();
   }
}
