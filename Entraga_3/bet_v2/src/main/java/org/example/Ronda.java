package org.example;

import lombok.Getter;
import lombok.Setter;

public class Ronda {
    @Getter
    @Setter
    private int nroRonda;
    @Getter
    @Setter
    private Partido[] matches;
    public Ronda (int nR, Partido[] mt){
        this.nroRonda=nR;
        this.matches=mt;
    }
}
