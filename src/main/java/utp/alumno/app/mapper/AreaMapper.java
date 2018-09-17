package utp.alumno.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import utp.alumno.app.model.Area;

@Repository("areaMapper")
@Mapper
public interface AreaMapper {

	@Select("SELECT a.id, a.name_area FROM areas a limit #{offset}, #{rows} ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "namearea", column = "name_area")
    })
	public List<Area> findAllAreas(@Param("offset")int offset,@Param("rows")int rows);
	
	@Select("SELECT count(a.id) FROM areas a")
	public int findAllAreasCount();
	
	@Select("SELECT a.id, a.name_area as namearea, a.status FROM areas a WHERE a.id=#{id}")
	public Area getAreaById(@Param("id")int id);
	
	@Insert("insert into areas(id,name_area,status) values(#{id},#{namearea},#{status})")
	@SelectKey(statement = "SELECT max(id)+1 as id FROM areas", keyProperty = "id",before = true, resultType = int.class)
	public int createArea(Area area);
	
	@Update("update areas set name_area=#{namearea},status=#{status} where id=#{id}")
	public int updateArea(Area area);

}
