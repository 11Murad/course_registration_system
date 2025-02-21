package org.example.the_system_of_student_information.repository;
import org.example.the_system_of_student_information.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.name LIKE  %:name%")
    Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
