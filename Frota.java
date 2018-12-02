import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.Serializable;

public class Frota implements Serializable {  
    
    //Variáveis de Classe
    public static int percentagemParaSair = 60;

    //Variáveis de Instância
    private Map<Integer,Veiculo> veiculosNaGaragem;
    private Map<Integer,Veiculo> veiculosEmViagem;
    private int numIDFrota = 1;

    //Construtores
    public Frota() {
        this.veiculosNaGaragem = new TreeMap<Integer,Veiculo>();
        this.veiculosEmViagem = new TreeMap<Integer,Veiculo>();
    }
        
    public Frota(Map<Integer,Veiculo> veicsNaGaragem, Map<Integer,Veiculo> veicsEmViagem) {    
        
        this.veiculosNaGaragem = new TreeMap<Integer,Veiculo>();
        for(Veiculo v : veicsNaGaragem.values())
            this.veiculosNaGaragem.put(v.getNumID(),v.clone());
            
        this.veiculosEmViagem = new TreeMap<Integer,Veiculo>();
            for(Veiculo v : veicsEmViagem.values())
                this.veiculosEmViagem.put(v.getNumID(),v.clone());
     }
    
    public Frota(Frota f) {
        
        this.veiculosNaGaragem = new TreeMap<Integer,Veiculo>();
        for(Veiculo v : f.getVeiculosNaGaragem().values())
            this.veiculosNaGaragem.put(f.getNumIDFrota(),v.clone());
           
        this.veiculosEmViagem = new TreeMap<Integer,Veiculo>();
        for(Veiculo v : f.getVeiculosEmViagem().values())
            this.veiculosEmViagem.put(f.getNumIDFrota(),v.clone());
    }

    /** Gets */
    public Integer getNumIDFrota() { return numIDFrota; }
    
    public Map<Integer,Veiculo> getVeiculosNaGaragem() {
        TreeMap<Integer,Veiculo> aux = new TreeMap<Integer,Veiculo>();
        for(Veiculo v : this.veiculosNaGaragem.values())
            aux.put(v.getNumID(),v.clone());
        return aux;
    }

    public Map<Integer,Veiculo> getVeiculosEmViagem() {
        TreeMap<Integer,Veiculo> aux = new TreeMap<Integer,Veiculo>();
        for(Veiculo v : this.veiculosEmViagem.values())
            aux.put(v.getNumID(),v.clone());
        return aux;
    }    
    
    /** Sets */
    
    public void setNumIDFrota(int novoNumIDFrota) { numIDFrota = novoNumIDFrota; }
    
    /** Determinar total da frota */
    public int totalFrota() {
        return (veiculosNaGaragem.size() + veiculosEmViagem.size());
    }
    
    /** Inserir novo veiculo na Frota */
    public Integer inserirVeiculo(Veiculo v) throws FrotaException {
        boolean jaPertence = verificarVeiculoNaGaragem(v.getMatricula());
        if (jaPertence) 
            throw
                new FrotaException("O veiculo de matricula " +v.getMatricula()+ " já pertence à Frota!");
        else { 
            v.setNumID(numIDFrota);
            this.veiculosNaGaragem.put(this.numIDFrota,v.clone());
            this.numIDFrota++; 
        }
        return numIDFrota-1;
    }
    
     public void inserirVeiculoMantemNum(Veiculo v) throws FrotaException {
        boolean jaPertence = verificarVeiculoNaGaragem(v.getMatricula());
        if (jaPertence) 
            throw
                new FrotaException("O veiculo de matricula " +v.getMatricula()+ " já pertence à Frota!");
        else { 
            this.veiculosNaGaragem.put(v.getNumID(),v.clone());
        }
    }
    
    /** Por um veiculo em Viagem, dado o seu ID */
    public void porVeiculoEmViagem(Integer i) throws FrotaException {
        Veiculo v = veiculosNaGaragem.get(i);
        if (v == null) 
            throw
                new FrotaException("O Veiculo que especificou não está na Garagem !!");
        else {
            this.veiculosEmViagem.put(i,v.clone());
            this.veiculosNaGaragem.remove(i);
        }
    }

    /** Retornar para a Garagem um Veiculo em Viagem, dado o seu ID */
    public void retornarVeiculoDeViagem(Integer i) throws FrotaException {
        Veiculo v = veiculosEmViagem.get(i);
        if (v == null) 
            throw
                new FrotaException("O Veiculo que especificou não estava em Viagem !!");
        else {
            v.setPercCargaOcupada(0);
            this.veiculosNaGaragem.put(i,v.clone());
            this.veiculosEmViagem.remove(i);
        } 
    }

    /** Remover um veiculo da frota, dado o seu ID */
    public Veiculo removeVeiculo(Integer i) throws FrotaException {
        Veiculo v = veiculosNaGaragem.get(i);
        Veiculo vr;
        if (v != null)
            vr = this.veiculosNaGaragem.remove(i);
        else {
            v = veiculosEmViagem.get(i);
            if (v != null)
                vr = this.veiculosEmViagem.remove(i);
            else {
                throw
                    new FrotaException("O Veiculo que especificou não pertence á Frota !!");
            }
        }
        return vr;
    }
    
    /** Devolver um veiculo, dado o seu ID */
    public Veiculo getVeiculo(Integer i) throws FrotaException {
        Veiculo aux = veiculosNaGaragem.get(i);     
        if (aux != null)
            return aux.clone();
        else {
           aux = veiculosEmViagem.get(i);
            if (aux != null)
                return aux.clone();
            else {
                throw new FrotaException("Não existe o ID que especificou\n");
            }
        }       
    }
    
