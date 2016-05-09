/**
 * Author: Rubén Labrador Páez.
 * Email: alu0100309553@ull.edu.es
 * Tit: Grado Ingeniería Informática - Universidad de La Laguna
 * Course: 3 - Computación
 * Subject: Programación de aplicaciones interactivas.
 * Practice: 12
 * Class/Program: Shoot Game
 * File: InfoWindow.java
 * Description: This is a game to throw balls and practice marksmanship.
 * @author Rubén Labrador Páez
 * @version 1.0.0 09/05/2016
 **/

package gui;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class InfoWindow extends JFrame {
  JTextArea text;     // Text area to write info
  
  // Class constructor
  InfoWindow() {
    this.setTitle("Info");
    text = new JTextArea();
    text.setText(
        "Programación de Aplicaciones Interactivas.\n 3º del Grado en "
        + "Ingeniería Informática. \n Práctica 12: Un juego de disparo "
        + "de bolas. \n Autor: Rubén Labrador Páez. \n Correo Electrónico: "
        + "alu0100309553@ull.edu.es");
    this.add(text);
    this.pack();
  }

}
