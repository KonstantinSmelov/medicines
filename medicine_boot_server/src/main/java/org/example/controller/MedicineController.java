package org.example.controller;

import org.example.dao.MedicineDAO;
import org.example.entity.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@RestController
@SpringBootApplication(scanBasePackages = "org.example")
public class MedicineController {

    @Autowired
    private MedicineDAO medicineDAO;
    String currentSort = "ByName";

    @GetMapping("/medicines")
    public List<Medicine> showAllMedicines(Model model) {

        return medicineDAO.getAllMedicines();
    }

    @GetMapping("/medicines/{id}")
    public Medicine getMedicine(@PathVariable int id) {

        return medicineDAO.getMedicine(id);
    }

    @PostMapping("/medicines")
    public Medicine addNewMedicine(@RequestBody Medicine medicine) {

        medicineDAO.saveMedicine(medicine);
        return medicine;
    }

    @PutMapping("/medicines")
    public Medicine updateMedicine(@RequestBody Medicine medicine) {

        medicineDAO.saveMedicine(medicine);
        return medicine;
    }

    @DeleteMapping("/medicines/{id}")
    public Medicine deleteMedicine(@PathVariable int id) {

        Medicine medicine = medicineDAO.getMedicine(id);
        medicineDAO.deleteMedicine(id);
        return medicine;
    }

    ///////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/medicinesByID")
    public List<Medicine> showAllMedicinesById(Model model) {

        List<Medicine> allMedicineList = medicineDAO.getAllMedicinesById();
        model.addAttribute("allMedicine", allMedicineList);
        return allMedicineList;
    }


//
//    @GetMapping("/medicinesByName")
//    public List<Medicine> showAllMedicinesByName(Model model) {
//
//        List<Medicine> allMedicineList = medicineDAO.getAllMedicinesByName();
//        model.addAttribute("allMedicine", allMedicineList);
//
//        return allMedicineList;
//    }

    //    @RequestMapping("/sortByExpDate")
//    public String showAllMedicinesByExpData(Model model) {
//
//        List<Medicine> allMedicineList = medicineDAO.getAllMedicinesByExpData();
//        model.addAttribute("allMedicine", allMedicineList);
//
//        return "all-drugs-list";
//    }
//

    //    @RequestMapping("/saveMedicine")
//    public String saveMedicine(@ModelAttribute("drug") Medicine medicine) {
//
//        medicineDAO.saveOrUpdateMedicine(medicine);
//
//        if (currentSort == "ByName")
//            return "redirect:/sortByName";
//
//        if (currentSort == "ById")
//            return "redirect:/sortById";
//
//        return "redirect:/";
//    }
//

//
//    @RequestMapping("/findMedicine")
//    public List<Medicine> findMedicine(@RequestParam("medicineName") String medicineName, Model model) {
//
////        List<Medicine> allMedicineList = medicineDAO.getAllMedicinesByName();
//
//        List<Medicine> foundMedicineList = medicineDAO.getAllMedicinesByFound("Нурофен");
//
////        if(!foundMedicineList.isEmpty())
////            model.addAttribute("allMedicine", foundMedicineList);
////        else
////            model.addAttribute("allMedicine", allMedicineList);
//
//        return foundMedicineList;
//    }
}