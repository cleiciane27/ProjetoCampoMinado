/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author CleicianeGomes
 */
public class Jogo extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Jogo.class.getName());

    //aqui é o local onde criamos as nossas VARIAVEIS
    
    //Jbuttons presica da importacao da sua biblioteca
    //btnCampos ´é o nome da variavel-(voce que escolhe)
    //matriz com -10 linhas e 10 colunas
    JButton [] [] btnCampos =new JButton [10][10];
    
    //matriz para guardar as bombas - true p/bomba,  false p/numero
    boolean [][] bombas = new boolean [10] [10];   
  
    //matriz para guardar os campos que foram abertos
    boolean [][] abertos = new boolean [10][10];
    
    int quantidadeBombas= 17;
    int quantidadeCasasAbertas=0;
    boolean jogoEncerrado= false;
    
    
    /**
     * Creates new form Jogo
     */
    //CONTRUTOR SA TELA/CLASSE - SEM ELE A TELA NAO FUNCIONA
    public Jogo() {
        initComponents();
        //definir tamanho para o painel
        painelCampo.setPreferredSize(new Dimension(900,700));
        CriarTabuleiro();
    }
//CRIAR AS NOSSAS FUMÇÕES/METODOS
    public void CriarTabuleiro(){
    //definir que o painel sera dividido em 10 linhas e 10 colunas
    //com altura 2px e largura 2px
        painelCampo.setLayout(new GridLayout(10,10,2,2));
        
        for(int coluna=0; coluna<=9;coluna++){
                for(int linha=0; linha<=9; linha++){
                //variavel botao para guardar as dados provisorios
                JButton botao = new JButton();
                botao.setFont(new Font("Jokerman",Font.PLAIN,18));//fonte
                botao.setBackground(new Color(204,255,255));//cor de fundo
                botao.setForeground(Color.BLACK);//cor de texto
                
                //remover marcas do botao que vem por padrao
                botao.setFocusPainted(false);
                botao.setEnabled(false);
                
                final int linhaSelecionada = linha;
                 final int colunaSelecionada = coluna;

                  //acicionar o evento de click para abrir as casas
                botao.addActionListener((ActionEvent Evento) ->{abrirBotao(linhaSelecionada,colunaSelecionada);
                });
                
                //adicionar botao a matrix
                btnCampos[linha][coluna]=botao;
                //adicionar ele dentro do painel
                painelCampo.add(botao);
                
                }//fim do 2 for
             }//fim do 1 for
        
        
    }//fim da funçao/metodo criar tabuleiro
    
    public void AdicionarBombas(){
    //Criar uma variavel Random para gerar valores aleatorios
    Random sorteador = new Random();
    int bombasAdicionadas = 0;
    
    while(bombasAdicionadas < quantidadeBombas){
  //sortear o n da linha e coluna que vai ficar a bomba
     int linha = sorteador.nextInt(10);
    int coluna = sorteador.nextInt(10);
       //verifica se nao existe adicionada bomba no local
    if(!bombas[linha][coluna]){
    //adicionar bomba na matrix
    bombas[linha][coluna]=true;
    bombasAdicionadas++;
    }
            

    }
    
    }//fim do adicionar bombas
    
    public void IniciarJogo(){
        //chamar o metodo adicionarBombas
        AdicionarBombas();
        
        //depois precisamos iniciar os botoes do jogo
        for(int coluna=0;coluna<=9;coluna++){
           for(int linha=0; linha<=9;linha++){
               JButton botao = btnCampos[linha][coluna];
               //deixar os botoes visiveis e clicaveis
               botao.setEnabled(true);
           }//fom do 2 for
        }//fim do 1 for
    btnIniciar.setText("REINICIAR");
    }
    
    public void abrirBotao(int linha, int coluna){
    //verificar se o jogo foi finalizado
    if(jogoEncerrado) return;
    
     //verificar se o botao ja foi aberto
     if(abertos[linha][coluna]) return;
     /*se o jogo ainda estiver rodando e o batao ainda nao tiver sido aberto - entao vamos abrir o botao
     */
    abertos[linha][coluna]=true;
    quantidadeCasasAbertas++;
    
//acessar oque tem dentro do botao
    JButton botao = btnCampos[linha][coluna];
    //se no botao tiver uma bomba , entao vamos a bomba a ele
    if(bombas[linha][coluna]){
        //variavel que recebe a nossa imagem
    ImageIcon imgBomba = new ImageIcon(getClass().getResource("/Interface/bomb.png"));
    //colocae a imagem no botao
    botao.setIcon(imgBomba);
    return;
    }else{
   ImageIcon imgBandeira = new ImageIcon(getClass().getResource("/Interface/map.png"));
   botao.setIcon(imgBandeira);
   return;
    }
    
    }//fim do metodo abrirbotao
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        titulo = new javax.swing.JLabel();
        tfTempo = new javax.swing.JTextField();
        painelCampo = new javax.swing.JPanel();
        btnIniciar = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(20, 20));

        titulo.setFont(new java.awt.Font("Jokerman", 0, 28)); // NOI18N
        titulo.setForeground(new java.awt.Color(158, 19, 19));
        titulo.setText("Campo Minado");

        tfTempo.setEditable(false);
        tfTempo.setFont(new java.awt.Font("Jokerman", 1, 12)); // NOI18N
        tfTempo.setText("00:00");
        tfTempo.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createCompoundBorder()));
        tfTempo.addActionListener(this::tfTempoActionPerformed);

        painelCampo.setBackground(new java.awt.Color(204, 204, 255));
        painelCampo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 153, 255), new java.awt.Color(102, 102, 102), null));

        javax.swing.GroupLayout painelCampoLayout = new javax.swing.GroupLayout(painelCampo);
        painelCampo.setLayout(painelCampoLayout);
        painelCampoLayout.setHorizontalGroup(
            painelCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        painelCampoLayout.setVerticalGroup(
            painelCampoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 473, Short.MAX_VALUE)
        );

        btnIniciar.setBackground(new java.awt.Color(0, 51, 102));
        btnIniciar.setFont(new java.awt.Font("Ravie", 0, 14)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciar.setText("PLAY");
        btnIniciar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), new java.awt.Color(0, 102, 153), new java.awt.Color(51, 51, 51), null));
        btnIniciar.addActionListener(this::btnIniciarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(titulo)
                        .addGap(215, 215, 215)
                        .addComponent(tfTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(painelCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(titulo)))
                .addGap(48, 48, 48)
                .addComponent(painelCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // TODO add your handling code here:
        IniciarJogo();
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void tfTempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTempoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Jogo().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel painelCampo;
    private javax.swing.JTextField tfTempo;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
