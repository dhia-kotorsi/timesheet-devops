package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;



	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);

	@Override
	public List<User> retrieveAllUsers() { 
		try {
			return userRepository.findAll();
		} catch (Exception e) {
			l.error("error in retrieveAllUsers() : ", e);
			return null;
		}
	}


	@Override
	public User addUser(User u) {

		User utilisateur = null; 

		try {
			l.info("Adding user: {} {}", u.getFirstName(), u.getLastName());
			utilisateur = userRepository.save(u); 
			l.info("User added with id {}", utilisateur.getId());

		} catch (Exception e) {
			l.error("error in addUser() : ", e);
		}

		return utilisateur; 
	}

	@Override 
	public User updateUser(User u) {

		User userUpdated = null; 

		try {
			l.info("Updating user id {}", u.getId());
			userUpdated = userRepository.save(u); 
			l.info("User updated id {}", userUpdated.getId());

		} catch (Exception e) {
			l.error("error in updateUser() : ", e);
		}

		return userUpdated; 
	}

	@Override
	public void deleteUser(String id) {

		try {
			l.info("Deleting user id {}", id);
			userRepository.deleteById(Long.parseLong(id)); 
			l.info("Deleted user id {}", id);

		} catch (Exception e) {
			l.error("error in deleteUser() : ", e);
		}

	}

	@Override
	public User retrieveUser(String id) {
		try {
			return userRepository.findById(Long.parseLong(id)).orElse(null);
		} catch (Exception e) {
			l.error("error in retrieveUser() : ", e);
			return null;
		}
	}

	
	
	
}
