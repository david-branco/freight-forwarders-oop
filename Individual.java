
public class Individual extends Cliente {

    public Individual() {
        super();
    }
    
    public Individual(int num, String nome, String morada, String numcontrib) {
        super(num,nome,morada,numcontrib);
    }
    
    public Individual(Individual i) {
        super(i);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);        
    }
    
    public String toString() {
      StringBuilder s = new StringBuilder();
      
      s.append("Tipo: Individual\n");
      s.append(super.toString());
        
      return s.toString();
    }
        
    public Individual clone() {
        return new Individual(this);
    }
}
