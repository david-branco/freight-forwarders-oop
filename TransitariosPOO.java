import static java.lang.System.out;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.lang.Integer;
import java.lang.Double;
import java.lang.Boolean;
import java.lang.String;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;
import java.util.GregorianCalendar;
import java.util.TreeMap;

public class TransitariosPOO {
    
    private static Produtos produtos = new Produtos();
    private static Clientes clientes = new Clientes();
    private static Encomendas encomendas = new Encomendas();
    private static Frota frota = new Frota();

    public static void main(String[] args) {
        int i;
        String comando;
        StringTokenizer st;
        String comandos[] = new String[5];
        
        printComandos();
        
        for(;;) {
            for(i = 0; i < 5; i++) {
                comandos[i] = null;
            }
            
            comando = Input.lerString();

            st = new StringTokenizer(comando);
            
            for(i = 0; i < 5 && st.hasMoreTokens(); i++) {
                comandos[i] = st.nextToken();
            }
            
            if(comandos[0] == null) {
                out.println("Não inseriu nenhum comando\n");
                continue;
            }
            
            switch(comandos[0]) {
                case "Ver":
                    switch(comandos[1]) {                        
                        case "Produto": 
                            if(comandos[2] != null) {
                                verProduto(comandos[2]);
                            }
                            else out.println("Não inseriu um ID de Produto\n");
                            break;
                            
                        case "Produtos":
                            out.println(produtos.toString());
                            break;
                            
                        case "Cliente":
                            if(comandos[2] != null) {
                                verCliente(comandos[2]);
                            }
                            else out.println("Não inseriu um ID de Cliente\n");
                            break;
                            
                        case "Clientes":
                            out.println(clientes.ordValorContratado());
                            break;
                            
                        case "Encomenda":
                            if(comandos[2] != null) {
                                verEncomenda(comandos[2]);
                            }
                            else out.println("Não inseriu um ID de Cliente\n");
                            break;
                        
                        case "Encomendas":
                            out.println(encomendas.toString());
                            break;
                        
                        case "Veiculo":
                            if(comandos[2] != null) {
                                verVeiculo(comandos[2]);
                            }
                            else out.println("Não inseriu um ID de Veiculo\n");
                            break;
                            
                        case "Veiculos":
                            out.println(frota.toString());
                            break;
                            
                        case "VeiculosEmTransporte":
                            out.println(frota.listarVeiculosEmViagem());
                            break;
                            
                        case "VeiculosParados":
                            out.println(frota.listarVeiculosNaGaragemOrdCarga());
                            break;
                            
                        case "GesVars":
                            verGesVars();
                            break;
                                                  
                        default:
                            out.println("Comando não reconhecido\n");
                            break;  
                    }
                    break;
                    
               case "Adicionar":
                   switch(comandos[1]) {
                       case "Produto":
                           adicionarProduto();
                           break;
                           
                       case "Cliente":
                           adicionarCliente();
                           break;
                           
                       case "Encomenda":
                           adicionarEncomenda();
                           break;
                           
                       case "Veiculo":
                           adicionarVeiculo();
                           break;
                           
                       default:
                           out.println("Comando não reconhecido");
                           break;       
                   }
                   break;
                   
               case "Modificar":
                    switch(comandos[1]) {
                        case "Produto":
                            if(comandos[2] != null) {
                                modificarProduto(comandos[2]);
                            }
                            else out.println("Não inseriu um ID de produto\n");
                            break;
                       
                        case "Cliente":
                            if(comandos[2] != null) {
                                modificarCliente(comandos[2]);
                            }
                            else out.println("Não inseriu um ID de cliente\n");
                            break;
                                                        
                        case "Veiculo":
                            if(comandos[2] != null) {
                                modificarVeiculo(comandos[2]);
                            }
                            else out.println("Não inseriu um ID de veículo\n");
                            break;
                            
                        case "GesVars":
                            modificarGesVars();
                            break;
                                                
                        default:
                            out.println("Comando não reconhecido");
                            break;
                    }
                    break;
                           
               case "Remover":
                   switch(comandos[1]) {
                        case "Produto":
                            if(comandos[2] != null) {
                                removerProduto(comandos[2]);
                            }
                            else out.println("Não inseriu um ID de produto\n");
                            break;
                       
                        case "Cliente":
                            if(comandos[2] != null) {
                                removerCliente(comandos[2]);
                            }
                            else out.println("Não inseriu um ID de cliente\n");
                            break;
                            
                        case "Encomenda":
                            if(comandos[2] != null) {
                                removerEncomenda(comandos[2]);
                            }
                            else out.println("Não inseriu um ID de encomenda\n");
                            break;
                            
                        case "Veiculo":
                            if(comandos[2] != null) {
                                removerVeiculo(comandos[2]);
                            }
                            else out.println("Não inseriu um ID de veiculo\n");
                            break;
                                           
                        default:
                            out.println("Comando não reconhecido");
                            break;
                   }
                   break;
               
               case "Despachar":
                   if(comandos[1] != null) {
                       despachar(comandos[1]);
                   }
                   else out.println("Não inseriu um ID de veiculo\n");
                   break;
                    
                    
               case "Retornar":
                   if(comandos[1] != null) {
                       retornar(comandos[1]);
                    }
                    else out.println("Não inseriu um ID de veiculo\n");
                    break;
                
               case "Guardar":
                   guardar();
                   break;
               
               case "Abrir":
                   abrir();
                   break;               
                   
               case "Sair":
                   System.exit(0);
                   break;
                   
               case "?":
                   printComandos();
                   break;
               
               default:
                   out.println("Comando não reconhecido\n");
                           
            }
           
        }
    }     
    
