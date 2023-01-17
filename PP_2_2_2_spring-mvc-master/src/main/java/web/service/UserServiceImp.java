package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.User;
import web.repositories.UsersRepositories;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImp {

    private final UsersRepositories usersRepositories;

    @Autowired
    public UserServiceImp(UsersRepositories usersRepositories) {
        this.usersRepositories = usersRepositories;
    }

    public List<User> findAll() {
        return usersRepositories.findAll();
    }

    public User findOne(Long id) {
        Optional<User> foundPerson = usersRepositories.findById(id);
        return foundPerson.orElse(null);
    }

    @Transactional
    public void save(User user) {
        usersRepositories.save(user);
    }

    @Transactional
    public void delete(Long id) {
        usersRepositories.deleteById(id);
    }

    @Transactional
    public void update(long id, User user) {
        user.setId(id);
        usersRepositories.save(user);
    }

}
