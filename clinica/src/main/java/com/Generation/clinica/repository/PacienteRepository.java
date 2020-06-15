package com.Generation.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Generation.clinica.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
