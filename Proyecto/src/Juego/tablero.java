package Juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Juego.Figura.Piezas;
import Juego.Manager;

import javax.swing.Timer;


public class tablero extends JPanel implements ActionListener{
    int ANCHO= 15;
    int ALTO  = 30;
    Timer timer;
    boolean terminaDeCaer = false;
    boolean star = false;
    boolean pausar = false;
    int lineas = 0;
    int posX = 0;
    int posY = 0;
    JLabel puntuacion;
    Figura posicionPieza;
    Piezas[] tablero;
    public tablero(Tetris parent)
        {
        setFocusable(true);
        posicionPieza = new Figura();
        timer = new javax.swing.Timer(600, this);
        timer.start();
        puntuacion =  parent.obtenerPuntuacion();
        tablero = new Piezas[ANCHO * ALTO];
        addKeyListener(new control());
        limpiaTablero();
        }
     public void actionPerformed(ActionEvent e)
        {
        if (terminaDeCaer)
            {
            terminaDeCaer = false;
            piezaNueva();
            }
        else
            {
            bajaUna();
            }
        }
    int anchoCelda()
        {
        return (int) getSize().getWidth() / ANCHO;
        }
    int altoCelda()
        {
        return (int) getSize().getHeight() / ALTO;
        }
    Piezas formaEn(int x, int y)
        {
        return tablero[(y * ANCHO) + x];
        }
    public void start()
        {
        if(pausar)
            return;
        star = true;
        terminaDeCaer = false;
        lineas = 0;
        limpiaTablero();
        piezaNueva();
        timer.start();
        }
    private void pausa()
        {
        if (!star)
            return;
        pausar = !pausar;
        if (pausar)
            {
            timer.stop();
            puntuacion.setText("pausa");
            }
        else
            {
            timer.start();
            puntuacion.setText(String.valueOf(lineas));
            }
        repaint();
        }
    public void paint(Graphics g)
        {
        super.paint(g);
        g.setColor(Color.gray);
        Dimension tamaño = getSize();
        for (int i=1; i < tamaño.height/23; i++){
            g.drawLine(22*i,26,22*i,tamaño.height);
        }
        g.setColor(Color.GRAY);
        for (int i=1; i < tamaño.height/22 +1; i++){
            g.drawLine(0,4+22*i,tamaño.height,4+22*i);
        }
        int topeTableroA = (int) tamaño.getHeight() - ALTO * altoCelda();
        for (int i = 0; i < ALTO; ++i)
            {
            for (int j = 0; j < ANCHO; ++j)
                {
                Piezas forma = formaEn(j, ALTO - i - 1);
                if (forma != Piezas.nada)
                    dibuja(g, 0 + j * anchoCelda(),
                               topeTableroA + i * altoCelda(), forma);
                }
            }
   
        if (posicionPieza.obtenerFigura() != Piezas.nada)
            {
            for (int i = 0; i < 4; ++i)
                {
                int x = posX + posicionPieza.x(i);
                int y = posY - posicionPieza.y(i);
                dibuja(g, 0 + x * anchoCelda(),
                           topeTableroA + (ALTO - y - 1) * altoCelda(),
                           posicionPieza.obtenerFigura());
                }
            }
        }
    private void bajar()
        {
        int nuevoY = posY;
        while (nuevoY > 0)
            {
            if (!mueve(posicionPieza, posX, nuevoY - 1))
                break;
            --nuevoY;
            }
        bajaPieza();
        }
     private void bajaUna()
        {
        if (!mueve(posicionPieza, posX, posY - 1))
            bajaPieza();
        }
  
