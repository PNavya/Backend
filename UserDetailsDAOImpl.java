package com.niit.ShoppingCart.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingCart.model.UserDetails;
@EnableTransactionManagement

@Repository("userdetailsDAO")

public class UserDetailsDAOImpl implements UserDetailsDAO{
	
	@Autowired
	private SessionFactory sessionfactory;
	public UserDetailsDAOImpl(SessionFactory sessionfactory)
	{
		this.sessionfactory=sessionfactory;
	}
	 @Transactional
		public boolean save(UserDetails userdetails) {
			try {
				Session s=sessionfactory.getCurrentSession();
				Transaction tx=s.beginTransaction();
				//sessionFactory.getCurrentSession().save(category);
				s.save(userdetails);
				tx.commit();
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

		}
	   @Transactional
		public boolean update(UserDetails userdetails) {
			try {
				Session s=sessionfactory.getCurrentSession();
				Transaction tx=s.beginTransaction();
				s.update(userdetails);
				tx.commit();
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

		}
	@Transactional
		public boolean delete(UserDetails userdetails) {
			try {
				Session s=sessionfactory.getCurrentSession();
				Transaction tx=s.beginTransaction();
				s.delete(userdetails);
				tx.commit();
				return true;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}

		}
	@Transactional
		public UserDetails get(int id) {

			String hql = "from UserDetails where id=" + " ' " + id + "'";
			Query query = sessionfactory.getCurrentSession().createQuery(hql);
			List<UserDetails> list = query.list();
			if (list == null)

				return null;
			else {
				return list.get(0);
			}
		}
	
	@Transactional
	public UserDetails isValidUser(String name,String password)
	{
		Session s=sessionfactory.getCurrentSession();
		Transaction tx=s.beginTransaction();
		
		//select * from UserDetails where id='101' and password='niit'
		String hql="from UserDetails where name = '" +name+"' and password='"+password+"'";
		org.hibernate.Query query=s.createQuery(hql);
		
		List<UserDetails> list=query.list();
		tx.commit();
		if (list == null)

			return null;
		else {
			return list.get(0);
		}
		
	}
	@Transactional
		public List<UserDetails> list() {
			String hql = "from UserDetails";
			Query query = sessionfactory.getCurrentSession().createQuery(hql);
			return query.list();

		}

	
	
	
	
}
