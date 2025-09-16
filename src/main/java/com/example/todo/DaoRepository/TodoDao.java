package com.example.todo.DaoRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.todo.DataEntityService.TodoData;
import com.example.todo.FormDto.TodoForm;

import lombok.extern.slf4j.Slf4j;

@Repository //DBへSQLを送る
@Slf4j //ログ出力のLombok

public class TodoDao {
	
	//DBの処理をしやすくするAPI
	private final JdbcTemplate jdbcTemplate;
	
	public TodoDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//DB取得
	public List<TodoData> findAll(){
		
		String sql = "SELECT * FROM task_list";
		
		try {
		
		//複数のエンティティレコードを返す
		return jdbcTemplate.query(sql, new RowMapper<TodoData>() {
			@Override
			public TodoData mapRow(ResultSet rs,int rowNum) throws SQLException{
				TodoData item = new TodoData();
				item.setTaskId(rs.getInt("task_id"));
				item.setTask_title(rs.getString("task_title"));
				item.setTask_content(rs.getString("task_content"));
				item.setTask_deadline(rs.getDate("task_deadline"));
				item.setTask_status(rs.getString("task_status"));
				return item;
			}
		});
		} catch (DataAccessException e) {
			log.error("DB取得エラー：{}", e.getMessage(), e);
			throw new RuntimeException("DB取得エラー", e);
		}	
	}
	
	//新規登録
	public void insert(TodoForm form) {
		try {
			String sql = "INSERT INTO task_list (task_title, task_content, task_deadline, task_status) VALUES (?, ?, ?, ?)";
			jdbcTemplate.update(sql, form.getTask_title(), form.getTask_content(), form.getTask_deadline(), form.getTask_status());
	
		} catch (DataAccessException e) {
			log.error("DB取得エラー：{}", e.getMessage(), e);
			throw new RuntimeException("DB取得エラー", e);
			}
			
	}
}
