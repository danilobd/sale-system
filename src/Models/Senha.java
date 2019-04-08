/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javax.swing.JOptionPane;


/**
 *
 * @author IAGO
 */
public class Senha {
    public Fila idosos = new Fila();
    public Fila jovens = new Fila();
    Nodef obj;
    private String ultse,atualse,proxsen;
    
    private boolean verProd(Produto t){
        int quantgas,quantagua,quantsenha;
        quantagua = t.getQt_agua();
        quantgas = t.getQt_gas();
        quantsenha = (idosos.getSize() + jovens.getSize());
        return ( (quantagua+quantgas-quantsenha) > 0);
    }
    
    /*Essa função serve para inserir novas senhas na fila.
        *Primeiramente ela recebe um produto que servirá para ser passado a uma outra função que verificará se haverá produtos para essa pessoa comprar.
        *Ela tambem recebe um valor que diz se a pessoa será inserida na fila preferencial ou não. Sendo 1 para jovens e 2 para idosos.
        *Depois tem uma verificação que serve apenas para arrumar o nome da senha de forma organizada.
        *E no final insere a pessoa na fila e printa o novo nó adicionado(nova senha).
    */
    public String addFila(int tipo,Produto t){
        if(verProd(t)){
            if(tipo == 1){
                if(jovens.getQuant() > 9)
                    obj = new Nodef("A"+jovens.getQuant());
                else
                    obj = new Nodef("A0"+jovens.getQuant());
                jovens.enqueue(obj);
                return obj.getElement();
            }else{
                if(idosos.getQuant() > 9)
                    obj = new Nodef("P"+idosos.getQuant());
                else
                    obj = new Nodef("P0"+idosos.getQuant());
                idosos.enqueue(obj);
                return obj.getElement();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Você não pode pegar uma senha pois estamos em falta de produtos.");
            return "";
        }
    }
    
    /*Essa função chama a próxima pessoa da fila.
        *Ela recebe um contador que vai ser o que faz com que a função siga as prioridades. Da seguinte forma.
            *Se o contador que é iniciado em 0 for menor que 2 vai chamar preferencialmente os preferencias porém se o contador virar 2 irá chamar preferencialmente os jovens.
        *Após isso verifica se a fila dos jovens está vazia.
            *Caso não esteja, verifica se a fila dos idosos está vazia e se o contador é menor que 2, se for chama alguem da fila preferencial se não chama um jovem.
        *Se a dos jovens estiver vazia. Chama uma senha preferencial caso haja, se não houver printa que não há pessoas na fila.
        *No final retorna o contador que deve ser usado quando for chamar a função novamente.
    */
    public int chamarProxFila(int contador){
        if(!jovens.isEmpty()){
            if(!(idosos.isEmpty()) && (contador < 2)){
                obj = idosos.dequeue();
                setUltse(getAtualse());
                setAtualse(obj.getElement());
                return (contador+=1);
            }else{
                obj = jovens.dequeue();
                setUltse(getAtualse());
                setAtualse(obj.getElement());
                return 0;
            }
        }else if(!idosos.isEmpty()){
            obj = idosos.dequeue();
            setUltse(getAtualse());
            setAtualse(obj.getElement());
            return 0;
        }else{
            JOptionPane.showMessageDialog(null, "Não há ninguem na fila");
            return 0;
        }
    }   

    public String getUltse() {
        return ultse;
    }

    public void setUltse(String ultse) {
        this.ultse = ultse;
    }

    public String getAtualse() {
        return atualse;
    }

    public void setAtualse(String atualse) {
        this.atualse = atualse;
    }

    public String getProxsen() {
        return proxsen;
    }

    public void setProxsen(String proxsen) {
        this.proxsen = proxsen;
    }
    
}
