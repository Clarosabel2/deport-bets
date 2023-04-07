package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Data.loadData();
            System.out.println("Puntaje: "+Pronostico.points());
            System.out.println("Porcentaje de aciertos: "+((Pronostico.points()*100)/Partido.cntmatchs)+"%");
            System.out.println("Parditos acertados: ");
            for(Partido match:Partido.ResultP){
                System.out.println("     Nº:"+match.getIdMatch()+
                        " Gana:"+match.getTeamwinner().name);
            }
        } catch (Exception e){
            System.out.println(e);
        }

    }
}