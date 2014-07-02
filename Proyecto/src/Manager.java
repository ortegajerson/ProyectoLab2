
public class Manager {
Inicio inicio;
Logear logear;
    public Manager(){
inicio = new Inicio(this);
logear= new Logear(this);
logear.setVisible(true);
}
    public static void main(String[] args) {
        new Manager();
    }
}
