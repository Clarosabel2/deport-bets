package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Data.loadData();
        /*System.out.println("-----------------Resultados:----------------");
        for(Equipo team: ResultadoEnum.teamsresult(0)){
            System.out.println(team.name+team.description);

        }
        System.out.println("---------Predicciones de Participante:-------");
        for (Equipo team: ResultadoEnum.teamsresult(1)){
            System.out.println(team.name+team.description);
        }*/
        System.out.println("Puntaje: "+Pronostico.points());
    }
}