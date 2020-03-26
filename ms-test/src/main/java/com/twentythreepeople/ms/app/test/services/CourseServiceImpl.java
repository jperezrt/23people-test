package com.twentythreepeople.ms.app.test.services;

import com.twentythreepeople.ms.app.test.models.Course;
import com.twentythreepeople.ms.app.test.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService, PagingAndSortingRepository<Course, Long> {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Iterable<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Course> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return courseRepository.count();
    }

    @Override
    @Transactional
    public <S extends Course> Iterable<S> saveAll(Iterable<S> entities) {
        return courseRepository.saveAll(entities);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Long aLong) {
        return courseRepository.existsById(aLong);
    }

    @Override
    @Transactional
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Transactional
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void delete(Course entity) {
        courseRepository.delete(entity);
    }

    @Override
    @Transactional
    public void deleteAll(Iterable<? extends Course> entities) {
        courseRepository.deleteAll(entities);
    }

    @Override
    @Transactional
    public void deleteAll() {
        courseRepository.deleteAll();
    }

    @Override
    public Iterable<Course> findAll(Sort sort) {
        return courseRepository.findAll(sort);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Course> findAll(Pageable pageable) {
        return courseRepository.findAll(pageable);
    }
}
