package com.twentythreepeople.ms.app.test.services;

import com.twentythreepeople.ms.app.test.models.Student;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface StudentService {
    public Iterable<Student> findAll();

    public Optional<Student> findById(Long id);

    public Student save(Student student);

    public void deleteById(Long id);

    Iterable<Student> findAll(Pageable pageable);
}
