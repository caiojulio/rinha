/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rinha.ataque;
import com.rinha.ataque.Efeito.Efeito;

public class AtaqueAgil extends Ataque implements Golpe{

    public AtaqueAgil(String nomeAtaque, int forca, int nivel, int agilidade, Efeito efeito){
        this.nomeAtaque = nomeAtaque;
        this.forca = forca;
        this.nivel = nivel;
        this.agilidade = agilidade;
        this.defineDano();
        this.definePontosDePoder();
        this.setPontosDePoderAtual(this.getPontosDePoderOriginal());
        this.setEfeitoAtaque(efeito); // Efeito mandela: envenenar
    }
    
    @Override
    public void defineDano() {
        this.dano = this.agilidade * (this.nivel/10) + this.agilidade ;
    }

    @Override
    public void definePontosDePoder() {
        this.pontosDePoderOriginal = 8; //Substituir pela lógica para atribuição dos pontos de poder 
    }

}
