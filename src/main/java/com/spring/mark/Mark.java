package com.spring.mark;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.spring.semester.Semester;
import com.spring.student.Student;
import com.spring.subject.Subject;

@Entity
public class Mark {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;
	
	@ManyToOne
	@JoinColumn(name = "semester_id")
	private Semester semester;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@Column(length = 10, nullable = true)
	private String diligence_mark;
	
	@Column(length = 10, nullable = true)
	private String exam_mark;
	
	@Column(length = 10, nullable = true)
	private String mid_term_mark;
	
	@Column(length = 10, nullable = true)
	private String final_exam_mark;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getDiligence_mark() {
		return diligence_mark;
	}

	public void setDiligence_mark(String diligence_mark) {
		this.diligence_mark = diligence_mark;
	}

	public String getExam_mark() {
		return exam_mark;
	}

	public void setExam_mark(String exam_mark) {
		this.exam_mark = exam_mark;
	}

	public String getMid_term_mark() {
		return mid_term_mark;
	}

	public void setMid_term_mark(String mid_term_mark) {
		this.mid_term_mark = mid_term_mark;
	}

	public String getFinal_exam_mark() {
		return final_exam_mark;
	}

	public void setFinal_exam_mark(String final_exam_mark) {
		this.final_exam_mark = final_exam_mark;
	}


}
