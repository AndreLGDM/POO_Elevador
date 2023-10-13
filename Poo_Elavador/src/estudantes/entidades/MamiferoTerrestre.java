package estudantes.entidades;

public class MamiferoTerrestre extends Mamifero {
    private final int PACIENCIA_MAXIMA = 35;
    private String andar;

    public MamiferoTerrestre(int id, String nome, String especie, int andarDesejado, int peso, int temperatura,
            boolean peludo) {
        super(id, nome, especie, andarDesejado, peso, temperatura, peludo);
        this.andar = andar;
    }

    public String getAndar() {
        return andar;
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
    public boolean equals(Object mamiferoterrestre) {
        if (mamiferoterrestre == null) {
            return false;
        }
        if (this == mamiferoterrestre) {
            return true;
        }
        if (mamiferoterrestre instanceof MamiferoTerrestre) {
            return false;
        }
        MamiferoTerrestre outromamifero = (MamiferoTerrestre) mamiferoterrestre;
        if (this.getId() == outromamifero.getId()
                && this.getNome() == outromamifero.getNome()
                && this.getEspecie() == outromamifero.getEspecie()
                && this.getPeso() == outromamifero.getPeso()
                && this.getAndarDesejado() == outromamifero.getAndarDesejado()
                && this.getTempoDeEspera() == outromamifero.getTempoDeEspera()
                && this.getTemperaturaIdeal() == outromamifero.getTemperaturaIdeal()
                && this.andar.equals(outromamifero.andar)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 13;
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
