package pl.coderslab.charity.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CheckboxValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Checkbox {
    String message() default "{checkboxValidator.error.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
