package estudantes.entidades;

public class Peixe extends Animal {
    public int PACIENCIA_MAXIMA = 60;
    private String corDasEscamas;

    public Peixe(int id, String nome, String especie, int andarDesejado, int peso, int temperatura,
            String cordaescama) {
        super(id, nome, especie, andarDesejado, peso, temperatura);
        this.corDasEscamas = cordaescama;
    }

    public String nadar() {
        return "nadando";
    }

    @Override
    public String toString() {
        return "Peixe: " + "PACIENCIA_MAXIMA: " + PACIENCIA_MAXIMA + " ID: " + getId() + " Nome: " + getNome()
                + " especie: "
                + getEspecie() + " peso: " + getPeso()
                + " Andar desejado: " + getAndarDesejado() + " tempo de espera: " + getTempoDeEspera()
                + " temperatura ideal: "
                + getTemperaturaIdeal() + " cor das escamas: " + corDasEscamas;
    }

    @Override
    public boolean equals(Object peixe) {
        if (peixe == null) {
            return false;
        }
        if (this == peixe) {
            return true;
        }
        if (!(peixe instanceof Peixe)) {
            return false;
        }
        Peixe outropeixe = (Peixe) peixe;
        if (this.getId() == outropeixe.getId()
                && this.getNome() == outropeixe.getNome()
                && this.getEspecie() == outropeixe.getEspecie()
                && this.getPeso() == outropeixe.getPeso()
                && this.getAndarDesejado() == outropeixe.getAndarDesejado()
                && this.getTempoDeEspera() == outropeixe.getTempoDeEspera()
                && this.getTemperaturaIdeal() == outropeixe.getTemperaturaIdeal()
                && this.corDasEscamas == outropeixe.corDasEscamas) {
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
        hash = hash + corDasEscamas.hashCode();
        return hash;
    }

}
