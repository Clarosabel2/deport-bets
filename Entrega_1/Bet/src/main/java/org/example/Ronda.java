package org.example;

import lombok.Getter;
import lombok.Setter;

public class Ronda {
    @Getter
    @Setter
    private int id;
    @Getter
    @Setter
    private String nro;
    @Getter
    @Setter
    private Partido[] matchs;
}
