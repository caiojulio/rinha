package main.rinha.galos;

public class GaloBMW extends Galo {
        // Definindo informações básicas
    
       public GaloBMW(int nivel){
            setNome("Galo BMW");
            setRaridade("Epico");
            setNivel(nivel);
            String[] ataques = {"Atropelamento", "VrumVrumGatinha", "Gasolina de Milho", "Freio da Blazer"};
            setAtaques(ataques);
        
            // Definindo a partir das informações dadas 
            defineValor();
            defineDefesa();
            defineForca();
            defineVida();
           
       }
    
}
