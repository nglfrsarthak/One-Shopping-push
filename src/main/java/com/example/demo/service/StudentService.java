package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository){
        this.repository = repository;
    }

    public List<Student> getAllStudents(){
        return repository.findAll();
    }

    public Student getStudent(Long id){
        return repository.findById(id).orElse(null);
    }

    public Student saveStudent(Student student){
        return repository.save(student);
    }

    public Student updateStudent(Long id, Student student){

        Student existing = repository.findById(id).orElse(null);

        if(existing != null){
            existing.setName(student.getName());
            existing.setDepartment(student.getDepartment());

            return repository.save(existing);
        }

        return null;
    }

    public void deleteStudent(Long id){
        repository.deleteById(id);
    }
}
