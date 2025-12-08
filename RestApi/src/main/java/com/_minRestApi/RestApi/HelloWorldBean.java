package com._minRestApi.RestApi;

public class HelloWorldBean {
    private String message;

    public HelloWorldBean(String message) {
        this.message=message;
    }
    public String getS() {
        return message;
    }
    public void setS(String message){
        this.message=message;
    }
    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "Message= " + message + '\'' +
                '}';
    }
}
