package springapps.validated_student.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//where would you like to put it class, field, method
@Target(ElementType.TYPE)
//when will it be processed compiler, runtime ...
@Retention(RetentionPolicy.RUNTIME)
//wich class has your validation logic
@Constraint(validatedBy = AgeAnnotation.class)
public @interface Age {
    String message() default "Age and birthday are not matching";
    //to match the expectations
    Class<?>[] groups() default {};
    public abstract Class<? extends Payload>[] payload() default {};
}

