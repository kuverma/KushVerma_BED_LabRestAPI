package com.greatlearning.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.student.entity.Student;
import com.greatlearning.student.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/")
	public String welcomepage() {
		return "Welcome to this page";
	}

	@RequestMapping("/list")
	public String listStudents(Model model) {
		List<Student> students = studentService.getAllStudentDetails();
		model.addAttribute("students", students);
		return "list-students";
	}

	@RequestMapping("/add")
	public String add(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		model.addAttribute("action", "add");
		return "student-form";
	}

	@PostMapping("/saveStudent")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("course") String course,
			@RequestParam("country") String country, @RequestParam("action") String action) {
		// System.out.println(id);
		Student student;
		if (action.equalsIgnoreCase("update")) {
			student = studentService.getStudentById(id);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setCourse(course);
			student.setCountry(country);
			// System.out.println(student);
			studentService.saveStudentDetail(student);
		}
		if (action.equalsIgnoreCase("add")) {
			student = new Student(id, firstName, lastName, course, country);
			studentService.saveStudentDetail(student);
		}
		return "redirect:/student/list";

	}

	@RequestMapping("/update")
	public String updateStudentById(@RequestParam("id") int id, Model model) {
		Student student = studentService.getStudentById(id);
		model.addAttribute("Student", student);
		model.addAttribute("action", "update");
		model.addAttribute("id", id);
		// System.out.println("in updatecontroller" + student);
		return "student-form";
	}

	@RequestMapping("/delete")
	public String deleteStudentByid(@RequestParam("id") int id) {
		studentService.DeleteStudentDetailById(id);
		return "redirect:/student/list";
	}

	/*
	 * @RequestMapping("/403") public String noAccess() { return "error"; }
	 */
}
