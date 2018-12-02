import java.util.Comparator;

public class VeiculoComparator implements Comparator<Veiculo> {
   public int compare(Veiculo v1, Veiculo v2) {
       if(v1.getPercCargaOcupada() < v2.getPercCargaOcupada()) return -1;
       else if(v1.getPercCargaOcupada() > v2.getPercCargaOcupada()) return 1;       
       else return Integer.compare(v1.getNumID(),v2.getNumID());
    }
}