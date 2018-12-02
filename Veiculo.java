import java.io.*;
import java.util.*;
import java.lang.*;
import java.io.Serializable;

public abstract class Veiculo implements Serializable {

    //Variáveis de Instância
    private String matricula;
    private String marca;
    private String modelo;
    private double custoManutencao;
    private double capUtilCarga;
    private double percCargaOcupada;
    private int numID;
    
    //Constructores
    public Veiculo() { 
        this.matricula = " ";
        this.marca = " ";
        this.modelo = " ";
        this.custoManutencao = 0.0;
        this.capUtilCarga = 0.0;
        this.percCargaOcupada = 0.0;        
        this.numID = 0; 
    }
    
    public Veiculo(String matricula, String marca, String modelo, double custoManutencao, double capUtilCarga, double percCargaOcupada, int numID) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.custoManutencao = custoManutencao;
        this.capUtilCarga = capUtilCarga;
        this.percCargaOcupada = percCargaOcupada;
        this.numID = numID;       
    }
       
    
    public Veiculo(Veiculo v) {
        this.matricula = v.getMatricula();
        this.marca = v.getMarca();
        this.modelo = v.getModelo();
        this.custoManutencao = v.getCustoManutencao();
        this.capUtilCarga = v.getCapUtilCarga();
        this.percCargaOcupada = v.getPercCargaOcupada();
        this.numID = v.getNumID();
    }
    
    // Métodos de Instância
    /** Gets */
    public String getMatricula() { return matricula; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public double getCustoManutencao() { return custoManutencao; }
    public double getCapUtilCarga() { return capUtilCarga; }    
    public double getPercCargaOcupada() { return percCargaOcupada; }
    public int getNumID() { return numID; } 

    /** Sets */
    public void setMatricula(String matricula) { this.matricula = matricula; }
    public void setMarca(String marca) { this.marca = marca; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setCustoManutencao(double custoManutencao) { this.custoManutencao = custoManutencao; }
    public void setCapUtilCarga(double capUtilCarga) { this.capUtilCarga = capUtilCarga; }
    public void setPercCargaOcupada(double percCargaOcupada) { this.percCargaOcupada = percCargaOcupada; }
    public void setNumID(int numID) { this.numID = numID; }

    /** Actualiza o campo percCargaOcupada */
    public void actualizaPercCargaOcupada(double novoValor) {
        this.percCargaOcupada += (novoValor / this.capUtilCarga) * 100;
    }
   
    public boolean cabePeso(double peso) {
        if((this.pesoOcupado() + peso) <= this.capUtilCarga) return true;
        else return false;
    }
    
    public double pesoOcupado() {
        return (this.percCargaOcupada * this.capUtilCarga) / 100;
    }
    
    /** Devolve uma string com o tipo de Veiculo em questão */
    public String tipoDeVeiculo(Veiculo v) {
        String s = "Não Defenido"; 
        if(v instanceof Refrigerado) 
            s = "Refrigerado";
         else {
            if(v instanceof NaoRefrigerado) 
                s = "Não Refrigerado";
         }
       return s;
    }
    
    /** Gravar uma instância em ficheiro */
    public void gravaTxt(String fich) throws IOException {
        try {
            PrintWriter pw = new PrintWriter(fich);
            pw.print(this);
            pw.flush();
            pw.close();
        }
        catch(IOException e) { throw e; }
    }

    /** Grava um objecto em ficheiro */
    public void gravaObj(String fich) throws IOException {
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(fich));
        try {
            oout.writeObject(this);
        }
        catch(IOException e) { System.out.println(e.getMessage()); }
        oout.flush();
        oout.close();
    }
    
    /** método equals() standard - recebe Object como parâmetro */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        Veiculo v = (Veiculo) obj;
        return this.matricula == v.getMatricula() && this.marca == v.getMarca() && this.modelo == v.getModelo() && this.custoManutencao == v.getCustoManutencao() 
          && this.capUtilCarga == v.getCapUtilCarga() && this.percCargaOcupada == v.getPercCargaOcupada() && this.numID == v.getNumID(); 
    }
   
    /** Representacao como texto */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Numero de Identificação: " + this.numID + "\n");
        s.append("Matricula: " + this.matricula + "\n");
        s.append("Marca: " + this.marca + "\n");
        s.append("Modelo: " + this.modelo + "\n");
        s.append("Custo de Manutenção: " + this.custoManutencao + "\n");
        s.append("Capacidade Util de Carga: " + this.capUtilCarga + "\n");
        s.append("Percentagem de Carga Utilizada: " + (int)this.percCargaOcupada + " %\n");

    return s.toString(); 
    }    
    
    //Métodos abstractos 
    /** Copia de Veiculo */
    public abstract Veiculo clone();
    
    
} 

