package com.example.appcrudstudent.controller;

import com.example.appcrudstudent.entity.Student;
import com.example.appcrudstudent.payload.StudentDto;
import com.example.appcrudstudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/main")
public class MainController {
    @Autowired
    StudentRepository studentRepository;

    @PostMapping
    public Student add(@RequestBody StudentDto studentDto){
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setPhone(studentDto.getPhone());

        Student save = studentRepository.save(student);
        return save;
    }

    @GetMapping
    public List<Student> main(){
        List<Student> students = studentRepository.findAll();
        return students;
    }

    @GetMapping("/{id}")
    public Student getOne(@PathVariable Integer id){
        Optional<Student> byId = studentRepository.findById(id);
        if (!byId.isPresent()){
            return new Student();
        }
        Student student = byId.get();
        return student;
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Integer id, @RequestBody StudentDto studentDto){
        Optional<Student> byId = studentRepository.findById(id);
        if (!byId.isPresent()){
            return new Student();
        }
        Student student = byId.get();
        student.setName(studentDto.getName());
        student.setPhone(studentDto.getPhone());

        Student save = studentRepository.save(student);
        return save;
    }


    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        try {
            studentRepository.deleteById(id);
        }catch (Exception e){
            return false;
        }

        return true;
    }


}
