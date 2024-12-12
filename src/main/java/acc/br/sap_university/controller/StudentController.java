package acc.br.sap_university.controller;

import acc.br.sap_university.model.StudentModel;
import acc.br.sap_university.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/index")
    public String showIndexPage(Model model) {
        model.addAttribute("student", new StudentModel());
        model.addAttribute("students", studentService.findAll());
        return "index"; // Nome da página HTML
    }

    @PostMapping
    public String createStudent(@ModelAttribute StudentModel studentModel) {
        studentService.save(studentModel);
        return "redirect:/students/index";
    }


    @GetMapping("/index/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        StudentModel student = studentService.getStudentById(id);
        if (student != null) {
            model.addAttribute("student", student);
            return "index";
        } else {
            return "redirect:/students";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
        return "redirect:/students/index";
    }
    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute StudentModel studentModel) {
        studentService.update(id, studentModel);
        return "redirect:/students/index";
    }

}
