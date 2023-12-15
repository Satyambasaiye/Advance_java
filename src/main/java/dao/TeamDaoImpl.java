package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Player;

import static utils.HibernateUtils.getFactory;

public class TeamDaoImpl implements TeamDao {

	@Override
	public List<String> getTeamsAbbreviations() {
		List<String>list;
		// 1. get session from SF
		Session session=getFactory().getCurrentSession();
		//2. begin a tx
		Transaction tx=session.beginTransaction();
		try {
			String jpql="select t.abbreviation from Team t ";
			list=session.createQuery(jpql, String.class).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
	
		
		return list;
	}

}
