package pl.coderslab.charity.validators;



import pl.coderslab.charity.entities.Category;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;


public class CheckboxValidator implements ConstraintValidator<Checkbox, List<Category>>  {

    @Override
    public void initialize(Checkbox constraintAnnotation) {

    }

    @Override
    public boolean isValid(List<Category> categories, ConstraintValidatorContext constraintValidatorContext) {
        if(categories == null || categories.isEmpty()){
            return false;
        }

        return categories.stream().allMatch(e  -> e.getId()!= null && !e.getName().isEmpty());
    }

}
