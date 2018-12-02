import java.util.*;

public abstract class Furgao extends Veiculo {

    //Variáveis de Classe
    public static double pB = 20.0;
    public static double coefX = 20.0;

    //Variáveis de Instância
    private String combustivel;
    private double autonomia;
    
    //Constructores
    public Furgao() {
        super();
        this.combustivel = " ";
        this.autonomia = 0.0;
    }
    
    public Furgao(String matricula, String marca, String modelo, double custoManutencao, double capUtilCarga, double percCargaOcupada, int numID, String combustivel, double autonomia) {
        super(matricula, marca, modelo, custoManutencao, capUtilCarga, percCargaOcupada, numID);
        this.combustivel = combustivel;
        this.autonomia = autonomia;
    }
   
    public Furgao(Furgao f) {
        super(f);
        this.combustivel = f.getCombustivel();
        this.autonomia = f.getAutonomia();
    }
    
    //Métodos de Classe
    /** Gets */
    public static double getPB() { return pB; } 
    public static double getCoefX() { return coefX; }
    
    /** Sets */
    public static void setPB(double novoPB) { pB = novoPB; }
    public static void setCoefX(double novoCoefX) { coefX = novoCoefX; }
     
    // Métodos de Instância
    /** Gets */
    public String getCombustivel() { return combustivel; }
    public double getAutonomia() { return autonomia; }
    
    /** Sets */
    public void setCombustivel(String combustivel) { this.combustivel = combustivel; }
    public void setAutonomia(double autonomia) { this.autonomia = autonomia; }
    
    /** método equals() standard - recebe Object como parâmetro */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        Furgao f = (Furgao) obj;
        return (combustivel == f.getCombustivel() && autonomia == f.getAutonomia() && super.equals(f));
    }      
    
    /** Representacao como texto */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("-------------- Furgão ---------------\n");
        s.append(super.toString());
        s.append("Combustivel: " + combustivel + "\n");
        s.append("Autonomia: " + autonomia + "\n");
        s.append("Tipo de Veiculo: " + tipoDeVeiculo(this) +"\n");
        s.append("Preço Base de Furgão: " + pB +"\n");
        s.append("Coeficiente de Carga X: " + coefX +"\n");   
        s.append("-------------------------------------\n\n");

        return s.toString(); 
    }      
    
    /** Copia de Furgao */
    public abstract Furgao clone();            
}    