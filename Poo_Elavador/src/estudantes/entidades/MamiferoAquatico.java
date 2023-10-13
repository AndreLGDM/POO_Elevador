package estudantes.entidades;

public class MamiferoAquatico extends Mamifero {

    private int PACIENCIA_MAXIMA = 40;
    private String nadar;

    public MamiferoAquatico(int id, String nome, String especie, int andarDesejado, int peso, int temperatura,
            boolean peludo) {
        super(id, nome, especie, andarDesejado, peso, temperatura, peludo);
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
    public boolean equals(Object mamiferoaquatico) {
        if (mamiferoaquatico == null) {
            return false;
        }
        if (this == mamiferoaquatico) {
            return true;
        }
        if (mamiferoaquatico instanceof MamiferoAquatico) {
            return false;
        }
        MamiferoAquatico outromamifero = (MamiferoAquatico) mamiferoaquatico;
        if (this.getId() == outromamifero.getId()
                && this.getNome() == outromamifero.getNome()
                && this.getEspecie() == outromamifero.getEspecie()
                && this.getPeso() == outromamifero.getPeso()
                && this.getAndarDesejado() == outromamifero.getAndarDesejado()
                && this.getTempoDeEspera() == outromamifero.getTempoDeEspera()
                && this.getTemperaturaIdeal() == outromamifero.getTemperaturaIdeal()
                && this.nadar.equals(outromamifero.nadar)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = hash * nadar.hashCode();
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
