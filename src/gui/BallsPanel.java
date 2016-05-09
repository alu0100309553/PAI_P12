/**
 * Author: Rubén Labrador Páez.
 * Email: alu0100309553@ull.edu.es
 * Tit: Grado Ingeniería Informática - Universidad de La Laguna
 * Course: 3 - Computación
 * Subject: Programación de aplicaciones interactivas.
 * Practice: 12
 * Class/Program: Shoot Game
 * File: BallsPanel.java
 * Description: This is a game to throw balls and practice marksmanship.
 * @author Rubén Labrador Páez
 * @version 1.0.0 09/05/2016
 **/

package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import javax.swing.Timer;

public class BallsPanel extends JPanel {
  private int ballD = 0;                      // Ball diameter
  private double alpha = 0;                   // Arrow angle
  private double alphaM = 0;                  // Shoot angle
  private boolean sBall = false;              // Shoot ball color is selected
  private int sBallC = 0;                     // Shoot ball color value
  private int ballCount = 0;                  // Balls not destroyed
  private Timer timer;                        // Timer for ball movement animation
  private double mX = 0;                      // X shootBall position offset
  private double mY = 0;                      // Y shootBall position offset
  private double dX = 0;                      // X shootBall movement diff
  private double dY = 0;                      // Y shootBall movement diff
  private boolean good = false;               // Mark if a shoot is good or not
  private int shootedBall = 0;                // Shooted ball number 
  private Ellipse2D oval;                     // Oval to mark de info button position
  private Image img1;                         // Image of info icon
  private Sounds sound = new Sounds();        // Sounds class
  private BallLine ballLine = new BallLine(); // Lines off balls to be shooted
  private int width = 0;                      // Store X dimension of the panel
  private int height = 0;                     // Store Y dimension of the panel
  private final int ICON_OFF = 5;             // Info icon lateral offset
  private final double A_FACTOR = 0.2;        // Arrow scale value
  private final double MIN_SH_F = 0.25;       // Min diameter ball factor for shoot limit
  private final double MAX_SH_F = 0.75;       // Max diameter ball factor for shoot limit
  private final int BALL_STEP = 10;           // Ball movement step

  // Getters and setters
  private int getBallD() {
    return ballD;
  }

  private double getAlpha() {
    return alpha;
  }

  private double getAlphaM() {
    return alphaM;
  }

  private boolean issBall() {
    return sBall;
  }

  private int getsBallC() {
    return sBallC;
  }

  private int getBallCount() {
    return ballCount;
  }

  public Timer getTimer() {
    return timer;
  }

  private double getmX() {
    return mX;
  }

  private double getmY() {
    return mY;
  }

  private double getdX() {
    return dX;
  }

  private double getdY() {
    return dY;
  }

  private boolean isGood() {
    return good;
  }

  private int getShootedBall() {
    return shootedBall;
  }

  private Ellipse2D getOval() {
    return oval;
  }

  private Image getImg1() {
    return img1;
  }

  private Sounds getSound() {
    return sound;
  }

  private BallLine getBallLine() {
    return ballLine;
  }

  private int get_Width() {
    return width;
  }

  private int get_Height() {
    return height;
  }

  private void setBallD(int ballD) {
    this.ballD = ballD;
  }

  private void setAlpha(double alpha) {
    this.alpha = alpha;
  }

  private void setAlphaM(double alphaM) {
    this.alphaM = alphaM;
  }

  private void setsBall(boolean sBall) {
    this.sBall = sBall;
  }

  private void setsBallC(int sBallC) {
    this.sBallC = sBallC;
  }

  private void setBallCount(int ballCount) {
    this.ballCount = ballCount;
  }

  private void setmX(double mX) {
    this.mX = mX;
  }

  private void setmY(double mY) {
    this.mY = mY;
  }

  private void setdX(double dX) {
    this.dX = dX;
  }

  private void setdY(double dY) {
    this.dY = dY;
  }

  private void setGood(boolean good) {
    this.good = good;
  }

  private void setShootedBall(int shootedBall) {
    this.shootedBall = shootedBall;
  }

  private void setOval(Ellipse2D oval) {
    this.oval = oval;
  }

  private void setImg1(Image img1) {
    this.img1 = img1;
  }

  private void setWidth(int width) {
    this.width = width;
  }

  private void setHeight(int height) {
    this.height = height;
  }

  // Class constructor
  BallsPanel() {
    this.addMouseMotionListener(new MyMouseMotionListener());
    this.addMouseListener(new MyMouseListener());
    timer = new Timer(5, new MyActionListener());
    ballCount = ballLine.BALL_N;
  }
  
