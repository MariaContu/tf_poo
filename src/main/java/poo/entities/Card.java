//PRONTA

package poo.entities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Card {
    private String imageId;
    private String nome;
    private final PropertyChangeSupport pcs;

    public Card(String anImageId, String nome) {
        imageId = anImageId;
        this.nome=nome;
        pcs = new PropertyChangeSupport(this);
    }

    public String getImageId() {
        return imageId;
    }

    public String getNome() {
        return nome;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return "Card [nome=" + nome + ", imageId=" + imageId + ", pcs=" + pcs + "]";
    }
}
