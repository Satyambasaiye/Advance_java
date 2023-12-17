package dao;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Player;
import pojos.Team;

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

	@Override
	public String validateAndAddPlayer(String abb, Player player) {
		//get session
		String message="player is not valid";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			String jpql="select t from Team t where t.abbreviation=:abbreviation";
			Team team=session.createQuery(jpql, Team.class).setParameter("abbreviation", abb).getSingleResult();
			System.out.println(team);
			int age=(int)(Period.between(player.getDob(), LocalDate.now())).toTotalMonths()/12;
			if(team.getMaxAge()>age && team.getMinBattingAvg()<player.getBattingAvg() && team.getMinWicketsTaken()<player.getWicketsTaken())
			{
				team.addPlayer(player);
				System.out.println("inside if");
				message="player added successfully";

				
			}
			tx.commit();
			System.out.println(message);
		}catch(RuntimeException e)
		{
			tx.rollback();
			throw e;
		}
		return message;
	}

}
