package com.spring.generation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GenerationController {

	@Autowired
	private GenerationRepository repo;
	
	@GetMapping("/generations")
	public String formGeneration(Model model)
	{
		List<Generation> listGenerations = repo.findAll();
		model.addAttribute("listGenerations", listGenerations);
		
		return "generations";
	}
	
	@GetMapping("/generations/new")
	public String addGeneration(Model model)
	{
		model.addAttribute("generation", new Generation());
		
		return "generation-form";
	}
	
	@PostMapping("/generations/save")
	public String saveGeneration(Generation generation)
	{
		repo.save(generation);
		return "redirect:/generations";
	}
	
	@GetMapping("generations/edit/{id}")
	public String editGeneration(@PathVariable("id") Integer id, Model model)
	{
		Generation generation = repo.findById(id).get();
		model.addAttribute("generation", generation);
		
		return "generation-form";
	}
	
	@GetMapping("generations/delete/{id}")
	public String deleteGeneration(@PathVariable("id") Integer id, Model model)
	{
		repo.deleteById(id);
		
		return "redirect:/generations";
	}
}
