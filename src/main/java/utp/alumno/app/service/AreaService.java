package utp.alumno.app.service;

import java.util.List;

import utp.alumno.app.mapper.AreaMapper;
import utp.alumno.app.model.Area;

public interface AreaService{
	
	public int findAllAreasCount();
	public List<Area> findAllAreas(int offset, int rows);
	public Area getAreaById(int id);
	public int createArea(Area area);
	public int updateArea(Area area);	
	
}
