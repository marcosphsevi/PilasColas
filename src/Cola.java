public class Cola<T> {

    private Nodo<T> frente;

    private Nodo<T> fin;

    private int tamanio;

    public void enqueue(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (isEmpty()) {
            frente = nuevo;
        } else {
            fin.setSiguiente(nuevo);
        }
        fin = nuevo;
        tamanio++;
    }

    public T dequeue() {

        if (isEmpty()) {
            return null;
        }
        T dato = frente.getDato();

        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        tamanio--;
        return dato;
    }

    public boolean isEmpty() {
        return frente == null;
    }

    public int size() {
        return tamanio;
    }
}

