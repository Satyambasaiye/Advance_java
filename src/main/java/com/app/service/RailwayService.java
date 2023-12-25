package com.app.service;

import java.util.List;

import com.app.dto.RailwayReq;
import com.app.dto.RailwayRespDto;
import com.app.entities.Category;
import com.app.entities.Railway;

public interface RailwayService {
	RailwayReq addRailway(RailwayReq rail);

	String deleteRailway(Long id);
	List<RailwayRespDto> getRailwayByCategory(Category cat);

}
