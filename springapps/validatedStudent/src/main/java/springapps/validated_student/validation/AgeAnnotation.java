package springapps.validated_student.validation;

import springapps.validated_student.Student;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class AgeAnnotation implements ConstraintValidator <Age, Student> {

    @Override
    public void initialize(Age constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
    //logic here:
    @Override
    public boolean isValid(Student student, ConstraintValidatorContext constraintValidatorContext) {
        Period period = Period.between(student.getBirthday(), LocalDate.now());
        return period.getYears() == student.getAge();
    }
}