    public static void verProduto(String num) {
        Produto prod;
        Integer id = new Integer(num);
        
        prod = produtos.getProduto(id);
        if(prod == null) out.println("Não existe o ID que especificou\n");
        else out.println(prod.toString());
    }
    
    public static void verCliente(String num) {
        Cliente cli;
        Integer id = new Integer(num);

        cli = clientes.getCliente(id);
        if(cli == null) out.println("Não existe o ID que especificou\n");
        else out.println(cli.toString());
    }
    
    public static void verEncomenda(String num) {
        Encomenda enc;
        Integer id = new Integer(num);

        enc = encomendas.getEncomenda(id);
        if(enc == null) out.println("Não existe o ID que especificou\n");
        else out.println(enc.toString());
    }
    
    public static void verVeiculo(String num) {
        Veiculo vei;
        Integer id = new Integer(num);

        try  {
            vei = frota.getVeiculo(id);
            out.println(vei.toString());
        }
        catch(FrotaException e) { out.println(e.getMessage()); }
    }
    
    public static void verProdutos() {
        produtos.toString();
    }
    
    public static void verClientes() {
        clientes.toString();
    }
    
    public static void verEncomendas() {
        encomendas.toString();
    }
    
    public static void verVeiculos() {
        frota.toString();
    }
    
    public static void verGesVars() {        
        out.println("Preço Base dos Camioes: " + Camiao.pB);
        out.println("Preço Base dos Furgoes: " + Furgao.pB);
        out.println("Preço Base das Vans: " + Van.pB);
        out.println("Coeficiente X dos Furgoes: " + Furgao.coefX);
        out.println("Percentagem pra sair um veiculo: " + Frota.percentagemParaSair);
    }        
    
    public static void adicionarProduto() {
        Produto prod = new Produto();
        int iaux;
        Carga carga = null;
        String saux;
        String tipo = null;
        double daux;
        
        out.println("Nome do produto: ");
        saux = Input.lerString();
        prod.setNome(saux);
        
        while(carga == null) {
            out.println("\nTipo de carga (Perecivel/Toxica/Indiferenciada): ");
            tipo = Input.lerString();
        
            switch(tipo) {
                case "Perecivel":
                    carga = new CargaPerecivel();
                    break;
                
                case "Toxica":        
                    carga = new CargaToxica();
                    break;
           
                case "Indiferenciada":
                    carga = new CargaIndiferenciada();
                    break;
                
                default:
                    out.println("A carga pode ser Perecivel Toxica ou Indiferenciada\n");
            }
        }
        
        out.println("\nPeso Máximo (kgs): ");
        daux = Input.lerDouble();
        carga.setPeso(daux);
        out.println("\nAltura Máxima (metros): ");
        daux = Input.lerDouble();
        carga.setAltura(daux);
        out.println("\nNumero de Unidades: ");
        iaux = Input.lerInt();
        carga.setUnidades(iaux);
        out.println("\nDesconto: ");
        daux = Input.lerDouble();
        prod.setDesconto(daux);
        prod.setCarga(carga);
        produtos.addProduto(prod);
        
        out.println("Produto adicionado com sucesso\n");
    }
    
    public static void adicionarCliente() {
        String tipocliente;
        String saux;
        int iaux;
        Cliente cli = null;
        Integer id;
        
        while(cli == null) {
            out.println("\nTipo de cliente (Empresarial/Individual): ");
            tipocliente = Input.lerString();
                           
            if(tipocliente.equals("Individual")) {
                cli = new Individual();
            }
            else if(tipocliente.equals("Empresarial")) {
                cli = new Empresarial();
            }
            else {
                out.println("O tipo de cliente que especificou não está correcto, o cliente pode ser Individual ou Empresarial\n");
            }
        }
        
        out.println("\nNome: ");
        saux = Input.lerString();
        cli.setNome(saux);
        out.println("\nMorada: ");
        saux = Input.lerString();
        cli.setMorada(saux);
        out.println("\nNúmero de Contribuinte: ");
        saux = Input.lerString();
        cli.setNumContrib(saux);
        id = clientes.addCliente(cli);
        cli.setNumCliente(id);
        
        cli.toString();
        out.println("Cliente adicionado com sucesso\n");
    }
    
