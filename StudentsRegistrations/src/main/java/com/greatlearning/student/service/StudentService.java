package com.greatlearning.student.service;

import java.util.List;

import com.greatlearning.student.entity.Student;

public interface StudentService {

	public void saveStudentDetail(Student student);

	public void updateStudentDetail(Student student);

	public Student getStudentById(int id);

	public void DeleteStudentDetailById(int id);

	public List<Student> getAllStudentDetails();

}
