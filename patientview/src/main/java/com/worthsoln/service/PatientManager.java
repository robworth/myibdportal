package com.worthsoln.service;

import com.worthsoln.patientview.model.Patient;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface PatientManager {

    Patient get(Long id);

    void save(Patient patient);

    List<Patient> get(String unitCode);

    // Note: generics not used as the result is half user, half patient
    List getUnitPatientsWithTreatment(String unitcode, String nhsno, String name, boolean showgps);

    // Note: generics not used as the result is half user, half patient
    List getUnitPatientsAllWithTreatmentDao(String unitcode);
}
