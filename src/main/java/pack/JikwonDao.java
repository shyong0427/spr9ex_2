package pack;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;


public class JikwonDao extends JdbcDaoSupport{
	private RowMapper rowMapper;
	
	public JikwonDao(DataSource dataSource,RowMapper rowMapper) {
		this.setDataSource(dataSource);
		this.rowMapper = rowMapper;
	}
	
	public List<JikwonDto> selectList(String message) throws DataAccessException {
		return getJdbcTemplate().query("select j.jikwon_no , j.jikwon_name , b.buser_name, j.jikwon_jik from jikwon j , buser b where j.buser_num=b.buser_no and j.buser_num = ?",new Object[] {message}, rowMapper);
	}
	
	public List<JikwonDto> selectListAll() throws DataAccessException {
		return getJdbcTemplate().query("select j.jikwon_no , j.jikwon_name , b.buser_name, j.jikwon_jik from jikwon j , buser b where j.buser_num=b.buser_no;", rowMapper);
	}
	
	public List<JikwonDto> login(String no , String name) throws DataAccessException {
		return getJdbcTemplate().query("select j.jikwon_no , j.jikwon_name , b.buser_name, j.jikwon_jik from jikwon j , buser b where jikwon_no=? and jikwon_name= ?",new Object[] {no,name}, rowMapper);
	}
}
