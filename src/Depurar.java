public class Depurar {
    public static boolean depuracionEnteros (String numero){
        try {
            Integer.parseInt(numero);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
