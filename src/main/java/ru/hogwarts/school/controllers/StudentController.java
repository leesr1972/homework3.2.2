package ru.hogwarts.school.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.models.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return ResponseEntity.ok(student);
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        Student foundStudent = studentService.findStudent(id);
        if (foundStudent == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @PutMapping
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        Student foundStudent = studentService.editStudent(student);
        if (foundStudent == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id) {
        Student foundStudent = studentService.deleteStudent(id);
        if (foundStudent == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<List<Student>> getStudentsByAge(@PathVariable Integer age) {
        List<Student> foundStudents = studentService.getStudentsByAge(age);
        if (foundStudents.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundStudents);
    }
}
