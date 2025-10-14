package ar.edu.unlu.poo.labo2.estrategias;

import ar.edu.unlu.poo.labo2.artefactos.Artefacto;

public class AlquimistaExperto implements EstrategiaDeMejora{
// Su lógica de mejorar es cuidadosa: si el artefacto es de tipo "Poción",
// incrementa su poder en 20 puntos, pero sin que el nivel de poder final supere los 100.
// (Ej: si una poción tiene 85 de poder, su nuevo poder será 100, no 105).

    @Override
    public void mejorar(Artefacto artefacto) {
         if (artefacto.getTipo().equals("Poción")) {
              artefacto.setPoder(artefacto.getNivelDePoder() + 20);
                }
            }
        }


