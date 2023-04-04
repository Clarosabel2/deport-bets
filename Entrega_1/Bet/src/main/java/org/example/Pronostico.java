package org.example;

public class Pronostico {
    Partido match;
    Equipo team;
    ResultadoEnum result;
    public Pronostico(Partido mt, Equipo tm){
        this.match=mt;
        this.team=tm;
    }
    public static int points(){
        int sumpoints=0;
        for(Partido match: Partido.ResultP){
            sumpoints++;
        }
        return sumpoints;
    }
}
