//VER METODOS SE SAO UTEIS
package poo.entities;

import poo.entities.TiposPokemons.PokemonAgua;
import poo.entities.TiposPokemons.PokemonAr;
import poo.entities.TiposPokemons.PokemonFogo;
import poo.entities.TiposPokemons.PokemonPedra;
import poo.entities.TiposPokemons.PokemonPlanta;
import poo.entities.enums.Raridade;
import poo.entities.enums.Elementos;

import java.util.*;

public class CardDeck {
    public static final int NCARDS = 34;
    private List<Card> baralho = new ArrayList<>(NCARDS);
    private List<GameListener> observers;

    public CardDeck() {
        Random r = new Random();
        observers = new LinkedList<>();
        criaBaralho();
    }

    public List<Card> getBaralho() {
        return Collections.unmodifiableList(baralho);
    }


    public void addGameListener(GameListener listener) {
        observers.add(listener);
    }

    //cria e embaralha baralho completo
    public void criaBaralho()   {
        //todos os pokemons tipo agua: 5comum 3raro 1lendario
        baralho.add(new PokemonAgua("1", "Popplio",Raridade.COMUM));
        baralho.add(new PokemonAgua("2", "Magikarp",Raridade.COMUM));
        baralho.add(new PokemonAgua("3", "Tapu Fini",Raridade.COMUM));
        baralho.add(new PokemonAgua("4", "Blastoise",Raridade.RARO));
        baralho.add(new PokemonAgua("5", "Glaceon",Raridade.RARO));
        baralho.add(new PokemonAgua("6","Vaporeon", Raridade.LENDARIO));

        //todos os pokemons tipo ar: 5comum 3raro 1lendario
        baralho.add(new PokemonAr("7", "Pidgey",Raridade.COMUM));
        baralho.add(new PokemonAr("8","Butterfree", Raridade.COMUM));
        baralho.add(new PokemonAr("9", "Doduo",Raridade.COMUM));
        baralho.add(new PokemonAr("10", "Aerodactyl",Raridade.RARO));
        baralho.add(new PokemonAr("11","Fearow",Raridade.RARO));
        baralho.add(new PokemonAr("12", "Lugia",Raridade.LENDARIO));

        //todos os pokemons tipo fogo: 5comum 3raro 1lendario
        baralho.add(new PokemonFogo("13", "Turtonator",Raridade.COMUM));
        baralho.add(new PokemonFogo("14","Salandit", Raridade.COMUM));
        baralho.add(new PokemonFogo("15","Victini", Raridade.COMUM));
        baralho.add(new PokemonFogo("16", "Marowak",Raridade.RARO));
        baralho.add(new PokemonFogo("17", "Charizard",Raridade.RARO));
        baralho.add(new PokemonFogo("18", "Blaziken",Raridade.LENDARIO));

        //todos os pokemons tipo pedra: 5comum 3raro 1lendario
        baralho.add(new PokemonPedra("19", "Nosepass",Raridade.COMUM));
        baralho.add(new PokemonPedra("20", "Rhyhorn",Raridade.COMUM));
        baralho.add(new PokemonPedra("21", "Sudowoodo",Raridade.COMUM));
        baralho.add(new PokemonPedra("22", "Golem",Raridade.RARO));
        baralho.add(new PokemonPedra("23", "Graveler",Raridade.RARO));
        baralho.add(new PokemonPedra("24", "Melmetal",Raridade.LENDARIO));

        //todos os pokemons tipo planta: 5comum 3raro 1lendario
        baralho.add(new PokemonPlanta("25", "Wimpod", Raridade.COMUM));
        baralho.add(new PokemonPlanta("26", "Pheromosa",Raridade.COMUM));
        baralho.add(new PokemonPlanta("27", "Scyther",Raridade.COMUM));
        baralho.add(new PokemonPlanta("28", "Lurantis",Raridade.RARO));
        baralho.add(new PokemonPlanta("29", "Tsareena",Raridade.RARO));
        baralho.add(new PokemonPlanta("30", "Orbeetle",Raridade.LENDARIO));

        //cartas treinadores
        baralho.add(new Treinador("31","Spark",1));
        baralho.add(new Treinador("32","Professor Nogueira",2));
        baralho.add(new Treinador("33","Professora Bruna", 3));
        baralho.add(new Treinador("34","Cintia",4));

        //embaralhar cartas
        Collections.shuffle(baralho);
    }

}
