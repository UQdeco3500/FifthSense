//code referenced from
//https://gabrielpulga.medium.com/building-a-real-time-chat-application-with-spring-boot-and-websocket-4ad1c68ee217
//and also
//https://github.com/gabrielpulga/spring-boot-websocket

//changed the language of the code to suit our needs.
package com.tupinamba.springbootwebsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebsocketApplication.class, args);
    }
}