package org.example.the_system_of_student_information.model.result;

public class SuccessDataResult <T> extends DataResult<T> {

    public SuccessDataResult() {}

    public SuccessDataResult(String message, T data) {
        super(true, message, data);
    }
}
