package org.example;

public class Main {
    public static void main(String[] args) {
        try{
            //Se cargan los datos y se guardan los datos en sus respectivas listas
            Data.CargarDatos();
            //Se imprimen en pantalla los valoes de los objetos
            for(Partido match: Data.matches){
                System.out.println(match.getIdmatch());
            }
            for(Persona per : Data.ListPer){
                System.out.println(per.getName()+" puntaje:"+per.getPoints());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}