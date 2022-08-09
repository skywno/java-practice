package challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTests {
    Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void validUserInfo() throws Exception {
        User.UserBuilder userBuilder = new User.UserBuilder("monika", "klooi0988")
                .email("monika@gmail.com")
                .firstName("Monika")
                .lastName("Gunther");

        validate(userBuilder);
    }

    @Test
    public void invalidUserNickname() throws Exception {
        User.UserBuilder userBuilder = new User.UserBuilder("ab", "Kdfasdfhk")
                .email("monika@gmail.com")
                .firstName("Monika")
                .lastName("Gunther");

        Assertions.assertThrows(Exception.class, () -> validate(userBuilder));
    }

    @Test void invalidUserEmail() throws Exception {
        User.UserBuilder userBuilder = new User.UserBuilder("monika", "klooi0988")
                .email("monikagmail.com")
                .firstName("Monika")
                .lastName("Gunther");

        Assertions.assertThrows(Exception.class, () -> validate(userBuilder));

    }

    private void validate(User.UserBuilder userBuilder) throws Exception {
        User user;
        final Set<ConstraintViolation<User.UserBuilder>> violations
                = validator.validate(userBuilder);

        if (violations.isEmpty()) {
            user = userBuilder.build();

            System.out.println("User successfully created on: " + user.getCreated());
        } else {
            printConstraintViolations("UserBuilder Violations: ", violations);
            throw new Exception("Invalid input");
        }
    }

    private static <T> void printConstraintViolations(
            String caption, Set<ConstraintViolation<T>> violations) {

        System.out.println(caption);

        violations.forEach((v) -> {
            System.out.println("\t" + v.getPropertyPath() + " " + v.getMessage());
        });
    }
}