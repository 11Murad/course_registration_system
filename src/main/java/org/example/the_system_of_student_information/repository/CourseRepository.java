package org.example.the_system_of_student_information.repository;
import org.example.the_system_of_student_information.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    @EntityGraph(attributePaths = {"teachers", "students"})
    Page<Course> findByNameContainingIgnoreCase(String name, Pageable pageable);

    @EntityGraph(attributePaths = {"teachers", "students"})
    @Query("SELECT c FROM Course c")
    Page<Course> findAllCourses(Pageable pageable);

}