    public static void adicionarEncomenda() {
        Encomenda enc = new Encomenda();
        Carga carga = null;
        Integer id;
        Produto prod;
        Veiculo vei = null;
        Cliente cli;
        Camiao camiao;
        Furgao furgao;
        Van van;
        int iaux;
        double daux;
        String saux;
        String tipocarga;
        String tipoveiculo;
        double preco = 0;
        GregorianCalendar data = new GregorianCalendar();
        
        out.println("\nNúmero do cliente: ");
        iaux = Input.lerInt();
        enc.setNumCliente(iaux);
        
        id = new Integer(iaux);
        cli = clientes.getCliente(iaux);
        
        //Carga a transportar
        out.println("\nTipo de carga (Indiferenciada/Perecivel/Toxica): ");
        tipocarga = Input.lerString();
        
        switch(tipocarga) {
            case "Perecivel":
                carga = new CargaPerecivel();
                break;
            
            case "Indiferenciada":
                carga = new CargaIndiferenciada();
                break;
            
            case "Toxica":
                carga = new CargaToxica();
                break;
        }
        
        out.println("\nPeso da carga: ");
        daux = Input.lerDouble();
        carga.setPeso(daux);
        out.println("\nAltura da carga: ");
        daux = Input.lerDouble();
        carga.setAltura(daux);
        out.println("\nUnidades: ");
        iaux = Input.lerInt();
        carga.setUnidades(iaux);
        enc.setCarga(carga);
        
        //Listar veículos que possam servir e tratar de actualizar o veículo.
        out.println("Veículos na garagem adequados para transportar esta carga:");
        melhorVeiculo(carga);
        out.println("\nNúmero do veículo: ");
        iaux = Input.lerInt();
        enc.setVeiculo(iaux);
        
        id = Integer.valueOf(iaux);
        
        try  {
            vei = frota.getVeiculo(id);
            vei.actualizaPercCargaOcupada(carga.getPeso());            
            tipoveiculo = vei.getClass().getSimpleName();
            frota.removeVeiculo(vei.getNumID());
            frota.inserirVeiculoMantemNum(vei);
        }
        catch(FrotaException e) { 
            out.println(e.getMessage());
            return;
        }
        
        //Calcular Preço
        switch(tipoveiculo) {
            case "Camiao":
                camiao = (Camiao) vei;
                preco = camiao.getCoefY() * camiao.getPB() + camiao.getCoefX() * (camiao.getCapUtilCarga() - carga.getPeso());
                break;
                
            case "FurgaoNaoRefrigerado":
                
            case "FurgaoRefrigerado":
                furgao = (Furgao) vei;
                preco = furgao.getPB() + furgao.getCoefX() * (furgao.getCapUtilCarga() - carga.getPeso());
                break; 
            
            case "Van":
                van = (Van) vei;
                preco = van.getPB();
                break;
                
            default:
                out.println("Error ao calcular preco\n");
        }
        
        //Listar o melhor produto para esta carga
        preco = melhorProduto(carga,preco,enc);
        
        if(preco == -1) {
            return;
        }
        
        //Mete a data na encomenda
        enc.setData(data);
        
        //Mete o preço na encomenda
        enc.setPreco(preco);
        
        //Adiciona Encomenda e dá-nos o ID da mesma.
        id = encomendas.addEncomenda(enc);
        enc.setNumEnc(id);
        
        //Actualizar cliente por la o ID da encomenda e actualizar o valor contratado.
        cli.addNumEncomenda(id,preco);
        clientes.removeCliente(cli.getNumCliente());
        clientes.addClienteMantemNum(cli);
        
        enc.toString();        
        out.println("Encomenda adicionada com sucesso\n");
    }
    
