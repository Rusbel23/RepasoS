package com.demojavadj.appweb.services;

import com.demojavadj.appweb.models.Student;
import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    void addStudent(Student student);
    Student getStudentById(Long id);
    void deleteStudent(Long id);
    void updateStudent(Student student);
}
