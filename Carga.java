import java.io.Serializable;

public abstract class Carga implements Serializable {

    private double peso;
    private double altura;
    private int unidades;
  
    public Carga() {
        peso = 0;
        altura = 0;
        unidades = 0;
    }
    
    public Carga(double peso, double altura,int unidades) {
        
        this.peso = peso;
        this.altura = altura;
        this.unidades = unidades;        
            
    }
    
    public Carga(Carga c) {
        
        this.peso = c.getPeso();
        this.altura = c.getAltura();
        this.unidades = c.getUnidades();
    }
    
    public double getPeso() { return peso; }
    public double getAltura() { return altura; }
    public int getUnidades() { return unidades; }
    
    public void setPeso(double peso) { this.peso =  peso; }
    public void setAltura(double altura) { this.altura = altura; }
    public void setUnidades(int unidades) { this.unidades = unidades; }
    
    public boolean cabeCarga(Carga c) {
        if(c.getPeso() <= this.peso && c.getAltura() <= this.altura && c.getUnidades() <= this.unidades) return true;
        else return false;
    }
    
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        Carga c = (Carga) obj;
        return (peso == c.getPeso() && altura == c.getAltura() && unidades == c.getUnidades());
    }
    
    public String toString() {
        StringBuilder s = new StringBuilder();
        
        s.append("Peso: " + peso + "\n");
        s.append("Altura: " + altura + "\n");
        s.append("Unidades: " + unidades + "\n");
        
        return s.toString();
    }
    
    public abstract Carga clone();
}
