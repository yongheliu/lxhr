package com.lxhr.ds;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 数据库连接
 * @author yonghe.liu
 *
 * 2014年11月5日
 */
public class BaseConnection extends HibernateDaoSupport{

	private DriverManagerDataSource ur_dms=null;
	
    protected JdbcTemplate jdbcTemplate;	
    


	public void setUr_dms(DriverManagerDataSource ur_dms) {
		this.ur_dms = ur_dms;
	}

	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public void save(Object enti){
		this.getHibernateTemplate().save(enti);
	}
	
	public void update(Object enti){
		this.getHibernateTemplate().merge(enti);
	}
	public void delete(Class clz,Integer id){
		Object obj=this.getHibernateTemplate().load(clz, id);
	   this.getHibernateTemplate().delete(obj);
	}
	
	
	public List<Map<String,Object>> query(String sql){
		return jdbcTemplate.queryForList(sql);
	}
	
	
	
	public List find(String hql){
		return this.getHibernateTemplate().find(hql);
	}
	
	public Long getTotal(String sql){
		return jdbcTemplate.queryForObject(sql, Long.class);
	}

	public void execute(String sql){
		jdbcTemplate.execute(sql);
	}

	
	
	public Object load(Class clz,int id){
		return this.getHibernateTemplate().get(clz, id);
	}
	
	public Map load(String sql){
		return this.jdbcTemplate.queryForMap(sql);
	}

	
}
