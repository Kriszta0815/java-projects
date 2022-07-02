package springapps.validated_student;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.format.annotation.DateTimeFormat;
import springapps.validated_student.validation.Age;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Objects;

@Age
public class Student {
    private String id;
    @NotEmpty
    @Size(min= 8,max= 15)
    @Indexed(unique = true)
    private String username;
    @Email
    private String email;
    private String phoneNumber;
    @Min(18)
    private int age;
    @Past
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthday;

    public Student(String username, String email, String phoneNumber, int age, LocalDate birthday) {
        this.username = username;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.birthday = birthday;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(id, student.id) && Objects.equals(username, student.username) && Objects.equals(email, student.email) && Objects.equals(phoneNumber, student.phoneNumber) && Objects.equals(birthday, student.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, phoneNumber, age, birthday);
    }
}
