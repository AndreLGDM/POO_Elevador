package estudantes.entidades;

import professor.entidades.Andar;
import professor.entidades.Elevador;

/**
 * Classe que traz a lógica do algoritmo de uso do elevador.
 * <br>
 * <br>
 * Você pode incluir novos atributos e métodos nessa classe para criar
 * lógicas mais complexas para o gerenciamento do uso do elevador, mas esses
 * <strong>atributos e métodos devem ser todos privados</strong>. O único
 * método público deve ser "agir".
 * 
 * @author Jean Cheiran
 * @version 1.0
 */
public class Ascensorista {

    /**
     * Construtor padrão de Ascensorista.
     * Esse construtor sem parâmetros que será usado pela Arca. Embora a
     * assinatura do construtor não deva ser mudada, o código interno pode
     * ser alterado conforme a necessidade.
     */
    public Ascensorista() {
    }

    /**
     * Executa a lógica de controle do elevador e dos animais.
     * Esse método é o único método de controle invocado durante a simulação
     * de vida da arca.
     * <br>
     * <br>
     * Aqui podem ser feitas todas as verificações sobre os animais do elevador
     * e da fila de animais que estão esperando no andar. A partir desses
     * estados, você pode movimentar animais para dentro e para fora do
     * elevador usando os métodos "desembarcar" e "embarcar" por exemplo.
     * O estado do elevador também é importante para acionar os comandos do
     * elevador como "drenar", "encher", "subir" e "descer".
     * 
     * @param elevador o elevador controlado pelo ascensorista
     * @param andar    o andar no qual o elevador está parado
     */
    public void agir(Elevador elevador, Andar andar) {
        Animal[] animal = new Animal[100];
        Animal[] embarcados = new Animal[100];
        int peso = 0;
        animal = andar.checarFilaParaElevador();
        embarcados = elevador.checarAnimaisNoElevador();
        for (int i = 0; i < andar.consultarTamanhoDaFila(); i++) {
            if (animal[0] instanceof Ave || animal[0] instanceof MamiferoTerrestre
                    || animal[0] instanceof MamiferoVoador || animal[0] instanceof Reptil) {
                for (int j = 0; j < andar.consultarTamanhoDaFila(); j++) {
                    if (animal[j] instanceof Anfibio || animal[j] instanceof Ave
                            || animal[j] instanceof MamiferoTerrestre
                            || animal[j] instanceof MamiferoVoador || animal[j] instanceof Reptil) {
                        animal = elevador.checarAnimaisNoElevador();
                        for (Animal animaisElevador : animal) {
                            peso += animaisElevador.getPeso();
                        }
                        if (elevador.LIMITE_DE_PESO > peso) {
                            elevador.embarcar(animal[j]);
                            andar.tirarDaFila(i);
                        }

                    }
                }
            }
            if (animal[0] instanceof MamiferoAquatico
                    || animal[0] instanceof Peixe || animal[0] instanceof ReptilAquatico) {
                for (int j = 0; j < andar.consultarTamanhoDaFila(); j++) {
                    if (animal[j] instanceof Anfibio || animal[j] instanceof MamiferoAquatico
                            || animal[j] instanceof Peixe || animal[j] instanceof ReptilAquatico) {
                        animal = elevador.checarAnimaisNoElevador();
                        for (Animal animaisElevador : animal) {
                            peso += animaisElevador.getPeso();
                        }
                        if (elevador.LIMITE_DE_PESO > peso) {
                            elevador.embarcar(animal[j]);
                            andar.tirarDaFila(i);
                        }
                    }
                }
            }
        }
    }
}
