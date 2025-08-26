package web.servece;

import web.model.User;

import java.util.List;

public interface UserServece {

    List<User> index();

    User show(int id);

    void update(int id, User updatedUser);

    void delete(int id);

    void save(User user);
}
