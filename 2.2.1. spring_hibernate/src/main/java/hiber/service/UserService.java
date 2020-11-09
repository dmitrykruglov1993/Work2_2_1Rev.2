package hiber.service;

import hiber.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    List<User> listUsersCar();
}
