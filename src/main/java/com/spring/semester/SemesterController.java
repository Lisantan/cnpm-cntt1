package com.spring.semester;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SemesterController {
	
	@Autowired
	private SemesterRepository repo;
	
	@GetMapping("/semesters")
	public String formSemester(Model model)
	{
		List<Semester> listSemesters = repo.findAll();
		model.addAttribute("listSemesters", listSemesters);
		
		return "semesters";
	}
	
	@GetMapping("/semesters/new")
	public String addSemester(Model model)
	{
		model.addAttribute("semester", new Semester());
		
		return "semester-form";
	}
	
	@PostMapping("/semesters/save")
	public String saveSemester(Semester semester)
	{
		repo.save(semester);
		return "redirect:/semesters";
	}
	
	@GetMapping("semesters/edit/{id}")
	public String editSemester(@PathVariable("id") Integer id, Model model)
	{
		Semester semester = repo.findById(id).get();
		model.addAttribute("semester", semester);
		
		return "semester-form";
	}
	
	@GetMapping("semesters/delete/{id}")
	public String deleteSemester(@PathVariable("id") Integer id, Model model)
	{
		repo.deleteById(id);
		
		return "redirect:/semesters";
	}

}
