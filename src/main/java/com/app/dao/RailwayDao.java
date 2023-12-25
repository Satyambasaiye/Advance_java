package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Railway;

import net.bytebuddy.asm.Advice.Return;
import com.app.entities.Category;


public interface RailwayDao extends JpaRepository<Railway, Long> {
	
	
	List<Railway> findByType(Category type);

}
