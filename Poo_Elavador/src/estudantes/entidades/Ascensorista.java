package estudantes.entidades;

import java.util.Arrays;

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

    private int andarAnterior;

    /**
     * Construtor padrão de Ascensorista.
     * Esse construtor sem parâmetros que será usado pela Arca. Embora a
     * assinatura do construtor não deva ser mudada, o código interno pode
     * ser alterado conforme a necessidade.
     */
    public Ascensorista() {
        andarAnterior = 0;
    }

    private boolean verificarTipoTerrestre(Animal[] vetor) {
        Class<?>[] classes_alvo = { Ave.class, AveVoadora.class, MamiferoTerrestre.class, MamiferoVoador.class,
                Reptil.class };

        if (vetor.length > 0) {
            Animal animal = vetor[0];
            for (Class<?> classe : classes_alvo) {
                if (classe.isInstance(animal))
                    return true;
            }
        }
        return false;
    }

    private boolean VerificarElevadorVazio(Elevador elevador) {
        Animal[] embarcados = elevador.checarAnimaisNoElevador();
        if (embarcados.length == 0) {
            return true;
        }
        return false;
    }

    private boolean verificarTemperatura(Animal animal, Elevador elevador) {
        if ((animal.getTemperaturaIdeal() + 15) >= elevador.getTemperaturaDoArCondicionado()
                && (animal.getTemperaturaIdeal() - 15) <= elevador.getTemperaturaDoArCondicionado()) {
            return true;
        }
        return false;
    }

    /**
     * Percorre um vetor de Animal embarcados e verifica se o peso excede o limite
     * de peso do elevador
     */
    private boolean verificarPeso(Elevador elevador, Animal animal) {
        int peso = 0;
        Animal[] animaisElevador = elevador.checarAnimaisNoElevador();
        for (Animal animaisNoElevador : animaisElevador) {
            peso += animaisNoElevador.getPeso();
        }
        if (peso + animal.getPeso() < elevador.LIMITE_DE_PESO) {
            return true;
        }
        return false;
    }

    /**
     * Percorre um vetor de Animal embarcados e faz a media de temperatura ideal.
     * Muda a temperatura do elevador para a mais adequada.
     * <br>
     * !!!Cuidado, se algum animal morrer, o motivo pode estar aqui!!!
     */
    private void ajustarTemperaturaElevador(Elevador elevador, Andar andar) {
        Animal[] embarcados = elevador.checarAnimaisNoElevador();
        Animal[] naoEmbarcados = andar.checarFilaParaElevador();
        int temperaturaIdealMenor = Integer.MAX_VALUE;
        int temperaturaIdealMaior = Integer.MIN_VALUE;
        int mediaTemperatura = 0;

        for (Animal animaisNoElevador : embarcados) {
            int temperaturaIdeal = animaisNoElevador.getTemperaturaIdeal();
            temperaturaIdealMenor = Math.min(temperaturaIdealMenor, temperaturaIdeal);
            temperaturaIdealMaior = Math.max(temperaturaIdealMaior, temperaturaIdeal);
        }
        if (embarcados.length > 0) {
            mediaTemperatura = (temperaturaIdealMenor + temperaturaIdealMaior) / 2;
            elevador.setTemperaturaDoArCondicionado(mediaTemperatura);
        } else {
            if (naoEmbarcados.length > 0) {
                Animal animalAndar = naoEmbarcados[0];
                if (animalAndar.getTemperaturaIdeal() > 40) {
                    elevador.setTemperaturaDoArCondicionado(40);
                } else if (animalAndar.getTemperaturaIdeal() < 0) {
                    elevador.setTemperaturaDoArCondicionado(0);
                } else {
                    elevador.setTemperaturaDoArCondicionado(animalAndar.getTemperaturaIdeal());
                }
            }
        }
    }

    private void modificarAndar(Elevador elevador) {
        andarAnterior = elevador.getAndar();
    }

    private boolean verificaSubindo(Elevador elevador) {
        int andarAtual = elevador.getAndar();
        if (andarAtual > andarAnterior || andarAtual == 0) {
            return true;
        }
        return false;
    }

    private boolean verificarIntencao(Elevador elevador, Animal animal) {
        if (verificaSubindo(elevador)) {
            if (animal.getAndarDesejado() >= elevador.getAndar()) {
                return true;
            }
            return false;

        } else {
            if (animal.getAndarDesejado() <= elevador.getAndar()) {
                return true;
            }
            return false;
        }
    }

    private Animal[] verificarPaciencia(Animal[] vetor) {
        Animal[] lista = vetor.clone(); // Crie uma cópia do vetor original para não modificar o original
        Animal[] listaOrganizada = new Animal[lista.length];

        for (int i = 0; i < lista.length; i++) {
            listaOrganizada[i] = lista[i];
        }

        for (int i = 0; i < lista.length - 1; i++) {
            for (int j = 0; j < lista.length - i - 1; j++) {
                if ((listaOrganizada[j].PACIENCIA_MAXIMA
                        - listaOrganizada[j].getTempoDeEspera()) < (listaOrganizada[j + 1].PACIENCIA_MAXIMA
                                - listaOrganizada[j + 1].getTempoDeEspera())) {
                    Animal temp = listaOrganizada[j];
                    listaOrganizada[j] = listaOrganizada[j + 1];
                    listaOrganizada[j + 1] = temp;
                }
            }
        }

        return listaOrganizada;
    }

    private void embarcarTerrestre(Elevador elevador, Andar andar) {

        Animal[] vetorAnimais = verificarPaciencia(andar.checarFilaParaElevador());
        Animal[] animaisSelecionados = new Animal[vetorAnimais.length];
        Animal animalSelecionado = null;
        int cont = 0;

        Class<?>[] classes_alvo = { Ave.class, AveVoadora.class, MamiferoTerrestre.class, MamiferoVoador.class,
                Reptil.class, Anfibio.class, ReptilAquatico.class };
        if (vetorAnimais.length > 0) {
            for (Animal animalFila : vetorAnimais) {
                for (Class<?> classe : classes_alvo) {
                    if (classe.isInstance(animalFila)) {
                        animaisSelecionados[cont] = animalFila;
                        animalSelecionado = (Animal) animaisSelecionados[cont];
                        elevador.drenar();
                        if (verificarTemperatura(animalSelecionado, elevador)
                                && verificarPeso(elevador, animalSelecionado)
                                && verificarIntencao(elevador, animalSelecionado)) {
                            elevador.embarcar(animalSelecionado);
                            andar.tirarDaFila(animalSelecionado);
                        }
                    }
                }
                cont++;
            }
            modificarAndar(elevador);
        }
    }

    private void embarcarAquatico(Elevador elevador, Andar andar) {
        Animal[] vetorAnimais = andar.checarFilaParaElevador();
        Animal[] animaisSelecionados = new Animal[vetorAnimais.length];
        Animal animalSelecionado = null;
        int cont = 0;

        Class<?>[] classes_alvo = { MamiferoAquatico.class, Peixe.class, ReptilAquatico.class, Anfibio.class };
        if (vetorAnimais.length > 0) {
            for (Animal animalFila : vetorAnimais) {
                for (Class<?> classe : classes_alvo) {
                    if (classe.isInstance(animalFila)) {
                        animaisSelecionados[cont] = animalFila;
                        animalSelecionado = (Animal) animaisSelecionados[cont];
                        elevador.encher();
                        if (verificarTemperatura(animalSelecionado, elevador)
                                && (verificarPeso(elevador, animalSelecionado))
                                && verificarIntencao(elevador, animalSelecionado)) {
                            elevador.embarcar(animalSelecionado);
                            andar.tirarDaFila(animalSelecionado);
                        }
                    }
                }
            }
            modificarAndar(elevador);
        }
    }

    private void desembarcarAnimais(Elevador elevador, Andar andar) {
        Animal[] vetorAnimais = elevador.checarAnimaisNoElevador();
        for (Animal animalFila : vetorAnimais) {
            if (animalFila.getAndarDesejado() == andar.getAndar()) {
                elevador.desembarcar(animalFila, andar);
            }
        }
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

        if (elevador.getAndar() == 0) {
            desembarcarAnimais(elevador, andar);
            if (verificaSubindo(elevador)) {
                if (verificarTipoTerrestre(andar.checarFilaParaElevador())) {
                    embarcarTerrestre(elevador, andar);
                    desembarcarAnimais(elevador, andar);
                    ajustarTemperaturaElevador(elevador, andar);
                    elevador.subir();
                } else {
                    elevador.encher();
                    embarcarAquatico(elevador, andar);
                    desembarcarAnimais(elevador, andar);
                    ajustarTemperaturaElevador(elevador, andar);
                    elevador.subir();
                }
            }

        } else if (elevador.getAndar() > 0 && elevador.getAndar() < 4) {
            desembarcarAnimais(elevador, andar);
            if (VerificarElevadorVazio(elevador)) {
                if (verificaSubindo(elevador)) {
                    if (verificarTipoTerrestre(andar.checarFilaParaElevador())) {
                        embarcarTerrestre(elevador, andar);
                        desembarcarAnimais(elevador, andar);
                        ajustarTemperaturaElevador(elevador, andar);
                        elevador.subir();
                    } else {
                        elevador.encher();
                        embarcarAquatico(elevador, andar);
                        desembarcarAnimais(elevador, andar);
                        ajustarTemperaturaElevador(elevador, andar);
                        elevador.subir();
                    }
                } else {
                    if (verificarTipoTerrestre(andar.checarFilaParaElevador())) {
                        embarcarTerrestre(elevador, andar);
                        desembarcarAnimais(elevador, andar);
                        ajustarTemperaturaElevador(elevador, andar);
                        elevador.descer();
                    } else {
                        elevador.encher();
                        embarcarAquatico(elevador, andar);
                        desembarcarAnimais(elevador, andar);
                        ajustarTemperaturaElevador(elevador, andar);
                        elevador.descer();
                    }
                }
            } else {
                if (verificaSubindo(elevador)) {
                    if (!elevador.isCheioDeAgua()) {
                        embarcarTerrestre(elevador, andar);
                        desembarcarAnimais(elevador, andar);
                        ajustarTemperaturaElevador(elevador, andar);
                        elevador.subir();
                    } else {
                        embarcarAquatico(elevador, andar);
                        desembarcarAnimais(elevador, andar);
                        ajustarTemperaturaElevador(elevador, andar);
                        elevador.subir();
                    }
                } else {
                    if (!elevador.isCheioDeAgua()) {
                        embarcarTerrestre(elevador, andar);
                        desembarcarAnimais(elevador, andar);
                        ajustarTemperaturaElevador(elevador, andar);
                        elevador.descer();
                    } else {
                        embarcarAquatico(elevador, andar);
                        desembarcarAnimais(elevador, andar);
                        ajustarTemperaturaElevador(elevador, andar);
                        elevador.descer();
                    }
                }
            }
        }

        if (elevador.getAndar() == 4) {
            modificarAndar(elevador);
            desembarcarAnimais(elevador, andar);
            if (!verificaSubindo(elevador)) {
                if (verificarTipoTerrestre(andar.checarFilaParaElevador())) {
                    embarcarTerrestre(elevador, andar);
                    desembarcarAnimais(elevador, andar);
                    ajustarTemperaturaElevador(elevador, andar);
                    elevador.descer();
                } else {
                    elevador.encher();
                    embarcarAquatico(elevador, andar);
                    desembarcarAnimais(elevador, andar);
                    ajustarTemperaturaElevador(elevador, andar);
                    elevador.descer();
                }
            }
        }
    }
}

