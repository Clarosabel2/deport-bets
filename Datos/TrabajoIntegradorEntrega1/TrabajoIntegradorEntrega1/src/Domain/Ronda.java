/**
 * 
 */
package Domain;

/**
 * @author lucas
 *
 */
public class Ronda {
	
	 private int id;
	 private Partido[] partidos;
	 private String nro;
	 private int punto;

	    public Ronda(int id,Partido[] unosPartidos,String unNro,int unPunto) {
	        this.id=id;
	    	this.partidos = unosPartidos;
	    	this.nro= unNro;
	    	this.punto= unPunto;
	    }

	    public Partido[] getPartidos() {
	        return partidos;
	    }

	    public void setPartidos(Partido[] partidos) {
	        this.partidos = partidos;
	    }
	    
	    public int puntos() {
	    	return this.punto;
	    }
}


