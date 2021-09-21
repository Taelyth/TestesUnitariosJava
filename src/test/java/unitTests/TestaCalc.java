package unitTests;

import devcalc.Calc;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestaCalc {

    @Test
    public void testarSomarDoisNumeros()
    {
        // 1 - Prepara - Configurar - Given
        int num1 = 5;
        int num2 = 7;
        int resultadoEsperado = 12;

        // 2 - Executa - When
        int resultadoAtual = Calc.somarDoisNumeros(num1, num2);

        // 3 - Valida - Then
        System.out.println("O resultado esperado é: " + resultadoEsperado + "\nO resultado Atual foi: " + resultadoAtual);
        assertEquals(resultadoAtual, resultadoEsperado);
    }
}
