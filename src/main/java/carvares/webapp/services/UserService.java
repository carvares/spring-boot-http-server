package carvares.webapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import carvares.webapp.entities.User;
import carvares.webapp.repositories.UserRepository;
import carvares.webapp.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        try {
            return repository.findById(id).get();

        } catch (Exception e) {
            throw new ResourceNotFoundException();
        }
    }

    public User insert(User obj) {
        User user = new User(null, obj.getName(), obj.getEmail(), obj.getPassword());

        return repository.save(user);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException();
        }
    }

    public User update(Long id, User obj) {
        try {
            User entity = repository.findById(id).get();
            updateData(entity, obj);
            return repository.save(entity);
        } catch (Exception e) {
            throw new ResourceNotFoundException();
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPassword(obj.getPassword());
    }
}
