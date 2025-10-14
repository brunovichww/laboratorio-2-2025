package ar.edu.unlu.poo.labo2.estrategias;

import ar.edu.unlu.poo.labo2.artefactos.Artefacto;

// Si el artefacto es de tipo "Pergamino" y su poder es menor a 30, incrementa su poder en 25.
// Si su poder es 30 o más, el encantamiento es inestable y pierde 10 puntos de poder.

public class EscribaArcano implements EstrategiaDeMejora {
    @Override
    public void mejorar(Artefacto artefacto) {
        if (artefacto.getTipo().equals("Pergamino")) {
            if (artefacto.getNivelDePoder() < 30) {
                artefacto.setPoder(artefacto.getNivelDePoder() + 25);
            }else{
                    artefacto.setPoder(artefacto.getNivelDePoder() - 10);
                }
            }
        }
    }
