package com.hospital.data;

import com.hospital.model.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private static DataManager instance;
    private final Map<Integer, Doctor> doctors;
    private final Map<Integer, Patient> patients;
    private final Map<Integer, Pharmacist> pharmacists;
    private final Map<Integer, ITSupport> itSupports;
    private final Map<Integer, Dietician> dieticians;
    private final Map<Integer, Hospital> hospitals;

    private DataManager() {
        doctors = new HashMap<>();
        patients = new HashMap<>();
        pharmacists = new HashMap<>();
        itSupports = new HashMap<>();
        dieticians = new HashMap<>();
        hospitals = new HashMap<>();
    }

    public static synchronized DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public void addDoctor(Doctor doctor) {
        doctors.put(doctor.getId(), doctor);
    }

    public void addPatient(Patient patient) {
        patients.put(patient.getId(), patient);
    }

    public void addPharmacist(Pharmacist pharmacist) {
        pharmacists.put(pharmacist.getId(), pharmacist);
    }

    public void addITSupport(ITSupport itSupport) {
        itSupports.put(itSupport.getId(), itSupport);
    }

    public void addDietician(Dietician dietician) {
        dieticians.put(dietician.getId(), dietician);
    }

    public void addHospital(Hospital hospital) {
        hospitals.put(hospital.getId(), hospital);
    }

    public Doctor getDoctor(int id) {
        return doctors.get(id);
    }

    public Patient getPatient(int id) {
        return patients.get(id);
    }

    public Pharmacist getPharmacist(int id) {
        return pharmacists.get(id);
    }

    public ITSupport getITSupport(int id) {
        return itSupports.get(id);
    }

    public Dietician getDietician(int id) {
        return dieticians.get(id);
    }

    public Hospital getHospital(int id) {
        return hospitals.get(id);
    }

    public List<Doctor> getAllDoctors() {
        return new ArrayList<>(doctors.values());
    }

    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients.values());
    }

    public List<Pharmacist> getAllPharmacists() {
        return new ArrayList<>(pharmacists.values());
    }

    public List<ITSupport> getAllITSupports() {
        return new ArrayList<>(itSupports.values());
    }

    public List<Dietician> getAllDieticians() {
        return new ArrayList<>(dieticians.values());
    }

    public List<Hospital> getAllHospitals() {
        return new ArrayList<>(hospitals.values());
    }
} 