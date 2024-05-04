package carvares.webapp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import carvares.webapp.entities.User;
import carvares.webapp.services.UserService;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserResource {
    @Autowired
    private UserService service;

    @GetMapping("/")
    public List<User> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping("/")
    public User insert(@RequestBody User obj) {
        User user = new User(null, obj.getName(), obj.getEmail(), obj.getPassword());
        return service.insert(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") Long id, @RequestBody User obj) {
        return service.update(id, obj);
    }

}
