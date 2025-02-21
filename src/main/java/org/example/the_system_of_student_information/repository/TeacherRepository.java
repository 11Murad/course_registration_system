package org.example.the_system_of_student_information.repository;
import org.example.the_system_of_student_information.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    @Query("select s from Teacher s join fetch s.user where s.user.name like %:name%")
    Page<Teacher> findByUser_NameContainingIgnoreCase(String firstName, Pageable pageable);

}

