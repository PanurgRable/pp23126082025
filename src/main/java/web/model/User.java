package web.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;

    @Column
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column
    @Min(value = 0, message = "Age should be greater than 0")
    private int age;

    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
