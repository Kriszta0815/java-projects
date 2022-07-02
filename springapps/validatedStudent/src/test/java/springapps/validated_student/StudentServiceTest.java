package springapps.validated_student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.util.stream.Stream;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class StudentServiceTest {
    @Autowired
    StudentService studentService;
    @MockBean
    StudentRepository studentRepository;

    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new Student("test", "test@tst.com", "test" , 40, LocalDate.of(1981, 8,15))),
                Arguments.of(new Student("testtest", "test", "test" , 40, LocalDate.of(1981, 8,15))),
                Arguments.of(new Student("testtest", "test@tst.com", "test" , 15, LocalDate.of(2007, 5,15))),
                Arguments.of(new Student(null, "test@tst.com", "test" , 40, LocalDate.of(1981, 8,15)))

        );
    }
    @ParameterizedTest
    @MethodSource("parameters")
    void save_not(Student input) {
        Student student = new Student("tst", "test", "test" , 18, LocalDate.now());
        Assertions.assertThrows(ConstraintViolationException.class, () -> studentService.save(input));
        Mockito.verify(studentRepository, Mockito.never()).save(student);
    }
    @Test
    void save() {
        Student student = new Student("testtest", "test@tst.com", "test" , 40, LocalDate.of(1981, 8,15));
        studentService.save(student);
        Mockito.verify(studentRepository).save(student);
    }
    @Test
    void getAll() {
        studentService.getAll();
        Mockito.verify(studentRepository).findAll();
    }
}