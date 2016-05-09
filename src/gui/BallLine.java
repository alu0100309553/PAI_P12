/**
 * Author: Rubén Labrador Páez.
 * Email: alu0100309553@ull.edu.es
 * Tit: Grado Ingeniería Informática - Universidad de La Laguna
 * Course: 3 - Computación
 * Subject: Programación de aplicaciones interactivas.
 * Practice: 12
 * Class/Program: Shoot Game
 * File: BallLine.java
 * Description: This is a game to throw balls and practice marksmanship.
 * @author Rubén Labrador Páez
 * @version 1.0.0 09/05/2016
 **/

package gui;

import java.awt.Color;
import java.util.Random;

public class BallLine {
  private boolean[] ballState = { true, true, true, true, true, true, true,         // Array that store the state of the balls
      true, true, true, true, true, true, true, true, true, true, true, true,
      true };
  private Color[] colors = { Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW,      // Array to store different colors
      Color.ORANGE };
  private int[] ballC = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,     // Array to store the ball color value
      0, 0 };
  private Random rm = new Random();                                                 // Random generator instance
  public final int BALL_N = 20;                                                     // Constant for balls number

  // Class constructor
  BallLine() {
    for (int i = 0; i < BALL_N; i++) {
      int aux = rm.nextInt(colors.length);
      ballC[i] = aux;
    }
  }

  // Method that return the ball state
  public boolean getBallState(int pos) {
    return ballState[pos];
  }

  // Method to return a random of valid ball in ballline
  public int getRandomColor() {
    int color = 0;
    boolean exist = false;
    while (!exist) {
      int aux = rm.nextInt(BALL_N);
      if (getBallState(aux)) {
        exist = true;
        color = ballC[aux];
      }
    }
    return color;

  }

  // Method that return color of a value
  public Color getColor(int value) {
    return colors[value];
  }

  // Method that return the color of the ball in position pos
  public Color getBallColor(int pos) {
    return colors[ballC[pos]];
  }

  // Method to set the balls state
  public void setBallState(int pos, boolean state) {
    ballState[pos] = state;
  }

}
