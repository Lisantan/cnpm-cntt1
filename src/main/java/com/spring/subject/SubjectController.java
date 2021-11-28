package com.spring.subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class SubjectController {
	
	@Autowired
	private SubjectRepository repo;
	
	@GetMapping("/subjects")
	public String formSubject(Model model)
	{
		List<Subject> listSubjects = repo.findAll();
		model.addAttribute("listSubjects", listSubjects);
		
		return "subjects";
	}
	
	@GetMapping("/subjects/new")
	public String addSubject(Model model)
	{
		model.addAttribute("subject", new Subject());
		
		return "subject-form";
	}
	
	@PostMapping("/subjects/save")
	public String saveSubject(Subject subject)
	{
		repo.save(subject);
		return "redirect:/subjects";
	}
	
	@GetMapping("subjects/edit/{id}")
	public String editSubject(@PathVariable("id") Integer id, Model model)
	{
		Subject subject = repo.findById(id).get();
		model.addAttribute("subject", subject);
		
		return "subject-form";
	}
	
	@GetMapping("subjects/delete/{id}")
	public String deleteSubject(@PathVariable("id") Integer id, Model model)
	{
		repo.deleteById(id);
		
		return "redirect:/subjects";
	}

}
