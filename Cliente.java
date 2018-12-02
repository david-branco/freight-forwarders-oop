import java.io.Serializable;
import java.util.ArrayList;
import java.lang.Integer;
import java.lang.Double;

public abstract class Cliente implements Serializable {
    private int numCliente;
    private String nome;
    private String morada;
    private String numcontrib;
    private double valorContratado;
    private ArrayList<Integer> encomendas;

    public Cliente() {
        this.numCliente = -1;
        this.nome = "";
        this.morada = "";
        this.numcontrib = "";
        this.valorContratado = 0.0;
        encomendas = new ArrayList<Integer>();
    }
       
    public Cliente(int num, String nome, String morada, String numcontrib) {
        this.numCliente = num;
        this.nome = nome;
        this.morada = morada;
        this.numcontrib = numcontrib;
        valorContratado = 0;
        encomendas = new ArrayList<Integer>();
    }
   
    public Cliente(Cliente cli) {
        encomendas = new ArrayList<Integer>();
        ArrayList<Integer> aux = cli.getEncomendas();
        
        numCliente = cli.getNumCliente();
        nome = cli.getNome();
        morada = cli.getMorada();
        numcontrib = cli.getNumContrib();
        valorContratado = cli.getValorContratado();
        for(Integer i : aux) encomendas.add(i);
    }
    
    public int getNumCliente() { return numCliente; }
    public String getNome() { return nome; }
    public String getMorada() { return morada; }
    public String getNumContrib() { return numcontrib; }
    public double getValorContratado() { return valorContratado; }
    
    public ArrayList<Integer> getEncomendas() {
        ArrayList<Integer> aux = new ArrayList<Integer>();
        
        for(Integer i : encomendas) aux.add(i);
        
        return aux;
    }
    
    public void setNumCliente(int num) { this.numCliente = num; }  
    public void setNome(String nome) { this.nome = nome; }
    public void setMorada(String morada) { this.morada = morada; }
    public void setNumContrib(String num) { this.numcontrib = num; }
    
    public void addNumEncomenda(Integer i, Double preco) {
        encomendas.add(i);
        valorContratado += preco;
    }        
    
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        Cliente c = (Cliente) obj;
        return numCliente == c.getNumCliente();
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        
        s.append("Número de cliente: " + numCliente + "\n");
        s.append("Nome: " + nome + "\n");
        s.append("Morada: " + morada + "\n");
        s.append("Número de contribuinte: " + numcontrib + "\n");
        s.append("Valor contratado: " + valorContratado + "\n");
        s.append("\nServiços prestados: \n");
        
        if(encomendas.isEmpty()) {
            s.append("Este cliente ainda não contractou nenhum serviço\n");
        }   
        else {
            for(Integer i : encomendas) {
                s.append("Nº de encomenda: " + i.intValue() + "\n");
            }
        }
        return s.toString();
    }
    
    public abstract Cliente clone();   
}
