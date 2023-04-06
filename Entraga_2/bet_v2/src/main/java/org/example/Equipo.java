package org.example;

import lombok.Getter;
import lombok.Setter;

public class Equipo {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String description;
    public Equipo(String name){
        this.name=name;
        this.description=null;
    }
}