    public static void adicionarVeiculo() {
        String tipoVeiculo = null;                                                
        String matriculaAux = null;
        String marcaAux = null;
        String modeloAux = null;
        double custoManutencaoAux = 0.0;
        double capUtilCargaAux = 0.0;
        boolean ok = false;
        
        while(!ok) {
            out.println("\nTipo do Veículo (Camiao/Furgao/Van): ");
            tipoVeiculo = Input.lerString();
        
            if (tipoVeiculo.equals("Camiao") || tipoVeiculo.equals("Furgao") || tipoVeiculo.equals("Van")) {
            out.println("Matricula do veiculo: ");
            matriculaAux = Input.lerString();
            out.println("Marca: ");
            marcaAux = Input.lerString();
            out.println("Modelo: ");
            modeloAux = Input.lerString();
            out.println("Custo de manutenção: ");
            custoManutencaoAux = Input.lerDouble();                                              
            out.println("Capacidade util de carga: ");
            capUtilCargaAux = Input.lerDouble();   
            ok = true;
            }
            else {
                out.println("O tipo de veículo que especificou não está correcto\n");
            }
        }
          
        switch(tipoVeiculo) {
            case "Camiao":
                adicionarCamiao(matriculaAux, marcaAux, modeloAux, custoManutencaoAux, capUtilCargaAux);            
                break;
            
            case "Furgao":
                adicionarFurgao(matriculaAux, marcaAux, modeloAux, custoManutencaoAux, capUtilCargaAux);
                break;
            
            case "Van":
                adicionarVan(matriculaAux, marcaAux, modeloAux, custoManutencaoAux, capUtilCargaAux);
                break;
                
            default:
                out.println("O tipo de Veículo que especificou não está correcto\n");            
        }
        
        out.println("Veículo adicionado com sucesso\n");
    }
    
     
    public static void adicionarCamiao(String matricula, String marca, String modelo, double custoManutencao, double capUtilCarga) {
        Camiao c;
        String nomeCondutorAux;
        Boolean atreladoAux;
        double altUtilCargaAux;
        Boolean coefAux;
        double coefXAux = 0.0;
        double coefYAux = 0.0;
        int id;
      
        out.println("Nome do Condutor: ");
        nomeCondutorAux = Input.lerString();
        out.println("Têm atrelado (true/false) : ");
        atreladoAux = new Boolean(Input.lerString());
        out.println("Altura util de carga: ");
        altUtilCargaAux = Input.lerDouble();
        out.println("Pretende utilizar os coeficientes de carga prédefinidos (true/false) : ");
        coefAux = new Boolean(Input.lerString());
        if (coefAux == true) 
            c = new Camiao(matricula, marca, modelo, custoManutencao, capUtilCarga, 0.0, 0, nomeCondutorAux, atreladoAux, altUtilCargaAux,20.0,40.0);      //Zeros = ID e %CargaOcupada Inicial
        else {     
            out.println("Coeficiente de X ");
            coefXAux = Input.lerDouble();
            out.println("Coeficiente de Y: ");
            coefYAux= Input.lerDouble();
            c = new Camiao(matricula, marca, modelo, custoManutencao, capUtilCarga, 0.0, 0, nomeCondutorAux, atreladoAux, altUtilCargaAux, coefXAux, coefYAux);
        }
        
        try  {
            id = frota.inserirVeiculo(c);
            c.setNumID(id);
            out.println(c.toString());
        }
        catch(FrotaException e) { 
            out.println(e.getMessage());
        }      
    }
        
    public static void adicionarFurgao(String matricula, String marca, String modelo, double custoManutencao, double capUtilCarga) {
        Furgao f = null;
        String combustivelAux;
        double autonomiaAux;
        String tipoAux;
        int id;
        
        out.println("Tipo de Combustivel: ");
        combustivelAux = Input.lerString();
        out.println("Autonomia : ");
        autonomiaAux = Input.lerDouble();
         
        while(f == null) {
            out.println("Tipo de Veiculo (Refrigerado/NaoRefrigerado) : ");
            tipoAux = Input.lerString();
            
            switch(tipoAux) {
                case "Refrigerado":
                    f = new FurgaoRefrigerado(matricula, marca, modelo, custoManutencao, capUtilCarga, 0.0, 0, combustivelAux, autonomiaAux); //Zeros = ID e %CargaOcupada Inicial 
                    try  {
                        id = frota.inserirVeiculo(f);
                        f.setNumID(id);
                        out.println(f.toString());
                    }
                    catch(FrotaException e) { out.println(e.getMessage()); }
                    break;
                
                case "NaoRefrigerado":
                    f = new FurgaoNaoRefrigerado(matricula, marca, modelo, custoManutencao, capUtilCarga, 0.0, 0, combustivelAux, autonomiaAux);
                    try  {
                        id = frota.inserirVeiculo(f);
                        f.setNumID(id);
                        out.println(f.toString());
                    }
                    catch(FrotaException e) { out.println(e.getMessage()); }
                    break;
                    
                default:
                    out.println("O tipo de Furgão que especificou não está correcto\n");            
            }
        }   
    }
        
    public static void adicionarVan(String matricula, String marca, String modelo, double custoManutencao, double capUtilCarga) {        
        Van v = new Van(matricula, marca, modelo, custoManutencao, capUtilCarga, 0.0, 0);
        int id;
        
        try  {
            id = frota.inserirVeiculo(v);
            v.setNumID(id);
            out.println(v.toString());
        }
        catch(FrotaException e) { out.println(e.getMessage()); }
    }    
    
    public static void modificarProduto(String num) {
        Produto prod;
        Integer id;
        double daux;
        String saux;
        int iaux;
        boolean ok = false;
        
        id = new Integer(num);
        prod = produtos.getProduto(id);
        if(prod == null) {
            out.println("Não existe o ID que especificou\n");
            return;
        }
        
        for(;;) {
            out.println("O que deseja modificar?\n1. Nome\n2. Carga\n3. Desconto\n");
            iaux = Input.lerInt();
            
            switch(iaux) {
                case 1:
                    out.println("Introduza o novo nome: ");
                    saux = Input.lerString();
                    prod.setNome(saux);
                    break;
                case 2:
                    prod.setCarga(modificarCarga(prod.getCarga()));
                    break;
                case 3:
                    out.println("Valor do Desconto: ");
                    daux = Input.lerDouble();
                    prod.setDesconto(daux);
                    break;
                    
                default:
                    out.println("Valor invalido\n");
                    continue;
            }
            
            out.println("Guardar alterações ao Produto ou deseja continuar a editar? (G/E)"); 
            saux = Input.lerString();
            if(saux.equals("G")) {
                removerProduto(num);
                produtos.addProdutoMantemNum(prod);
                return;
            }
        }
    }
    
