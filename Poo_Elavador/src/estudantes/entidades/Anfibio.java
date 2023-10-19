package estudantes.entidades;

public class Anfibio extends Animal {

    public final int PACIENCIA_MAXIMA = 45;

    public Anfibio(int id, String nome, String especie, int andarDesejado, int peso, int temperatura) {
        super(id, nome, especie, andarDesejado, peso, temperatura);
    }

    public int getPACIENCIA_MAXIMA() {
        return PACIENCIA_MAXIMA;
    }

    public String andar() {
        return "andando";
    }

    public String nadar() {
        return "nadando";
    }

    @Override
    public String toString() {
        return "Anfibio: " + "PACIENCIA_MAXIMA: " + PACIENCIA_MAXIMA + " ID: " + getId() + " Nome: " + getNome()
                + " especie: "
                + getEspecie() + " peso: " + getPeso()
                + " Andar desejado: " + getAndarDesejado() + " tempo de espera: " + getTempoDeEspera()
                + " temperatura ideal: "
                + getTemperaturaIdeal();
    }

    @Override
    public boolean equals(Object anfibio) {
        if (anfibio == null) {
            return false;
        }
        if (this == anfibio) {
            return true;
        }
        if (!(anfibio instanceof Anfibio)) {
            return false;
        }
        Anfibio outrAnfibio = (Anfibio) anfibio;
        if (this.getId() == outrAnfibio.getId() && this.getNome() == outrAnfibio.getNome()
                && this.getEspecie() == outrAnfibio.getEspecie()
                && this.getPeso() == outrAnfibio.getPeso()
                && this.getAndarDesejado() == outrAnfibio.getAndarDesejado()
                && this.getTempoDeEspera() == outrAnfibio.getTempoDeEspera()
                && this.getTemperaturaIdeal() == outrAnfibio.getTemperaturaIdeal()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = hash + getNome().hashCode();
        hash = hash + getEspecie().hashCode();
        hash = hash + getId() * 17;
        hash = hash + getPeso() * 23;
        hash = hash + getAndarDesejado() * 29;
        hash = hash + getTemperaturaIdeal() * 31;
        hash = hash + getTempoDeEspera() * 37;
        return hash;

    }

}