package com.example.student.nfc.domain.model;

import java.io.Serializable;

public class StudentNFCRelation implements Serializable {
    
    private String idNfc;
    private Student alumno;

    public String getIdNfc() {
        return idNfc;
    }

    public void setIdNfc(String idNfc) {
        this.idNfc = idNfc;
    }

    public Student getAlumno() {
        return alumno;
    }

    public void setAlumno(Student alumno) {
        this.alumno = alumno;
    }
    
}
