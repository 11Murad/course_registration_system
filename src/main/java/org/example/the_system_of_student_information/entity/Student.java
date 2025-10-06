package org.example.the_system_of_student_information.entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDate;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students" )
@ToString(exclude = "course")
@EqualsAndHashCode(exclude = "course")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Boolean scholarshipStatus;

    @CreationTimestamp
    LocalDate createdAt;

    @UpdateTimestamp
    LocalDate updatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    User user;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;
}
