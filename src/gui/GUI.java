/**
 * Author: Rubén Labrador Páez.
 * Email: alu0100309553@ull.edu.es
 * Tit: Grado Ingeniería Informática - Universidad de La Laguna
 * Course: 3 - Computación
 * Subject: Programación de aplicaciones interactivas.
 * Practice: 12
 * Class/Program: Shoot Game
 * File: GUI.java
 * Description: This is a game to throw balls and practice marksmanship.
 * @author Rubén Labrador Páez
 * @version 1.0.0 09/05/2016
 **/

package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.Timer;


public class GUI extends JApplet {
  public BallsPanel panel ;
  public Timer getTimer(){
    return panel.getTimer();
  }

  // Init method to use as an applet
  public void init() {

    setLayout(new BorderLayout());
    panel = new BallsPanel();
    this.add(panel, BorderLayout.CENTER);

  }

  // Main method to use as an stand alone app
  public static void main(String[] args) {
    JFrame frame = new JFrame("Shoot");
    GUI applet = new GUI();
    frame.add(applet, BorderLayout.CENTER);
    applet.init();
    applet.start();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setSize(screenSize);
    frame.setVisible(true);
  }
}
