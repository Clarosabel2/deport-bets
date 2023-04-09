package org.example;

import lombok.Getter;
import lombok.Setter;

public class Equipo {
    @Getter
    @Setter
    String name;
    @Getter
    @Setter
    String description;
    public Equipo(String _name){
        this.name=_name;
        this.description=null;
    }
}
