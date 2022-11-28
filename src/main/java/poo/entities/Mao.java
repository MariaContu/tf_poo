package poo.entities;

import java.util.ArrayList;
import java.util.List;

//classe responsavel por controlar a "mao" de cartas do jogador
public class Mao {
    private List<Card> mao;

    public Mao() {
        mao = new ArrayList<>();

    }

    public void addCartaNaMao(Card carta) {mao.add(carta);}

    public List<Card> getMao() {
        return mao;
    }


    public Card getCartaDaMao(String nome)    {
        Card carta = mao.stream().filter(p -> p.getNome().equals(nome)).toList().get(0);
        mao.remove(carta);
        return carta;
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();
        mao.forEach(p -> line.append(p.toString()+ "\n"));
        return line.toString();
    }
}
