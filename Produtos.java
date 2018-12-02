import java.util.TreeMap;
import java.util.Collection;
import java.util.TreeSet;
import java.io.Serializable;

public class Produtos implements Serializable
{
    // variaveis de instancia
    private TreeMap<Integer,Produto> produtos;
    private int numero;

    // constructores
    public Produtos() {
        produtos    = new TreeMap<Integer,Produto>();
        numero      = 1;
    }
    
    public Produtos(Produto produto) {
        produtos = new TreeMap<Integer,Produto>();
        produto.setNumProd(1);
        produtos.put(1,produto.clone());
        numero = 2;
    }
    
    public Produtos(Produtos prod) {
        produtos = new TreeMap<Integer,Produto>();
        
        for(Produto p : prod.getProdutos().values()) {
            produtos.put(p.getNumProd(),p.clone());
        }
        this.numero = prod.getNumero();
    }
    
    public Integer addProduto(Produto p) {
        p.setNumProd(this.numero);
        produtos.put(this.numero,p.clone());        
        numero++;
        return numero-1;
    }
    
    public void addProdutoMantemNum(Produto p) {
        produtos.put(p.getNumProd(),p.clone());
    }
    
    public Produto removeProduto(Integer i) {
        return produtos.remove(i);
    }
    
    public boolean existeProduto(Integer i) {
        return produtos.containsKey(i);
    }
    
    public int numeroProdutos() { return produtos.size(); }
    
    public Produto getProduto(Integer i) {
        Produto p   = produtos.get(i);
        
        if(p == null)   return null;
        
        return p.clone();
    }
    
    public int getNumero()  {return this.numero; }
    
    public TreeMap<Integer,Produto> getProdutos() {
        TreeMap<Integer,Produto> prod = new TreeMap<Integer,Produto>();
        
        for(Produto p : produtos.values()) {
            prod.put(p.getNumProd(),p.clone());
        }
        
        return prod;
    }
       
    public String toString() {
        StringBuilder s = new StringBuilder();
        
        if(produtos.size() == 0) {
            s.append("Não foram ainda definidos produtos.\n");
        }
        else {
            for(Produto p : produtos.values()) {
                s.append(p.toString() +"\n\n");
            }
        }
        return s.toString();
    }
    
    public Produtos clone() { return new Produtos(this); }
    
}
