import java.util.TreeMap;
import java.util.Collection;
import java.util.TreeSet;
import java.io.Serializable;

public class Clientes implements Serializable {

    private TreeMap<Integer,Cliente> clientes;
    private int num;

    public Clientes() {
        clientes = new TreeMap<Integer,Cliente>();
        num = 1;
    }
    
    public Clientes(Cliente c) {
        clientes = new TreeMap<Integer,Cliente>();
        c.setNumCliente(1);
        clientes.put(1,c.clone());
        num = 2;
    }
    
    public Clientes(Clientes cls) {
        clientes = new TreeMap<Integer,Cliente>();
        
        for(Cliente c : cls.getClientes().values()) {
            clientes.put(c.getNumCliente(),c.clone());
        }
        
        num = cls.getNum();
    }
    
    public Integer addCliente(Cliente c) {
        c.setNumCliente(this.num);
        clientes.put(this.num,c.clone());
        num++;
        return num-1;
    }
    
    public void addClienteMantemNum(Cliente c) {
        clientes.put(c.getNumCliente(),c.clone());
    }
    
    public Cliente removeCliente(Integer i) {
        return clientes.remove(i);
    }
    
    public boolean existeCliente(Integer i) {
        return clientes.containsKey(i);
    }
    
    public int numClientes() { return clientes.size(); }
    
    public Cliente getCliente(Integer i) {
        Cliente c = clientes.get(i);
       
        if(c == null) {
            return null;
        }
        else {
            return c.clone();
        }
    }
    
    public TreeMap<Integer,Cliente> getClientes() {
        TreeMap<Integer,Cliente> cls = new TreeMap<Integer,Cliente>();
        
        for(Cliente c : clientes.values()) {
            cls.put(c.getNumCliente(),c.clone());
        }
        
        return cls;
    }
    
    public int getNum() {
        return this.num;
    }
    
    public String ordValorContratado() {
        StringBuilder s = new StringBuilder();
        TreeSet<Cliente> sortedClientes = new TreeSet<Cliente>(new ClienteComparator());
        
        if(clientes.size() == 0) {
            s.append("Ainda não existem clientes\n");
        }
        else {        
            for(Cliente c : clientes.values()) {
                sortedClientes.add(c.clone());
            }
        
            for(Cliente c : sortedClientes) {
                s.append(c.toString() + "\n\n");
            }
        }
        
        return s.toString();
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        
        if(clientes.size() == 0) {
            s.append("Ainda não existem clientes\n");
        }
        else {
            for(Cliente c : clientes.values()) {
                s.append(c.toString() + "\n\n");
            }
        }
        
        return s.toString();
    }
    
    public Clientes clone() { return new Clientes(this); }
    
}
