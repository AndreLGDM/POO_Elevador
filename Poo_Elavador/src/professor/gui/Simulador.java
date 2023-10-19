package professor.gui;

import estudantes.entidades.Animal;
import professor.entidades.Arca;
import java.awt.Color;
import java.util.TimerTask;

/**
 * Simulador gráfico da arca de Noé.
 * <br>
 * <br>
 * <strong>Não mexa aqui!!!</strong>
 * 
 * @author Jean Cheiran
 * @version 1.0
 */
public class Simulador extends javax.swing.JFrame {

    private Arca arca;
    private static TimerTask tarefa;
    private static Simulador instancia;

    /**
     * Invoca o simulador de vida da arca.
     * Esse método é um intermediário no contexto da interface gráfica com
     * usuário para ser usado nas chamadas agendadas do Timer. Ele é necessário,
     * embora seja indesejado.
     */
    public void simular() {
        arca.simularVida();
    }

    public static void pararSimulacao() {
        tarefa.cancel();
    }

    /**
     * Atualiza os elementos na tela com base no estado da arca.
     * Esse método é invocado pelo simulador da arca sempre que o estado
     * atinge um ponto estável.
     */
    public void atualizarInterface() {
        // atualiza posição do elevador
        int novoY = 400 - arca.getElevador().getAndar() * 100;
        elevador.setLocation(0, novoY);

        // atualiza quantidade animais elevador
        labelElevador.setText("." + arca.getElevador().checarAnimaisNoElevador().length + ".");

        // atualiza elevador cheio ou vazio
        if (arca.getElevador().isCheioDeAgua()) {
            elevador.setBackground(new Color(150, 255, 255));
        } else {
            elevador.setBackground(new Color(200, 200, 200));
        }

        // atualiza os animais nas filas
        for (int i = 0; i < Arca.QUANTIDADE_DE_ANDARES_NA_ARCA; i++) {
            if (arca.getAndares()[i].checarFilaParaElevador().length > 0) {
                Animal[] a = arca.getAndares()[i].checarFilaParaElevador();
                String label = "";
                for (int j = a.length - 1; j >= 0; j--) {
                    label += a[j].getClass() + " " + a[j].getAndarDesejado() + " -> ";
                }
                switch (i) {
                    case 0 -> labelAndar0.setText(label);
                    case 1 -> labelAndar1.setText(label);
                    case 2 -> labelAndar2.setText(label);
                    case 3 -> labelAndar3.setText(label);
                    case 4 -> labelAndar4.setText(label);
                }
            } else {
                switch (i) {
                    case 0 -> labelAndar0.setText("vazio");
                    case 1 -> labelAndar1.setText("vazio");
                    case 2 -> labelAndar2.setText("vazio");
                    case 3 -> labelAndar3.setText("vazio");
                    case 4 -> labelAndar4.setText("vazio");
                }
            }
        }

        // atualiza quantidade animais descidos nos andares
        labelDescidos0.setText(arca.getAndares()[0].checarDesembarcados().length + " <-");
        labelDescidos1.setText(arca.getAndares()[1].checarDesembarcados().length + " <-");
        labelDescidos2.setText(arca.getAndares()[2].checarDesembarcados().length + " <-");
        labelDescidos3.setText(arca.getAndares()[3].checarDesembarcados().length + " <-");
        labelDescidos4.setText(arca.getAndares()[4].checarDesembarcados().length + " <-");

        this.repaint();
    }

    /**
     * Padrão de projeto Singleton para obter o simulador.
     * 
     * @return instância única de Simulador
     */
    public static Simulador getInstancia() {
        if (instancia == null) {
            instancia = new Simulador();
        }
        return instancia;
    }

