package com.csb.TrackMe.controller;


import com.csb.TrackMe.dto.DiseaseDTO;
import com.csb.TrackMe.dto.VaccineDTO;
import com.csb.TrackMe.services.DiseaseService;
import com.csb.TrackMe.services.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("vaccine")
public class VaccineController {

    @Autowired
    private VaccineService vaccineService;

    @GetMapping
    private String list(Model model) {
        model.addAttribute("vaccines", vaccineService.list());
        return "vaccine/index";
    }

    @GetMapping("/add")
    private String getVaccineAddForm(Model model) {
        model.addAttribute("vaccine", new VaccineDTO());
        return "vaccine/add-vaccine";
    }

    @PostMapping
    private String add(@Valid @ModelAttribute("vaccine") VaccineDTO vaccine, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("vaccine", vaccine);
            return "vaccine/add-vaccine";
        }
        vaccineService.add(vaccine);
        return list(model);
    }

    @GetMapping("/{id}")
    private String get(@PathVariable Long id, Model model) {
        model.addAttribute("vaccine", vaccineService.get(id));
        return "vaccine/view-vaccine";
    }

    @PutMapping
    private String update(VaccineDTO vaccine, Model model) {
        vaccineService.update(vaccine);
        return list(model);
    }

    @DeleteMapping
    private String delete(VaccineDTO vaccine, Model model) {
        vaccineService.delete(vaccine.getId());
        return list(model);
    }
}
