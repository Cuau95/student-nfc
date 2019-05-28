package com.example.student.nfc.domain.helper;

import com.example.student.nfc.domain.model.StudentNFCRelation;
import com.example.student.nfc.domain.model.StudentNFCRelationEntity;
import com.example.student.nfc.domain.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceHelper {
    
    private StudentService studentService;

    @Autowired
    public ServiceHelper(StudentService studentService) {
        this.studentService = studentService;
    }
    
    public List<StudentNFCRelation> transformFromEntityToModel(List<StudentNFCRelationEntity> entitiesList) {
        List<StudentNFCRelation> modelList = new ArrayList<>();
        entitiesList.forEach(element -> {
            StudentNFCRelation relation = new StudentNFCRelation();
            relation.setIdNfc(element.getIdNfc());
            relation.setAlumno(studentService.getStudentById(element.getIdAlumno()));
            modelList.add(relation);
        });
        return modelList;
    }
    
}
