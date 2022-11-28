package poo.entities;

import java.util.ArrayList;
import java.util.List;

//classe destinada a controlar a pilha de pokemons mortos
public class Pilha {
    private List<Pokemon> lista;

    public Pilha() {
        lista = new ArrayList<>();
    }

    public List<Pokemon> getLista() {
        return lista;
    }

    public void addPilha(Pokemon p) {
        lista.add(p);
    }

    //retira e retorna pokemon retirado
    public Pokemon retiraPilha() {
        Pokemon pokemonRetirado = lista.get(lista.size()-1);
        lista.remove(lista.size()-1);
        return pokemonRetirado;
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();
        lista.forEach(p -> line.append(p.toString()+ "\n"));
        return line.toString();
    }

}
