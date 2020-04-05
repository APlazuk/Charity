package pl.coderslab.charity.validators;

import pl.coderslab.charity.repositories.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

   private final UserRepository userRepository;

   public UniqueUsernameValidator(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   public void initialize(UniqueUsername constraint) {
   }

   public boolean isValid(String value, ConstraintValidatorContext context) {
      return !userRepository.existsUserByUsername(value);
   }
}
