package com.example.student.nfc.domain.service;

import com.example.student.nfc.domain.helper.ServiceHelper;
import com.example.student.nfc.domain.model.Student;
import com.example.student.nfc.domain.model.StudentNFCRelation;
import com.example.student.nfc.domain.model.StudentNFCRelationEntity;
import com.example.student.nfc.domain.repository.StudentNFCRelationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentNFCRelationService {
    
    private StudentService studentService;
    private StudentNFCRelationRepository repository;
    private ServiceHelper helper;

    @Autowired
    public StudentNFCRelationService(StudentService studentService, StudentNFCRelationRepository repository, ServiceHelper helper) {
        this.studentService = studentService;
        this.repository = repository;
        this.helper = helper;
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
    
    public Student getStudentById(String id) {
        return studentService.getStudentById(id);
    }
    
    public String getIdStudentByidNFC(String idNFC) {
        return repository.findByIdNfc(idNFC).getIdAlumno();
    }
    
    public List<StudentNFCRelation> getStudentNFCRelation() {
        List<StudentNFCRelationEntity> entitiesList = (List<StudentNFCRelationEntity>)repository.findAll();
        return helper.transformFromEntityToModel(entitiesList);
    }
    
    private void updateStudent(String idStudent, String idNFC) {
        StudentNFCRelationEntity relationEntity = new StudentNFCRelationEntity();
        relationEntity.setIdAlumno(idStudent);
        relationEntity.setIdNfc(idNFC);
        saveNFCId(relationEntity);
    }
    
    private StudentNFCRelationEntity getNFCId() {
        return repository.findByIdAlumno(null).get(0);
    }
    
}
