package Juego;






public class Manager {
Inicio inicio;
Logear logear;
memory memory;
Jugador jugador;
Tetris tetris;
AdivinaNumero adivinanumero;



    public Manager(){
inicio = new Inicio(this);
logear= new Logear(this);
logear.setVisible(true);
memory= new memory(this);
tetris=new Tetris(this);
adivinanumero= new AdivinaNumero(this);


}
    public static void main(String[] args) {
        new Manager();
    }
}
