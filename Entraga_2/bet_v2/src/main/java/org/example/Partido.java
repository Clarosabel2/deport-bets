package org.example;

import lombok.Getter;
import lombok.Setter;

public class Partido {
    @Getter
    @Setter
    private Equipo team1;
    @Getter
    @Setter
    private int cntglstm1;
    @Getter
    @Setter
    private Equipo team2;
    @Getter
    @Setter
    private int cntglstm2;
    public Partido(Equipo t1, int glst1, Equipo t2, int glst2){
        this.team1=t1;
        this.cntglstm1=glst1;
        this.team2=t2;
        this.cntglstm2=glst2;
    }
}
