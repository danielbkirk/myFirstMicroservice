package com.tsi.dan.kirk.program;


import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int actor_id;

    //Attributes
    String first_name;
    String last_name;

    public Actor(String first_name, String last_name){

        this.first_name = first_name;
        this.last_name = last_name;

    }

    //Empty constructor
    public Actor(){

    }

    //Getters and setters
    public String getFirst_name(){
        return this.first_name;
    }

    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }

    public String getLast_name(){
        return this.last_name;
    }

    public void setLast_name(String last_name){
        this.last_name = last_name;
    }

    public int getActor_id() {
        return actor_id;
    }

    public void setActor_id(int actor_id) {
        this.actor_id = actor_id;
    }
}
