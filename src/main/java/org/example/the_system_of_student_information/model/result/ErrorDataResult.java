package org.example.the_system_of_student_information.model.result;

public class ErrorDataResult <T>extends DataResult<T>{

    public ErrorDataResult() {}

    public ErrorDataResult(String message,T data) {
        super(false, message,data);
    }
}
