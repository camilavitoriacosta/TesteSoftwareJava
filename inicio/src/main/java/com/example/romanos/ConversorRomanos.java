package com.example.romanos;

import java.util.HashMap;
import java.util.Map;

public class ConversorRomanos {
    private Map<String, Integer> mapaRomanos = new HashMap<>();
    Map<String, Integer> contadorRomanos = new HashMap<>();
    
    public ConversorRomanos(){
        // INSERE VALORES NO MAPA
        mapaRomanos.put("I", 1);
        mapaRomanos.put("V", 5);
        mapaRomanos.put("X", 10);
        mapaRomanos.put("L", 50);
        mapaRomanos.put("C", 100);
        mapaRomanos.put("D", 500);
        mapaRomanos.put("M", 1000);

        constroiMapaFrequencias();
    }

    public void constroiMapaFrequencias(){
        contadorRomanos.put("I", 0);
        contadorRomanos.put("V", 0);
        contadorRomanos.put("X", 0);
        contadorRomanos.put("L", 0);
        contadorRomanos.put("C", 0);
        contadorRomanos.put("D", 0);
        contadorRomanos.put("M", 0); 
    }
    
    public int converter(String simbolo){
        int somador = 0;
        Character atual, proximo;
    
        for (int i=0, j=1; i < simbolo.length(); i++, j++){
            atual = simbolo.charAt(i);
            
            Integer frequenciaNumero = contadorRomanos.get(atual.toString());
            
            if(frequenciaNumero < 3){ // verifica se é diferente de 3
                contadorRomanos.put(atual.toString(), frequenciaNumero + 1);
                
                Integer valorNumero = mapaRomanos.get(atual.toString());

                if (j < simbolo.length()){
                    proximo = simbolo.charAt(j);
                    if ( valorNumero < mapaRomanos.get(proximo.toString())){
                        somador -= valorNumero;
                    }
                    else{
                        somador += valorNumero;
                    }
                }
                else{
                    somador += valorNumero;
                }
            }
            else{
                return -1;
            }


        }

        return somador;
    }
}