    /** Verificar se um veiculo está na Garagem, pela sua matricula*/       
    public boolean verificarVeiculoNaGaragem(String matricula) {
        boolean pertence = false;
        for(Veiculo v : veiculosNaGaragem.values())
            if (matricula == v.getMatricula())
                return pertence = true;
        return pertence;
    }

    /** Verificar se um veiculo está em Viagem, pelo ID */                          
    public boolean verificarVeiculoEmViagem(Integer i) {     
        return this.veiculosEmViagem.containsKey(i);
    }
    
    /** Verificar se um veiculo pertence á Frota */                                
    public boolean verificarVeiculoNaFrota(Integer i) {
        Veiculo v = veiculosNaGaragem.get(i);
        return (verificarVeiculoNaGaragem(v.getMatricula()) || verificarVeiculoEmViagem(i));
    }
 
    /** Representacao como texto de uma Frota */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("--------------- FROTA ---------------\n");
        s.append("------- Total de Veiculos: " +totalFrota()+ " --------\n");

        s.append("-------- Veiculos na Garagem --------\n");
        for(Veiculo v : veiculosNaGaragem.values())
            s.append(v.toString());
         
        s.append("-------- Veiculos em Viagem ---------\n"); 
        for(Veiculo v : veiculosEmViagem.values())
            s.append(v.toString());

        return s.toString();
    }
    
    /** Listagem dos Veiculos na Garagem */
    public String listarVeiculosNaGaragem() {
        StringBuilder s = new StringBuilder();
        s.append("-------- Veiculos na Garagem --------\n");
        for(Veiculo v : veiculosNaGaragem.values())
            s.append(v.toString());
        
        return s.toString();
    }
    
    public String listarVeiculosNaGaragemOrdCarga() {
        StringBuilder s = new StringBuilder();
        TreeSet<Veiculo> sortedVeiculos = new TreeSet<Veiculo>(new VeiculoComparator());
        
        if(veiculosNaGaragem.size() == 0) {
            s.append("Não existem veiculos na garagem\n");
        }
        else {
            for(Veiculo v : veiculosNaGaragem.values()) {
                sortedVeiculos.add(v.clone());
            }
        
            for(Veiculo v : sortedVeiculos) {
                s.append(v.toString() + "\n\n");
            }
        }
        
        return s.toString();
    }
    
    /** Listagem dos Veiculos em Viagem */
    public String listarVeiculosEmViagem() {
        StringBuilder s = new StringBuilder();
        s.append("-------- Veiculos em Viagem ---------\n"); 
        for(Veiculo v : veiculosEmViagem.values()) 
            s.append(v.toString());
         
        return s.toString();
    }
    
    /** Informação de um veiculo na frota, dado o seu ID */
    public String listarInfoVeiculo(Integer i) throws FrotaException {
        Veiculo v = veiculosNaGaragem.get(i);     
        if (v != null)
            return v.toString();
        else {
            v = veiculosEmViagem.get(i);
            if (v != null)
                return v.toString();
            else {
                throw
                    new FrotaException("O Veiculo " +v.getNumID()+ " não pertence á Frota !!");
            }
        }       
    }
    
    /**Actualiza o campo percCargaOcupada */        
    public void actualizaPercCargaOcupada(Integer i, double novoValor) throws FrotaException {
        Veiculo v = veiculosNaGaragem.get(i), aux = v.clone();
        if (v == null)
            throw
                new FrotaException("O Veiculo " +v.getNumID()+ " não está na Garagem !!");
        else {
            aux.actualizaPercCargaOcupada(novoValor);
            if (aux.getPercCargaOcupada() > 100) 
                throw
                    new FrotaException("O Veiculo " +v.getNumID()+ " não tem capacidade de carga livre para a nova carga !!");
            else {
                v.actualizaPercCargaOcupada(novoValor);
            }
        }         
    }
    
    /** Listagem de todos Veiculos na Garagem com a Percentagem de Carga Ocupada acima de um dado valor */
    public String listarVeiculosComPercAcimaDe(double perc) { 
        StringBuilder s = new StringBuilder();
        s.append("-- Veiculos com percentagem de carga ocupada acima de " +perc+ " --\n");
        for(Veiculo v : veiculosNaGaragem.values()) 
            if (v.getPercCargaOcupada() > perc) 
                s.append(v.toString());

        return s.toString();
    }

    /** Devolve uma lista com os Veiculos na Garagem com a Percentagem de Carga Ocupada acima de um dado valor */
    public List<Veiculo> listaDeVeiculosComPercAcimaDe(double perc) { 
        ArrayList<Veiculo> aux = new ArrayList<Veiculo>();
        for (Veiculo v : veiculosNaGaragem.values()) 
            if (v.getPercCargaOcupada() > perc) 
                aux.add(v.clone());
        return aux;
    }
  
    /** Copia da Frota */
    public Frota clone() { return new Frota(this); }
   
    /** método equals() standard - recebe Object como parâmetro */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if((obj == null) || (this.getClass() != obj.getClass())) return false;
        Frota f = (Frota) obj;
        return (this.numIDFrota == f.getNumIDFrota() && this.veiculosNaGaragem.equals(f.getVeiculosNaGaragem()) && this.veiculosEmViagem.equals(f.getVeiculosEmViagem()));
    }
    

   /** Gravar uma instância em ficheiro */
    public void gravaTxt(String fich) throws IOException {
        try {
            PrintWriter pw = new PrintWriter(fich);
            pw.print(this);
            pw.flush();
            pw.close();
        }
        catch(IOException e) { throw e; }
    }

    /** Grava um objecto em ficheiro */
    public void gravaObj(String fich) throws IOException {
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(fich));
        try {
            oout.writeObject(this);
        }
        catch(IOException e) { System.out.println(e.getMessage()); }
        oout.flush();
        oout.close();
    }
}   