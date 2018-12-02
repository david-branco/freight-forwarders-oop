public class Empresarial extends Cliente {

    public Empresarial() {
        super();
    }
    
    public Empresarial(int num, String nome, String morada, String numcontrib) {
        super(num,nome,morada,numcontrib);
    }
    
    public Empresarial(Empresarial i) {
        super(i);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    
    public String toString() {
      StringBuilder s = new StringBuilder();
      
      s.append("Tipo: Empresarial\n");
      s.append(super.toString());
        
      return s.toString();
    }
    
    
    public Empresarial clone() {
        return new Empresarial(this);
    }
}