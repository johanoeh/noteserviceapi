package se.sundsvall.midalva.noteapi.model.dto;


import java.util.Date;

public class ErrorDetails {

    private Date timeStamp;
    private String message;
    private String result;

    public ErrorDetails(Date timeStamp,  String result,String message) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.result = result;
    }

    public ErrorDetails(String message, String result) {
        this.timeStamp = new Date();
        this.message = message;
        this.result = result;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
