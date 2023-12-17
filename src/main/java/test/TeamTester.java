package test;

import java.time.LocalDate;
import java.util.List;

import dao.TeamDaoImpl;
import pojos.Player;
public class TeamTester {

	public static void main(String[] args) {
		TeamDaoImpl teamDao=new TeamDaoImpl();
//		List<String> l=teamDao.getTeamsAbbreviations();
//		System.out.println("output:");
//		l.forEach(s->System.out.println(s));
		Player p=new Player("ms Dhoni", "dsf", LocalDate.parse("1999-07-07"), 65, 22);
		String s=teamDao.validateAndAddPlayer("csk", p);
		System.out.println(s);
	}
}
