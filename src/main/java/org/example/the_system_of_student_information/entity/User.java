package org.example.the_system_of_student_information.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.the_system_of_student_information.entity.enums.Status;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_number", unique = true)
    private Integer userNumber;

    private String password;

    @Enumerated(EnumType.STRING)
    private Status status;
}