    public static Carga modificarCarga(Carga c) {
        int iaux;
        double daux;
        String saux;
        
        for(;;) {
            out.println("O que deseja modificar?\n1. Peso\n2. Altura\n3. Unidades");
            iaux = Input.lerInt();
            
            switch(iaux) {
                case 1:
                    out.println("Introduza o novo Peso: ");
                    daux = Input.lerDouble();
                    c.setPeso(daux);
                    break;
                
                case 2:
                    out.println("Introduza a nova Altura: ");
                    daux = Input.lerDouble();
                    c.setAltura(daux);
                    break;
                    
                case 3:
                    out.println("Introduza o novo número de Unidades: ");
                    iaux = Input.lerInt();
                    c.setUnidades(iaux);
                    break;
                    
                default:
                    out.println("Não introduziu um campo válido\n");
                    return c;
            }
            
            out.println("Guardar alterações à Carga ou deseja continuar a editar? (G/E)"); 
            saux = Input.lerString();
            if(saux.equals("G")) {
                return c;
            }
        }
    }
    
    public static void modificarCliente(String num) {
        Cliente cli;
        Integer id;
        String saux;
        int iaux;
        
        id = new Integer(num);
        cli = clientes.getCliente(id);
        if(cli == null) {
            out.println("Não existe o ID que especificou\n");
            return;
        }
        
        for(;;) {
            out.println("O que deseja modificar?\n1. Nome\n2. Morada\n3. Número de contribuinte\n");
            iaux = Input.lerInt();
            
            switch(iaux) {
                case 1:
                    out.println("Introduza o novo nome: ");
                    saux = Input.lerString();
                    cli.setNome(saux);
                    break;
                case 2:
                    out.println("Introduza a nova morada: ");
                    saux = Input.lerString();
                    cli.setMorada(saux);
                    break;
                case 3:
                    out.println("Introduza o novo nº de contribuinte: ");
                    saux = Input.lerString();
                    cli.setNumContrib(saux);
                    break ;
            }
            
            out.println("Guardar alterações ao Cliente ou deseja continuar a editar? (G/E)"); 
            saux = Input.lerString();
            if(saux.equals("G")) {
                removerCliente(num);
                clientes.addClienteMantemNum(cli);
                return;
            }
        }
        
    }
    
    public static void modificarVeiculo(String num) { 
        Integer id = new Integer(num);
        String tipoVeiculo = null;  
        Veiculo v = null;
        
        try  {
            v = frota.getVeiculo(id);
        }
        catch(FrotaException e) { out.println(e.getMessage()); }
         
        
        if(v == null) {
            out.println("Não existe o veiculo com o ID que especificou\n");
            return;
        }
        
        tipoVeiculo = v.getClass().getSimpleName();
        
        switch(tipoVeiculo) {
            case "Camiao": 
                modificarCamiao((Camiao) v);
                break;
                    
            case "Van": modificarVan((Van) v);
                break;
    
            case "FurgaoRefrigerado": 
                        
            case "FurgaoNaoRefrigerado": 
                modificarFurgao((Furgao) v);    
                break;
                    
            default : out.println("Não introduziu um veiculo válido.");  
        }
    }
    
