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
        ResultadoEnum.teamsresult();
        for(Equipo team : Partido.teamR){
            for(Equipo teamP: Partido.teamP){
                if(team.getDescription().equals(teamP.getDescription())){
                    sumpoints++;
                }
            }
        }
        return sumpoints;
    }
}
