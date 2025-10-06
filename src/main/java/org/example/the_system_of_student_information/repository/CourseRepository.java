package org.example.the_system_of_student_information.repository;
import org.example.the_system_of_student_information.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    @EntityGraph(attributePaths = {"teachers", "students"})
    Page<Course> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Page<Course> findAllBy(Pageable pageable);

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,value = "course-with-teachers-and-students")
    Set<Course> getAllBy();

}
