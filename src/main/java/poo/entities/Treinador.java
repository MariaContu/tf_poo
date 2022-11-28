package poo.entities;


public class Treinador extends Card {
    
    private String descricao;
    private int tipo;

    public Treinador(String imgId, String nome, int tipo) {
        super(imgId, nome);
        setDescricao();
        this.tipo=tipo;
    }
    
    public String getDescricao()    {
        return descricao;
    }
    
    public int getTipo()    {
        return tipo;
    }

    public void setDescricao() {
        if (tipo==1) this.descricao = "Recupera o HP completo do Pokemon";
        if (tipo==2) this.descricao = "Aumenta em 25% o dano do Pokemon";
        if (tipo==3) this.descricao = "Recupera o último pokemon morto";
        if (tipo==4) this.descricao = "Evolui o pokemon";
    }

    public void aplicaBuff(Jogador jogador) {
        Pokemon pokemon = jogador.getPokemonAtivo();
        if (tipo==1) pokemon.setVida(pokemon.getMaxVida());
        if (tipo==2) pokemon.attackPointsBuff();
        if (tipo==3) jogador.ressucitaPokemon();
        if (tipo==4) this.descricao = "Evolui o pokemon";
    }
}
