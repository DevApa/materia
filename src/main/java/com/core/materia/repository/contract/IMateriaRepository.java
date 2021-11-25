package com.core.materia.repository.contract;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.core.materia.repository.models.Materia;

@Repository
public interface IMateriaRepository extends JpaRepository<Materia, BigInteger>{

}
