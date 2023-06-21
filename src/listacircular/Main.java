package listacircular;

public class Main {

    public static void main(String[] args) {
        Lista lista = new Lista();
        lista.insertar(15);
        lista.insertar(22);
        lista.insertar(1);
        lista.insertar(0, 0);
        lista.insertar(3, 10);
        lista.mostrar();
        lista.voltear();
        lista.mostrar();
        lista.insertar(99);
        lista.mostrar();
        lista.insertar(59);
        lista.mostrar();
        lista.voltear();
        lista.mostrar();
    }
    
}
