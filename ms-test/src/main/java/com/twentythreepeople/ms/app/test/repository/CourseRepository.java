package com.twentythreepeople.ms.app.test.repository;

import com.twentythreepeople.ms.app.test.models.Course;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {
}
