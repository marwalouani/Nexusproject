package service;

import java.util.List;

import javax.ejb.Remote;

import entities.User;



@Remote
public interface userServiceRemote {
	public int addUser(User user);
	public void removeUser(int id);
	public void updateUser(User user);
	public User findUserById(int id);
	public List<User> findAllUsers();
	public User getEmployeByEmailAndPassword(String email, String password);
	 public List<User> getAllEmployes();

}
