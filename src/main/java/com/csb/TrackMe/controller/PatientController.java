package com.csb.TrackMe.controller;

import com.csb.TrackMe.dto.PatientDTO;
import com.csb.TrackMe.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    private String list(Model model) {
        model.addAttribute("patient", patientService.list());
        return "patient/index";
    }

    @GetMapping("/add")
    private String getPatientAddForm(Model model) {
        model.addAttribute("patient", new PatientDTO());
        return "patient/add-patient";
    }

    @PostMapping
    private String add(@Valid @ModelAttribute("patient") PatientDTO patient, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("patient", patient);
            return "patient/add-patient";
        }
        patientService.add(patient);
        return list(model);
    }

    @GetMapping("/{id}")
    private String get(@PathVariable Long id, Model model) {
        model.addAttribute("patient", patientService.get(id));
        return "patient/view-patient";
    }

    @PutMapping
    private String update(PatientDTO patient, Model model) {
        patientService.update(patient);
        return list(model);
    }

    @DeleteMapping
    private String delete(PatientDTO patient, Model model) {
        patientService.delete(patient.getId());
        return list(model);
    }
}