/*
 * Animal[] animaisNaFila = new Animal[100];
 * Animal[] embarcados = new Animal[100];
 * int peso = 0;
 * animaisNaFila = andar.checarFilaParaElevador();
 * embarcados = elevador.checarAnimaisNoElevador();
 * if (elevador.getAndar() == 0 && andar.consultarTamanhoDaFila() > 0) {
 * for (int i = 0; i < andar.consultarTamanhoDaFila(); i++) {
 * System.out.println(animaisNaFila[i]);
 * if (verificarTipoTerrestre(animaisNaFila)) {
 * for (int j = 0; j < andar.consultarTamanhoDaFila(); j++) {
 * if (animaisNaFila[j] instanceof Anfibio || animaisNaFila[j] instanceof Ave
 * || animaisNaFila[j] instanceof MamiferoTerrestre
 * || animaisNaFila[j] instanceof MamiferoVoador || animaisNaFila[j] instanceof
 * Reptil) {
 * embarcados = elevador.checarAnimaisNoElevador();
 * for (Animal animaisElevador : embarcados) {
 * peso += animaisElevador.getPeso();
 * }
 * if (elevador.LIMITE_DE_PESO > peso) {
 * if (embarcados.equals(null) && (animaisNaFila[j].getTemperaturaIdeal() + 15)
 * < elevador
 * .getTemperaturaDoArCondicionado()
 * || (animaisNaFila[j].getTemperaturaIdeal() - 15) > elevador
 * .getTemperaturaDoArCondicionado()) {
 * elevador.setTemperaturaDoArCondicionado(animaisNaFila[j].getTemperaturaIdeal(
 * ));
 * elevador.embarcar(animaisNaFila[j]);
 * andar.tirarDaFila(j);
 * elevador.subir();
 * } else if (!embarcados.equals(null)
 * && (animaisNaFila[j].getTemperaturaIdeal() + 15) < elevador
 * .getTemperaturaDoArCondicionado()
 * || (animaisNaFila[j].getTemperaturaIdeal() - 15) > elevador
 * .getTemperaturaDoArCondicionado()) {
 * andar.chamarProximoDaFila();
 * }
 * }
 * }
 * }
 * }
 * if (animaisNaFila[0] instanceof MamiferoAquatico
 * || animaisNaFila[0] instanceof Peixe || animaisNaFila[0] instanceof
 * ReptilAquatico) {
 * for (int j = 0; j < andar.consultarTamanhoDaFila(); j++) {
 * if (animaisNaFila[j] instanceof Anfibio || animaisNaFila[j] instanceof
 * MamiferoAquatico
 * || animaisNaFila[j] instanceof Peixe || animaisNaFila[j] instanceof
 * ReptilAquatico) {
 * embarcados = elevador.checarAnimaisNoElevador();
 * for (Animal animaisElevador : embarcados) {
 * peso += animaisElevador.getPeso();
 * }
 * if (elevador.LIMITE_DE_PESO > peso) {
 * elevador.encher();
 * if (elevador.isCheioDeAgua()) {
 * elevador.embarcar(animaisNaFila[j]);
 * andar.tirarDaFila(j);
 * }
 * elevador.subir();
 * }
 * }
 * }
 * }
 * }
 * }
 * if (elevador.getAndar() != 0 && elevador.getAndar() < 4) {
 * animaisNaFila = andar.checarFilaParaElevador();
 * if (!elevador.isCheioDeAgua()) {
 * 
 * }
 * }
 */