    public static void modificarCamiao(Camiao c) {
        String matriculaAux;                    //Variaveis de Camião                 
        String marcaAux;
        String modeloAux;
        double custoManutencaoAux;
        double capUtilCargaAux;
        double pBAux;
        double coefXAux;
        double coefYAux;
        String nomeCondutorAux;                               
        Boolean atreladoAux;
        double altUtilCargaAux;
        String saux;
        
        int opcaoAux;
        boolean continua = true;
        
        while (continua) {
            out.println("Que campo deseja alterar:\n1. Matricula\n2. Marca\n3. Modelo\n4. Custo de Manutenção\n5. Capacidade Util de Carga\n6. Nome do Condutor\n7. Altura Util de Carga\n8. Preço Base\n9. Coeficiente de X\n10. Coeficiente de Y\n11. Sair");  
            opcaoAux = Input.lerInt();
                switch(opcaoAux) {
                        case 1: out.println("Introduza a nova matricula: ");
                                matriculaAux = Input.lerString();
                                c.setMatricula(matriculaAux);
                                break;
        
                        case 2: out.println("Introduza a nova marca: ");
                                marcaAux = Input.lerString();
                                c.setMarca(marcaAux);
                                break;
                            
                        case 3: out.println("Introduza o novo modelo: ");
                                modeloAux = Input.lerString();
                                c.setModelo(modeloAux);
                                break;
                            
                        case 4: out.println("Introduza o Custo de Manutenção: ");
                                custoManutencaoAux = Input.lerDouble();
                                c.setCustoManutencao(custoManutencaoAux);
                                break;
                            
                        case 5: out.println("Introduza o Capacidade Util de Carga: ");
                                capUtilCargaAux = Input.lerDouble();
                                c.setCapUtilCarga(capUtilCargaAux); 
                                break;
                            
                        case 6: out.println("Nome do Condutor: ");
                                nomeCondutorAux = Input.lerString();
                                c.setNomeCondutor(nomeCondutorAux); 
                                break;    
                                            
                        case 7: out.println("Possui atrelado (true/false) : ");
                                atreladoAux = new Boolean(Input.lerString());
                                c.setAtrelado(atreladoAux); 
                                break;
                            
                        case 8: out.println("Preço Base: ");
                                pBAux = Input.lerDouble();
                                c.setPB(pBAux); 
                                break;
                            
                        case 9: out.println("Coeficiente de X: ");
                                coefXAux = Input.lerDouble();
                                c.setCoefX(coefXAux); 
                                break;
                            
                        case 10: out.println("Coeficiente de Y: ");
                                 coefYAux = Input.lerDouble();
                                 c.setCoefY(coefYAux); 
                                 break;
                            
                        case 11: continua = false;
                                 break;
                         
                        default : out.println("Não introduziu uma opção válida");  
                    }
                    
                if(opcaoAux != 11) {
                    out.println("Guardar alterações ao Veiculo ou deseja continuar a editar? (G/E): ");
                    saux = Input.lerString();
                    if(saux.equals("G")) {
                        continua = false;
                        try {
                            frota.removeVeiculo(c.getNumID());
                            frota.inserirVeiculoMantemNum(c);
                        }
                        catch(FrotaException e) {
                            out.println(e);
                        }
                    }
                    else {
                        continua = true;
                    }
                }
        }
    }
    
    public static void modificarVan(Van v) {    
        String matriculaAux;
        String marcaAux;
        String modeloAux;
        double custoManutencaoAux;
        double capUtilCargaAux;
        double pBAux;
        String saux;
        
        int opcaoAux;
        boolean continua = true;
        
        while (continua) {
            out.println("Que campo deseja alterar:\n1. Matricula\n2. Marca\n3. Modelo\n4. Custo de Manutenção\n5. Capacidade Util de Carga\n6. Preço Base\n7. Sair");  
            opcaoAux = Input.lerInt();
                switch(opcaoAux) {
                        case 1: out.println("Introduza a nova matricula: ");
                                matriculaAux = Input.lerString();
                                v.setMatricula(matriculaAux);
                                break;
        
                        case 2: out.println("Introduza a nova marca: ");
                                marcaAux = Input.lerString();
                                v.setMarca(marcaAux);
                                break;
                            
                        case 3: out.println("Introduza o novo modelo: ");
                                modeloAux = Input.lerString();
                                v.setModelo(modeloAux);
                                break;
                            
                        case 4: out.println("Introduza o Custo de Manutenção: ");
                                custoManutencaoAux = Input.lerDouble();
                                v.setCustoManutencao(custoManutencaoAux);
                                break;
                            
                        case 5: out.println("Introduza o Capacidade Util de Carga: ");
                                capUtilCargaAux = Input.lerDouble();
                                v.setCapUtilCarga(capUtilCargaAux); 
                                break;
                                
                        case 6: out.println("Preço Base: ");
                                pBAux = Input.lerDouble();;
                                v.setPB(pBAux); 
                                break;        
                            
                        case 7: continua = false;
                                break;
    
                        default : out.println("Não introduziu uma opção válida!!");  
                    }
                    
                if(opcaoAux != 7) {
                    out.println("Guardar alterações ao Veiculo ou deseja continuar a editar? (G/E): ");
                    saux = Input.lerString();
                    if(saux.equals("G")) {
                        continua = false;
                        try {
                            frota.removeVeiculo(v.getNumID());
                            frota.inserirVeiculoMantemNum(v);
                        }
                        catch(FrotaException e) {
                            out.println(e);
                        }
                    }
                    else {
                        continua = true;
                    }
                }
        }
    }
        
