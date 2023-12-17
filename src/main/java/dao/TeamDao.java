package dao;

import java.util.List;

import pojos.Player;

public interface TeamDao {
	List<String>getTeamsAbbreviations();
	String validateAndAddPlayer(String abb,Player player);

}
