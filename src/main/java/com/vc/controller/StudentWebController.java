package com.vc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.vc.entity.Student;
import com.vc.service.StudentService;

@Controller
public class StudentWebController {

	@Autowired
	private StudentService service;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("students", service.getAllStudents());
		return "index"; // Loads index.html from /templates
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("student", new Student());
		return "add";
	}

	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student student) {
		service.save(student);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("student", service.getById(id));
		return "edit";
	}

	@PostMapping("/update")
	public String updateStudent(@ModelAttribute("student") Student student) {
		service.save(student);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		service.delete(id);
		return "redirect:/";
	}
}
