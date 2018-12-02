import java.util.TreeMap;
import java.io.Serializable;

public class Encomendas implements Serializable {

    private TreeMap<Integer,Encomenda> encomendas;
    private int num;

    public Encomendas() {
        encomendas = new TreeMap<Integer,Encomenda>();
        num = 1;
    }
    
    public Encomendas(Encomenda e) {
        encomendas = new TreeMap<Integer,Encomenda>();
        e.setNumEnc(1);
        encomendas.put(1,e.clone());
        num = 2;
    }
    
    public Encomendas(Encomendas encs) {
        encomendas = new TreeMap<Integer,Encomenda>();
        
        for(Encomenda e : encs.getEncomendas().values()) {
            encomendas.put(e.getNumEnc(),e.clone());
        }
        
        this.num = encs.getNum();
    }    
    
    public Integer addEncomenda(Encomenda e) {
        e.setNumEnc(this.num);
        encomendas.put(this.num,e.clone());
        num++;
        return num-1;
    }
    
    public Encomenda removeEncomenda(Integer i) {
        return encomendas.remove(i);
    }
    
    public boolean existeEncomenda(Integer i) {
        return encomendas.containsKey(i);
    }
    
    public int numEncomendas() { return encomendas.size(); }
    
    public Encomenda getEncomenda(Integer i) {
        Encomenda e = encomendas.get(i);
        
        if(e == null) {
            return null;
        }
        else {
            return e.clone();
        }
    }
    
    public int getNum() {
        return this.num;
    }
    
    public TreeMap<Integer,Encomenda> getEncomendas() {
        TreeMap<Integer,Encomenda> encs = new TreeMap<Integer,Encomenda>();
        
        for(Encomenda e : encomendas.values()) {
            encs.put(e.getNumEnc(),e.clone());
        }
        
        return encs;
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        
        if(encomendas.size() == 0) {
            s.append("Ainda não existem encomendas\n");
        }
        else {
            for(Encomenda e : encomendas.values()) {
                s.append(e.toString() + "\n\n");
            }
        }
        
        return s.toString();
    }
    
    
    public Encomendas clone() { return new Encomendas(this); }
    
}
