package com.example.patient_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.patient_service.dto.PatientRequestDTO;
import com.example.patient_service.dto.PatientResponseDTO;
import com.example.patient_service.exception.EmailAlreadyExistsException;
import com.example.patient_service.mapper.PatientMapper;
import com.example.patient_service.model.Patient;
import com.example.patient_service.repository.PatientRepository;

@Service
public class PatientService {
  private PatientRepository patientRepository;

  public PatientService(PatientRepository patientRepository) {
    this.patientRepository = patientRepository;
  }
  
  public List<PatientResponseDTO> getPatients() {
    List<Patient> patients = patientRepository.findAll();
    
    return patients.stream()
        .map(PatientMapper::toDTO)
        .toList();  
  }

  public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){
    if (patientRepository.existsByEmail(patientRequestDTO.getEmail()) ) {
      throw new EmailAlreadyExistsException("Email already in use" + patientRequestDTO.getEmail());
    }

    Patient patient = patientRepository.save(PatientMapper.toModel(patientRequestDTO));

    return PatientMapper.toDTO(patient);
  }
}
