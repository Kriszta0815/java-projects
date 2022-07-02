package springapps.validated_student;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentEndpoint {
    private final StudentService studentService;

    public StudentEndpoint(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    Student post(@Valid @RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping
    List<Student> getAll() {
        return studentService.getAll();
    }
}