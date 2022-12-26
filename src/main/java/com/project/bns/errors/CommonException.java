package com.project.bns.errors;

import lombok.Getter;

import java.io.PrintWriter;
import java.io.StringWriter;

@Getter
public class CommonException extends RuntimeException{
    private ErrorCode errorCode;
    private String errorDetailMsg;


    public CommonException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.errorDetailMsg = getStackTraceMsg(this);
    }

    public CommonException(ErrorCode errorCode, Exception exception) {
        this.errorCode = errorCode;
        this.errorDetailMsg = getStackTraceMsg(exception);
    }

    protected String getStackTraceMsg(Exception exception) {
        StringWriter sw = new StringWriter();
        exception.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }
}
