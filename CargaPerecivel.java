public class CargaPerecivel extends Carga {

    public CargaPerecivel() {
        super();
    }

    public CargaPerecivel(double peso, double altura,int unidades) {
        super(peso,altura,unidades);
    }
    
    public CargaPerecivel(Carga c) {
        super(c);
    }
 
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        CargaPerecivel c = (CargaPerecivel) obj;
        return (super.equals(c));
    }
    
    public String toString() {
      StringBuilder s = new StringBuilder();
      
      s.append("Tipo de carga: Perecivel\n");
      s.append(super.toString());
        
      return s.toString();
    }
    
    public CargaPerecivel clone() {
        return new CargaPerecivel(this);
    }
}