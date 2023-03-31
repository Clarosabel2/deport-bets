package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Partido {
    public static List<Equipo>teamR= new ArrayList<>();
    public static List<Equipo>teamP= new ArrayList<>();
    @Setter
    @Getter
    private int idMatch;
    @Setter
    @Getter
    private Equipo Team1;
    @Setter
    @Getter
    private int cntglsTeam1;
    @Setter
    @Getter
    private Equipo Team2;
    @Setter
    @Getter
    private int cntglsTeam2;

    public Partido(int id, Equipo t1, int cntgT1, Equipo t2, int cntgT2){
        this.idMatch=id;
        this.Team1=t1;
        this.cntglsTeam1=cntgT1;
        this.Team2=t2;
        this.cntglsTeam2=cntgT2;
    }
    public static void result(){
        for (Partido match : Data.matches) {
            if (match.getCntglsTeam1() > match.getCntglsTeam2()) {
                Equipo tw = new Equipo(match.getTeam1().name);
                tw.setDescription("Gana "+match.idMatch);
                teamR.add(tw);
            }
            if (match.getCntglsTeam2() > match.getCntglsTeam1()) {
                Equipo tw = new Equipo(match.getTeam2().name);
                tw.setDescription("Gana "+match.idMatch);
                teamR.add(tw);
            }
            if(match.getCntglsTeam1()== match.getCntglsTeam2()){
                Equipo tw = new Equipo(null);
                tw.setDescription("Empate "+match.idMatch);
                teamR.add(tw);
            }
        }
        for (Partido match : Data.usuPronostic) {
            if (match.getCntglsTeam1() > match.getCntglsTeam2()) {
                Equipo twP = new Equipo(match.getTeam1().name);
                twP.setDescription("Gana "+match.idMatch);
                teamP.add(twP);
            }
            if (match.getCntglsTeam2() > match.getCntglsTeam1()) {
                Equipo twP = new Equipo(match.getTeam2().name);
                twP.setDescription("Gana "+match.idMatch);
                teamP.add(twP);
            }
            if(match.getCntglsTeam1()== match.getCntglsTeam2()){
                Equipo twP = new Equipo(null);
                twP.setDescription("Empate "+match.idMatch);
                teamP.add(twP);
            }
        }
    }
}
