package poo.entities;

import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private List<Pokemon> reserva;
    private int maxTamanhoReserva;

    public Reserva() {
        reserva = new ArrayList<>();
        maxTamanhoReserva=5;
    }
    public void addReserva(Pokemon pokemon) {
        if (reserva.size()==maxTamanhoReserva) {
            System.out.println("Reserva cheia");
        }
        else reserva.add(pokemon);
    }
    public Pokemon getPokeNaReserva(String pokeName) {
        Pokemon poke = reserva.stream().filter(p -> p.getNome().equals(pokeName)).toList().get(0);
        if (poke==null) {
            System.out.println("Pokémon não está na reserva");
            return null;
        }
        return poke;
    }
    public Pokemon trocaReservaMao(String  antigo, Pokemon novo) {
        Pokemon old = getPokeNaReserva(antigo);
        if (old.getVida()<old.getMaxVida()) System.out.println("Pokémon que sofreu dano não pode ser trocado");
        else {
            reserva.remove(old);
            reserva.add(novo);
            return old;
        }
        return null;
    }
    public Pokemon trocaReservaPrincipal(String antigo, Pokemon novo) {
        Pokemon old = getPokeNaReserva(antigo);
        reserva.remove(old);
        if(novo!=null) reserva.add(novo);
        return old;
    }

    public Pokemon trocaPokemonMorto(String pokemon) {
        maxTamanhoReserva--;
        if (maxTamanhoReserva<0) maxTamanhoReserva=0;
        Pokemon old = getPokeNaReserva(pokemon);
        reserva.remove(old);
        return old;
    }

    public List<Pokemon> getReserva() {
        return reserva;
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();
        reserva.forEach(p -> line.append(p.toString()+ "\n"));
        return line.toString();
    }
}
