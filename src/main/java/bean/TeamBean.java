package bean;

import java.util.List;

import dao.TeamDaoImpl;

public class TeamBean {

	//dep: team dao
	private TeamDaoImpl teamDao;
	public TeamBean() {
		teamDao=new TeamDaoImpl();
		System.out.println("team bean n dao createed!");
	}
	
//	B.L. method to send all abbrs to jsp
	public List<String>getAbbreviations()
	{
		return teamDao.getTeamsAbbreviations();
	}
}
