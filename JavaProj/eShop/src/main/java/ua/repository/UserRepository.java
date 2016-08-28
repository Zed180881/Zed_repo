package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>,
	JpaSpecificationExecutor<User> {

    User findByFullName(String fullName);

    User findByLogin(String login);

    User findByMail(String mail);
}
