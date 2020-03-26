package com.twentythreepeople.ms.app.test.services;

import com.twentythreepeople.ms.app.test.models.Course;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CourseService {
    public Iterable<Course> findAll();

    public Optional<Course> findById(Long id);

    public Course save(Course course);

    public void deleteById(Long id);

    Iterable<Course> findAll(Pageable pageable);
}
