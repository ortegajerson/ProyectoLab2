package Juego;






public class Manager {
Inicio inicio;
Logear logear;
Jugador jugador;
Tetris tetris;
AdivinaNumero adivinanumero;
tenisframe tenist;


    public Manager() throws InterruptedException{
inicio = new Inicio(this);
logear= new Logear(this);
logear.setVisible(true);
tetris=new Tetris(this);
adivinanumero= new AdivinaNumero(this);
tenist =new tenisframe(this);
    }
    public static void main(String[] args) throws InterruptedException {
        new Manager();
        
    }
}
