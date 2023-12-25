package com.app.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Category;
import com.app.entities.Railway;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
class RailwayDaoTest {
	@Autowired
	private RailwayDao railDao;
	

	@Test
	void test() {
		List<Railway>list=List.of(
				new Railway("sachkhand", Category.EXPRESS, LocalTime.now(), LocalTime.of(20, 23), "nanded", "amritsar"),
				new Railway("goa", Category.AC, LocalTime.now(), LocalTime.of(12, 23), "shrinagr", "panji"),
				new Railway("zelum", Category.RAJDHANI, LocalTime.now(), LocalTime.of(20, 23), "delhi", "pune"),
				new Railway("pune", Category.SF, LocalTime.now(), LocalTime.of(10, 23), "nanded", "pune"),
				new Railway("karnataka", Category.SHATABDI, LocalTime.now(), LocalTime.of(20, 23), "benglore", "delhi"));
			List<Railway> list2 = railDao.saveAll(list);
			assertEquals(5, list2.size());
		
	}

}
