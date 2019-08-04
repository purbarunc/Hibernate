package com.purbarun.hibernate.dao;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.purbarun.hibernate.dto.Player;
import com.purbarun.hibernate.dto.Team;

@DisplayName("TeamDao under Test")
@TestMethodOrder(OrderAnnotation.class)
class TeamDaoTest {

	TeamDao dao;

	@BeforeEach
	void createObject() {
		dao = new TeamDao();
	}

	@Test
	@DisplayName("Testing save method")
	@Order(1)
	void createTest() {
		Team team=new Team();
		Player player1=new Player();
		player1.setName("Messi");
		player1.setNationality("Argentina");
		
		Player player2=new Player();
		player2.setName("Suarez");
		player2.setNationality("Uruguay");
		
		ArrayList<Player> players = new ArrayList<>();
		players.add(player1);
		players.add(player2);
		team.setName("FC Barcelona");
		team.setCountry("Spain");
		team.setPlayer(players);
		dao.saveTeam(team);
	}
	@Test
	@DisplayName("Testing find method")
	@Order(2)
	void findTest() {
		Team team=dao.findById(1);
		List<Player> actualPlayers=team.getPlayer();
		Player player1=new Player();
		player1.setId(1);
		player1.setName("Messi");
		player1.setNationality("Argentina");
		Player player2=new Player();
		player2.setId(2);
		player2.setName("Suarez");
		player2.setNationality("Uruguay");
		assertThat(actualPlayers.get(0)).isEqualToComparingFieldByField(player1);
		assertThat(actualPlayers.get(1)).isEqualToComparingFieldByField(player2);
	}
}
