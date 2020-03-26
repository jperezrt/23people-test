package com.twentythreepeople.ms.app.test.repository;

import com.twentythreepeople.ms.app.test.models.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {
}