  // Paint method
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    setWidth(this.getWidth());
    setHeight(this.getHeight());
    setBallD(get_Width() / getBallLine().BALL_N);
    paintBall(g);
    drawArrow(g);
    paintSBall(g);
    drawIcon(g);
  }

  // Method to draw info icon
  private void drawIcon(Graphics g) {
    setOval (new Ellipse2D.Double(get_Width() - getBallD() - ICON_OFF, get_Height() - getBallD() - ICON_OFF, getBallD(),
        getBallD()));
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(this.getBackground());
    g2d.fill(getOval());
    setImg1(Toolkit.getDefaultToolkit().getImage("info.png"));
    g.drawImage(getImg1(), get_Width() - getBallD() - ICON_OFF, get_Height() - getBallD() - ICON_OFF, getBallD(), getBallD(),
        this);
  }

  // Method to draw ball to shoot
  private void paintSBall(Graphics g) {
    if (!issBall() && getBallCount() > 0) {
      setsBallC(getBallLine().getRandomColor());
      setsBall( true);
    }
    g.setColor(getBallLine().getColor(getsBallC()));
    g.fillOval(((get_Width() / 2) - (getBallD() / 2)) + (int) getmX(),
        (get_Height() - (getBallD() / 2)) - (int) getmY(), getBallD(), getBallD());
  }

  // Method to draw the balls line
  private void paintBall(Graphics g) {
    int xpos = (get_Width() - (getBallD() * getBallLine().BALL_N)) / 2;
    for (int i = 0; i < getBallLine().BALL_N; i++) {
      if (getBallLine().getBallState(i)) {
        g.setColor(getBallLine().getBallColor(i));
        g.fillOval(xpos, 0, getBallD(), getBallD());
      }
      xpos += getBallD();
    }
  }

  // Method to draw the shoot arrow
  private void drawArrow(Graphics g) {
    g.setColor(Color.BLACK);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setStroke(new BasicStroke(getBallD()));
    if (getAlpha() >= 0) {
      g.drawLine(get_Width() / 2, get_Height(),
          (get_Width() / 2) + ((int) (Math.cos(getAlpha()) * get_Height() * A_FACTOR)),
          get_Height() - ((int) (Math.sin(getAlpha()) * get_Height() * A_FACTOR)));
    } else {
      g.drawLine(get_Width() / 2, get_Height(),
          (get_Width() / 2) - ((int) (Math.cos(getAlpha()) * get_Height() * A_FACTOR)),
          get_Height() + ((int) (Math.sin(getAlpha()) * get_Height() * A_FACTOR)));
    }
  }

  // Method to calculate the arrow angle
  private void alphaC(int x, int y) {
    setAlpha ( Math.atan((double) (get_Height() - y) / (double) (x - (get_Width() / 2))));
  }

  // Method to calculate shoot angle
  private void alphaMC(int x, int y) {
    setAlphaM(Math.atan((double) (get_Height() - y) / (double) (x - (get_Width() / 2))));
    setdX(Math.cos(getAlphaM()) * BALL_STEP);
    setdY(Math.sin(getAlphaM()) * BALL_STEP);

  }

  // Method to calculate the shooted ball
  private void shoot(int x, int y) {
    int shootXpos = (((getBallD() / 2) - get_Height()) * (x - (get_Width() / 2)) / (y - get_Height()))
        + get_Width() / 2;
    int divResult = shootXpos / getBallD();
    int divRest = shootXpos % getBallD();
    if (divResult < getBallLine().BALL_N && divResult >= 0 && (int) (MIN_SH_F * getBallD()) < divRest
        && divRest < (int) (MAX_SH_F * getBallD()) && getBallLine().getBallState(divResult)
        && getBallCount() > 0) { // && sBallC == ballC[divResult]
      setShootedBall(divResult);
      setGood(true);
      setBallCount(getBallCount()-1);

    } else {
      setGood(false);
    }
  }

  // Inner class for timer events
  class MyActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      if (getmY() < get_Height() - getBallD() && Math.abs(getmX()) < get_Width() / 2) {
        if (getAlphaM() > 0) {
          setmX(getmX() + getdX());
          setmY(getmY() + getdY());
        } else {
          setmX(getmX() - getdX());
          setmY(getmY() - getdY());
        }
        repaint();
      } else {
        setmX(0);
        setmY(0);
        repaint();
        getTimer().stop();
        if (isGood()) {
          getBallLine().setBallState(getShootedBall(), false);
          setsBall(false);
          getSound().playWin();
        } else {
          getSound().playFail();
        }
        repaint();
      }
    }
  }

  // Inner class for mouse motion events
  class MyMouseMotionListener implements MouseMotionListener {

    @Override
    public void mouseDragged(MouseEvent arg0) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
      alphaC(e.getX(), e.getY());
      repaint();
    }
  }

  // Inner class for mouse events
  class MyMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
      if (getOval().contains(e.getX(), e.getY())) {
        InfoWindow inf = new InfoWindow();
        inf.setVisible(true);
      } else {
        alphaMC(e.getX(), e.getY());
        shoot(e.getX(), e.getY());
        repaint();
        getTimer().start();
      }
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }
  }
}
