/**
 * Author: Rubén Labrador Páez.
 * Email: alu0100309553@ull.edu.es
 * Tit: Grado Ingeniería Informática - Universidad de La Laguna
 * Course: 3 - Computación
 * Subject: Programación de aplicaciones interactivas.
 * Practice: 12
 * Class/Program: Shoot Game
 * File: ShootTest.java
 * Description: This is a game to throw balls and practice marksmanship.
 * @author Rubén Labrador Páez
 * @version 1.0.0 09/05/2016
 **/

package test;

import static org.junit.Assert.*;

import javax.swing.JFrame;

import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gui.*;

public class ShootTest {
  private FrameFixture frame;
  private GUI applet;
  
  @Before
  public void initialize() {
    applet = new GUI();
    JFrame window = new JFrame();
    window.setSize(800, 600);
    window.add(applet);
    applet.init();
    applet.start();
    window.setVisible(true);
    frame = new FrameFixture(window);
  }

  //Test that timer start when mouse is clicked
  @Test
  public void testShoot() {
    frame.click();
    assertEquals(applet.getTimer().isRunning(),true);
  }
 
  @After
  public void clear() {
    frame.cleanUp();
  }
}