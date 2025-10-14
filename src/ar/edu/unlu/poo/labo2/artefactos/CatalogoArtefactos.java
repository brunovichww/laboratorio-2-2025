package ar.edu.unlu.poo.labo2.artefactos;

//import java.util.HashSet; Comentamos porque importamos util.*
//import java.util.Set;
import ar.edu.unlu.poo.labo2.estrategias.EstrategiaDeMejora;

import java.util.*;

import static java.util.Comparator.comparingDouble;


public class CatalogoArtefactos {
    private Set<Artefacto> colecionArtefactos = new HashSet<>();
    private Map<String, Integer> mapaArtefactos = new HashMap<>();
    private int contadorPocion = 0;
    private int contadorPergamino = 0;
    private int contadorAmuleto = 0;
    private int  contadorVarita = 0;

    public int getContadorPocion() {
        return contadorPocion;
    }

    public void setContadorPocion(int contadorPocion) {
        this.contadorPocion = contadorPocion;
    }

    public int getContadorPergamino() {
        return contadorPergamino;
    }

    public void setContadorPergamino(int contadorPergamino) {
        this.contadorPergamino = contadorPergamino;
    }

    public int getContadorAmuleto() {
        return contadorAmuleto;
    }

    public void setContadorAmuleto(int contadorAmuleto) {
        this.contadorAmuleto = contadorAmuleto;
    }

    public int getContadorVarita() {
        return contadorVarita;
    }

    public void setContadorVarita(int contadorVarita) {
        this.contadorVarita = contadorVarita;
    }

    private EstrategiaDeMejora estrategia;

    public CatalogoArtefactos() {

    }

    public CatalogoArtefactos(EstrategiaDeMejora estrategia) {
        this.setEstrategia(estrategia);
    }

    public EstrategiaDeMejora getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(EstrategiaDeMejora estrategia) {
        this.estrategia = estrategia;
    }

    public void aplicarMejoras() {
        for (Artefacto a : colecionArtefactos) {
            this.getEstrategia().mejorar(a);
        }
    }

    public void agregarArtefacto(Artefacto nuevoArtefacto){
       //agregar if para avisar si elemento repetido
        colecionArtefactos.add(nuevoArtefacto);
        switch (nuevoArtefacto.getTipo()){
            case "Poción":
            {this.setContadorPocion(this.getContadorPocion() + 1);
                mapaArtefactos.put(nuevoArtefacto.getTipo(), this.getContadorPocion());
            break;}
            case "Pergamino": mapaArtefactos.put(nuevoArtefacto.getTipo(), contadorPergamino++);
                break;
            case "Amuleto":
            {this.setContadorAmuleto(this.getContadorAmuleto() + 1);
                mapaArtefactos.put(nuevoArtefacto.getTipo(),  this.getContadorAmuleto());
                break;}
            case "Varita":
            {this.setContadorVarita(this.getContadorVarita() + 1);
                mapaArtefactos.put(nuevoArtefacto.getTipo(), this.getContadorVarita());}
        }
    }

    public Set obtenerArtefactosUnicos(){
        return this.colecionArtefactos;
    }

    public List buscarArtefactosPorTipo(String tipo) {
        List<Artefacto> listaPorTipo = new ArrayList<>();
        for (Artefacto a : colecionArtefactos) {
            if (a.getTipo().equals(tipo)) {
                listaPorTipo.add(a);
            }
        }
        listaPorTipo.sort(comparingDouble(Artefacto::getNivelDePoder).reversed());
        //leido de stackoverflow https://stackoverflow.com/questions/16252269/how-to-sort-a-list-arraylist
        return listaPorTipo;
    }

    public Map<String, Integer> contarArtefactosPorTipo(){
        return mapaArtefactos;
    }
    public Artefacto obtenerArtefactoMasPoderoso(){
        double maxPoder = 0;
        Artefacto masPoderoso = null;
        for (Artefacto a : colecionArtefactos) {
            if (a.getNivelDePoder()>maxPoder) {
                masPoderoso = a;
                maxPoder = a.getNivelDePoder();
            }
        }
        return masPoderoso;
    }

}
