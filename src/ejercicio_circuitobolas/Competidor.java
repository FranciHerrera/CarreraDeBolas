package ejercicio_circuitobolas;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Competidor extends Thread {

    int speed, id, posX, posY;
    int timeAwait;

    public Competidor(int speed, int id, int posX, int posY, int timeAwait) {
        this.speed = speed;
        this.id = id;
        this.posX = posX;
        this.posY = posY;
        this.timeAwait = timeAwait;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    @Override
    public void run() {
        while (true) {
            for (int i = 0; i < 800; i += speed) {
                posX += speed;
                //System.out.println("Cuadro: " + id + " en " + i);
                try {
                    sleep(timeAwait);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Competidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            for (int i = 0; i < 300; i += speed) {
                posY += speed;
                try {
                    sleep(timeAwait);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Competidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            for (int i = 800; i > 0; i -= speed) {
                posX -= speed;
                //System.out.println("Cuadro: " + id + " en " + i);
                try {
                    sleep(timeAwait);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Competidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            for (int i = 300; i > 0; i -= speed) {
                posY -= speed;
                try {
                    sleep(timeAwait);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Competidor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
