package Juego;


import java.util.Random;
import java.util.*;
import java.lang.*;


public class Figura {
    enum Piezas { nada, zeta, ese, linea, tee , cuadro, ele, otraele };
    private Piezas piezaFigura;
    private int cordenadas[][];
    private int[][][] cordenadasTablero;
    //constructor con las cordenadas de la pieza en el tablero
    public Figura()
        {
        cordenadas = new int[4][2];
        ponerFigura(Piezas.nada);
        }
    // aqui estan todos los posible valores de coordenadas para las piezas
    //el metodo ordinal devuelve la posicion actual del objeto pieza
    public void ponerFigura(Piezas Figura)
        {
        cordenadasTablero = new int[][][]
            { { { 0, 0 },   { 0, 0 },   { 0, 0 },   { 0, 0 } }, { { 0, -1 },  { 0, 0 },   { -1, 0 },  { -1, 1 } },
            { { 0, -1 },  { 0, 0 },   { 1, 0 },   { 1, 1 } }, { { 0, -1 },  { 0, 0 },   { 0, 1 },   { 0, 2  } },
            { { -1, 0 },  { 0, 0 },   { 1, 0 },   { 0, 1 } }, { { 0, 0 },   { 1, 0 },   { 0, 1 },   { 1, 1 }  },
            { { -1, -1 }, { 0, -1 },  { 0, 0 },   { 0, 1 } },  { { 1, -1 },  { 0, -1 },  { 0, 0 },   { 0, 1 } } };
        for (int i = 0; i < 4 ; i++)
            {
            for (int j = 0; j < 2; ++j)
                {
                cordenadas[i][j] = cordenadasTablero[Figura.ordinal()][i][j];
                }
            }
        piezaFigura = Figura;
        }
    private void ponX(int index, int x)
        {
        cordenadas[index][0] = x;
        }
    private void ponY(int index, int y)
        {
        cordenadas[index][1] = y;
        }
    public int x(int index) 
        {
        return cordenadas[index][0];
        }
    public int y(int index) 
        {
        return cordenadas[index][1];
        }
    public Piezas obtenerFigura()
        {
        return piezaFigura;
        }
    public void ponerFiguraRnd()
        {
        Random r = new Random();
        int x = Math.abs(r.nextInt()) % 7 + 1;
        Piezas[] values = Piezas.values();
        ponerFigura(values[x]);
        }
    public int minX()
        {
        int m = cordenadas[0][0];
        for (int i=0; i < 4; i++)
            {
            m = Math.min(m, cordenadas[i][0]);
            }
        return m;
        }
    public int minY()
        {
        int m = cordenadas[0][1];
        for (int i=0; i < 4; i++)
            {
            m = Math.min(m, cordenadas[i][1]);
            }
        return m;
        }
    //funciones para rotar las figuras toma en cuenta q
    //el cuadro no tiene caso rotarlo y lo devuelve igual
    public Figura rotar()
        {
        if (piezaFigura == Piezas.cuadro)
            return this;
        Figura resultado = new Figura();
        resultado.piezaFigura = piezaFigura;
        for (int i = 0; i < 4; ++i)
            {
            resultado.ponX(i, y(i));
            resultado.ponY(i, -x(i));
            }
        return resultado;
        }
}
