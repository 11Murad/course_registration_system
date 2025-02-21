package org.example.the_system_of_student_information.model.result;

public class ErrorResult extends Result {

    public ErrorResult() {}

    public ErrorResult(String message) {
        super(false, message);
    }

}