    /**
     * Creates new form Simulador
     */
    private Simulador() {
        initComponents();
        arca = new Arca();
        fundo.setVisible(true);
        fosso.setVisible(true);
        elevador.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fundo = new javax.swing.JPanel();
        fosso = new javax.swing.JPanel();
        elevador = new javax.swing.JPanel();
        labelElevador = new javax.swing.JLabel();
        labelAndar0 = new javax.swing.JLabel();
        labelAndar1 = new javax.swing.JLabel();
        labelAndar2 = new javax.swing.JLabel();
        labelAndar3 = new javax.swing.JLabel();
        labelAndar4 = new javax.swing.JLabel();
        labelAndarDescricao = new javax.swing.JLabel();
        chao0 = new javax.swing.JPanel();
        chao1 = new javax.swing.JPanel();
        chao2 = new javax.swing.JPanel();
        chao3 = new javax.swing.JPanel();
        chao4 = new javax.swing.JPanel();
        labelDescidos0 = new javax.swing.JLabel();
        labelDescidos1 = new javax.swing.JLabel();
        labelDescidos2 = new javax.swing.JLabel();
        labelDescidos3 = new javax.swing.JLabel();
        labelDescidos4 = new javax.swing.JLabel();
        labelDescidosDescricao1 = new javax.swing.JLabel();
        labelDescidosDescricao2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulador - Ascensorista de Noe");
        setBackground(new java.awt.Color(102, 255, 255));
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 600));

        fundo.setBackground(new java.awt.Color(204, 102, 0));
        fundo.setMaximumSize(new java.awt.Dimension(800, 600));
        fundo.setMinimumSize(new java.awt.Dimension(800, 600));
        fundo.setPreferredSize(new java.awt.Dimension(800, 600));
        fundo.setLayout(null);

        fosso.setBackground(new java.awt.Color(102, 102, 102));
        fosso.setMaximumSize(new java.awt.Dimension(100, 500));
        fosso.setMinimumSize(new java.awt.Dimension(100, 500));
        fosso.setPreferredSize(new java.awt.Dimension(100, 500));
        fosso.setLayout(null);

        elevador.setMaximumSize(new java.awt.Dimension(100, 0));
        elevador.setLayout(null);

        labelElevador.setBackground(new java.awt.Color(200, 200, 200));
        labelElevador.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelElevador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelElevador.setText("vazio");
        elevador.add(labelElevador);
        labelElevador.setBounds(0, 30, 100, 40);

        fosso.add(elevador);
        elevador.setBounds(0, 400, 100, 100);

        fundo.add(fosso);
        fosso.setBounds(650, 50, 100, 500);

        labelAndar0.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelAndar0.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelAndar0.setText("vazio");
        fundo.add(labelAndar0);
        labelAndar0.setBounds(140, 510, 500, 40);

        labelAndar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelAndar1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelAndar1.setText("vazio");
        fundo.add(labelAndar1);
        labelAndar1.setBounds(140, 410, 500, 40);

        labelAndar2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelAndar2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelAndar2.setText("vazio");
        fundo.add(labelAndar2);
        labelAndar2.setBounds(140, 310, 500, 40);

        labelAndar3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelAndar3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelAndar3.setText("vazio");
        fundo.add(labelAndar3);
        labelAndar3.setBounds(140, 210, 500, 40);

        labelAndar4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelAndar4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelAndar4.setText("vazio");
        fundo.add(labelAndar4);
        labelAndar4.setBounds(140, 110, 500, 40);

        labelAndarDescricao.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelAndarDescricao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelAndarDescricao.setText("Filas de embarque");
        fundo.add(labelAndarDescricao);
        labelAndarDescricao.setBounds(340, 30, 300, 40);

        chao0.setBackground(new java.awt.Color(102, 51, 0));
        chao0.setLayout(null);
        fundo.add(chao0);
        chao0.setBounds(0, 545, 650, 5);

        chao1.setBackground(new java.awt.Color(102, 51, 0));
        chao1.setLayout(null);
        fundo.add(chao1);
        chao1.setBounds(0, 445, 650, 5);

        chao2.setBackground(new java.awt.Color(102, 51, 0));
        chao2.setLayout(null);
        fundo.add(chao2);
        chao2.setBounds(0, 345, 650, 5);

        chao3.setBackground(new java.awt.Color(102, 51, 0));
        chao3.setLayout(null);
        fundo.add(chao3);
        chao3.setBounds(0, 245, 650, 5);

        chao4.setBackground(new java.awt.Color(102, 51, 0));
        chao4.setLayout(null);
        fundo.add(chao4);
        chao4.setBounds(0, 145, 650, 5);

        labelDescidos0.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelDescidos0.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDescidos0.setText("vazio");
        fundo.add(labelDescidos0);
        labelDescidos0.setBounds(50, 510, 100, 40);

        labelDescidos1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelDescidos1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDescidos1.setText("vazio");
        fundo.add(labelDescidos1);
        labelDescidos1.setBounds(50, 410, 100, 40);

        labelDescidos2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelDescidos2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDescidos2.setText("vazio");
        fundo.add(labelDescidos2);
        labelDescidos2.setBounds(50, 310, 100, 40);

        labelDescidos3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelDescidos3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDescidos3.setText("vazio");
        fundo.add(labelDescidos3);
        labelDescidos3.setBounds(50, 210, 100, 40);

        labelDescidos4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelDescidos4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDescidos4.setText("vazio");
        fundo.add(labelDescidos4);
        labelDescidos4.setBounds(50, 110, 100, 40);

        labelDescidosDescricao1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelDescidosDescricao1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDescidosDescricao1.setText("Quantidade de");
        fundo.add(labelDescidosDescricao1);
        labelDescidosDescricao1.setBounds(10, 10, 200, 40);

        labelDescidosDescricao2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelDescidosDescricao2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDescidosDescricao2.setText("desembarques");
        fundo.add(labelDescidosDescricao2);
        labelDescidosDescricao2.setBounds(10, 40, 200, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fundo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fundo, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Simulador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Simulador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Simulador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Simulador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Simulador.getInstancia().setVisible(true);
        });

        tarefa = new TimerTask() {
            @Override
            public void run() {
                Simulador.getInstancia().simular();
            }
        };

        /*
         * invoca simular() de 1 em 1 segundo com atraso de 3 segundos na primeira vez
         */
        new java.util.Timer().schedule(tarefa, 3000, 1000);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chao0;
    private javax.swing.JPanel chao1;
    private javax.swing.JPanel chao2;
    private javax.swing.JPanel chao3;
    private javax.swing.JPanel chao4;
    private javax.swing.JPanel elevador;
    private javax.swing.JPanel fosso;
    private javax.swing.JPanel fundo;
    private javax.swing.JLabel labelAndar0;
    private javax.swing.JLabel labelAndar1;
    private javax.swing.JLabel labelAndar2;
    private javax.swing.JLabel labelAndar3;
    private javax.swing.JLabel labelAndar4;
    private javax.swing.JLabel labelAndarDescricao;
    private javax.swing.JLabel labelDescidos0;
    private javax.swing.JLabel labelDescidos1;
    private javax.swing.JLabel labelDescidos2;
    private javax.swing.JLabel labelDescidos3;
    private javax.swing.JLabel labelDescidos4;
    private javax.swing.JLabel labelDescidosDescricao1;
    private javax.swing.JLabel labelDescidosDescricao2;
    private javax.swing.JLabel labelElevador;
    // End of variables declaration//GEN-END:variables
}