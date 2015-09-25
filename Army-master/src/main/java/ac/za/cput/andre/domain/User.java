package ac.za.cput.andre.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by student on 2015/09/22.
 */
@Entity
public class User implements Serializable{

    @Id
    private String email;

    private String userpassword;
    private String firstname;
    private String lastname;

    private User()
    {}

    public User(Builder builder) {
        this.email=builder.email;
        this.userpassword=builder.userpassword;
        this.firstname=builder.firstname;
        this.lastname=builder.lastname;
    }

    public static class Builder{
        private String email;
        private String userpassword;
        private String firstname;
        private String lastname;

        public Builder(String email) {
            this.email = email;
        }

        public Builder firstname(String value){
            this.firstname=value;
            return this;
        }

        public Builder lastname(String value){
            this.lastname =value;
            return this;
        }

        public Builder userpassword(String value){
            this.userpassword=value;
            return this;
        }

        public User build(){
            return new User(this);
        }

    }

    public String getFirstname()
    {
        return firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public String getEmail()
    {
        return email;
    }

    public String getUserpassword()
    {
        return userpassword;
    }
}
