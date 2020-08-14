package com.ruv_front;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ruv_front {

    public static void main(String[] args) {
    	TimeZone.setDefault(TimeZone.getTimeZone("UTC")); 
        SpringApplication.run(ruv_front.class, args);
        
    }
    
}
