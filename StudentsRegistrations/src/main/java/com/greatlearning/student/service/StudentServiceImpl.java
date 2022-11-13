package com.greatlearning.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.student.entity.Student;
import com.greatlearning.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public void saveStudentDetail(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void updateStudentDetail(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void DeleteStudentDetailById(int id) {
		studentRepository.deleteById(id);
	}

	@Override
	public List<Student> getAllStudentDetails() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		Optional<Student> tempStudent = studentRepository.findById(id);
		if (tempStudent.isPresent()) {
			return tempStudent.get();
		}
		return null;

	}

}
