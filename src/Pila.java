public class Pila <T> {
    private Nodo<T> cima;

    private int tamanio;

    public void push(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.setSiguiente(cima);
        cima = nuevo;
        tamanio++;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T dato = cima.getDato();
        cima = cima.getSiguiente();
        tamanio--;
        return dato;
    }

    public boolean isEmpty() {
        return cima == null;
    }

    public int size() {
        return tamanio;
    }
}
