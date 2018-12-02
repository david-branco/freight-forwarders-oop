
import java.io.Serializable;
import java.lang.Integer;

public class Produto implements Serializable {
    // variavel de classe
    private int numProd; //lista final
    // variaveis de instancia
    private String nome;
    private Carga carga;
    private double desconto;
    
    // constructores 
    public Produto()    {
       
        this.numProd    = 0;
        this.nome       = " ";
        this.desconto   = 0;
        this.carga      = null;
    }
    
    public Produto(int numProd, String nome,double desconto, Carga carga)   {
        this.numProd    = numProd;
        this.nome       = nome;
        this.desconto   = desconto;
        this.carga      = carga.clone();
    }
    
    public Produto(Produto p)   {
        this.numProd    = p.getNumProd();
        this.nome       = p.getNome();
        this.desconto   = p.getDesconto();
        this.carga      = p.getCarga().clone();
    }
    
    // metodos de instancia
    
    //metodo gets
    public int      getNumProd()    {return numProd; }
    public String   getNome()       {return nome; }
    public double   getDesconto()   {return desconto; }
    public Carga    getCarga()      {return carga.clone(); }
    
    //metodo set
    public void setNumProd(int num)             { this.numProd = num; }
    public void setNome(String nome)            { this.nome  = nome; }
    public void setDesconto(double desconto)    { this.desconto = desconto; }
    public void setCarga(Carga p)               { this.carga = p.clone();}
    
    
    // metodo equals
    public boolean equals(Object obj)   {
        if (this == obj)    return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        Produto p = (Produto) obj;
        return numProd  == p.getNumProd()       &&
              desconto  == p.getDesconto()      &&
                  nome  == p.getNome()          &&
                 carga  == p.getCarga();  
    }
    
    // metodo toString
    public String toString()   {
        StringBuilder s = new StringBuilder();
        s.append("Numero Produto: "+ getNumProd() +"\n");
        s.append("Produto: "+ getNome() + "\n");
        s.append(carga.toString());
        s.append("Desconto: "+ getDesconto() + "\n");
    
        return s.toString();
    }
    // metodo clone
    public Produto clone()  { return new Produto(this); }
    
               
        
    
    
        
    

   
}
