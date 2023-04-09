package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Data {

    public static void loadData()throws  Exception{
        File rutaPronosticos = new File("D:\\pronostico.csv");
        File rutaResultados = new File("D:\\resultados.csv");
        String[]Vline;
        String line;
        int a=0,idperson=0;
        BufferedReader BRresult = new BufferedReader(new FileReader(rutaResultados));
        while((line=BRresult.readLine())!=null){
            Vline=line.split(";");

        }
        BRresult.close();
        a=0;
        String namebf = null;
        BufferedReader BRpredict = new BufferedReader(new FileReader(rutaPronosticos));
        while((line=BRpredict.readLine())!=null){
            if(a!=0){
                Vline=line.split(";");
                if(namebf!=Vline[0]){
                    idperson++;
                    Persona person = new Persona(idperson,Vline[0]);
                    namebf=Vline[0];
                }
                Equipo t1= new Equipo(Vline[1]);
                Equipo t2= new Equipo(Vline[5]);
                if(Vline[2]=="x"){
                    Resultado rslt = new Resultado();
                    rslt.setDraw(true);
                }
                if(Vline[3]=="x"){
                    Resultado rslt = new Resultado();
                    rslt.setWinner(t1);
                    rslt.setLoser(t2);
                }
                if(Vline[4]=="x"){
                    Resultado rslt = new Resultado();
                    rslt.setWinner(t2);
                    rslt.setLoser(t1);
                }
            }
            a++;
        }
        BRpredict.close();
    }
}
