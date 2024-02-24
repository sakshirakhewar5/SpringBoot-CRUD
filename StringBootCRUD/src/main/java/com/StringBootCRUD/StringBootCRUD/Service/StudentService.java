package com.StringBootCRUD.StringBootLayers.Service;

// StudentService.java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StringBootCRUD.StringBootLayers.POJO.Student;
import com.StringBootCRUD.StringBootLayers.Repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

	 @Autowired
	    private StudentRepository studentRepository;

	    public List<Student> getAllStudents() {
	        return studentRepository.findAll();
	    }

	    public Optional<Student> getStudentById(Long id) {
	        return studentRepository.findById(id);
	    }

	    public Student saveStudent(Student student) {
	        return studentRepository.save(student);
	    }

	    public Student updateStudent(Long id, Student student) {
	        // Check if the student with the given id exists
	        if (studentRepository.existsById(id)) {
	            student.setId(id);
	            return studentRepository.save(student);
	        } else {
	            // Handle the case when the student with the given id is not found
	            throw new RuntimeException("Student not found with id: " + id);
	        }
	    }

	    public void deleteStudent(Long id) {
	        studentRepository.deleteById(id);
	    }
}

