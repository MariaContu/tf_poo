package poo.entities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Card {
    private String id;
    private String imageId;
    private String nome;
    private final PropertyChangeSupport pcs;

    public Card(String anId, String anImageId, String nome) {
        id = anId;
        imageId = anImageId;
        this.nome=nome;
        pcs = new PropertyChangeSupport(this);
    }

    public String getId() {
        return id;
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
        return "Card [id=" + id + ", imageId=" + imageId + ", pcs=" + pcs + "]";
    }
}
