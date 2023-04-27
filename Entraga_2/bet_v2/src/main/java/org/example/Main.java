package org.example;

public class Main {
    public static void main(String[] args) {
        try{
            Data.CargarDatos();
            /*for(Persona person : Data.persons){
                System.out.println(person.getName()+" puntos:"+person.getPoints());
            }*/
            /*for(Partido match: Data.matches){
                System.out.println(match.getIdmatch());
            }*/
            for(Persona per : Data.ListPer){
                System.out.println(per.getName()+" puntaje:"+per.getPoints());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}