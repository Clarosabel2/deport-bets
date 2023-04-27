package org.example;

import lombok.Getter;
import lombok.Setter;

public class Pronostico {
    private Partido match;
    private Equipo team;
    private Resultado result;
    public Pronostico(Partido match, Equipo team, Resultado rslt){
        this.match=match;
        this.team=team;
        this.result=rslt;
    }
}
