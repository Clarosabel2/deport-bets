package org.example;

import lombok.Getter;
import lombok.Setter;

public class Pronostico {
    private Partido match;
    private Resultado result;
    public Pronostico(Partido match, Resultado rslt){
        this.match=match;
        this.result=rslt;
    }
}
