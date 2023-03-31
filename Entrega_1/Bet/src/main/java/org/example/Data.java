package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Partido>matches = new ArrayList<>();
    public static List<Partido>usuPronostic = new ArrayList<>();
    public static void loadData()throws IOException{
        File rutaPronosticos = new File("D:\\pronostico.csv");
        File rutaResultados = new File("D:\\resultados.csv");
        String[]Vline;
        String line;
        int a=0;
        BufferedReader BRresult = new BufferedReader(new FileReader(rutaResultados));
        while((line=BRresult.readLine())!=null){
            if(a!=0){
                Vline=line.split(";");
                Equipo team1 = new Equipo(Vline[1]);
                Equipo team2 = new Equipo(Vline[4]);
                Partido match = new Partido(Integer.parseInt(Vline[0]),team1,Integer.parseInt(Vline[2])
                        ,team2,Integer.parseInt(Vline[3]));
                matches.add(match);
            }
            a++;
        }
        BRresult.close();
        a=0;
        BufferedReader BRpredict = new BufferedReader(new FileReader(rutaPronosticos));
        while((line=BRpredict.readLine())!=null){
            if(a!=0){
                Vline=line.split(";");
                Equipo team1 = new Equipo(Vline[1]);
                Equipo team2 = new Equipo(Vline[5]);
                int cntgls1=0,cntgls2=0;
                if(Vline[2].equals("x")){
                    cntgls1=1;
                }
                if(Vline[3].equals("x")){
                    cntgls1=1;
                    cntgls2=1;
                }
                if(Vline[4].equals("x")){
                    cntgls2=1;
                }
                Partido matchusu = new Partido(Integer.parseInt(Vline[0]),team1,cntgls1,team2,cntgls2);
                usuPronostic.add(matchusu);
            }
            a++;
        }
        BRpredict.close();
    }
}
