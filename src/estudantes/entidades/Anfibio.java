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
        return "ID: " + id + " Nome: " + nome + " especie: " + especie + " paciencia: " + paciencia + " peso: " + peso
                + " Andar desejado: " + andarDesejado + " tempo de espera: " + tempoDeEspera + " temperatura ideal: "
                + temperaturaIdeal;
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
        if (this.id == outrAnfibio.id && this.nome == outrAnfibio.nome && this.especie == outrAnfibio.especie
                && this.paciencia == outrAnfibio.paciencia && this.peso == outrAnfibio.peso
                && this.andarDesejado == outrAnfibio.andarDesejado && this.tempoDeEspera == outrAnfibio.tempoDeEspera
                && this.temperaturaIdeal == outrAnfibio.temperaturaIdeal && this.nadar.equals(outrAnfibio.nadar)) {
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
