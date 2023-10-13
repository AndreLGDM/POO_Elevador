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
        return "ID: " + id + " Nome: " + nome + " especie: " + especie + " paciencia: " + paciencia + " peso: " + peso
                + " Andar desejado: " + andarDesejado + " tempo de espera: " + tempoDeEspera + " temperatura ideal: "
                + temperaturaIdeal + " andar: " + andar;
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
        if (this.id == outroReptil.id && this.nome == outroReptil.nome && this.especie == outroReptil.especie
                && this.paciencia == outroReptil.paciencia && this.peso == outroReptil.peso
                && this.andarDesejado == outroReptil.andarDesejado && this.tempoDeEspera == outroReptil.tempoDeEspera
                && this.temperaturaIdeal == outroReptil.temperaturaIdeal && this.andar.equals(outroReptil.andar)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 13;
        hash = hash * andar.hashCode();
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
