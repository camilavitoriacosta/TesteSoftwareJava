package com.example.romanos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConversorRomanosTest {
    
    @Test
    public void deve_converter_o_simbolo_I(){
        // Arrange
        String simbolo = "I";

        // Act
        ConversorRomanos conversor = new ConversorRomanos();
        int valorConvertido = conversor.converter(simbolo);

        //Assert
        Assertions.assertEquals(1, valorConvertido);
    }
    
    @Test
    public void deve_converter_o_simbolo_V(){
        // Arrange
        String simbolo = "V";

        // Act
        ConversorRomanos conversor = new ConversorRomanos();
        int valorConvertido = conversor.converter(simbolo);

        //Assert
        Assertions.assertEquals(5, valorConvertido);
    }

    @Test
    public void deve_converter_o_simbolo_M(){
        // Arrange
        String simbolo = "M";

        // Act
        ConversorRomanos conversor = new ConversorRomanos();
        int valorConvertido = conversor.converter(simbolo);

        //Assert
        Assertions.assertEquals(1000, valorConvertido);
    }
    

    @Test
    public void deve_poder_somatorio_de_simbolos(){
        // Arange
        String simbolo = "XVII";

        // Act
        ConversorRomanos conversor = new ConversorRomanos();
        int valorConvertido = conversor.converter(simbolo);

        //Assert
        Assertions.assertEquals(17, valorConvertido);
    }

    @Test
    public void deve_poder_subtrair_numeros_com_dois_simbolos(){
        // Arange
        String simbolo = "IV";

        // Act
        ConversorRomanos conversor = new ConversorRomanos();
        int valorConvertido = conversor.converter(simbolo);

        //Assert
        Assertions.assertEquals(4, valorConvertido);
    }

    @Test
    public void deve_poder_somar_numeros_com_tres_simbolos(){
        // Arange
        String simbolo = "XXX";

        // Act
        ConversorRomanos conversor = new ConversorRomanos();
        int valorConvertido = conversor.converter(simbolo);

        //Assert
        Assertions.assertEquals(30, valorConvertido);
    }

    @Test
    public void deve_poder_subtrair_numeros_com_tres_simbolos(){
        // Arange
        String simbolo = "XIX";

        // Act
        ConversorRomanos conversor = new ConversorRomanos();
        int valorConvertido = conversor.converter(simbolo);

        //Assert
        Assertions.assertEquals(19, valorConvertido);
    }

    @Test
    public void nao_deve_converter_numero(){
        // Arange
        String simbolo = "IIII";

        // Act
        ConversorRomanos conversor = new ConversorRomanos();
        int valorConvertido = conversor.converter(simbolo);

        //Assert
        Assertions.assertEquals(-1, valorConvertido);
    }
}
