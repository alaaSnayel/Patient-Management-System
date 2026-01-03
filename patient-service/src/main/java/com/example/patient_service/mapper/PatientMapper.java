package com.example.patient_service.mapper;

import com.example.patient_service.dto.PatientResponseDTO;
import com.example.patient_service.model.Patient;

public class PatientMapper {
  public static PatientResponseDTO toDTO (Patient patient) {
    PatientResponseDTO dto = new PatientResponseDTO();
    dto.setId(patient.getId().toString());
    dto.setName(patient.getName());
    dto.setEmail(patient.getEmail());
    dto.setAddress(patient.getAddress());
    dto.setDateOfBirth(patient.getDateOfBirth().toString());
    return dto;
  }

  // public static Patient toEntity (PatientResponseDTO dto) {
  //   Patient patient = new Patient();
  //   // Assuming ID is generated elsewhere, not setting it here
  //   patient.setName(dto.getName());
  //   patient.setEmail(dto.getEmail());
  //   patient.setAddress(dto.getAddress());
  //   return patient;
  // }
  
}
