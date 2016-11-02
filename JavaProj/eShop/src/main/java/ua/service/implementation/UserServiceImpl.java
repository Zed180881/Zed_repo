package ua.service.implementation;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Role;
import ua.entity.User;
import ua.form.filter.UserFilter;
import ua.repository.UserRepository;
import ua.service.UserService;
import ua.service.implementation.specification.UserFilterSpecification;

@Service("userDetailsService")
public class UserServiceImpl implements UserDetailsService, UserService {
    private User user;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public void save(User user) {	
	user.setPassword(encoder.encode(user.getPassword()));
	userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUserFullName(String userFullName) {
	return userRepository.findByFullName(userFullName);
    }

    @Override
    public void deleteByUserFullName(String userFullName) {
	if ((user = userRepository.findByFullName(userFullName)) != null)
	    userRepository.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
	return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findOne(int id) {
	return userRepository.findOne(id);
    }

    @Override
    public void deleteById(int id) throws DataIntegrityViolationException {
	userRepository.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUserLogin(String login) {
	return userRepository.findByLogin(login);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUserMail(String mail) {
	return userRepository.findByMail(mail);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> findAll(Pageable pageable) {
	return userRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> findAll(Pageable pageable, UserFilter filter) {
	return userRepository.findAll(new UserFilterSpecification(filter),
		pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username)
	    throws UsernameNotFoundException {
	return userRepository.findByLogin(username);
    }

    @PostConstruct
    public void postConstruct() {
	if (userRepository.findOne(1) == null) {
	    User user = new User();
	    user.setId(1);
	    user.setLogin("admin");
	    user.setRole(Role.ROLE_ADMIN);
	    user.setPassword(encoder.encode("admin"));
	    userRepository.save(user);
	}

    }
}
