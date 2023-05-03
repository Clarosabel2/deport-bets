package org.example;

import lombok.Getter;
import lombok.Setter;

public class Pronostico {
    @Getter
    @Setter
    private Partido match;
    @Getter
    @Setter
    private Resultado result;
    public Pronostico(Partido match, Resultado rslt){
        this.match=match;
        this.result=rslt;
    }
}
