package com.rinha.loja;

import com.rinha.perfil.Perfil;
import java.util.ArrayList;

public class Loja {
    ArrayList <PocaoCura> pocoes;
    ArrayList <Milho> milhos;
    
    public Loja(int nItens){
        this.pocoes = this.gerarPocaoCura(nItens);
        this.milhos = this.gerarMilho(nItens);
    }
    
    private ArrayList gerarPocaoCura(int quantidade){
        ArrayList <PocaoCura> pocoesGeradas = new ArrayList<>();
        PocaoCura pocao;
        
        for (int i = 0; i < quantidade; i++){
            pocao = new PocaoCura();
            pocoesGeradas.add(pocao);
        }
        
        return pocoesGeradas;
    }  
    
    private ArrayList gerarMilho(int quantidade){
        ArrayList <Milho> milhosGerados = new ArrayList<>();
        Milho milho;
        
        for (int i = 0; i < quantidade; i++){
            milho = new Milho();
            milhosGerados.add(milho);
        }
        
        return milhosGerados;
    }
    
    public boolean venderMilho(Perfil cliente, int indexMilho){
        Milho milho = milhos.get(indexMilho);
        if (cliente.comprarItem(milho)){
            this.milhos.remove(milho);
            return true;
        }
        return false;
    }
    
    public boolean venderPocaoCura(Perfil cliente, int indexPocaoCura){
        PocaoCura pocao = pocoes.get(indexPocaoCura);
        if (cliente.comprarItem(pocao)){
            this.pocoes.remove(pocao);
            return true;
        }
        return false;
    }
    
    // Métodos para a loja
    public Milho getMilho(int index){
        return this.milhos.get(index);
    }
    
    public PocaoCura getPocaoCura(int index){
        return this.pocoes.get(index);
    }
    
    public  int getQuantidadeMilhos(){
        return this.milhos.size();
    }
    
    public  int getQuantidadePocoes(){
        return this.pocoes.size();
    }
    
    public Object[] getInfoPocoes(int index){
        PocaoCura pocao = this.pocoes.get(index);
        Object[] info = {pocao.getNome(), pocao.getRestauracao(), pocao.getPreco()};
        return info;
    }
    
    public Object[] getInfoMilhos(int index){
        Milho milho = this.milhos.get(index);
        Object[] info = {milho.getNome(), milho.getXp(), milho.getPreco()};
        return info;
    }
    
}
