import java.util.GregorianCalendar;
import java.util.Calendar;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.Double;

public class Encomenda implements Serializable {
    private int numenc;
    private int numcliente;
    private int produto;
    private int veiculo;
    private double preco;
    private GregorianCalendar data;
    private Carga carga;
    
    public Encomenda() {
        this.numenc = -1;
        this.numcliente = -1;
        this.produto = -1;
        this.veiculo = -1;
        this.preco = 0.0;
        this.data = new GregorianCalendar();
    }
    
    public Encomenda(int numenc, int numcliente, int produto, int veiculo, GregorianCalendar data, Carga carga, double preco) {
        this.numenc = numenc;
        this.numcliente = numcliente;
        this.produto = produto;
        this.data = (GregorianCalendar) data.clone();
        this.carga = carga.clone();
        this.preco = preco;
    }    
    
    public Encomenda(Encomenda enc) {
        this.numenc = enc.getNumEnc();
        this.numcliente = enc.getNumCliente();
        this.produto = enc.getProduto();
        this.veiculo = enc.getVeiculo();
        this.data = enc.getData();
        this.carga = enc.getCarga();
        this.preco = enc.getPreco();
        
    }
    
    public int getNumEnc() { return numenc; }
    public int getNumCliente() { return numcliente; }
    public int getProduto() { return produto; }
    public int getVeiculo() { return veiculo; }
    public double getPreco() { return preco; }
    public GregorianCalendar getData() { return (GregorianCalendar) data.clone(); }
    public Carga getCarga() { return carga.clone(); }

    public void setNumEnc(int numenc) { this.numenc = numenc; }
    public void setNumCliente(int numcliente) { this.numcliente = numcliente; }
    public void setProduto(int produto) { this.produto = produto; }
    public void setVeiculo(int veiculo) { this.veiculo = veiculo; }
    public void setData(GregorianCalendar data) { this.data = (GregorianCalendar) data.clone(); }
    public void setCarga(Carga carga) { this.carga = carga.clone(); }
    public void setPreco(double preco) { this.preco = preco; }
        
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        Encomenda e = (Encomenda) obj;
        return numenc == e.getNumEnc();
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        
        s.append("Número de Identificação da encomenda: " + numenc + "\n");
        s.append("Número de Identificação do cliente: " + numcliente + "\n");
        s.append("Data: " + data.get(Calendar.DATE) + "-" + data.get(Calendar.DAY_OF_MONTH) + "-" + data.get(Calendar.DAY_OF_YEAR) + " / " + data.get(Calendar.HOUR) + ":" + data.get(Calendar.MINUTE) + "\n");
        s.append("Número de Identificação do produto: " + produto + "\n");
        s.append(carga.toString());
        s.append("Número de Identificação do Veículo: " + veiculo + "\n");
        s.append("Preço: " + preco + "\n");
 
        return s.toString();
    }
    
    public Encomenda clone() { return new Encomenda(this); }
}
