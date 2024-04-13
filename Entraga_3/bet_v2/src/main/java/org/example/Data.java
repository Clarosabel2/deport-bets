package org.example;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Data{
    public static List<Pronostico>Proc = new ArrayList<>();
    public static List<Persona>ListPer = new ArrayList<>();
    public static List<Resultado>Result = new ArrayList<>();
    public static void CargarDatos() throws Exception{//Carga de los datos
        String url="";
        String username="";
        String password="";
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
            Pronostico proc = new Pronostico(match,rslt);
            Proc.add(proc);
            Result.add(rslt);
        }
        int i=0,a=0,cntbets=0;
        String nombre;
        ArrayList<String>ListaNombre = new ArrayList<>();
        while(RSPronostic.next()) {
            nombre = RSPronostic.getString(1);
            //Se crean objetos "Personas"
            if (!ListaNombre.contains(nombre)) {//Agregando participante nuevo sin repetir
                ListaNombre.add(nombre);
                Persona pers = new Persona(i,nombre);
                i++;
                ListPer.add(pers);
            }else{
                ListPer.get(i-1).setCntbets(ListPer.get(i-1).getCntbets()+1);
            }
            Equipo team1 = new Equipo(RSPronostic.getString("equipo1"));
            Equipo team2 = new Equipo(RSPronostic.getString("equipo2"));
            Resultado rsltproc = new Resultado();
            rsltproc.setIDMatch(RSPronostic.getInt("Partido"));
            if(RSPronostic.getBoolean("gana1")){
                rsltproc.setWinner(team1);
                rsltproc.setLoser(team2);
            }
            else if(RSPronostic.getBoolean("empate")){
                rsltproc.setDraw(true);
            }
            else if(RSPronostic.getBoolean("gana2")){
                rsltproc.setWinner(team2);
                rsltproc.setLoser(team1);
            }
            //Proc.get(a).setResult(rsltproc);
            if(!rsltproc.isDraw()) {
                if(Result.get(a).getWinner()!=null) {
                    if (rsltproc.getWinner().getName().equals(Result.get(a).getWinner().getName())) {
                        ListPer.get(i - 1).setPoints(ListPer.get(i - 1).getPoints() + 1);
                    }
                }
            }else{
                if(Result.get(a).isDraw()){
                    ListPer.get(i-1).setPoints(ListPer.get(i-1).getPoints()+1);
                }
            }
            a++;
        }
        oCn.close();
        oCn2.close();
        expoints();
    }
    public static String uploadData(){
        try{
            String url="jdbc:mysql://db4free.net:3306/argprom42023";
            String username="chrisbel2000";
            String password="3rd@gJk7#NgV2Ha";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection oCn =  DriverManager.getConnection(url,username,password);
            for(Persona person : ListPer){
                PreparedStatement smt = oCn.prepareStatement("INSERT INTO PLAYER VALUES (?,?,?,?)");
                smt.setInt(1,person.getIdperson());
                smt.setString(2,person.getName());
                smt.setInt(3,person.getCntbets());
                smt.setInt(4,person.getPoints());
                smt.executeUpdate();
                smt.close();
            }
            oCn.close();
            return "SE SUBIERON CORRECTAMENTE LOS DATOS EN LA DB";
        }catch (Exception e){
            return "ERROR EN SUBIR LOS DATOS EN LA DB: "+e.getMessage();
        }

    }
    private static void expoints(){
        for(Persona person: ListPer){
            if(person.getCntbets() == person.getPoints()){
                person.setPoints(person.getPoints()+2);
            }
        }
    }
}
