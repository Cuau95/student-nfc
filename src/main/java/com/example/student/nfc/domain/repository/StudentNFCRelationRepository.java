package com.example.student.nfc.domain.repository;

import com.example.student.nfc.domain.model.StudentNFCRelationEntity;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentNFCRelationRepository extends CrudRepository<StudentNFCRelationEntity, Integer> {
    
    public List<StudentNFCRelationEntity> findByIdAlumno(String id);
    
}
