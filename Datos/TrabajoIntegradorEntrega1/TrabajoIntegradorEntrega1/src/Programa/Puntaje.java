/**
 * 
 */
package Programa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import Domain.Equipo;
import Domain.Partido;
import Domain.Pronostico;
import Domain.Ronda;
import Enum.Resultado;


/**
 * @author lucas
 *
 */
public class Puntaje {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        //System.out.print("Introduzca la ruta al archivo .csv de Resultados: ");

        //System.out.print("Introduzca la ruta al archivo .csv de Pronostico: ");

        Path rutaResultados = Paths.get("C:\\Users\\lucas\\OneDrive\\Escritorio\\Curso Java\\resultadosCSV.csv");
        Path rutaPronosticos = Paths.get("C:\\Users\\lucas\\OneDrive\\Escritorio\\Curso Java\\pronosticoCSV.csv");
        
        
        List<Partido> partidos = new ArrayList<>();
        
        try (BufferedReader reader = Files.newBufferedReader(rutaResultados, StandardCharsets.UTF_8)) {
        	reader.readLine();
        	String linea;
            while ((linea = reader.readLine()) != null) {
            	String[] partes = linea.split(";");
                int id = Integer.parseInt(partes[0]);
                Equipo equipo1 =  new Equipo(partes[1]);
                int golesEquipo1 = Integer.parseInt(partes[2]);
                int golesEquipo2 = Integer.parseInt(partes[3]);
                Equipo equipo2 =  new Equipo(partes[4]);
                Partido partido = new Partido(id,equipo1,equipo2,golesEquipo1,golesEquipo2);
                partidos.add(partido);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Partido[] parti2=new Partido[partidos.size()];
        
        for (int i = 0; i < partidos.size(); i++) {
            parti2[i] = partidos.get(i);
        }
        Ronda ronda= new Ronda(1,parti2,"48",1);

        List<Pronostico> pronosticos = new ArrayList<>();
        
        try (BufferedReader read = Files.newBufferedReader(rutaPronosticos, StandardCharsets.UTF_8)) {
        	read.readLine();
        	String linea;
            while ((linea = read.readLine()) != null) {
            	String[] partes = linea.split(";");
                int id = Integer.parseInt(partes[0]);
                Partido partido= buscarPartidoPorId(partidos,id); 
                
                String empatan = (partes[3]);
                String gana2 = (partes[4]);
                Resultado resultado= Resultado.ganador;
                Equipo equipo =partido.getEquipo1();
                if (empatan=="x") {equipo=partido.getEquipo1(); resultado= Resultado.empate; }
                if (gana2=="x") {equipo=partido.getEquipo2();}
                
                Pronostico pronostico= new Pronostico(partido,equipo,resultado);
                pronosticos.add(pronostico);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        for (Partido partido : partidos) {
        	System.out.print("Id "+partido.getId()+" "+partido.getEquipo1().getNombre()+" "+partido.getGolesEquipo1()+" "+partido.getEquipo2().getNombre()+" "+partido.getGolesEquipo2()+"\n");
         
        }
        
        
        int totalDePuntos=0;
        for (Pronostico pronostico : pronosticos) {
        	System.out.print("Id "+pronostico.getPartido().getId()+" "+pronostico.getPartido().getEquipo1().getNombre()+" "+pronostico.getResultado()+" "+pronostico.getPartido().resultado(pronostico.getEquipo())+"\n");
            
            totalDePuntos=totalDePuntos+pronostico.puntos();
         
        }
        
        
        System.out.print("Total de puntos es: " + ronda.puntos()*totalDePuntos);
        
        
    }
	
	
	//No tengo controladoras metodo ubicado provisoriamente
	public static Partido buscarPartidoPorId(List<Partido> partidos, int id) {
        for (Partido partido : partidos) {
            if (partido.getId() == id) {
                return partido;
            }
        }
        return null; 
    }
}
