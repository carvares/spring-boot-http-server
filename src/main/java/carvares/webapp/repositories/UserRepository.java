package carvares.webapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import carvares.webapp.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
