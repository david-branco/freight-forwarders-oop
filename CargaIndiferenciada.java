public class CargaIndiferenciada extends Carga {

    public CargaIndiferenciada() {
        super();
    }

    public CargaIndiferenciada(double peso, double altura,int unidades) {
        super(peso,altura,unidades);
    }
    
    public CargaIndiferenciada(Carga c) {
        super(c);
    }
 
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        CargaIndiferenciada c = (CargaIndiferenciada) obj;
        return (super.equals(c));
    }
    
    public String toString() {
      StringBuilder s = new StringBuilder();
      
      s.append("Tipo de carga: Indiferenciada\n");
      s.append(super.toString());
        
      return s.toString();
    }
    
    public CargaIndiferenciada clone() {
        return new CargaIndiferenciada(this);
    }
}