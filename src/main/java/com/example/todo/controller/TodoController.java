package com.example.todo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.todo.DaoRepository.TodoDao;
import com.example.todo.DataEntityService.TodoData;
import com.example.todo.FormDto.TodoForm;

@Controller
public class TodoController {
	//リポジトリにアクセス可
	private final TodoDao todoDao;
	
	public TodoController(TodoDao todoDao) {
		this.todoDao = todoDao;
	}
	
	//一覧画面取得
	@GetMapping("/todo")
	public ModelAndView top(Model model) {
		
		List<TodoData> items = todoDao.findAll();
		
		ModelAndView m = new ModelAndView();
		m.setViewName("todoview"); //htmlを画面につかう
		m.addObject("items", items); //取得データを渡す
		return m; //値をモデルへわたす
	}
	
	//新規登録＋編集画面取得
	@GetMapping("/todo/addTodo")
	public ModelAndView todoForm() {
		return new ModelAndView("todoUpdate");
	}

	//新規登録送信
	@PostMapping("/todo/addTodo") //入力フォームの名前とクラスのメンバ変数名をマッピング
	public ModelAndView add(@ModelAttribute TodoForm form) {
		todoDao.insert(form);
		//登録後にリダイレクト
		return new ModelAndView("redirect:/todo");
	}
}