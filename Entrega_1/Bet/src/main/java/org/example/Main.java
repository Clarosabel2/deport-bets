package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Data.loadData();
        System.out.println("Puntaje: "+Pronostico.points());
        System.out.println("Parditos acertados: ");
        for(Partido match:Partido.ResultP){
            System.out.println("Nº:"+match.getIdMatch()+
                    " Gana:"+match.getTeamwinner().name);
        }
    }
}