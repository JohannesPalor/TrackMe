package com.csb.TrackMe.controller;


import com.csb.TrackMe.dto.DiseaseDTO;
import com.csb.TrackMe.services.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("disease")
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;

    @GetMapping
    private String list(Model model) {
        model.addAttribute("diseases", diseaseService.list());
        return "disease/index";
    }

    @GetMapping("/add")
    private String getDiseaseAddForm(Model model) {
        model.addAttribute("disease", new DiseaseDTO());
        return "disease/add-disease";
    }

    @PostMapping
    private String add(@Valid @ModelAttribute("disease") DiseaseDTO disease, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("disease", disease);
            return "disease/add-disease";
        }
        diseaseService.add(disease);
        return list(model);
    }

    @GetMapping("/{id}")
    private String get(@PathVariable Long id, Model model) {
        model.addAttribute("disease", diseaseService.get(id));
        return "disease/view-disease";
    }

    @PutMapping
    private String update(DiseaseDTO disease, Model model) {
        diseaseService.update(disease);
        return list(model);
    }

    @DeleteMapping
    private String delete(DiseaseDTO disease, Model model) {
        diseaseService.delete(disease.getId());
        return list(model);
    }







//    @GetMapping
//    private String home(Model model) {
//        return "disease/index";
//    }
}
