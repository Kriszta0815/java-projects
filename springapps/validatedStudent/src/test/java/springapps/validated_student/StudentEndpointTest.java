package springapps.validated_student;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StudentEndpointTest {
    @Autowired
    TestRestTemplate testRestTemplate;
    @MockBean
    StudentService studentService;
    String url = "/students";

    @Test
    void getAll() {
        testRestTemplate.getForObject(url, Student[].class);
        Mockito.verify(studentService).getAll();
    }
    @Test
    void post_not() {
        Student student = new Student("tst", "test", "test" , 18, LocalDate.now());
        testRestTemplate.postForObject(url, student, Student.class);
        Mockito.verify(studentService, Mockito.never()).save(student);

    }
    @Test
    void post() {
        Student student = new Student("testtest", "test@tst.com", "test" , 40, LocalDate.of(1981, 8,15));
        testRestTemplate.postForObject(url, student, Student.class);
        Mockito.verify(studentService).save(student);

    }
}