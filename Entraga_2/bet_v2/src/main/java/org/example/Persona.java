package org.example;

import lombok.Getter;
import lombok.Setter;

public class Persona {
    @Getter
    @Setter
    private int idperson;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int points;
    public Persona(int idperson, String name){
        this.idperson=idperson;
        this.name=name;
        this.points=0;
    }
}
