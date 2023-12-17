package pojos;


import java.util.ArrayList;

import java.util.List;

import javax.persistence.*;

/*
 * id , name, abbreviation,owner,max_age,batting_avg,wickets_taken	
 */
@Entity
@Table(name = "teams" )
public class Team extends BaseEntity {
	@Column(length = 100,unique = true)
	private String name;
	@Column(length = 10,unique = true)
	private String abbreviation;
	@Column(length = 20)
	private String owner;
	
	private int maxAge;
	private double minBattingAvg;
	@Column(name = "minimum_wickets")
	private int minWicketsTaken;
//	team 1-->*player
//	terms : one ,parent table, inverse(sincce no fk here)
	@OneToMany(mappedBy = "myTeam",cascade = CascadeType.ALL,orphanRemoval =true)
	private List<Player>players=new ArrayList();//initialize collection based property to empty
	


	public Team() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Team(int teamId, String name, String abbreviation, String owner, int maxAge, double minBattingAvg,
			int minWicketsTaken) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxAge = maxAge;
		this.minBattingAvg = minBattingAvg;
		this.minWicketsTaken = minWicketsTaken;
	}


	public List<Player> getPlayers() {
		return players;
	}


	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	public double getMinBattingAvg() {
		return minBattingAvg;
	}
	public void setMinBattingAvg(double minBattingAvg) {
		this.minBattingAvg = minBattingAvg;
	}
	public int getMinWicketsTaken() {
		return minWicketsTaken;
	}
	public void setMinWicketsTaken(int minWicketsTaken) {
		this.minWicketsTaken = minWicketsTaken;
	}
	public void addPlayer(Player p) {
		this.players.add(p);
		p.setMyTeam(this);
	}
	public void removePlayer(Player p)
	
	{
		this.players.remove(p);
		p.setMyTeam(null);
	}
	@Override
	public String toString() {
		return "Team [teamId=" +getId() + ", name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner
				+ ", maxAge=" + maxAge + ", minBattingAvg=" + minBattingAvg + ", minWicketsTaken=" + minWicketsTaken
				+ "]";
	}
	
}
