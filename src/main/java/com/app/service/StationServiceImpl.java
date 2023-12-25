package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.StationDao;
import com.app.dto.StationRespDto;

@Service
@Transactional
public class StationServiceImpl implements StationService 
{

	@Autowired
	StationDao stationDao;
	@Autowired
	ModelMapper mapper;
	@Override
	public List< StationRespDto> getAllStations() {
		// TODO Auto-generated method stub
		
		return stationDao.findAll().stream().map(s-> mapper.map(s, StationRespDto.class)).collect(Collectors.toList());
		
	}
	

}
