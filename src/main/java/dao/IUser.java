package dao;

import java.util.List;

import metier.entities.User;

public interface IUser {
	
	public User save(User user);
	public List<User> users ();
	public User getUser (long user_id);
	public User updateUser(User user);
	public void deleteUser(long user_id);
}
