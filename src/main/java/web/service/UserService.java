package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    User getUserById(long id);
    void updateUser(User user);
    void deleteUserById(long id);
    List<User> getAllUsers();
}
