package com.example.todo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.todo.DaoRepository.TodoDao;
import com.example.todo.DataEntityService.TodoData;

@Controller
public class TodoController {
	
	private final TodoDao todoDao;
	public TodoController(TodoDao todoDao) {
		this.todoDao = todoDao;
	}
	
	//一覧画面をリクエスト
	@GetMapping("/todo")
	public ModelAndView top(Model model) {
		
		List<TodoData> items = todoDao.findAll();
		
		ModelAndView m = new ModelAndView();
		m.setViewName("todoview");
		
		m.addObject("items", items);
		return m;
	}
}