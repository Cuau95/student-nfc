package com.example.student.nfc.infrestructure.controller;

import com.example.student.nfc.domain.model.Student;
import com.example.student.nfc.domain.model.StudentNFCRelation;
import com.example.student.nfc.domain.model.StudentNFCRelationEntity;
import com.example.student.nfc.domain.service.StudentNFCRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student-nfc-relation")
public class StudentNFCRelationController {
    
    private StudentNFCRelationService service;

    @Autowired
    public StudentNFCRelationController(StudentNFCRelationService service) {
        this.service = service;
    }
    
    @PostMapping("/nfc/id/{idNFC}")
    public ResponseEntity<StudentNFCRelationEntity> saveOnlyIdNFC(@PathVariable("idNFC") String idNFC) {
        StudentNFCRelationEntity nfc = new StudentNFCRelationEntity();
        nfc.setIdNfc(idNFC);
        StudentNFCRelationEntity nfcSaved = service.saveNFCId(nfc);
        return new ResponseEntity<>(nfcSaved, OK);
    }
    
    @PostMapping("/student/id/{idStudent}")
    public ResponseEntity<StudentNFCRelation> saveStudentNFCRelation(@PathVariable("idStudent") String idStudent) {
        StudentNFCRelation relationSaved = service.saveStudentNFCRelation(idStudent);
        HttpStatus status = OK;
        if(relationSaved.getAlumno() == null || relationSaved.getIdNfc() == null){
            status = NOT_FOUND;
        }
        return new ResponseEntity<>(relationSaved, status);
    }
    
    @GetMapping("/nfc/id/{idNFC}")
    public ResponseEntity<String> getStudentId(@PathVariable String idNFC) {
        return new ResponseEntity<>(service.getIdStudentByidNFC(idNFC), OK);
    }
    
}
