package org.example;

public class Main {
    public static void main(String[] args) {
        try{
            Data.CargarDatos();
            System.out.println("Partidos: ");
            System.out.println("--------- ");
            for(Pronostico proc: Data.Proc){
                System.out.println(" ID: "+proc.getMatch().getIdmatch());
                if(!proc.getResult().isDraw()){
                    System.out.println(" Ganador: "+proc.getResult().getWinner().getName());
                    System.out.println(" Perdedor: "+proc.getResult().getLoser().getName());
                }
                else{
                    System.out.println(" Empate");
                }
                System.out.println("------");
            }
            System.out.println("Participantes: ");
            System.out.println("-------------- ");
            for(Persona per : Data.ListPer){
                System.out.println(
                        " ID: "+per.getIdperson()+
                        "\n Nombre: "+per.getName()+
                        "\n Cantidad de Apuestas: "+per.getCntbets()+
                        "\n Puntaje:"+per.getPoints());
                System.out.println("------");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}