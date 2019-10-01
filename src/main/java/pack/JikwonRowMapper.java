package pack;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class JikwonRowMapper implements RowMapper{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		//select 실행 결과를 한 레크드씩 전달받아서 처리
		JikwonDto dto = new JikwonDto();
		dto.setJikwon_no(rs.getString("jikwon_no"));
		dto.setJikwon_name(rs.getString("jikwon_name"));
		dto.setBuser_name(rs.getString("buser_name"));
		dto.setJikwon_jik(rs.getString("jikwon_jik"));
		return dto;
	}
}

