package com.habuma.ttt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcDweetRepository implements DweetRepository {
	private static final Logger logger = LoggerFactory.getLogger(JdbcDweetRepository.class);
	private final JdbcOperations jdbc;

	@Autowired
	public JdbcDweetRepository(JdbcOperations jdbc) {
		logger.info("JDBCOperations injected via @Autowire...");
		this.jdbc = jdbc;
	}
	
	public List<Dweet> findRecentDweets() {
		return jdbc.query("SELECT id, message, time_stamp FROM dweet ORDER BY time_stamp DESC", 
			new RowMapper<Dweet>() {
				public Dweet mapRow(ResultSet rs, int rowNum) throws SQLException {
					return new Dweet(rs.getLong("id"), rs.getString("message"), rs.getTimestamp("time_stamp"));
				}
			});
	}
	
	public void saveDweet(String message) {
		jdbc.update("INSERT INTO dweet (message, time_stamp) VALUES (?, ?)", message, new Date());
	}
	
}
