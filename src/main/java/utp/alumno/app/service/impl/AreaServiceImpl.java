package utp.alumno.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import utp.alumno.app.mapper.AreaMapper;
import utp.alumno.app.model.Area;
import utp.alumno.app.service.AreaService;

@Service("areaService")
public class AreaServiceImpl implements AreaService {

	@Autowired
	@Qualifier("areaMapper")
	private AreaMapper areaMapper;

	@Override
	public final int findAllAreasCount() {
		return areaMapper.findAllAreasCount();
	}
	
	@Override
	public final List<Area> findAllAreas(int offset,int rows) {
		return areaMapper.findAllAreas(offset, rows);
	}
	
	@Override
	public final Area getAreaById(int id) {
		return areaMapper.getAreaById(id);
	}
	
	@Override
	public final int createArea(Area area) {
		return areaMapper.createArea(area);
	}
	
	@Override
	public final int updateArea(Area area) {
		return areaMapper.updateArea(area);
	}

}
