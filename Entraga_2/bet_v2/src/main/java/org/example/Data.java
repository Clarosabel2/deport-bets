package org.example;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Data{
    public static List<Partido>matches = new ArrayList<>();
    public static List<Persona>ListPer = new ArrayList<>();
    public static List<Resultado>Result = new ArrayList<>();
    public static void CargarDatos() throws Exception{//Carga de los datos
            String url="jdbc:mysql://db4free.net:3306/argprom42023";
            String username="chrisbel2000";
            String password="3rd@gJk7#NgV2Ha";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection oCn =  DriverManager.getConnection(url,username,password);
            Connection oCn2 =  DriverManager.getConnection(url,username,password);
            Statement stmt = oCn.createStatement();
            Statement stmt2 = oCn2.createStatement();
            ResultSet RSResult = stmt.executeQuery("SELECT * FROM RESULTADOS");
            ResultSet RSPronostic = stmt2.executeQuery("SELECT * FROM Pronostico");
            while(RSResult.next()){
                Equipo team1 = new Equipo(RSResult.getString("TEAM1"));
                Equipo team2 = new Equipo(RSResult.getString("TEAM2"));
                Partido match = new Partido(RSResult.getInt("IDMatch"),team1,RSResult.getInt("CNTGLS1"),team2,RSResult.getInt("CNTGLS2"));
                matches.add(match);//Se crean los objetos "Partidos" y "Resultados"
                Resultado rslt = new Resultado();
                rslt.setIDMatch(RSResult.getInt("IDMatch"));
                if(RSResult.getInt("CNTGLS1")>RSResult.getInt("CNTGLS2")){
                    rslt.setWinner(team1);
                    rslt.setLoser(team2);
                }
                else if(RSResult.getInt("CNTGLS2")>RSResult.getInt("CNTGLS1")){
                    rslt.setWinner(team2);
                    rslt.setLoser(team1);
                }
                else{
                    rslt.setWinner(null);
                    rslt.setLoser(null);
                    rslt.setDraw(true);
                }
                Result.add(rslt);
            }
            int i=0,a=0;
            String nombre;
            ArrayList<String>ListaNombr = new ArrayList<>();
            while(RSPronostic.next()) {
                nombre = RSPronostic.getString(1);
                //Se crean objetos "Personas"
                if (!ListaNombr.contains(nombre)) {//Agregando participante nuevo sin repetir
                    ListaNombr.add(nombre);
                    Persona pers = new Persona(i,nombre);
                    i++;
                    ListPer.add(pers);
                }
                Equipo team1 = new Equipo(RSPronostic.getString("equipo1"));
                Equipo team2 = new Equipo(RSPronostic.getString("equipo2"));
                Resultado rsltproc = new Resultado();
                rsltproc.setIDMatch(RSPronostic.getInt("Partido"));
                if(RSPronostic.getInt("gana1")==1){
                    rsltproc.setWinner(team1);
                    rsltproc.setLoser(team2);
                }
                else if(RSPronostic.getInt("empate")==1){
                    rsltproc.setDraw(true);
                    rsltproc.setWinner(null);
                    rsltproc.setLoser(null);
                }
                else if(RSPronostic.getInt("gana2")==1){
                    rsltproc.setWinner(team2);
                    rsltproc.setLoser(team1);
                }
                /*System.out.println(ListPer.get(i-1).getName() + " Match ID: " + Result.get(a).getIDMatch());
                if(!rsltproc.isDraw()) {

                    if(Result.get(a).getWinner()!=null) {

                        System.out.println("Ganador en resultados en la posicion :" + a + " " + Result.get(a).getWinner().getName());

                    }else System.out.println("Empate en posicion: " + a);

                    System.out.println("Ganador en pronostico: " + rsltproc.getWinner().getName());

                }else System.out.println("Empate");*/
                if(!rsltproc.isDraw()) {
                    //Se corrobora que los atributos no sean nulos y que concida con la precicion del participante
                    //En el caso que, en las lineas 91 95 101 sea true, se suma un punto al percipante y se actuliza en la lista de "Personas"
                    if(Result.get(a).getWinner()!=null) {
                        if(rsltproc.getWinner().getName().equals(Result.get(a).getWinner().getName())){
                            ListPer.get(i-1).setPoints(ListPer.get(i-1).getPoints()+1);
                        }
                    }
                    if(Result.get(a).getLoser()!=null){
                        if(rsltproc.getLoser().getName().equals(Result.get(a).getLoser().getName())){
                            ListPer.get(i-1).setPoints(ListPer.get(i-1).getPoints()+1);
                        }
                    }
                }else{
                    if(rsltproc.isDraw()==true && Result.get(a).isDraw()==true){
                        ListPer.get(i-1).setPoints(ListPer.get(i-1).getPoints()+1);
                    }
                }
                a++;
            }
            oCn.close();
            oCn2.close();
    }
}
