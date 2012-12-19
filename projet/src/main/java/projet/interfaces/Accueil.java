package projet.interfaces;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;



	public class Accueil extends javax.swing.JFrame {

	    //Initialisation: 
	    public Accueil() {
	        initComponents();
	    }

	    
	    @SuppressWarnings("unchecked")
	    // Methode d'initialisation : 
	    private void initComponents() {

	        // Création du Jlabel : 
	        jLabel1 = new javax.swing.JLabel();
	        // Fermeture de programme sur fermeture de la fenetre : 
	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        //Dimension de la fenetre : 
	        setPreferredSize(new java.awt.Dimension(800, 600));
	        getContentPane().setLayout(null);
	     
	        // Spécification du bouton 1: image et events
	        jButton1 = new javax.swing.JButton(new ImageIcon("partie.jpg"));
	        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
	        	public void mouseClicked(java.awt.event.MouseEvent evt) {
	                jButton1MouseClicked(evt);
	            }
	            public void mouseEntered(java.awt.event.MouseEvent evt) {
	                jButton1MouseEntered(evt);
	            }
	            public void mouseExited(java.awt.event.MouseEvent evt) {
	                jButton1MouseExited(evt);
	            }
	            
	        });
	        jButton1.setBorder(BorderFactory.createEmptyBorder());
	        jButton1.setContentAreaFilled(false);
	        getContentPane().add(jButton1);
	        jButton1.setBounds(310, 250, 170, 40);
	     
	        // Spécification du bouton 2: image et events
	        jButton2 = new javax.swing.JButton(new ImageIcon("quitter.jpg"));
	        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
	        	public void mouseClicked(java.awt.event.MouseEvent evt) {
	                jButton2MouseClicked(evt);
	            }
	            public void mouseEntered(java.awt.event.MouseEvent evt) {
	                jButton2MouseEntered(evt);
	            }
	            public void mouseExited(java.awt.event.MouseEvent evt) {
	                jButton2MouseExited(evt);
	            }
	        });
	        jButton2.setBorder(BorderFactory.createEmptyBorder());
	        jButton2.setContentAreaFilled(false);
	        getContentPane().add(jButton2);
	        jButton2.setBounds(310, 340, 170, 30);
	     
	        // Spécification du bouton 3: image et events
	        jButton3 = new javax.swing.JButton(new ImageIcon("regle.jpg"));
	        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
	        	public void mouseClicked(java.awt.event.MouseEvent evt) {
	                jButton3MouseClicked(evt);
	            }
	            public void mouseEntered(java.awt.event.MouseEvent evt) {
	                jButton3MouseEntered(evt);
	            }
	            public void mouseExited(java.awt.event.MouseEvent evt) {
	                jButton3MouseExited(evt);
	            }
	        });
	        jButton3.setBorder(BorderFactory.createEmptyBorder());
	        jButton3.setContentAreaFilled(false);
	        getContentPane().add(jButton3);
	        jButton3.setBounds(310, 293, 180, 40);

	        jLabel1.setIcon(new javax.swing.ImageIcon("accueil.jpg")); // NOI18N
	        getContentPane().add(jLabel1);
	        jLabel1.setBounds(0, 0, 800, 600);

	        pack();
	    }
	    
	  //Evenement entrer sortie de bouton 1 : 
	    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {
	    	jButton1.setIcon(new ImageIcon("partieclic.jpg"));
	        
	    }
	    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {
	    	jButton1.setIcon(new ImageIcon("partie.jpg"));
	        
	    }
	    //evenement clique bouton 1: 
	    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {
	    	  new InterfaceChoix().setVisible(true); 
	    	  
	    }
	    //Evenement entrer sortie de bouton 2 : 
	    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {
	    	jButton2.setIcon(new ImageIcon("quitterclic.jpg"));
	        
	    }
	    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {
	    	jButton2.setIcon(new ImageIcon("quitter.jpg"));
	        
	    }
	  //evenement clique bouton 2: 
	    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {
	    	System.exit(0); 
	    	 
	    }
	    //Evenement entrer sortie de bouton 3  : 
	    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {
	    	jButton3.setIcon(new ImageIcon("regleclic.jpg"));
	        
	    }
	    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {
	    	jButton3.setIcon(new ImageIcon("regle.jpg"));
	       
	    }
	  //evenement clique boutton 3: 
	    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {
	    	this.hide();
	    	new Regles().setVisible(true);
	    	  
	    }
	   
	    public static void main(String args[]) {
	        
	        try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(Accueil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        

	        
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new Accueil().setVisible(true);
	            }
	        });
	    }
	    // Déclaration de variables : 
	    private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JButton jButton3;
	    private javax.swing.JLabel jLabel1;
	    // End of variables declaration
	}


