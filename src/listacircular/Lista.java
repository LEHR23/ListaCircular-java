package listacircular;

public class Lista {
    
    private Nodo raiz;
    private int contador;
    
    public Lista(){
        raiz = null;
        contador = 0;
    }
    
    public void insertar(int dato){
        contador++;
        if(raiz == null){
            raiz = new Nodo();
            raiz.dato = dato;
            raiz.siguiente = raiz;
        }else{
            Nodo aux = raiz;
            while(aux.siguiente != raiz){
                aux = aux.siguiente;
            }
            aux.siguiente = new Nodo();
            aux.siguiente.dato = dato;
            aux.siguiente.siguiente = raiz;
        }
        System.out.println("DATO INSERTADO: " + dato);
    }
    
    public void insertar(int pos, int dato){
        if(raiz == null){
            raiz = new Nodo();
            raiz.dato = dato;
            raiz.siguiente = raiz;
        }else{
            if(pos+1 > contador){
                Nodo aux = raiz;
                while(aux.siguiente != raiz){
                    aux = aux.siguiente;
                }
                aux.siguiente = new Nodo();
                aux.siguiente.dato = dato;
                aux.siguiente.siguiente = raiz;
            }else{
                if(pos == 0){
                    Nodo aux = raiz;
                    while(aux.siguiente != raiz){
                        aux = aux.siguiente;
                    }
                    aux.siguiente = new Nodo();
                    aux.siguiente.dato = dato;
                    aux.siguiente.siguiente = raiz;
                    raiz = aux.siguiente;
                }else{
                    Nodo aux = raiz;
                    int cont = 0;
                    while(cont+1 < pos){
                        aux = aux.siguiente;
                        cont++;
                    }
                    Nodo aux2 = new Nodo();
                    aux2.dato = dato;
                    aux2.siguiente = aux.siguiente;
                    aux.siguiente = aux2;
                }
            }
        }
        System.out.println("DATO INSERTADO: " + dato);
        contador++;
    }
    
    public void remover(int dato){
        if(raiz.dato == dato){
            if(contador == 1){
                raiz = null;
            }else{
                Nodo aux = raiz;
                while(aux.siguiente != raiz){
                    aux = aux.siguiente;
                }
                aux.siguiente = aux.siguiente.siguiente;
                contador--;
                raiz = aux.siguiente;
                System.out.println("DATO ELIMINADO: " + dato);
            }
        }else{
            boolean encontrado = false;
            Nodo aux = raiz;
            while(!encontrado && aux.siguiente != raiz){
                if(aux.siguiente.dato == dato){
                    encontrado = true;
                }else{
                    aux = aux.siguiente;
                }
            }
            if(encontrado){
                aux.siguiente = aux.siguiente.siguiente;
                System.out.println("DATO ELIMINADO: " + dato);
                contador--;
            }else{
                System.out.println("DATO NO ENCONTRADO: " + dato);
            }
        }
    }
    
    public int obtener(){
        int dato = -1;
        if(contador == 1){
            dato = raiz.dato;
            raiz = null;
            contador--;
        }else{
            Nodo aux = raiz;
            while(aux.siguiente.siguiente != raiz){
                aux = aux.siguiente;
            }
            dato = aux.siguiente.dato;
            aux.siguiente = aux.siguiente.siguiente;
        }
        return dato;
    }
    
    public int obtener(int posicion){
        int dato = -1;
        if(contador <= posicion){
            System.out.println("NO EXISTE LA POSICION: " + posicion);
        }else{
            if(posicion == 0){
                if(contador == 1){
                    dato = raiz.dato;
                    contador--;
                    raiz = null;
                }else{
                    Nodo aux = raiz;
                    dato = raiz.dato;
                    while(aux.siguiente != raiz){
                        aux = aux.siguiente;
                    }
                    aux.siguiente = aux.siguiente.siguiente;
                    raiz = aux.siguiente;
                    contador--;
                }
            }else{
                Nodo aux = raiz;
                int cont = 1;
                while(cont != posicion){
                    aux = aux.siguiente;
                    cont++;
                }
                dato = aux.siguiente.dato;
                aux.siguiente = aux.siguiente.siguiente;
                contador--;
            }
        }
        return dato;
    }
    
    public void vaciar(){
        raiz = null;
        contador = 0;
    }
    
    public void mostrar(){
        if(raiz == null){
            System.out.println("LISTA VACIA");
        }else{
            Nodo aux = raiz;
            while(aux.siguiente != raiz){
                System.out.print("["+aux.dato+"]->");
                aux = aux.siguiente;
            }
            System.out.println("["+aux.dato+"]");
        }
    }
    
    public int posicion(int dato){
        if(raiz == null){
            System.out.println("NO EXISTE EL DATO: " + dato);
            return -1;
        }else{
            boolean encontrado = false;
            Nodo aux = raiz;
            int cont = 0;
            while(!encontrado && aux.siguiente != raiz){
                if(aux.dato == dato){
                    encontrado = true;
                }else{
                    cont++;
                    aux = aux.siguiente;
                }
            }
            if(aux.dato == dato){
                encontrado = true;
            }
            if(encontrado){
                return cont;
            }else{
                System.out.println("NO EXISTE EL DATO: " + dato);
                return -1;
            }
        }
    }
    
    public int contador(){
        return contador;
    }
    
    public void voltear(){
        if(raiz != null){
            if(contador <= 2){
                raiz = raiz.siguiente;
            }else{
                Nodo aux = raiz;
                Nodo aux2 = raiz.siguiente;
                Nodo aux3 = raiz.siguiente.siguiente;
                while(aux3.siguiente != raiz){
                    aux2.siguiente = aux;
                    aux = aux2;
                    aux2 = aux3;
                    aux3 = aux3.siguiente;
                }
                aux2.siguiente = aux;
                raiz.siguiente = aux3;
                aux3.siguiente = aux2;
                raiz = aux3;
            }
        }
    }
    
    public void extender(Lista lista){
        while(lista.contador != 0){
            insertar(lista.obtener(0));
        }
    }
    
}
