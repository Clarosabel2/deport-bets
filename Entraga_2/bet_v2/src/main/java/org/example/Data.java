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
                    rslt.setDraw(true);
                }
                Result.add(rslt);
            }
            int i=0;
            String nombre;
            ArrayList<String>ListaNombr = new ArrayList<>();
            while(RSPronostic.next()) {
                nombre = RSPronostic.getString(1);
                //Se crean objetos "Personas"
                if (!ListaNombr.contains(nombre)) {//Agregando participante nuevo sin repetir
                    ListaNombr.add(nombre);
                    i++;
                    Persona pers = new Persona(i,nombre);
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
                }
                else if(RSPronostic.getInt("gana2")==1){
                    rsltproc.setWinner(team2);
                    rsltproc.setLoser(team1);
                }
                for(Resultado rslt : Result){
                    if(rslt.equals(rsltproc)){
                        ListPer.get(i).setPoints(ListPer.get(i).getPoints()+1);
                    }
                }
            }
            oCn.close();
            oCn2.close();
    }
}
