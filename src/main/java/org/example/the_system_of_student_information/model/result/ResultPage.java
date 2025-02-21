package org.example.the_system_of_student_information.model.result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultPage<T>{
    private List<T> data;
    private int page;
    private int size;
    private long totalPages;
}
