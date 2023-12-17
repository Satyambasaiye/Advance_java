package beans;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import dao.TeamDaoImpl;
import pojos.Player;
import pojos.Team;

public class addPlayerBean {
	private String name;
	private String dob;
	private double avg;
	private String abbr;
	private int wickets;
	private TeamDaoImpl teamDao;
	public addPlayerBean() {
		teamDao=new TeamDaoImpl();
	}
	private Team team;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbr() {
		return abbr;
	}
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public TeamDaoImpl getTeamDao() {
		return teamDao;
	}
	public void setTeamDao(TeamDaoImpl teamDao) {
		this.teamDao = teamDao;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public String addPlayer() {
		if (dob != null && !dob.isEmpty()) {
	        try {
	            LocalDate date = LocalDate.parse(dob);
	            teamDao.validateAndAddPlayer(abbr, new Player(name, "xyz", date, avg, wickets));
	            return "player added";
	        } catch (DateTimeParseException e) {
	            return "Invalid date format for Date of Birth";
	        }
	    } else {
	        return "Date of Birth cannot be null or empty";
	    }
	}
	
}
