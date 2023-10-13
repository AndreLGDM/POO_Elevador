package estudantes.entidades;

public class Reptil extends Animal {

    private final int PACIENCIA_MAXIMA = 10;
    private String andar;

    public Reptil(int id, String nome, String especie, int andarDesejado, int peso, int temperatura) {
        super(id, nome, especie, andarDesejado, peso, temperatura);
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
    public boolean equals(Object reptil) {
        if (reptil == null) {
            return false;
        }
        if (this == reptil) {
            return true;
        }
        if (reptil instanceof Reptil) {
            return false;
        }
        Reptil outroReptil = (Reptil) reptil;
        if (this.getId() == outroReptil.getId()
                && this.getNome() == outroReptil.getNome()
                && this.getEspecie() == outroReptil.getEspecie()
                && this.getPeso() == outroReptil.getPeso()
                && this.getAndarDesejado() == outroReptil.getAndarDesejado()
                && this.getTempoDeEspera() == outroReptil.getTempoDeEspera()
                && this.getTemperaturaIdeal() == outroReptil.getTemperaturaIdeal()
                && this.andar.equals(outroReptil.andar)) {
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
