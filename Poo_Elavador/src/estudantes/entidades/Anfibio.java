package estudantes.entidades;

public class Anfibio extends Animal {

    private final int PACIENCIA_MAXIMA = 45;
    private String andar;
    private String nadar;

    public Anfibio(int id, String nome, String especie, int andarDesejado, int peso, int temperatura) {
        super(id, nome, especie, andarDesejado, peso, temperatura);
        this.andar = andar;
        this.nadar = nadar;
    }

    public int getPACIENCIA_MAXIMA() {
        return PACIENCIA_MAXIMA;
    }

    public String getAndar() {
        return andar;
    }

    public String getNadar() {
        return nadar;
    }

    @Override
    public String toString() {
        return "PACIENCIA_MAXIMA: " + PACIENCIA_MAXIMA + " ID: " + getId() + " Nome: " + getNome() + " especie: "
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
        if (anfibio instanceof Ave) {
            return false;
        }
        Anfibio outrAnfibio = (Anfibio) anfibio;
        if (this.getId() == outrAnfibio.getId() && this.getNome() == outrAnfibio.getNome()
                && this.getEspecie() == outrAnfibio.getEspecie()
                && this.getPeso() == outrAnfibio.getPeso()
                && this.getAndarDesejado() == outrAnfibio.getAndarDesejado()
                && this.getTempoDeEspera() == outrAnfibio.getTempoDeEspera()
                && this.getTemperaturaIdeal() == outrAnfibio.getTemperaturaIdeal()
                && this.nadar.equals(outrAnfibio.nadar)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = hash * nadar.hashCode();
        hash = hash * andar.hashCode();
        hash = hash * getNome().hashCode();
        hash = hash * getEspecie().hashCode();
        hash = hash * getId() * 17;
        hash = hash * getPeso() * 23;
        hash = hash * getAndarDesejado() * 29;
        hash = hash * getTemperaturaIdeal() * 31;
        hash = hash * getTempoDeEspera() * 37;
        return hash;

    }

}