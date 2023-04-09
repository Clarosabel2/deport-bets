package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Data.loadData();
            System.out.println("Puntaje: "+Pronostico.points());
            System.out.println("Porcentaje de aciertos: "+((Pronostico.points()*100)/Partido.cntmatchs)+"%");
            System.out.println("Desea visualizar los partidos acertados? \n 1.Si \n 2.No");
            Scanner sc = new Scanner(System.in);
            if(sc.nextInt()==1){
                System.out.println("Parditos acertados: ");
                for(Partido match:Partido.ResultP){
                    System.out.println("     Nº:"+match.getIdMatch()+
                            "||Gana:"+match.getTeamwinner().name);
                }
            }
            System.out.println("Hasta luego");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}