package estudantes.entidades;

public class MamiferoVoador extends Mamifero {
    public final int PACIENCIA_MAXIMA = 15;

    public MamiferoVoador(int id, String nome, String especie, int andarDesejado, int peso, int temperatura,
            boolean peludo) {
        super(id, nome, especie, andarDesejado, peso, temperatura, peludo);
    }

    public String voar() {
        return "voando";
    }

    @Override
    public String toString() {
        return "Mamifero Voador: " + "PACIENCIA_MAXIMA: " + PACIENCIA_MAXIMA + " ID: " + getId() + " Nome: " + getNome()
                + " especie: "
                + getEspecie() + " peso: " + getPeso()
                + " Andar desejado: " + getAndarDesejado() + " tempo de espera: " + getTempoDeEspera()
                + " temperatura ideal: "
                + getTemperaturaIdeal() + " peludo: " + isPeludo();
    }

    @Override
    public boolean equals(Object mamiferovoador) {
        if (mamiferovoador == null) {
            return false;
        }
        if (this == mamiferovoador) {
            return true;
        }
        if (!(mamiferovoador instanceof MamiferoVoador)) {
            return false;
        }
        MamiferoVoador outromamifero = (MamiferoVoador) mamiferovoador;
        if (this.getId() == outromamifero.getId()
                && this.getNome() == outromamifero.getNome()
                && this.getEspecie() == outromamifero.getEspecie()
                && this.getPeso() == outromamifero.getPeso()
                && this.getAndarDesejado() == outromamifero.getAndarDesejado()
                && this.getTempoDeEspera() == outromamifero.getTempoDeEspera()
                && this.getTemperaturaIdeal() == outromamifero.getTemperaturaIdeal()
                && this.isPeludo() == outromamifero.isPeludo()) {
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
        hash = hash + (isPeludo() ? 41 : 43);
        return hash;
    }
}
