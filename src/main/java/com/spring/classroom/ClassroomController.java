package com.spring.classroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClassroomController {
	
	@Autowired
	private ClassroomRepository repo;
	
	@GetMapping("/classrooms")
	public String formClassroom(Model model)
	{
		List<Classroom> listClassrooms = repo.findAll();
		model.addAttribute("listClassrooms", listClassrooms);
		
		return "classrooms";

	}
	
	@GetMapping("/classrooms/new")
	public String addClassroom(Model model)
	{
		model.addAttribute("classroom", new Classroom());
		
		return "classroom-form";
	}
	
	@PostMapping("/classrooms/save")
	public String saveClassroom(Classroom classroom)
	{
		repo.save(classroom);
		return "redirect:/classrooms";
	}
	
	@GetMapping("classrooms/edit/{id}")
	public String editClassroom(@PathVariable("id") Integer id, Model model)
	{
		Classroom classroom = repo.findById(id).get();
		model.addAttribute("classroom", classroom);
		
		return "classroom-form";
	}
	
	@GetMapping("classrooms/delete/{id}")
	public String deleteClassroom(@PathVariable("id") Integer id, Model model)
	{
		repo.deleteById(id);
		
		return "redirect:/classrooms";
	}

}
