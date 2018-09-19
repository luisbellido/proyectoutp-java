package utp.alumno.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import utp.alumno.app.model.EmailAddress;

@Repository("emailAddressMapper")
@Mapper
public interface EmailAddressMapper {
	
	@Select("SELECT e.id, e.email_data, e.status_email FROM email_addresses e limit #{offset}, #{rows} ")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "emaildata", column = "email_data"),
        @Result(property = "statusemail", column = "status_email")
    })
	public List<EmailAddress> getEmailAddresses(int offset,int rows);
	
	@Select("SELECT count(e.id) FROM email_addresses e")
	public int getEmailCount();
	
	@Select("SELECT e.id, e.email_data as emaildata, e.status_email as statusemail FROM email_addresses e WHERE e.id=#{id}")
	public EmailAddress getEmailAddressById(int id);
	
	@Insert("insert into email_addresses values(#{id},#{emaildata},#{statusemail})")
	@SelectKey(statement = "SELECT IFNULL(max(id)+1,1) as id FROM email_addresses", keyProperty = "id",before = true, resultType = int.class)
	public int createEmail(EmailAddress emailAddress);
	
	@Update("update email_addresses set email_data=#{emaildata},status_email=#{statusemail} where id=#{id}")
	public int updateEmail(EmailAddress emailAddress);

}
