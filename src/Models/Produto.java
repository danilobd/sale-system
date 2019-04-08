package Models;

public class Produto {
    
    int qt;
    String tipo;
    private double lucro;
    private int tamanho;
    private int qt_gas;
    private int qt_agua;

    private int vendasAgua=0, vendasGas=0;
    
    public Produto() {
        this.lucro = 0;
        this.tamanho = 0;
        this.qt_gas = 0;
        this.qt_agua = 0;
    }
    
    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getQt_gas() {
        return qt_gas;
    }

    public void setQt_gas(int qt_gas) {
        this.qt_gas = qt_gas;
    }

    public int getQt_agua() {
        return qt_agua;
    }

    public void setQt_agua(int qt_agua) {
        this.qt_agua = qt_agua;
    }
    
    public int getVendasAgua(){
        return this.vendasAgua;
    }
    
    public int getVendasGas(){
        return this.vendasGas;
    }
    
    DLinkedList lista = new DLinkedList();
    
    /*
    *   Adiciona produtos na fila
    * 
    *   'tipo': Recebe o código do que ira ser adicionado (1 para água, 2 para botijão).
    *   'Quant': Quantidade a ser adicinada.
    * 
    */
    public void cadastrar(int Tipo, int Quant){
        
        //tipo    = JOptionPane.showInputDialog("PRODUTO QUE DESEJA CADASTRAR:(AGUA OU GAS)");
        //qt      = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de produtos a serem cadasrtados:"));
        
        if(Tipo == 1){ // Agua
            
            System.out.println("1");
            
            for(int i=0;i<Quant;i++){
                lista.addLast(new Node("agua",null,null));
                this.qt_agua++;
            }
            
        }else if(Tipo == 2){ // Gas
            
            System.out.println("2");
            
            for(int i=0;i<Quant;i++){
                lista.addLast(new Node("gas",null,null));
                this.qt_gas++;
            }
        }
        
        //System.out.println(lista);
        this.tamanho = qt_agua + qt_gas;
    }
    
    /*
    *   Remove produtos na fila
    * 
    *   'tipo': Recebe o código do que ira ser adicionado (1 para água, 2 para botijão).
    *   'Quant': Quantidade a ser vendida.
    * 
    */
    public void remove(int Tipo, int Quant){
        
        //String tipo1 = JOptionPane.showInputDialog("PRODUTO VENDIDO(AGUA ,GAS ou AGUA e GAS)");
        
        //if(null != tipo1)
            
       /* switch (tipo1) {
            case "AGUA":
                lista.deleteAt("agua");
                lucro=lucro+2;
                qt_agua=qt_agua-1;
                break;
            case "GAS":
                lista.deleteAt("gas");
                lucro=lucro+20;
                qt_gas=qt_gas-1;
                break;
            case "AGUA e GAS":
                lista.deleteAt("gas");
                lucro=lucro+2;
                qt_agua=qt_agua-1;
                lista.deleteAt("agua");
                lucro=lucro+20;
                qt_gas=qt_gas-1;
                break;
            default:
                break;
        }
        
        tamanho=qt_agua+qt_gas;*/
       
       if(Tipo == 1){ // Agua
           
           for(int i=0;i<Quant;i++){
           
                // Remove da lista
                lista.deleteAt("agua",qt_agua);

                // Diminui a quantidade de agua no estoque
                qt_agua--;
           
           }
           
       }else if(Tipo == 2){// Gas
       
           for(int i=0;i<Quant;i++){
           
                // Remove da lista
                lista.deleteAt("gas",qt_gas);

                // Diminui a quantidade de gas no estoque
                qt_gas--;
           
           }
       }
     
       this.tamanho = qt_agua + qt_gas;
       
    }
    
    public void setLucro(int Tipo, int Quant){
    
        if(Tipo == 1){ // Agua
            
            // Aumenta o lucro
            this.lucro += Quant * 2;
            
            this.vendasAgua += Quant;
            
        }else if(Tipo == 2){// Gas
            
            // Aumenta o lucro
            this.lucro += Quant * 20;
            
            this.vendasGas += Quant;
        }
    }
    
    public void imprimir(){
        System.out.println("lucro" +lucro);
        System.out.println("qt_gas" +qt_gas);
        System.out.println("qt_agua" +qt_agua);
        System.out.println("tamanho" +tamanho);
    }
    
}
