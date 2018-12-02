import java.util.*;

public class Camiao extends Veiculo implements NaoRefrigerado {
    
    //Variáveis de Classe
    public static double pB = 30.0;

    //Variáveis de Instância
    private String nomeCondutor;
    private boolean atrelado;
    private double altUtilCarga;
    private double coefX;
    private double coefY;

    //Constructores
    public Camiao() {
        super();
        this.nomeCondutor = " ";
        this.atrelado = false;
        this.altUtilCarga = 0.0;
        this.coefX = 20.0;
        this.coefY = 40.0;
    }
      
    public Camiao(String matricula, String marca, String modelo, double custoManutencao, double capUtilCarga, double percCargaOcupada, int numID, String nomeCondutor, boolean atrelado, double altUtilCarga, double coefX, double coefY) {
        super(matricula, marca, modelo, custoManutencao, capUtilCarga, percCargaOcupada, numID);
        this.nomeCondutor = nomeCondutor;
        this.atrelado = atrelado;
        this.altUtilCarga = altUtilCarga;
        this.coefX = coefX;
        this.coefY = coefY;        
    }
    
    public Camiao(Camiao c) {
        super(c);
        this.nomeCondutor = c.getNomeCondutor();
        this.atrelado = c.getAtrelado();
        this.altUtilCarga = c.getAltUtilCarga();
        this.coefX = c.getCoefX();
        this.coefY = c.getCoefY(); 
    }

    //Métodos de Classe
    /** Gets */
    public static double getPB() { return pB; } 
    
    /** Sets */
    public static void setPB(double novoPB) { pB = novoPB; }
    
    // Métodos de Instância
    /** Gets */
    public String getNomeCondutor() { return this.nomeCondutor; }
    public boolean getAtrelado() { return this.atrelado; }
    public double getAltUtilCarga() { return this.altUtilCarga; }
    public double getCoefX() { return this.coefX; }
    public double getCoefY() { return this.coefY; }
    
    /** Sets */
    public void setNomeCondutor(String nomeCondutor) { this.nomeCondutor = nomeCondutor; }
    public void setAtrelado(boolean atrelado) { this.atrelado = atrelado; }
    public void setAltUtilCarga(double altUtilCarga) { this.altUtilCarga = altUtilCarga; }
    public void setCoefX(double novoCoefX) { this.coefX = novoCoefX; }
    public void setCoefY(double novoCoefY) { this.coefY = novoCoefY; }
 
    /** método equals() standard - recebe Object como parâmetro */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        Camiao c = (Camiao) obj;
        return (nomeCondutor == c.getNomeCondutor() && atrelado == c.getAtrelado() && altUtilCarga == c.getAltUtilCarga()
                 && coefX == c.getCoefX() && coefY == c.getCoefY() && super.equals(c));
    }  
    
    /** Representacao como texto */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("--------------- Camiao --------------\n");
        s.append(super.toString());
        s.append("Nome do Condutor: " + nomeCondutor + "\n");
        s.append("Atrelado: " + atrelado + "\n");
        s.append("Altura Util de Carga: " + altUtilCarga + "\n");
        s.append("Tipo de Veiculo: " + tipoDeVeiculo(this) +"\n");
        s.append("Preço Base de Camião: " + pB + "\n");
        s.append("Coeficiente de Carga X: " + coefX + "\n");
        s.append("Coeficiente de Carga Y: " + coefY + "\n") ;      
        s.append("-------------------------------------\n\n");
        return s.toString(); 
    }     
    
    /** Copia de Camiao */
    public Camiao clone() { 
        return new Camiao(this); 
    }             
}