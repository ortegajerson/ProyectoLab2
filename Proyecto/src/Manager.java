
public class Manager {
Inicio inicio;
Logear logear;
memory memory;
    public Manager(){
inicio = new Inicio(this);
logear= new Logear(this);
logear.setVisible(true);
memory= new memory(this);
}
    public static void main(String[] args) {
        new Manager();
    }
}
