package poo.entities.TiposPokemons;

import poo.entities.Pokemon;
import poo.entities.enums.Elementos;
import poo.entities.enums.Raridade;

public class PokemonAr extends Pokemon {

    public PokemonAr(String imgId, String nome, Raridade raridade) {
        super(imgId, nome, raridade, Elementos.AR);
    }

    /*
     agua > pedra
agua > fogo
agua < planta
agua < ar
fogo > pedra
fogo < agua
fogo > planta
fogo < ar
planta > agua
planta < fogo
planta < pedra
planta > ar
ar < pedra
ar > agua
ar > fogo
ar < planta
pedra > planta
pedra < fogo
pedra > ar
pedra < agua
     */

    @Override
    public void atacar(Pokemon p){
        if(p.getElemento()==Elementos.PEDRA|| p.getElemento()==Elementos.PLANTA) p.recebeAtaque(this.getAttackPoints()*0.8);
        else p.recebeAtaque(this.getAttackPoints()*1.2);
    }
}

