package web.servece;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@Service
public class UserServeceImpl implements UserServece{

    private UserDao userDao;
    @Autowired
    public UserServeceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> index() {
        return userDao.index();
    }
    @Transactional(readOnly = true)
    @Override
    public User show(int id) {
        return userDao.show(id);
    }
    @Transactional
    @Override
    public void update(int id, User updatedUser) {
        userDao.update(id,updatedUser);
    }
    @Transactional
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }
}
