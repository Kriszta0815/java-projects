package springapps.validated_student;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student save(@Valid Student student) {
        return studentRepository.save(student);
    }
    public List<Student> getAll() {
        return studentRepository.findAll();
    }
}