package org.example.the_system_of_student_information.repository;
import org.example.the_system_of_student_information.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query("select s from Student s join fetch s.user where s.user.name like %:name%")
    Page<Student> findByUser_NameContainingIgnoreCase(String name, Pageable pageable);

    @EntityGraph(attributePaths = {"user", "course"})
    Optional<Student> findStudentById(int id);
}
