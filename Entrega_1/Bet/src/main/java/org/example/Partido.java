package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Partido {
    public static int cntmatchs;
    public static List<Partido>ResultP = new ArrayList<>();
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
    @Getter
    @Setter
    private Equipo teamwinner;

    public Partido(int id, Equipo t1, int cntgT1, Equipo t2, int cntgT2){
        this.idMatch=id;
        this.Team1=t1;
        this.cntglsTeam1=cntgT1;
        this.Team2=t2;
        this.cntglsTeam2=cntgT2;
        this.teamwinner=null;
    }
    public static void result(){
        for (Partido matchR : Data.matches) {
            cntmatchs++;
            for (Partido matchP : Data.usuPronostic) {
                if(matchR.getIdMatch()==matchP.getIdMatch()){
                    if(matchP.getCntglsTeam1()>matchP.getCntglsTeam2()){
                        if(matchR.getCntglsTeam1()>matchR.getCntglsTeam2()){
                            matchR.setTeamwinner(matchR.getTeam1());
                            ResultP.add(matchR);
                        }
                    }
                    if(matchP.getCntglsTeam1()<matchP.getCntglsTeam2()){
                        if(matchR.getCntglsTeam1()<matchR.getCntglsTeam2()){
                            matchR.setTeamwinner(matchR.getTeam2());
                            ResultP.add(matchR);
                        }
                    }
                    if(matchP.getCntglsTeam1()==matchP.getCntglsTeam2()){
                        if(matchR.getCntglsTeam1()==matchR.getCntglsTeam2()){
                            Equipo team = new Equipo("Empate");
                            matchR.setTeamwinner(team);
                            ResultP.add(matchR);
                        }
                    }
                }
            }
        }

    }
}
