package com.example.student.nfc.domain.service;

import com.example.student.nfc.domain.model.Student;
import com.example.student.nfc.domain.model.StudentNFCRelation;
import com.example.student.nfc.domain.model.StudentNFCRelationEntity;
import com.example.student.nfc.domain.repository.StudentNFCRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentNFCRelationService {
    
    private StudentService studentService;
    private StudentNFCRelationRepository repository;

    @Autowired
    public StudentNFCRelationService(StudentService studentService, StudentNFCRelationRepository repository) {
        this.studentService = studentService;
        this.repository = repository;
    }
    
    public StudentNFCRelationEntity saveNFCId(StudentNFCRelationEntity nfc) {
        return repository.save(nfc);
    }
    
    public StudentNFCRelation saveStudentNFCRelation (String idStudent) {
        StudentNFCRelation relation = new StudentNFCRelation();
        Student student = getStudentById(idStudent);
        String idNFC = getNFCId().getIdNfc();
        relation.setAlumno(student);
        relation.setIdNfc(idNFC);
        if(student != null && idNFC != null){
            updateStudent(student.getId(), idNFC);
        }
        return relation;
    }
    
    private void updateStudent(String idStudent, String idNFC) {
        StudentNFCRelationEntity relationEntity = new StudentNFCRelationEntity();
        relationEntity.setIdAlumno(idStudent);
        relationEntity.setIdNfc(idNFC);
        saveNFCId(relationEntity);
    }
    
    public Student getStudentById(String id) {
        return studentService.getStudentById(id);
    }
    
    private StudentNFCRelationEntity getNFCId() {
        return repository.findByIdAlumno(null).get(0);
    }
    
}
