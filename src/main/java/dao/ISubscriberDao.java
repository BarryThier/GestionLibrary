package dao;

import java.util.List;

import metier.entities.Subscriber;

public interface ISubscriberDao {
	
	public Subscriber save (Subscriber subscriber);
	public List<Subscriber> getAllSubscriber();
	public Subscriber getSubscriber(int id);
	public Subscriber updateSubscriber(Subscriber subscriber);
	public void deleteSubscriber(int numMatricule);
	
	
	
	
	
}
