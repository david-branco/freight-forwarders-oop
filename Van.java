import java.util.*;

public class Van extends Veiculo implements Refrigerado {   
    
    //Variáveis de Classe
    public static double pB = 10.0;

    //Variáveis de Instância
    
    //Constructores
    public Van() {
        super();
    }
    
    public Van(String matricula, String marca, String modelo, double custoManutencao, double capUtilCarga, double percCargaOcupada, int numID) {
        super(matricula, marca, modelo, custoManutencao, capUtilCarga, percCargaOcupada, numID);
    }
   
    public Van(Van v) {
        super(v);
    }
    
    //Métodos de Classe
    /** Gets */
    public static double getPB() { return pB; } 
    
    /** Sets */
    public static void setPB(double novoPB) { pB = novoPB; }
    
    // Métodos de Instância
     
    /** método equals() standard - recebe Object como parâmetro */
    public boolean equals(Object obj) {
       if (this == obj) return true;
       if((obj == null) || (this.getClass() != obj.getClass())) return false;
       Van v = (Van) obj;
       return (super.equals(v));
    }  
    
    /** Representacao como texto */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("---------------- Van ----------------\n");
        s.append(super.toString());
        s.append("Tipo de Veiculo: " + tipoDeVeiculo(this) +"\n");
        s.append("Preço Base de Van " + pB +"\n");
        s.append("-------------------------------------\n\n");
        
        return s.toString();
    }
    
    /** Copia de Van */
    public Van clone() { 
        return new Van(this); 
    }
   
}  