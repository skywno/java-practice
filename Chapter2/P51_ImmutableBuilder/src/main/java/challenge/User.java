package challenge;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public final class User {

    @NotNull
    private final String nickname;
    @NotNull
    @Size(min = 8, max = 20)
    private final String password;
    @NotNull
    private final Date created;
    @Email
    @NotNull
    private final String email;
    private final String firstname;
    private final String lastname;

    private User(UserBuilder builder) {
        this.nickname = builder.nickname;
        this.password = builder.password;
        this.created = builder.created;
        this.email = builder.email;
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
    }

    public static UserBuilder getBuilder(String nickname, String password){
        return new UserBuilder(nickname, password);
    }
    public static class UserBuilder {

        private final String nickname;
        private final String password;
        private final Date created;
        private String email;
        private String firstname;
        private String lastname;

        public UserBuilder(String nickname, String password){
            this.nickname = nickname;
            this.password = password;
            this.created = new Date();
        }

        public UserBuilder email(String email){
            this.email = email;
            return this;
        }

        public UserBuilder firstName(String firstname){
            this.firstname = firstname;
            return this;
        }

        public UserBuilder lastName(String lastname){
            this.lastname = lastname;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public Date getCreated() {
        return created;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

}
