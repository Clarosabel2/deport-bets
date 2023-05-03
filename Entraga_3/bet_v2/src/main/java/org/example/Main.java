package org.example;

public class Main {
    public static void main(String[] args) {
        try{
            Data.CargarDatos();
            for(Persona per : Data.ListPer){
                System.out.println("Participante: "+per.getName()+"\n Cantidad de Apuestas: "+per.getCntbets()+"\n Puntaje:"+per.getPoints());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}