package estudantes.entidades;

public class Aves extends Animal {

    int PACIENCIA_MAXIMA = 30;
    String corDasPenas;

    public Aves(int id, String nome, String especie, int peso, int andarDesejado, int tempoDeEspera,
            int temperaturaIdeal, String corDasPenas, int hash, String toString, boolean equals) {
        super(id, nome, especie, peso, andarDesejado, tempoDeEspera, temperaturaIdeal, hash, toString, equals);
        this.corDasPenas = corDasPenas;
    }

}