    private void limpiaTablero()
        {
        for (int i = 0; i < ALTO * ANCHO; ++i)
            tablero[i] = Piezas.nada;
        }
     private void bajaPieza()
        {
        for (int i = 0; i < 4; ++i)
            {
            int x = posX + posicionPieza.x(i);
            int y = posY - posicionPieza.y(i);
            tablero[(y * ANCHO) + x] = posicionPieza.obtenerFigura();
            }
        quitarLinea();
        if (!terminaDeCaer)
            piezaNueva();
        }
     private void piezaNueva()
        {
        posicionPieza.ponerFiguraRnd();
        posX = ANCHO / 2 + 1;
        posY = ALTO - 1 + posicionPieza.minY();
        if (!mueve(posicionPieza, posX, posY))
            {
            posicionPieza.ponerFigura(Piezas.nada);
            timer.stop();
            star = false;
            puntuacion.setText("Perdiste");

            }
        }
   
    private boolean mueve(Figura piezaNueva, int nuevolugarX, int nuevolugarY)
        {
        for (int i = 0; i < 4; ++i)
            {
            int x = nuevolugarX + piezaNueva.x(i);
            int y = nuevolugarY - piezaNueva.y(i);
            if (x < 0 || x >= ANCHO || y < 0 || y >= ALTO)
                return false;
            if (formaEn(x, y) != Piezas.nada)
                return false;
            }
        posicionPieza = piezaNueva;
        posX = nuevolugarX;
        posY = nuevolugarY;
        repaint();
        return true;
        }
    private void quitarLinea()
        {
        int numFilasLlenas = 0;
        for (int i = ALTO - 1; i >= 0; --i)
            {
            boolean lineaLLena = true;
            for (int j = 0; j < ANCHO; ++j)
                {
                if (formaEn(j, i) == Piezas.nada)
                    {
                    lineaLLena = false;
                    break;
                    }
                }
            if (lineaLLena)
                {
                ++numFilasLlenas;
                for (int k = i; k < ALTO - 1; ++k)
                    {
                    for (int j = 0; j < ANCHO; ++j)
                         tablero[(k * ANCHO) + j] = formaEn(j, k + 1);
                    }
                }
            }
        if (numFilasLlenas > 0)
            {
        lineas += numFilasLlenas;
        puntuacion.setText(String.valueOf(lineas));
        terminaDeCaer = true;
        posicionPieza.ponerFigura(Piezas.nada);
        repaint();
        }
    }
    private void dibuja(Graphics g, int x, int y, Piezas figura)
    {
     Color colores[] = { new Color(5, 5, 5), new Color(204, 102, 102),
    new Color(102, 204, 102), new Color(23, 102, 204),
    new Color(204, 204, 42), new Color(204, 102, 204),
    new Color(102, 204, 204), new Color(218, 170, 0)
                     };
    Color color = colores[figura.ordinal()];
        g.setColor(color);
        g.fillRect(x + 1, y + 1, anchoCelda() - 2, altoCelda() - 2);
        g.setColor(color.brighter());
        g.drawLine(x, y + altoCelda() - 1, x, y);
        g.drawLine(x, y, x + anchoCelda() - 1, y);
        g.setColor(color.darker());
        g.drawLine(x + 1, y + altoCelda() - 1,x + anchoCelda() - 1, y + altoCelda() - 1);
        g.drawLine(x + anchoCelda() - 1, y + altoCelda() - 1,x + anchoCelda() - 1, y + 1);
        }
    class control extends KeyAdapter
        {
        public void keyPressed(KeyEvent e)
            {
            if (!star || posicionPieza.obtenerFigura() == Piezas.nada)
                {
                return;
                }
            int keycode = e.getKeyCode();
            if (keycode == 'p' || keycode == 'P')
                {
                pausa();
                return;
                }
            if (pausar)
                return;
            switch (keycode)
                {
                case KeyEvent.VK_LEFT:
                    mueve(posicionPieza, posX - 1, posY);
                    break;
                case KeyEvent.VK_RIGHT:
                    mueve(posicionPieza, posX + 1, posY);
                    break;
                case KeyEvent.VK_DOWN:
                    bajar();
                    break;
                case KeyEvent.VK_UP:
                    mueve(posicionPieza.rotar(), posX, posY);
                    break;
                }
            }
        }
}
