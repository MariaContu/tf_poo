//PRONTA

package poo.entities;


import poo.entities.enums.Elementos;
import poo.entities.enums.Raridade;

public abstract class Pokemon extends Card{
    private double vida;
    private int attackPoints;
    private Raridade raridade;
    private Elementos elemento;

    public Pokemon(String imgId, String nome, Raridade raridade, Elementos elemento) {
        super(imgId, nome);
        this.raridade = raridade;
        this.elemento = elemento;
        setVida();
        setAttackPoints();
    }


    public boolean checkDeath() {
        return (vida<=0);
    }


    /**
     * Retorna o dano sofrido
     * confome os multiplicadores de tipo
     */
    public abstract void atacar(Pokemon p);

    public void recebeAtaque(double dano) {
        vida-=dano;
        checkDeath();
    }

    public double getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }



    public int getAttackPoints() {
        return attackPoints;
    }

    public Raridade getRaridade() {
        return raridade;
    }

    public void setRaridade(Raridade raridade) {
        this.raridade = raridade;
    }

    public void attackPointsBuff() {
        attackPoints*=1.2;
    }
    private void setAttackPoints() {
        if (raridade==Raridade.COMUM) attackPoints = 20;
        if (raridade==Raridade.RARO) attackPoints = 25;
        if (raridade==Raridade.LENDARIO) attackPoints = 30;
    }

    public Elementos getElemento() {
        return elemento;
    }

    public int getMaxVida() {
        if (raridade==Raridade.COMUM) return  100;
        if (raridade==Raridade.RARO) return  120;
        return 150;
    }
    private void setVida() {
        vida = getMaxVida();
    }

    @Override
    public String toString() {
        return getNome() + " " + getElemento() + " " + getRaridade();
    }
}