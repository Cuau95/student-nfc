package com.example.student.nfc.domain.repository;

import com.example.student.nfc.domain.model.Student;

public interface StudentRepository {
    
    public Student getStudentById(String id);
    
}
