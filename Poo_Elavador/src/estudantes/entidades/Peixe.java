package estudantes.entidades;

public class Peixe extends Animal {
    private int PACIENCIA_MAXIMA = 60;
    private String corDasEscamas;

    public Peixe(int id, String nome, String especie, int andarDesejado, int peso, int temperatura,
            String cordaescama) {
        super(id, nome, especie, andarDesejado, peso, temperatura);
        this.corDasEscamas = corDasEscamas;
    }

    public String getCorDasEscamas() {
        return corDasEscamas;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Nome: " + nome + " especie: " + especie + " paciencia: " + paciencia + " peso: " + peso
                + " Andar desejado: " + andarDesejado + " tempo de espera: " + tempoDeEspera + " temperatura ideal: "
                + temperaturaIdeal + "cor das escamas: " + corDasEscamas;
    }

    @Override
    public boolean equals(Object peixe) {
        if (peixe == null) {
            return false;
        }
        if (this == peixe) {
            return true;
        }
        if (peixe instanceof Peixe) {
            return false;
        }
        Peixe outropeixe = (Peixe) peixe;
        if (this.id == outropeixe.id && this.nome == outropeixe.nome && this.especie == outropeixe.especie
                && this.paciencia == outropeixe.paciencia && this.peso == outropeixe.peso
                && this.andarDesejado == outropeixe.andarDesejado
                && this.tempoDeEspera == outropeixe.tempoDeEspera
                && this.temperaturaIdeal == outropeixe.temperaturaIdeal
                && this.corDasEscamas.equals(outropeixe.corDasEscamas)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = hash * corDasEscamas.hashCode();
        hash = hash * nome.hashCode();
        hash = hash * especie.hashCode();
        hash = hash * id * 17;
        hash = hash * paciencia * 19;
        hash = hash * peso * 23;
        hash = hash * andarDesejado * 29;
        hash = hash * temperaturaIdeal * 31;
        hash = hash * tempoDeEspera * 37;
        return hash;
    }

}
