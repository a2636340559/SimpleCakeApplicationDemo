package com.wide.cakeapplication.infrastructure.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Getter
@Setter
public class Response {
    Integer code;
    String msg;
    Object body;

    public Response(Integer code, String msg, Object body) {
        this.code = code;
        this.msg = msg;
        this.body = body;
    }
    public Response(Exception e){
        this.code = 500;
        msg = e.getMessage();
    }

    public Response() {
    }

    public static Response SUCCESS(Object result){
        return new Response(200,"success",result);
    }
    public static Response SUCCESS(){
        return new Response(200,"success",null);
    }
    public static Response SUCCESS(String msg){
        return new Response(200,msg,null);
    }
    public static Response FAILED(Exception e){
        return new Response(e);
    }
}
