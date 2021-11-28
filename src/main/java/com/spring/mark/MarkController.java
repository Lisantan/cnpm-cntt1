package com.spring.mark;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.semester.Semester;
import com.spring.semester.SemesterRepository;
import com.spring.student.Student;
import com.spring.student.StudentRepository;
import com.spring.subject.Subject;
import com.spring.subject.SubjectRepository;

@Controller
public class MarkController {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private SemesterRepository semesterRepository;
	
	@Autowired
	private MarkRepository markRepository;
	
	@GetMapping("/marks/new")
	public String formMark(Model model)
	{
		List<Student> listStudents = studentRepository.findAll();
		List<Semester> listSemesters = semesterRepository.findAll();
		List<Subject> listSubjects = subjectRepository.findAll();
		
		model.addAttribute("mark", new Mark());
		model.addAttribute("listStudents", listStudents);
		model.addAttribute("listSemesters", listSemesters);
		model.addAttribute("listSubjects", listSubjects);
		
		return "mark-form";
	}
	
	@PostMapping("/marks/save")
	public String saveMark(Mark mark)
	{
		markRepository.save(mark);
		
		return "redirect:/marks";
	}
	
	@GetMapping("/marks")
	public String listMark(Model model)
	{
		List<Mark> listMarks = markRepository.findAll();
		model.addAttribute("listMarks", listMarks);
		
		return "marks";
	}
	
	@GetMapping("marks/edit/{id}")
	public String markStudent(@PathVariable("id") Integer id, Model model)
	{
		Mark mark = markRepository.findById(id).get();
		model.addAttribute("mark", mark);
		
		List<Student> listStudents = studentRepository.findAll();
		List<Semester> listSemesters = semesterRepository.findAll();
		List<Subject> listSubjects = subjectRepository.findAll();
		
		model.addAttribute("listStudents", listStudents);
		model.addAttribute("listSemesters", listSemesters);
		model.addAttribute("listSubjects", listSubjects);
		
		return "mark-form";
	}
	
	@GetMapping("marks/delete/{id}")
	public String deleteMark(@PathVariable("id") Integer id, Model model)
	{
		markRepository.deleteById(id);
		
		return "redirect:/marks";
	}
}
