package com.demojavadj.appweb.repository;

import com.demojavadj.appweb.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
