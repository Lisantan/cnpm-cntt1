package com.spring.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.classroom.Classroom;
import com.spring.classroom.ClassroomRepository;
import com.spring.generation.Generation;
import com.spring.generation.GenerationRepository;

@Controller
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ClassroomRepository classroomRepository;
	
	@Autowired
	private GenerationRepository generationRepository;
	
	@GetMapping("/students/new")
	public String formStudent(Model model)
	{
		List<Classroom> listClassrooms = classroomRepository.findAll();
		List<Generation> listGenerations = generationRepository.findAll();
		
		model.addAttribute("student", new Student());
		model.addAttribute("listClassrooms", listClassrooms);
		model.addAttribute("listGenerations", listGenerations);
		
		return "student-form";
	}
	
	@PostMapping("/students/save")
	public String saveStudent(Student student)
	{
		studentRepository.save(student);
		
		return "redirect:/students";
	}
	
	@GetMapping("/students")
	public String listStudent(Model model)
	{
		List<Student> listStudents = studentRepository.findAll();
		model.addAttribute("listStudents", listStudents);
		
		return "students";
	}
	
	@GetMapping("students/edit/{id}")
	public String editStudent(@PathVariable("id") Integer id, Model model)
	{
		Student student = studentRepository.findById(id).get();
		model.addAttribute("student", student);
		
		List<Classroom> listClassrooms = classroomRepository.findAll();
		List<Generation> listGenerations = generationRepository.findAll();
		
		model.addAttribute("listClassrooms", listClassrooms);
		model.addAttribute("listGenerations", listGenerations);
		
		return "student-form";
	}
	
	@GetMapping("students/delete/{id}")
	public String deleteStudent(@PathVariable("id") Integer id, Model model)
	{
		studentRepository.deleteById(id);
		
		return "redirect:/students";
	}

}
