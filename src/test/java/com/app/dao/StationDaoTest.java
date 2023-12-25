package com.app.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Railway;
import com.app.entities.Station;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
class StationDaoTest {

	@Autowired
	private StationDao stationDao;
	@Autowired 
	RailwayDao railDao;
	@Test
	void test() {
		Railway rail=railDao.findById(1L).get();
		Railway rail2=railDao.findById(1L).get();

		
		List<Station>list=List.of(new Station("st001", "pune", 6),
				new Station("st002", "pune", 6),
				new Station("st006", "mumbai", 5),
				new Station("st003", "dailhi", 7),
				new Station("st004", "bhusawal",8),
				new Station("st005", "sambhajinagar", 8));
		list.forEach(e->{
			rail.addStation(e);
		});
	
		List<Station> list2 = stationDao.saveAll(list);
		assertEquals(6, list2.size());
		
//		fail("Not yet implemented");
	}

}
