package twentyoneh.learn1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import twentyoneh.learn1.model.Student;
import twentyoneh.learn1.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {
     
    private final StudentService service;
    
    @GetMapping 
    public List<Student> finAllStudents()
    {   
        return service.finAllStudents();
    }
    
    @PostMapping("save_student")
    public Student saveStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @GetMapping("/{email}")
    public Student findByEmail(@PathVariable("email") String email) {
        return service.findByEmail(email);
    }

    @PutMapping("update_student")
    public Student UpdateStudent(@RequestBody Student student) {
        return service.UpdateStudent(student);
    }

    @DeleteMapping("delete_student/{email}")
    public void deleteStudent(@PathVariable("email") String email) {
        service.deleteStudent(email);
    }
}
