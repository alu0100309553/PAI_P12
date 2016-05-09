/**
 * Author: Rubén Labrador Páez.
 * Email: alu0100309553@ull.edu.es
 * Tit: Grado Ingeniería Informática - Universidad de La Laguna
 * Course: 3 - Computación
 * Subject: Programación de aplicaciones interactivas.
 * Practice: 12
 * Class/Program: Shoot Game
 * File: Sounds.java
 * Description: This is a game to throw balls and practice marksmanship.
 * @author Rubén Labrador Páez
 * @version 1.0.0 09/05/2016
 **/

package gui;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Sounds {
  private AudioClip fail;
  private AudioClip win;

  // Class constructor
  Sounds() {
    URL urlfail = getClass().getResource("sound/fail.wav");
    URL urlwin = getClass().getResource("sound/ding.wav");
    fail = Applet.newAudioClip(urlfail);
    win = Applet.newAudioClip(urlwin);
  }

  // Win sound play
  public void playWin() {
    win.play();
  }

  // Fail sound play
  public void playFail() {
    fail.play();
  }

}
