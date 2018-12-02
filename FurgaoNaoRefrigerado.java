import java.util.*;

public class FurgaoNaoRefrigerado extends Furgao implements NaoRefrigerado {

    //Variáveis de Instância

    //Constructores
    public FurgaoNaoRefrigerado() {
        super();
    }
    
    public FurgaoNaoRefrigerado(String matricula, String marca, String modelo, double custoManutencao, double capUtilCarga, double percCargaOcupada, int numID, String combustivel, double autonomia) {
        super(matricula, marca, modelo, custoManutencao, capUtilCarga, percCargaOcupada, numID, combustivel, autonomia);
    }
    
    public FurgaoNaoRefrigerado(Furgao f) {
        super(f);
    }
 
    // Métodos de Instância    
   /** método equals() standard - recebe Object como parâmetro */
   public boolean equals(Object obj) {
       if (this == obj) return true;
       if((obj == null) || (this.getClass() != obj.getClass())) return false;
       FurgaoNaoRefrigerado f = (FurgaoNaoRefrigerado) obj;
       return (super.equals(f));
   }      
    
    /** Representacao como texto */
    public String toString() {
        return super.toString();
    }
    
    /** Copia de Furgao */
    public FurgaoNaoRefrigerado clone() {
        return new FurgaoNaoRefrigerado(this);
    }
}