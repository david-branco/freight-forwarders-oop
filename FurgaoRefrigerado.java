import java.util.*;

public class FurgaoRefrigerado extends Furgao implements Refrigerado {

    //Variáveis de Instância

    //Constructores
    public FurgaoRefrigerado() {
        super();
    }
    
    public FurgaoRefrigerado(String matricula, String marca, String modelo, double custoManutencao, double capUtilCarga, double percCargaOcupada, int numID, String combustivel, double autonomia) {
        super(matricula, marca, modelo, custoManutencao, capUtilCarga, percCargaOcupada, numID, combustivel, autonomia);
    }
    
    public FurgaoRefrigerado(Furgao f) {
        super(f);
    }
 
    // Métodos de Instância    
    /** método equals() standard - recebe Object como parâmetro */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        FurgaoRefrigerado f = (FurgaoRefrigerado) obj;
        return (super.equals(f));
    }      
    
    /** Representacao como texto */
    public String toString() {
        return super.toString();
    }    
    
    /** Copia de Furgao */
    public FurgaoRefrigerado clone() {
        return new FurgaoRefrigerado(this);
    }
}