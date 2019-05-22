package com.example.student.nfc.domain.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alumno_nfc")
public class StudentNFCRelationEntity implements Serializable {
    
    @Id
    private String idNfc;
    private String idAlumno;

    public String getIdNfc() {
        return idNfc;
    }

    public void setIdNfc(String idNfc) {
        this.idNfc = idNfc;
    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }
    
}
