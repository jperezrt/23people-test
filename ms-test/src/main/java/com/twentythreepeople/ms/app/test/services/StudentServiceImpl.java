package com.twentythreepeople.ms.app.test.services;

import com.twentythreepeople.ms.app.test.models.Course;
import com.twentythreepeople.ms.app.test.models.Student;
import com.twentythreepeople.ms.app.test.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService, PagingAndSortingRepository<Student, Long> {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Student> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return studentRepository.count();
    }

    @Override
    @Transactional
    public <S extends Student> Iterable<S> saveAll(Iterable<S> entities) {
        return studentRepository.saveAll(entities);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Long aLong) {
        return studentRepository.existsById(aLong);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void delete(Student student) {
        studentRepository.delete(student);
    }

    @Override
    @Transactional
    public void deleteAll(Iterable<? extends Student> entities) {
        studentRepository.deleteAll(entities);
    }

    @Override
    @Transactional
    public void deleteAll() {
        studentRepository.deleteAll();
    }

    @Override
    public Iterable<Student> findAll(Sort sort) {
        return studentRepository.findAll(sort);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }
}
