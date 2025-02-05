
package com.rinha.ataque.efeito;

import com.rinha.galos.Galo;


public abstract class Efeito {
    
    private String nomeEfeito;
    
    public void setNomeEfeito(String nomeEfeito){
        this.nomeEfeito = nomeEfeito;
    }
    
    public String getNomeEfeito(){
        return this.nomeEfeito;
    }
    
    public abstract void aplicaEstado(Galo galo, int rodadaBatalha);
    
}
