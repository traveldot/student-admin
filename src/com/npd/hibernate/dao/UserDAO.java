package com.npd.hibernate.dao;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.npd.hibernate.bean.User;

public class UserDAO {

	public void addUserDetails(User user){
		Session session = null;
		Transaction transaction=null;
		try{
			session = new Configuration().configure().buildSessionFactory().openSession();
			System.out.println("Session created .....");
			transaction = session.beginTransaction();
			System.out.println("Transaction begin .....");
			session.save(user);
			transaction.commit();
			System.out.println("Data Saved");
		}catch(HibernateException ex){
			if (transaction !=null)
					transaction.rollback();
			System.out.println("Exception in tranaction:"+ex);			
		}
		finally{
			if (session != null && session.isOpen()){
				session.close();
				session=null;
			}
			if (transaction!=null && transaction.isActive()){
				transaction.commit();
			}
			
		}
		
	}
	
	
}
