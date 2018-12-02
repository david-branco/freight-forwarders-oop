public class CargaToxica extends Carga {

    public CargaToxica() {
        super();
    }

    public CargaToxica(double peso, double altura,int unidades) {
        super(peso,altura,unidades);
    }
    
    public CargaToxica(Carga c) {
        super(c);
    }
 
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        CargaToxica c = (CargaToxica) obj;
        return (super.equals(c));
    }
    
      public String toString() {
      StringBuilder s = new StringBuilder();
      
      s.append("Tipo de carga: Toxica\n");
      s.append(super.toString());
        
      return s.toString();
    }
    
    public CargaToxica clone() {
        return new CargaToxica(this);
    }
}