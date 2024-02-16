package org.jsp.usermvcapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.jsp.usermvcapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private EntityManager manager;

	public User saveUser(User u) {
		EntityTransaction transaction = manager.getTransaction();
		manager.persist(u);
		transaction.begin();
		transaction.commit();
		return u;
	}

	public User updateUser(User u) {
		User dbUser = manager.find(User.class, u.getId());
		if (dbUser != null) {
			EntityTransaction transaction = manager.getTransaction();
			dbUser.setName(u.getName());
			dbUser.setPhone(u.getPhone());
			dbUser.setEmail(u.getEmail());
			dbUser.setPassword(u.getPassword());
			transaction.begin();
			transaction.commit();
			return dbUser;
		}
		return null;
	}

	public User findUserById(int id) {
		User u = manager.find(User.class, id);
		if (u != null) {
			return u;
		}
		return null;
	}

	public User verifyUser(long phone, String password) {
		Query q = manager.createQuery("select u from User u where u.phone=?1 and u.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public User verifyUser(String email, String password) {
		Query q = manager.createQuery("select u from User u where u.email=?1 and u.password=?2");
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public User verifyUser(int id, String password) {
		Query q = manager.createQuery("select u from User u where u.id=?1 and u.password=?2");
		q.setParameter(1, id);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public User deleteUser(int id) {
		User u = manager.find(User.class, id);
		if (u != null) {
			EntityTransaction transaction = manager.getTransaction();
			manager.remove(u);
			transaction.begin();
			transaction.commit();
			return u;
		}
		return null;
	}
}