    public static void modificarFurgao(Furgao f) {        
        String matriculaAux;                    //Variaveis de Camião                 
        String marcaAux;
        String modeloAux;
        double custoManutencaoAux;
        double capUtilCargaAux;
        String combustivelAux; 
        double autonomiaAux;
        double pBAux;
        double coefXAux;
        String saux;

        int opcaoAux;
        boolean continua = true;
        
        while (continua) {
            out.println("Que campo deseja alterar:\n1. Matricula\n2. Marca\n3. Modelo\n4. Custo de Manutenção\n5. Capacidade Util de Carga\n6. Combustivel\n7. Autonomia\n8. Preço Base\n9 Coeficiente de X\n10. Sair");  
            opcaoAux = Input.lerInt();
                switch(opcaoAux) {
                        case 1: out.println("Introduza a nova matricula: ");
                                matriculaAux = Input.lerString();
                                f.setMatricula(matriculaAux);
                                break;
        
                        case 2: out.println("Introduza a nova marca: ");
                                marcaAux = Input.lerString();
                                f.setMarca(marcaAux);
                                break;
                            
                        case 3: out.println("Introduza o novo modelo: ");
                                modeloAux = Input.lerString();
                                f.setModelo(modeloAux);
                                break;
                            
                        case 4: out.println("Introduza o Custo de Manutenção: ");
                                custoManutencaoAux = Input.lerDouble();
                                f.setCustoManutencao(custoManutencaoAux);
                                break;
                            
                        case 5: out.println("Introduza o Capacidade Util de Carga: ");
                                capUtilCargaAux = Input.lerDouble();
                                f.setCapUtilCarga(capUtilCargaAux); 
                                break;
                            
                        case 6: out.println("Tipo de combustivel: ");
                                combustivelAux = Input.lerString();
                                f.setCombustivel(combustivelAux); 
                                break;    
                            
                        case 7: out.println("Autonomia: ");
                                autonomiaAux = Input.lerDouble();
                                f.setAutonomia(autonomiaAux); 
                                break;
                            
                        case 8: out.println("Preço Base: ");
                                pBAux = Input.lerDouble();
                                f.setPB(pBAux); 
                                break;
                            
                        case 9: out.println("Coeficiente de X: ");
                                coefXAux = Input.lerDouble();
                                f.setCoefX(coefXAux); 
                                break;
                            
                        case 10: continua = false;
                                 break;
                         
                        default : out.println("Não introduziu uma opção válida!!");  
                    }
                    
                if(opcaoAux != 10) {
                    out.println("Guardar alterações ao Veiculo ou deseja continuar a editar? (G/E): ");
                    saux = Input.lerString();
                    if(saux.equals("G")) {
                        continua = false;
                        try {
                            frota.removeVeiculo(f.getNumID());
                            frota.inserirVeiculoMantemNum(f);
                        }
                        catch(FrotaException e) {
                            out.println(e);
                        }
                    }
                    else {
                        continua = true;
                    }
                }
        }
    }           

    public static void modificarGesVars() {
        boolean continua = true;
        int escolha;
        int iaux;
        double daux;
        String saux;
        
        while(continua) {
            out.println("Que campo deseja alterar?\n1. Preço Base dos Camioes\n2. Preço Base dos Furgoes\n3. Preço Base das Vans\n4. Coeficiente X dos Furgoes\n5. Percentagem para sair um veículo");
            escolha = Input.lerInt();
        
            switch(escolha) {
                case 1:
                    out.println("Introduza o novo preço base para os camioes:");
                    daux = Input.lerDouble();
                    Camiao.pB = daux;
                    break;
                    
                case 2:
                    out.println("Introduza o novo preço base para os furgoes:");
                    daux = Input.lerDouble();
                    Furgao.pB = daux;
                    break;                    
                    
                case 3:
                    out.println("Introduza o novo preço base para as vans:");
                    daux = Input.lerDouble();
                    Van.pB = daux;
                    break;
                    
                case 4:
                    out.println("Introduza o novo coeficiente X para os furgoes:");
                    daux = Input.lerDouble();
                    Furgao.coefX = daux;
                    break;
                    
                case 5:
                    out.println("Introduza a nova percentagem para sair um veículo:");
                    iaux = Input.lerInt();
                    Frota.percentagemParaSair = iaux;
                    break;                    
                    
                default:
                    out.println("Não introduziu uma opção válida\n");
            }
            
            out.println("Guardar alterações ou deseja continuar a editar? (G/E)");
            saux = Input.lerString();
            if(saux.equals("G")) {
                continua = false;
            }
            else {
                continua = true;
            }
        }
    }
    
    public static void removerProduto(String num) {
        Integer id = new Integer(num);
        Produto prod;
        
        prod = produtos.removeProduto(id);
        if(prod==null) out.println("Produto referenciado não existe\n");
    }
    
    public static void removerCliente(String num) {
        Integer id = new Integer(num);
        Cliente cli;
        
        cli = clientes.removeCliente(id);
        if(cli == null) out.println("Cliente referenciado não existe\n");
    }
    
    public static void removerEncomenda(String num) {
        Integer id = new Integer(num);
        Encomenda enc;
        
        enc = encomendas.removeEncomenda(id);
        if(enc == null) out.println("Encomenda referenciada não existe\n");
    }
    
    public static void removerVeiculo(String num) {
        Integer id = new Integer(num);
        Veiculo vei = null;

        try  {
            vei = frota.removeVeiculo(id);
        }
        catch(FrotaException e) { out.println(e.getMessage()); }
    }
        
