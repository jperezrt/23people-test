package com.twentythreepeople.ms.app.test.controllers;

import com.twentythreepeople.ms.app.test.models.Course;
import com.twentythreepeople.ms.app.test.services.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/")
public class CurseController extends JWTController {

    @Autowired
    private CourseService courseService;

    @GetMapping("courses/all")
    public ResponseEntity<?> list(){
        return ResponseEntity.ok().body(courseService.findAll());
    }

    @GetMapping("courses")
    public ResponseEntity<?> list(Pageable pageable){
        return ResponseEntity.ok().body(courseService.findAll(pageable));
    }

    @GetMapping("courses/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        Optional<Course> optionalStudent = courseService.findById(id);
        if(!optionalStudent.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(optionalStudent.get());
    }

    @PostMapping("courses")
    public ResponseEntity<?> add(@Valid @RequestBody Course course, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return this.validate(bindingResult);
        }
        Course courseResponse = courseService.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(courseResponse);
    }

    @PutMapping("courses/{id}")
    public ResponseEntity<?> edit(@Valid @RequestBody Course course, BindingResult bindingResult, @PathVariable Long id){
        if(bindingResult.hasErrors()){
            return this.validate(bindingResult);
        }
        Optional<Course> optionalCourse = courseService.findById(id);
        if(!optionalCourse.isPresent()){
            return ResponseEntity.notFound().build();
        }
        Course courseDb = optionalCourse.get();
        courseDb.setCode(course.getCode());
        courseDb.setName(course.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.save(courseDb));
    }

    @DeleteMapping("courses/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Course> optionalStudent = courseService.findById(id);
        if(optionalStudent.isPresent()){
            courseService.deleteById(id);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}

