package utp.alumno.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import utp.alumno.app.model.Company;

@Repository("companyMapper")
@Mapper
public interface CompanyMapper {
	
	public List<Company> getCompanies(@Param("offset")int offset,@Param("rows")int rows);
	public int getCompanyCount();
	public Company getCompanyById(int id);
	public int updateCompany(Company company);
	public int addComp(Company company);
	
}
