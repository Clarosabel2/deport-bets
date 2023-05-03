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
    private int cntbets;
    @Getter
    @Setter
    private int points;
    public Persona(int idperson, String name){
        this.idperson=idperson;
        this.name=name;
        this.cntbets=1;
        this.points=0;
    }
}
