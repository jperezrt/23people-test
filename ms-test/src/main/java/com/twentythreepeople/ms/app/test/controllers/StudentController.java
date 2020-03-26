package com.twentythreepeople.ms.app.test.controllers;

import com.twentythreepeople.ms.app.test.models.Student;
import com.twentythreepeople.ms.app.test.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController extends JWTController {

    @Autowired
    private StudentService studentService;

    @GetMapping("students/all")
    public ResponseEntity<?> list(){
        return ResponseEntity.ok().body(studentService.findAll());
    }

    @GetMapping("students")
    public ResponseEntity<?> list(Pageable pageable){
        return ResponseEntity.ok().body(studentService.findAll(pageable));
    }

    @GetMapping("students/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        Optional<Student> optionalStudent = studentService.findById(id);
        if(!optionalStudent.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(optionalStudent.get());
    }

    @PostMapping("students")
    public ResponseEntity<?> add(@Valid @RequestBody Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return this.validate(bindingResult);
        }
        Student studentResponse = studentService.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentResponse);
    }

    @PutMapping("students/{id}")
    public ResponseEntity<?> edit(@Valid @RequestBody Student student, BindingResult bindingResult, @PathVariable Long id){
        if(bindingResult.hasErrors()){
            return this.validate(bindingResult);
        }
        Optional<Student> optionalStudent = studentService.findById(id);
        if(!optionalStudent.isPresent()){
            return ResponseEntity.notFound().build();
        }
        Student studentDb = optionalStudent.get();
        studentDb.setAge(student.getAge());
        studentDb.setName(student.getName());
        studentDb.setCourse(student.getCourse());
        studentDb.setLastName(student.getLastName());
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentDb));
    }

    @DeleteMapping("students/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Student> optionalStudent = studentService.findById(id);
        if(optionalStudent.isPresent()){
            studentService.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}

