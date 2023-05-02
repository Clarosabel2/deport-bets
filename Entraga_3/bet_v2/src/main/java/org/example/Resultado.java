package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
public class Resultado {
    @Getter
    @Setter
    private int IDMatch;
    @Getter
    @Setter
    private Equipo winner;
    @Getter
    @Setter
    private Equipo loser;
    @Getter
    @Setter
    private boolean draw;
}
