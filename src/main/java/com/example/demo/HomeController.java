package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TestRepository testRepository;

    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("tests", testRepository.findAll());
        return "index";
    }
    @RequestMapping("/addStudent")
    public String studentForm(Model model){
        model.addAttribute("student", new Student());
        return "studentForm";
    }
    @PostMapping("/process_student")
    public String processStudent(@Valid Student student, BindingResult result){
        if(result.hasErrors()){
            return "studentForm";
        }
        studentRepository.save(student);
        return "redirect:/";
    }
    @GetMapping("/addTest")
    public String addTest(Model model){
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("test", new Test());
        return "testForm";
    }
    @PostMapping("/process_test")
    public String processTestForm(@Valid Test test, BindingResult result){
        if(result.hasErrors()){
            return "testForm";
        }
        testRepository.save(test);
        return "redirect:/";
    }
}
