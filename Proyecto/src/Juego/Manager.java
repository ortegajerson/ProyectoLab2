package Juego;






public class Manager {
Inicio inicio;
Logear logear;
Jugador jugador;
Tetris tetris;
AdivinaNumero adivinanumero;



    public Manager(){
inicio = new Inicio(this);
logear= new Logear(this);
logear.setVisible(true);
tetris=new Tetris(this);
adivinanumero= new AdivinaNumero(this);


}
    public static void main(String[] args) {
        new Manager();
    }
}
