package com.example.jobportalon.Entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter

public class Role extends BaseEntity{
    private String name;


    public Role(String name) {
        super();
        this.name = name;
    }

    public Role() {

    }


    @Override
    public String toString() {
        return this.name;
    }



}