    public static double melhorProduto(Carga c1, Double preco, Encomenda enc) {
        Produto prod = null;
        double precoComDesconto = preco;
        double produtosPrecisos;
        double precop = preco;
        double pesop;
        double pesoc = c1.getPeso();
        Carga c2;
        String saux;
        int iaux;
        
        for(Produto p : produtos.getProdutos().values()) {
            c2 = p.getCarga();
            if(c2.getClass().equals(c1.getClass())) {
                pesop = c2.getPeso();
                if(pesop < pesoc) {
                    produtosPrecisos = (pesoc / pesop);
                    precop = preco * produtosPrecisos;
                }
                if(p.getDesconto() > 0) {
                    precop = preco - ((preco * p.getDesconto())/100);
                }                
                if(precop < precoComDesconto) {
                    precoComDesconto = precop;
                    prod = p;
                }
            }
        }
        
        if(prod != null) {
            out.println("\nO melhor produto para esta carga é:");
            out.println(prod.toString());
            out.println("Preço com este produto: " + precoComDesconto);
            out.println("\nDeseja escolher este produto? (S\\N): ");
            saux = Input.lerString();
            
            if(saux.equals("S")) {
                enc.setProduto(prod.getNumProd());
            }
            else if(saux.equals("N")) {
                out.println("Escolha outro produto entao:");
                verProdutos();
                out.println("\nNúmero do produto: ");
                iaux = Input.lerInt();
                enc.setProduto(iaux);
            }
        }
        else {
            out.println("\nNão há nenhum produto adequado para esta encomenda.");
            return -1;
        }
        
        return precoComDesconto;
    }
    
    public static void melhorVeiculo(Carga c) {
        String tipocarga = c.getClass().getSimpleName();
        double peso = c.getPeso();
        
        for(Veiculo v : frota.getVeiculosNaGaragem().values()) {
            
            switch(tipocarga) {
                case "CargaPerecivel": 
                    if(v instanceof Refrigerado && v.cabePeso(peso)) {
                        out.println(v.toString());
                    }
                    break;
                    
                 case "CargaToxica":
                    if(v instanceof NaoRefrigerado && v.cabePeso(peso)) {
                        out.println(v.toString());
                    }
                    break;
                    
                 case "CargaIndiferenciada":
                    if(v.cabePeso(peso)) {
                        out.println(v.toString());
                        break;
                    }
                    
                 default:
                    out.println("Erro no tipo de carga\n");
            }
        }
    }
   
    public static void despachar(String num) {
        Integer id = new Integer(num);
        
        try {
            frota.porVeiculoEmViagem(id);
            out.println("Veiculo " + num + "saiu da garagem\n");
        }
        catch(FrotaException e) {
            out.println(e);
        }
    }
    
    public static void retornar(String num) {
        Integer id = new Integer(num);
        
        try {
            frota.retornarVeiculoDeViagem(id);
            out.println("Veiculo " + num + "voltou à garagem\n");
        }
        catch(FrotaException e) {
            out.println(e);
        }
    }
        
    
    public static void guardar() {
        ObjectOutputStream output;
        String file;
        
        out.println("Introduza o nome do ficheiro: ");
        file = Input.lerString();
        
        try {
            output = new ObjectOutputStream(new FileOutputStream(file));
        }
        catch(IOException ioException) {
            out.println("Error opening file.\n");
            return;
        }
        
        try {
            output.writeObject(produtos);
            output.writeObject(clientes);
            output.writeObject(encomendas);
            output.writeObject(frota);
            out.println("O ficheiro foi guardado.");
        }
        catch(IOException ioException) {
           out.println("Error writing to file.\n");
        }
        
        try {
            if(output != null) {
                output.close();
            }
        }
        catch(IOException ioException) {
            out.println("Error closing file.\n");
            System.exit(1);
        }
    }
    
    public static void abrir() {
        ObjectInputStream inputfile;
        String file;
        
        out.println("Introduza o caminho para o ficheiro: ");
        file = Input.lerString();
        
        try {
            inputfile = new ObjectInputStream(new FileInputStream(file));
        }
        catch(IOException ioException) {
            out.println("Error opening file.\n");
            return;
        }
        
        try {
            produtos = (Produtos) inputfile.readObject();
            clientes = (Clientes) inputfile.readObject();
            encomendas = (Encomendas) inputfile.readObject();
            frota = (Frota) inputfile.readObject();
            out.println("O ficheiro foi aberto.");
        }
        catch(IOException ioException) {
            out.println("Error reading from file.\n");
        }
        catch(ClassNotFoundException e) {
            out.println("Error reading from file.\n");
        }
        
        try {
            if(inputfile != null) {
                inputfile.close();
            }
        }
        catch(IOException ioException) {
            out.println("Error closing file.\n");
            System.exit(1);
        }
    }
    
    public static void printComandos() {
        out.println("\nComandos: ");
        out.println("Ver (Produto(s) | Cliente(s) | Encomenda(s) | Veiculo(s) | VeiculosEmTransporte | VeiculosParados | GesVars) [ID]");
        out.println("Adicionar (Produto | Cliente | Encomenda | Veiculo)");
        out.println("Modificar (Produto | Cliente | Veiculo | GesVars) [ID]");
        out.println("Remover (Produto | Cliente | Encomenda | Veículo) ID");
        out.println("(Despachar | Retornar) VeículoID");
        out.println("Guardar para ficheiro");
        out.println("Abrir de ficheiro");
        out.println("Sair");
        out.println("Introduza '?' para ver esta lista novamente\n");
    }
    
}
