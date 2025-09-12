package com.example.todo.DataEntityService;

import java.util.Date;

public class TodoData {
	
	private int task_id;
	private String task_title;
	private String task_content;
	private Date task_deadline; //年月日を扱うクラス
	private String task_status;

	public int getTaskId() {
		return task_id;
	}
	
	public void setTaskId(int task_id) {
		this.task_id = task_id;
	}

	public String getTask_title() {
		return task_title;
	}

	public void setTask_title(String task_title) {
		this.task_title = task_title;
	}

	public String getTask_content() {
		return task_content;
	}

	public void setTask_content(String task_content) {
		this.task_content = task_content;
	}

	public Date getTask_deadline() {
		return task_deadline;
	}

	public void setTask_deadline(Date task_deadline) {
		this.task_deadline = task_deadline;
	}

	public String getTask_status() {
		return task_status;
	}

	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}
	
}

