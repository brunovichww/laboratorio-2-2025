package ar.edu.unlu.poo.labo2.estrategias;

import ar.edu.unlu.poo.labo2.artefactos.Artefacto;

// si el artefacto es de tipo "Amuleto", y su poder es menor a 50, duplica su poder. Si es mayor o igual a 50, lo incrementa en un 25%.

public class JoyeroElfico implements EstrategiaDeMejora{
    @Override
    public void mejorar(Artefacto artefacto) {
        if (artefacto.getTipo().equals("Amuleto")) {
            if (artefacto.getNivelDePoder() < 50) {
                artefacto.setPoder(artefacto.getNivelDePoder() * 2);
            } else {
                artefacto.setPoder(artefacto.getNivelDePoder() * 1.25);
            }
        }
    }
}
