package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.RailwayDao;
import com.app.dto.RailwayReq;
import com.app.dto.RailwayRespDto;
import com.app.entities.Category;
import com.app.entities.Railway;

@Service
@Transactional

public class RailwayServiceImpl implements RailwayService {
	@Autowired
	private RailwayDao railDao;
	@Autowired 
	private ModelMapper mapper;

	@Override
	public RailwayReq addRailway(RailwayReq rail) {
		// TODO Auto-generated method stub
		Railway railway = mapper.map(rail, Railway.class);
		System.out.println(railway);
		Railway save = railDao.save(railway);
		
		
		return mapper.map(save, RailwayReq.class);
	}

	@Override
	public String deleteRailway(Long id) {
		if(railDao.existsById(id))
		{
			railDao.deleteById(id);
		    return "successfully deleted railway with id:"+id;
		}
			
		return "failed to delete the railway";
	}

	@Override
	public List<RailwayRespDto> getRailwayByCategory(Category cat) {
		return railDao.findByType(cat)
				.stream().map(r->mapper.map(r, RailwayRespDto.class))
				.collect(Collectors.toList());
		
	
	}
	
	
	

}
