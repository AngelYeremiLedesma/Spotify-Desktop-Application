/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spotifyappf;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;



/**
 *
 * @author PC
 */
public class Reproductor extends javax.swing.JFrame {
    private Cancion[] todasLasCanciones = new Cancion[5];
    private int[] masEscuchadas = {0,1,2};
    private int[] playList = new int[5];
    private int playlist1=0;
    private int coincidencia=0;
    private int i,h=0;
    private int pausador=0;
    private String response = "";
    private File[] files= new File[5];
    private AudioInputStream[] audioStreams= new AudioInputStream[5];
    private Clip[] clips=new Clip[5];
    private int accion=0;
    private int cancionactual;
    private int varax=0;
    private int progreso;
     
    
    /**
     * Creates new form Reproductor
     */
    public Reproductor() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        initComponents();
        
        todasLasCanciones[0] = new Cancion("Arcade","Duncan Laurence","Eurovision ","3:03","Arcade.wav","Arcade.jpg",180000000);
        todasLasCanciones[1] = new Cancion("Sweater Weather","The NBHD","I Love You","4:12","NBHD.wav","NBHD.jpg",180000000);
        todasLasCanciones[2] = new Cancion("Symphony","Clean Bandit","Symphony","3:38","Symphony.wav","Symphony.jfif",180000000);
        todasLasCanciones[3] = new Cancion("Rockabye","Clean Bandit","Rockabye","4:16","Rockabye.wav","Rockabye.jpg",180000000);
        todasLasCanciones[4] = new Cancion("No Lie","Dua Lipa","538 Hitzone 80","3:49","Lie.wav","Lie.jpg",180000000);
        mostrarMasEscuchadas();
        jLabel88.setVisible(false);
        jLabel90.setVisible(false);
        jLabel91.setVisible(false);
        ImageIcon imagen = new ImageIcon("playy1.png");
        jLabel89.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(jLabel89.getWidth(),jLabel89.getHeight(), Image.SCALE_SMOOTH)));
        ImageIcon imagen1 = new ImageIcon("inicio.png");
        jLabel4.setIcon(new ImageIcon(imagen1.getImage()));
        ImageIcon imagen2 = new ImageIcon("buscador.png");
        jLabel6.setIcon(new ImageIcon(imagen2.getImage()));
        
        ImageIcon imagen3 = new ImageIcon("biblioteca.png");
        jLabel8.setIcon(new ImageIcon(imagen3.getImage()));
        ImageIcon imagen4 = new ImageIcon("usuarior.png");
        jLabel18.setIcon(new ImageIcon(imagen4.getImage()));
        jLabel15.setIcon(new ImageIcon(imagen4.getImage()));
        jLabel20.setIcon(new ImageIcon(imagen4.getImage()));
        ImageIcon imagen5 = new ImageIcon("barra.png");
        jLabel1.setIcon(new ImageIcon(imagen5.getImage()));
        ImageIcon imagen6 = new ImageIcon("pleyador.png");
        jLabel82.setIcon(new ImageIcon(imagen6.getImage()));
        ImageIcon imagen7 = new ImageIcon("agregar.png");
        jLabel84.setIcon(new ImageIcon(imagen7.getImage()));
        ImageIcon imagen8 = new ImageIcon("duracion.png");
        jLabel73.setIcon(new ImageIcon(imagen8.getImage()));
        jLabel34.setIcon(new ImageIcon(imagen8.getImage()));
        ImageIcon imagen9 = new ImageIcon("playy.png");
        jLabel92.setIcon(new ImageIcon(imagen9.getImage()));
        jLabel93.setIcon(new ImageIcon(imagen9.getImage()));
        jLabel94.setIcon(new ImageIcon(imagen9.getImage()));
        ImageIcon imagen10 = new ImageIcon("box.png");
        jLabel85.setIcon(new ImageIcon(imagen10.getImage()));
        ImageIcon imagen11 = new ImageIcon("regresar.png");
        jLabel91.setIcon(new ImageIcon(imagen11.getImage()));
        ImageIcon imagen12 = new ImageIcon("pause.png");
        jLabel88.setIcon(new ImageIcon(imagen12.getImage()));
        ImageIcon imagen13 = new ImageIcon("adelantar.png");
        jLabel90.setIcon(new ImageIcon(imagen13.getImage()));
        
        
        
        jLabel89.setVisible(false);
        jProgressBar1.setVisible(false);
        
        jLabel19.setText(Registrador.ggg.nombre);
        jLabel17.setText(Registrador.ggg.nombre);
        jLabel21.setText(Registrador.ggg.nombre);
        
        i=0;
        this.setLocationRelativeTo(null);
        
        for(i=0;i<5;i++){
            files[i] = new File(todasLasCanciones[i].localizacion);
            audioStreams[i] = AudioSystem.getAudioInputStream(files[i]);
            clips[i] = AudioSystem.getClip();
            clips[i].open(audioStreams[i]);
        }
        
        
        new Thread(new Runnable(){   
            @Override
            public void run() {
                
                while(true){
                  { 
                      while(accion==0){
                          System.out.print("");
                      }
			switch(response) {
				case ("P"): clips[cancionactual].start();
				break;
				case ("S"): clips[cancionactual].stop();
				break;
				case ("R"): 
                                clips[cancionactual].stop();
                                clips[coincidencia].setMicrosecondPosition(0);
                                clips[coincidencia].start();
                                cancionactual=coincidencia;
				break;
				case ("Q"): clips[cancionactual].close();
				break;
			}
                        accion=0;
		 }  
                }
                
                
                    
                }
            }).start();

        Timer timer = new Timer (500, new ActionListener ()
        {
        public void actionPerformed(ActionEvent e)
        {
            if(varax==1){
                if(clips[cancionactual].getMicrosecondPosition()>=todasLasCanciones[cancionactual].duracionreal){
            
                    if(h==(playlist1-1)){
                    coincidencia=playList[0];
                    h=0;
                    }
                    else{
                        coincidencia=playList[h+1];
                        h++;
                    }
                    response="R";
                    accion=1;

                                    ImageIcon imagen = new ImageIcon(todasLasCanciones[playList[h]].imaglocalizacion);
                                    jLabel85.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(jLabel85.getWidth(),jLabel85.getHeight(), Image.SCALE_SMOOTH)));
                                    jLabel86.setText(todasLasCanciones[playList[h]].nombre);
                                    jLabel87.setText(todasLasCanciones[playList[h]].autor);
            
                }
            }
            progreso=Math.toIntExact(100*clips[cancionactual].getMicrosecondPosition()/todasLasCanciones[cancionactual].duracionreal);
            jProgressBar1.setValue(progreso);
        }
        });
        timer.start();
        
        
        
    }

    
    public void listador(JLabel x,JLabel y,JLabel z,JLabel m,JLabel n,JLabel r,Integer i,JLabel s){
        x.setText(String.valueOf(i+1));
        ImageIcon imagen = new ImageIcon(todasLasCanciones[playList[i]].imaglocalizacion);
        y.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(y.getWidth(),y.getHeight(), Image.SCALE_SMOOTH)));
        z.setText(todasLasCanciones[playList[i]].nombre);
        m.setText(todasLasCanciones[playList[i]].autor);
        n.setText(todasLasCanciones[playList[i]].album);
        r.setText(todasLasCanciones[playList[i]].duracion);
        s.setVisible(true);
    }

    
    public void mostrarMasEscuchadas(){
            ImageIcon imagen = new ImageIcon(todasLasCanciones[masEscuchadas[0]].imaglocalizacion);
            jLabel26.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(jLabel26.getWidth(),jLabel26.getHeight(), Image.SCALE_SMOOTH)));
            ImageIcon imagen2 = new ImageIcon(todasLasCanciones[masEscuchadas[1]].imaglocalizacion);
            jLabel27.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(jLabel27.getWidth(),jLabel27.getHeight(), Image.SCALE_SMOOTH)));
            ImageIcon imagen3 = new ImageIcon(todasLasCanciones[masEscuchadas[2]].imaglocalizacion);
            jLabel28.setIcon(new ImageIcon(imagen3.getImage().getScaledInstance(jLabel28.getWidth(),jLabel28.getHeight(), Image.SCALE_SMOOTH)));
            jPanel4.setVisible(true);
            jLabel22.setText(todasLasCanciones[masEscuchadas[0]].nombre);
            jLabel23.setText(todasLasCanciones[masEscuchadas[1]].nombre);
            jLabel24.setText(todasLasCanciones[masEscuchadas[2]].nombre);
            jLabel25.setText(todasLasCanciones[masEscuchadas[0]].autor);
            jLabel29.setText(todasLasCanciones[masEscuchadas[1]].autor);
            jLabel30.setText(todasLasCanciones[masEscuchadas[2]].autor);
        jPanel7.setVisible(false);
        jPanel9.setVisible(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();

        jPopupMenu1.setBackground(new java.awt.Color(30, 30, 30));
        jPopupMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jPopupMenu1.setBorder(null);

        jMenuItem1.setBackground(new java.awt.Color(30, 30, 30));
        jMenuItem1.setForeground(new java.awt.Color(0, 0, 0));
        jMenuItem1.setText("Log Out");
        jMenuItem1.setBorder(null);
        jMenuItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem1MousePressed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(10, 10, 10));

        jPanel5.setBackground(new java.awt.Color(10, 10, 10));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
        });
        jPanel5.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Inicio");
        jPanel5.add(jLabel3);
        jLabel3.setBounds(60, 4, 60, 30);
        jPanel5.add(jLabel4);
        jLabel4.setBounds(10, 10, 41, 16);

        jPanel6.setBackground(new java.awt.Color(10, 10, 10));
        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Buscar");
        jPanel6.add(jLabel5);
        jLabel5.setBounds(60, 0, 80, 40);
        jPanel6.add(jLabel6);
        jLabel6.setBounds(21, -20, 30, 80);

        jPanel8.setBackground(new java.awt.Color(10, 10, 10));
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });
        jPanel8.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Playlists");
        jPanel8.add(jLabel7);
        jLabel7.setBounds(60, 4, 140, 30);
        jPanel8.add(jLabel8);
        jLabel8.setBounds(20, -5, 30, 50);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(317, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(25, 25, 25));
        jPanel2.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(25, 25, 25));
        jPanel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel4MouseMoved(evt);
            }
        });
        jPanel4.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Canciones más escuchadas");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(18, 35, 327, 29);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("X");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel9);
        jLabel9.setBounds(751, 15, 12, 24);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("—");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel10);
        jLabel10.setBounds(714, 15, 19, 24);

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Nombre");
        jPanel4.add(jLabel19);
        jLabel19.setBounds(550, 9, 120, 30);

        jLabel18.setComponentPopupMenu(jPopupMenu1);
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel18MousePressed(evt);
            }
        });
        jPanel4.add(jLabel18);
        jLabel18.setBounds(510, 0, 190, 50);

        jLabel26.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel26.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel26MouseMoved(evt);
            }
        });
        jPanel4.add(jLabel26);
        jLabel26.setBounds(60, 90, 140, 140);

        jLabel92.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel92.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel92MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel92);
        jLabel92.setBounds(110, 130, 50, 50);

        jLabel27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabel27.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel27MouseMoved(evt);
            }
        });
        jPanel4.add(jLabel27);
        jLabel27.setBounds(280, 150, 150, 140);

        jLabel93.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel93.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel93MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel93);
        jLabel93.setBounds(340, 200, 50, 40);

        jLabel28.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jLabel28.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel28MouseMoved(evt);
            }
        });
        jPanel4.add(jLabel28);
        jLabel28.setBounds(510, 200, 140, 140);

        jLabel94.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel94.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel94MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel94);
        jLabel94.setBounds(570, 250, 50, 50);

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Nombre1");
        jPanel4.add(jLabel22);
        jLabel22.setBounds(60, 250, 140, 19);

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Nombre2");
        jPanel4.add(jLabel23);
        jLabel23.setBounds(280, 310, 150, 19);

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Nombre3");
        jPanel4.add(jLabel24);
        jLabel24.setBounds(510, 360, 140, 19);

        jLabel25.setForeground(new java.awt.Color(153, 153, 153));
        jLabel25.setText("Autor1");
        jPanel4.add(jLabel25);
        jLabel25.setBounds(60, 270, 140, 16);

        jLabel29.setForeground(new java.awt.Color(153, 153, 153));
        jLabel29.setText("Autor2");
        jPanel4.add(jLabel29);
        jLabel29.setBounds(280, 330, 150, 16);

        jLabel30.setForeground(new java.awt.Color(153, 153, 153));
        jLabel30.setText("Autor3");
        jPanel4.add(jLabel30);
        jLabel30.setBounds(510, 380, 140, 16);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(0, 0, 780, 470);

        jPanel7.setBackground(new java.awt.Color(25, 25, 25));
        jPanel7.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel7ComponentShown(evt);
            }
        });
        jPanel7.setLayout(null);

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 0, 0));
        jTextField1.setBorder(null);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel7.add(jTextField1);
        jTextField1.setBounds(80, 40, 310, 24);
        jPanel7.add(jLabel1);
        jLabel1.setBounds(30, 30, 390, 50);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("X");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel11);
        jLabel11.setBounds(740, 10, 30, 40);

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("—");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel12);
        jLabel12.setBounds(700, 10, 30, 40);

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Nombre");
        jPanel7.add(jLabel17);
        jLabel17.setBounds(530, 20, 110, 19);

        jLabel15.setComponentPopupMenu(jPopupMenu1);
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel15MousePressed(evt);
            }
        });
        jPanel7.add(jLabel15);
        jLabel15.setBounds(490, 10, 190, 40);

        jLabel71.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("Coincidencias:");
        jPanel7.add(jLabel71);
        jLabel71.setBounds(50, 100, 150, 24);

        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("#        TÍTULO                                                                            ÁLBUM                               AGREGADO EL            REPRODUCIR    ");
        jPanel7.add(jLabel72);
        jLabel72.setBounds(50, 140, 660, 16);
        jPanel7.add(jLabel73);
        jLabel73.setBounds(710, 120, 30, 60);

        jLabel74.setForeground(new java.awt.Color(153, 153, 153));
        jLabel74.setText("_____________________________________________________________________________________________________");
        jPanel7.add(jLabel74);
        jLabel74.setBounds(40, 150, 710, 16);
        jPanel7.add(jLabel75);
        jLabel75.setBounds(80, 180, 40, 40);

        jLabel76.setForeground(new java.awt.Color(153, 153, 153));
        jLabel76.setText("1");
        jPanel7.add(jLabel76);
        jLabel76.setBounds(50, 190, 48, 16);

        jLabel77.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.add(jLabel77);
        jLabel77.setBounds(130, 180, 220, 20);

        jLabel78.setForeground(new java.awt.Color(153, 153, 153));
        jPanel7.add(jLabel78);
        jLabel78.setBounds(130, 200, 220, 20);

        jLabel79.setForeground(new java.awt.Color(153, 153, 153));
        jPanel7.add(jLabel79);
        jLabel79.setBounds(350, 190, 130, 20);

        jLabel80.setForeground(new java.awt.Color(153, 153, 153));
        jLabel80.setText("24 de may. de 2021");
        jPanel7.add(jLabel80);
        jLabel80.setBounds(480, 190, 120, 16);

        jLabel81.setForeground(new java.awt.Color(153, 153, 153));
        jPanel7.add(jLabel81);
        jLabel81.setBounds(710, 180, 40, 30);

        jLabel82.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel82.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel82MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel82);
        jLabel82.setBounds(610, 170, 30, 50);

        jLabel83.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setText("No se han encontrado resultados");
        jPanel7.add(jLabel83);
        jLabel83.setBounds(130, 260, 570, 50);

        jLabel84.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel84.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel84MouseClicked(evt);
            }
        });
        jPanel7.add(jLabel84);
        jLabel84.setBounds(650, 150, 40, 90);

        jPanel2.add(jPanel7);
        jPanel7.setBounds(0, 0, 780, 470);

        jPanel9.setBackground(new java.awt.Color(25, 25, 25));
        jPanel9.setForeground(new java.awt.Color(153, 153, 153));
        jPanel9.setLayout(null);

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Playlist");
        jPanel9.add(jLabel13);
        jLabel13.setBounds(20, 34, 103, 32);

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("—");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel14);
        jLabel14.setBounds(706, 14, 19, 24);

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("X");
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel16);
        jLabel16.setBounds(743, 14, 12, 24);

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Nombre");
        jPanel9.add(jLabel21);
        jLabel21.setBounds(540, 20, 120, 30);

        jLabel20.setComponentPopupMenu(jPopupMenu1);
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel20MousePressed(evt);
            }
        });
        jPanel9.add(jLabel20);
        jLabel20.setBounds(500, 10, 200, 50);

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("#       TÍTULO");
        jPanel9.add(jLabel31);
        jLabel31.setBounds(40, 100, 80, 16);

        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("ÁLBUM");
        jPanel9.add(jLabel32);
        jLabel32.setBounds(350, 100, 41, 16);

        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("AGREGADO EL");
        jPanel9.add(jLabel33);
        jLabel33.setBounds(500, 100, 90, 16);
        jPanel9.add(jLabel34);
        jLabel34.setBounds(690, 80, 30, 50);

        jLabel35.setForeground(new java.awt.Color(153, 153, 153));
        jLabel35.setText("_______________________________________________________________________________________________________");
        jPanel9.add(jLabel35);
        jLabel35.setBounds(30, 110, 730, 16);

        jLabel36.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(153, 153, 153));
        jPanel9.add(jLabel36);
        jLabel36.setBounds(40, 150, 20, 16);

        jLabel37.setForeground(new java.awt.Color(153, 153, 153));
        jPanel9.add(jLabel37);
        jLabel37.setBounds(40, 200, 30, 20);

        jLabel38.setForeground(new java.awt.Color(153, 153, 153));
        jPanel9.add(jLabel38);
        jLabel38.setBounds(40, 250, 30, 20);

        jLabel39.setForeground(new java.awt.Color(153, 153, 153));
        jPanel9.add(jLabel39);
        jLabel39.setBounds(40, 300, 30, 20);

        jLabel40.setForeground(new java.awt.Color(153, 153, 153));
        jPanel9.add(jLabel40);
        jLabel40.setBounds(40, 350, 30, 20);
        jPanel9.add(jLabel41);
        jLabel41.setBounds(70, 136, 40, 40);
        jPanel9.add(jLabel42);
        jLabel42.setBounds(70, 186, 40, 40);
        jPanel9.add(jLabel43);
        jLabel43.setBounds(70, 236, 40, 40);
        jPanel9.add(jLabel44);
        jLabel44.setBounds(70, 286, 40, 40);
        jPanel9.add(jLabel45);
        jLabel45.setBounds(70, 336, 40, 40);

        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jPanel9.add(jLabel46);
        jLabel46.setBounds(120, 140, 220, 20);

        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jPanel9.add(jLabel47);
        jLabel47.setBounds(120, 190, 220, 20);

        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jPanel9.add(jLabel48);
        jLabel48.setBounds(120, 240, 230, 20);

        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jPanel9.add(jLabel49);
        jLabel49.setBounds(120, 290, 230, 20);

        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jPanel9.add(jLabel50);
        jLabel50.setBounds(120, 340, 220, 20);

        jLabel51.setForeground(new java.awt.Color(153, 153, 153));
        jPanel9.add(jLabel51);
        jLabel51.setBounds(120, 160, 220, 20);

        jLabel52.setForeground(new java.awt.Color(153, 153, 153));
        jPanel9.add(jLabel52);
        jLabel52.setBounds(120, 210, 230, 20);

        jLabel53.setForeground(new java.awt.Color(153, 153, 153));
        jPanel9.add(jLabel53);
        jLabel53.setBounds(120, 260, 230, 20);

        jLabel54.setForeground(new java.awt.Color(153, 153, 153));
        jPanel9.add(jLabel54);
        jLabel54.setBounds(120, 310, 230, 20);

        jLabel55.setForeground(new java.awt.Color(153, 153, 153));
        jPanel9.add(jLabel55);
        jLabel55.setBounds(120, 360, 220, 20);

        jLabel56.setForeground(new java.awt.Color(153, 153, 153));
        jPanel9.add(jLabel56);
        jLabel56.setBounds(350, 150, 140, 20);

        jLabel57.setForeground(new java.awt.Color(153, 153, 153));
        jPanel9.add(jLabel57);
        jLabel57.setBounds(350, 200, 140, 20);

        jLabel58.setForeground(new java.awt.Color(153, 153, 153));
        jPanel9.add(jLabel58);
        jLabel58.setBounds(350, 250, 140, 20);

        jLabel59.setForeground(new java.awt.Color(153, 153, 153));
        jPanel9.add(jLabel59);
        jLabel59.setBounds(350, 300, 140, 20);

        jLabel60.setForeground(new java.awt.Color(153, 153, 153));
        jPanel9.add(jLabel60);
        jLabel60.setBounds(350, 350, 140, 20);

        jLabel61.setForeground(new java.awt.Color(153, 153, 153));
        jLabel61.setText("24 de may. de 2021");
        jPanel9.add(jLabel61);
        jLabel61.setBounds(500, 150, 120, 16);

        jLabel62.setForeground(new java.awt.Color(153, 153, 153));
        jLabel62.setText("24 de may. de 2021");
        jPanel9.add(jLabel62);
        jLabel62.setBounds(500, 200, 120, 16);

        jLabel63.setForeground(new java.awt.Color(153, 153, 153));
        jLabel63.setText("24 de may. de 2021");
        jPanel9.add(jLabel63);
        jLabel63.setBounds(500, 250, 120, 16);

        jLabel64.setForeground(new java.awt.Color(153, 153, 153));
        jLabel64.setText("24 de may. de 2021");
        jPanel9.add(jLabel64);
        jLabel64.setBounds(500, 300, 109, 16);

        jLabel65.setForeground(new java.awt.Color(153, 153, 153));
        jLabel65.setText("24 de may. de 2021");
        jPanel9.add(jLabel65);
        jLabel65.setBounds(500, 350, 109, 16);

        jLabel66.setForeground(new java.awt.Color(153, 153, 153));
        jPanel9.add(jLabel66);
        jLabel66.setBounds(690, 150, 40, 20);

        jLabel67.setForeground(new java.awt.Color(153, 153, 153));
        jPanel9.add(jLabel67);
        jLabel67.setBounds(690, 200, 50, 20);

        jLabel68.setForeground(new java.awt.Color(153, 153, 153));
        jPanel9.add(jLabel68);
        jLabel68.setBounds(690, 250, 50, 20);

        jLabel69.setForeground(new java.awt.Color(153, 153, 153));
        jPanel9.add(jLabel69);
        jLabel69.setBounds(690, 300, 50, 20);

        jLabel70.setForeground(new java.awt.Color(153, 153, 153));
        jPanel9.add(jLabel70);
        jLabel70.setBounds(690, 350, 50, 20);

        jLabel89.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel89.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel89MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel89);
        jLabel89.setBounds(350, 380, 60, 60);

        jPanel2.add(jPanel9);
        jPanel9.setBounds(0, 0, 780, 470);

        jPanel10.setBackground(new java.awt.Color(30, 30, 30));
        jPanel10.setLayout(null);
        jPanel10.add(jLabel85);
        jLabel85.setBounds(0, 0, 110, 110);

        jLabel86.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jPanel10.add(jLabel86);
        jLabel86.setBounds(130, 20, 310, 30);

        jLabel87.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(153, 153, 153));
        jPanel10.add(jLabel87);
        jLabel87.setBounds(130, 40, 370, 30);

        jLabel88.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel88.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel88MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel88);
        jLabel88.setBounds(520, 15, 40, 40);

        jProgressBar1.setBackground(new java.awt.Color(100, 100, 100));
        jProgressBar1.setForeground(new java.awt.Color(100, 100, 100));
        jProgressBar1.setBorder(null);
        jProgressBar1.setBorderPainted(false);
        jProgressBar1.setMinimumSize(new java.awt.Dimension(10, 5));
        jPanel10.add(jProgressBar1);
        jProgressBar1.setBounds(390, 72, 290, 10);

        jLabel90.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel90.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel90MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel90);
        jLabel90.setBounds(580, 20, 40, 40);

        jLabel91.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel91.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel91MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel91);
        jLabel91.setBounds(480, 10, 40, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(105, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 469, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MousePressed
        // TODO add your handling code here:
        response="S";
        accion=1;
        Login gtr = new Login();
        gtr.setVisible(true);
        gtr.pack();
        gtr.setLocationRelativeTo(null);
        gtr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1MousePressed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MousePressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel20MousePressed

    private void jLabel18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MousePressed

    }//GEN-LAST:event_jLabel18MousePressed

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
        jPanel4.setVisible(true);
        jPanel7.setVisible(false);
        jPanel9.setVisible(false);
        jPanel5.setBackground(new Color(70,70,70));
        jPanel6.setBackground(new Color(10,10,10));
        jPanel8.setBackground(new Color(10,10,10));
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        // TODO add your handling code here:
        jPanel7.setVisible(true);
        jPanel4.setVisible(false);
        jPanel9.setVisible(false);
        jLabel80.setVisible(false);
        jLabel76.setVisible(false);
        jLabel82.setVisible(false);
        jPanel6.setBackground(new Color(70,70,70));
        jPanel5.setBackground(new Color(10,10,10));
        jPanel8.setBackground(new Color(10,10,10));
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        // TODO add your handling code here:
        jPanel8.setBackground(new Color(70,70,70));
        jPanel6.setBackground(new Color(10,10,10));
        jPanel5.setBackground(new Color(10,10,10));
        
        jPanel9.setVisible(true);
        jPanel7.setVisible(false);
        jPanel4.setVisible(false);
        jLabel61.setVisible(false);
        jLabel62.setVisible(false);
        jLabel63.setVisible(false);
        jLabel64.setVisible(false);
        jLabel65.setVisible(false);
        
        for(int j=0;j<playlist1;j++){
            switch(j){
                case 0:
                    listador(jLabel36,jLabel41,jLabel46,jLabel51,jLabel56,jLabel66,j,jLabel61);
                    break;
                case 1:
                    listador(jLabel37,jLabel42,jLabel47,jLabel52,jLabel57,jLabel67,j,jLabel62);
                    break;
                case 2:
                    listador(jLabel38,jLabel43,jLabel48,jLabel53,jLabel58,jLabel68,j,jLabel63);
                    break;
                case 3:
                    listador(jLabel39,jLabel44,jLabel49,jLabel54,jLabel59,jLabel69,j,jLabel64);
                    break;
                case 4:
                    listador(jLabel40,jLabel45,jLabel50,jLabel55,jLabel60,jLabel70,j,jLabel65);
            }
            
        }
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel7ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel7ComponentShown
        // TODO add your handling code here:
        jTextField1.setText("");
        jLabel76.setVisible(false);
        jLabel82.setVisible(false);
        jLabel76.setVisible(false);
        jLabel75.setVisible(false);
        jLabel77.setVisible(false);
        jLabel78.setVisible(false);
        jLabel79.setVisible(false);
        jLabel81.setVisible(false);
        jLabel80.setVisible(false);
        jLabel84.setVisible(false);
    }//GEN-LAST:event_jPanel7ComponentShown

    private void jLabel84MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel84MouseClicked
        // TODO add your handling code here:
        playList[playlist1]=coincidencia;
        playlist1++;
        ImageIcon imagen = new ImageIcon("check list.png");
        jLabel84.setIcon(new ImageIcon(imagen.getImage()));
        jLabel89.setVisible(true);
    }//GEN-LAST:event_jLabel84MouseClicked

    private void jLabel82MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel82MouseClicked
        // TODO add your handling code here:
        jProgressBar1.setVisible(true);
        jLabel88.setVisible(true);
        ImageIcon imagen = new ImageIcon(todasLasCanciones[coincidencia].imaglocalizacion);
        jLabel85.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(jLabel85.getWidth(),jLabel85.getHeight(), Image.SCALE_SMOOTH)));
        jLabel86.setText(todasLasCanciones[coincidencia].nombre);
        jLabel87.setText(todasLasCanciones[coincidencia].autor);
        response="R";
        accion=1;
        pausador=1;
        ImageIcon imagen2 = new ImageIcon("pause.png");
        jLabel88.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(jLabel88.getWidth(),jLabel88.getHeight(), Image.SCALE_SMOOTH)));
        
        
    }//GEN-LAST:event_jLabel82MouseClicked

    private void jLabel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel15MousePressed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jLabel15MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:

        ImageIcon imagen = new ImageIcon("agregar.png");
        jLabel84.setIcon(new ImageIcon(imagen.getImage()));
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            int coincidencias=0;
            String nome=jTextField1.getText();
            
            for(int i=0;i<todasLasCanciones.length;i++)
            {
                if(todasLasCanciones[i].nombre.equalsIgnoreCase(nome)){
                    jLabel83.setVisible(false);
                    jLabel76.setVisible(true);
                    jLabel82.setVisible(true);
                    jLabel76.setVisible(true);
                    jLabel75.setVisible(true);
                    jLabel77.setVisible(true);
                    jLabel78.setVisible(true);
                    jLabel79.setVisible(true);
                    jLabel81.setVisible(true);
                    jLabel80.setVisible(true);
                    jLabel84.setVisible(true);

                    jLabel76.setText("1");
                    ImageIcon imagen2 = new ImageIcon(todasLasCanciones[i].imaglocalizacion);
                    jLabel75.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(jLabel75.getWidth(),jLabel75.getHeight(), Image.SCALE_SMOOTH)));
                    jLabel77.setText(todasLasCanciones[i].nombre);
                    jLabel78.setText(todasLasCanciones[i].autor);
                    jLabel79.setText(todasLasCanciones[i].album);
                    jLabel81.setText(todasLasCanciones[i].duracion);
                    coincidencia=i;
                    coincidencias=1;
                }
            }
            if(coincidencias==0){
                jLabel83.setVisible(true);
                jLabel76.setVisible(false);
                jLabel82.setVisible(false);
                jLabel76.setVisible(false);
                jLabel75.setVisible(false);
                jLabel77.setVisible(false);
                jLabel78.setVisible(false);
                jLabel79.setVisible(false);
                jLabel81.setVisible(false);
                jLabel80.setVisible(false);
                jLabel84.setVisible(false);
            }
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jLabel88MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel88MouseClicked
        // TODO add your handling code here:
        if(pausador==1){
            
            ImageIcon imagen = new ImageIcon("playy.png");
            jLabel88.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(jLabel88.getWidth(),jLabel88.getHeight(), Image.SCALE_SMOOTH)));
            pausador=0;
            response="S";
            accion=1;
            
        }
        else if(pausador==0){
            ImageIcon imagen2 = new ImageIcon("pause.png");
            jLabel88.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(jLabel88.getWidth(),jLabel88.getHeight(), Image.SCALE_SMOOTH)));
            pausador=1;
            response="P";
            accion=1;
        }
        

    }//GEN-LAST:event_jLabel88MouseClicked

    private void jLabel89MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel89MouseClicked
        // TODO add your handling code here:
        //Iniciamos en el primer elemento de la playlist
        jLabel90.setVisible(true);
        jLabel91.setVisible(true);
        jProgressBar1.setVisible(true);
        jLabel88.setVisible(true);
        varax=1;
        pausador=1;
        
        ImageIcon imagen2 = new ImageIcon("pause.png");
        jLabel88.setIcon(new ImageIcon(imagen2.getImage().getScaledInstance(jLabel88.getWidth(),jLabel88.getHeight(), Image.SCALE_SMOOTH)));

        
        ImageIcon imagen = new ImageIcon(todasLasCanciones[playList[0]].imaglocalizacion);
        jLabel85.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(jLabel85.getWidth(),jLabel85.getHeight(), Image.SCALE_SMOOTH)));
        jLabel86.setText(todasLasCanciones[playList[0]].nombre);
        jLabel87.setText(todasLasCanciones[playList[0]].autor);
        coincidencia=playList[0];
        h=0;
        response="R";
        accion=1;
        
        
        
        
    }//GEN-LAST:event_jLabel89MouseClicked

    private void jLabel91MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel91MouseClicked
        // TODO add your handling code here:
        if(h==0){
            coincidencia=playList[playlist1-1];
            h=playlist1-1;
        }
        else{
            //cancionactual=playList[h-1]; 
            coincidencia=playList[h-1];
            h--;
        }
        response="R";
        accion=1;

                            ImageIcon imagen = new ImageIcon(todasLasCanciones[playList[h]].imaglocalizacion);
                            jLabel85.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(jLabel85.getWidth(),jLabel85.getHeight(), Image.SCALE_SMOOTH)));
                            jLabel86.setText(todasLasCanciones[playList[h]].nombre);
                            jLabel87.setText(todasLasCanciones[playList[h]].autor);
    }//GEN-LAST:event_jLabel91MouseClicked

    private void jLabel90MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel90MouseClicked
        // TODO add your handling code here:
        if(h==(playlist1-1)){
            coincidencia=playList[0];
            h=0;
        }
        else{
            coincidencia=playList[h+1];
            h++;
        }
        response="R";
        accion=1;

                            ImageIcon imagen = new ImageIcon(todasLasCanciones[playList[h]].imaglocalizacion);
                            jLabel85.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(jLabel85.getWidth(),jLabel85.getHeight(), Image.SCALE_SMOOTH)));
                            jLabel86.setText(todasLasCanciones[playList[h]].nombre);
                            jLabel87.setText(todasLasCanciones[playList[h]].autor);
        
        
    }//GEN-LAST:event_jLabel90MouseClicked

    private void jLabel26MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseMoved
        // TODO add your handling code here:
        jLabel26.setVisible(false);
        jLabel92.setVisible(true);
        
    }//GEN-LAST:event_jLabel26MouseMoved

    private void jPanel4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseMoved
        // TODO add your handling code here:
        jLabel26.setVisible(true);
        jLabel92.setVisible(false);
        jLabel27.setVisible(true);
        jLabel93.setVisible(false);
        jLabel28.setVisible(true);
        jLabel94.setVisible(false);
    }//GEN-LAST:event_jPanel4MouseMoved

    private void jLabel27MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseMoved
        // TODO add your handling code here:
        jLabel93.setVisible(true);
        jLabel27.setVisible(false);
        
    }//GEN-LAST:event_jLabel27MouseMoved

    private void jLabel28MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseMoved
        // TODO add your handling code here:
        jLabel28.setVisible(false);
        jLabel94.setVisible(true);
        
    }//GEN-LAST:event_jLabel28MouseMoved

    private void jLabel92MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel92MouseClicked
        // TODO add your handling code here:
        jProgressBar1.setVisible(true);
        jLabel88.setVisible(true);
        pausador=1;
        ImageIcon imagen = new ImageIcon(todasLasCanciones[masEscuchadas[0]].imaglocalizacion);
        jLabel85.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(jLabel85.getWidth(),jLabel85.getHeight(), Image.SCALE_SMOOTH)));
        jLabel86.setText(todasLasCanciones[masEscuchadas[0]].nombre);
        jLabel87.setText(todasLasCanciones[masEscuchadas[0]].autor);
        coincidencia=masEscuchadas[0];
        response="R";
        accion=1;
    }//GEN-LAST:event_jLabel92MouseClicked

    private void jLabel93MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel93MouseClicked
        // TODO add your handling code here:
        jProgressBar1.setVisible(true);
        jLabel88.setVisible(true);
        pausador=1;
        ImageIcon imagen = new ImageIcon(todasLasCanciones[masEscuchadas[1]].imaglocalizacion);
        jLabel85.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(jLabel85.getWidth(),jLabel85.getHeight(), Image.SCALE_SMOOTH)));
        jLabel86.setText(todasLasCanciones[masEscuchadas[1]].nombre);
        jLabel87.setText(todasLasCanciones[masEscuchadas[1]].autor);
        coincidencia=masEscuchadas[1];
        response="R";
        accion=1;
    }//GEN-LAST:event_jLabel93MouseClicked

    private void jLabel94MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel94MouseClicked
        // TODO add your handling code here:
        jProgressBar1.setVisible(true);
        jLabel88.setVisible(true);
        pausador=1;
        ImageIcon imagen = new ImageIcon(todasLasCanciones[masEscuchadas[2]].imaglocalizacion);
        jLabel85.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(jLabel85.getWidth(),jLabel85.getHeight(), Image.SCALE_SMOOTH)));
        jLabel86.setText(todasLasCanciones[masEscuchadas[2]].nombre);
        jLabel87.setText(todasLasCanciones[masEscuchadas[2]].autor);
        coincidencia=masEscuchadas[2];
        response="R";
        accion=1;
    }//GEN-LAST:event_jLabel94MouseClicked

    protected void eventoSiguiente(){
       
    }
        
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reproductor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reproductor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
