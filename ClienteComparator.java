import java.util.Comparator;

public class ClienteComparator implements Comparator<Cliente> {
   public int compare(Cliente c1, Cliente c2) {
       if(c1.getValorContratado() < c2.getValorContratado()) return -1;
       else if(c1.getValorContratado() > c2.getValorContratado()) return 1;       
       else return Integer.compare(c1.getNumCliente(),c2.getNumCliente());
    }
}