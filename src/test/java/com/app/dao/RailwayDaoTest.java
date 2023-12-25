package com.app.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
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
				new Railway("sachkhand", Category.EXPRESS, LocalDateTime.now(), LocalDateTime.of(2022, 12, 22, 12, 12), "nanded", "amritsar"),
				new Railway("goa", Category.AC, LocalDateTime.now(), LocalDateTime.of(2022, 12, 22, 12, 12), "shrinagr", "panji"),
				new Railway("zelum", Category.RAJDHANI, LocalDateTime.now(), LocalDateTime.of(2022, 12, 22, 12, 12), "delhi", "pune"),
				new Railway("pune", Category.SF, LocalDateTime.now(), LocalDateTime.of(2022, 12, 22, 12, 12), "nanded", "pune"),
				new Railway("karnataka", Category.SHATABDI, LocalDateTime.now(), LocalDateTime.of(2022, 12, 22, 12, 12), "benglore", "delhi"));
			List<Railway> list2 = railDao.saveAll(list);
			assertEquals(5, list2.size());
		
	}

}
