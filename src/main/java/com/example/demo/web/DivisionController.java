package com.example.demo.web;

import com.example.demo.domain.Division;
import com.example.demo.service.DivisionService;
import com.example.demo.web.form.DivisionForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping(path = "/division")
public class DivisionController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    DivisionService divisionService;

    @GetMapping
    public String getAllDivisions(Model model) {
        List<Division> divisions = divisionService.findAll();
        model.addAttribute("divisions", divisions);
        return "division/index";
    }

    @GetMapping(path = "/create")
    public String createDivision(@ModelAttribute("divisionForm") DivisionForm divisionForm) {
        return "division/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String storeDivision(@ModelAttribute("divisionForm") @Validated DivisionForm divisionForm, BindingResult result) {
        if (result.hasErrors()) {
            return "/division/create";
        }
        Division division = new Division();
        BeanUtils.copyProperties(divisionForm, division);
        divisionService.insert(division);
        return "redirect:/division";
    }

    @GetMapping(path = "/edit/{division_id}")
    public String editDivision(@PathVariable("division_id") Integer id, @ModelAttribute("divisionForm") DivisionForm divisionForm) {
        Optional<Division> divisionOptional = divisionService.selectById(id);
        Division division = divisionOptional.get();
        BeanUtils.copyProperties("memberForm", division);
        return "division/edit";
    }

    @RequestMapping(value = "/edit/{division_id}", method = RequestMethod.POST)
    public String updateDivision(@RequestParam Integer division_id, @Validated @ModelAttribute("divisionForm") DivisionForm divisionForm, BindingResult result) {
        if(result.hasErrors()){
            return "division/edit";
        }
        Division division = new Division();
        BeanUtils.copyProperties(divisionForm, division);
        division.setId(division_id);
        divisionService.update(division);
        return "redirect:/division";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteDivision(@RequestParam Integer division_id) {
        divisionService.delete(division_id);
        return "redirect:/division";
    }

}

