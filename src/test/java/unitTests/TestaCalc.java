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
        System.out.println("----\ntestarSomarDoisNumeros");
        System.out.println("O resultado esperado é: " + resultadoEsperado + "\nO resultado Atual foi: " + resultadoAtual);
        assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testarSubtrairDoisNumeros()
    {
        // 1 - Prepara - Configurar - Given
        int num1 = 7;
        int num2 = 3;
        int resultadoEsperado = 4;

        // 2 - Executa - When
        int resultadoAtual = Calc.subtrairDoisNumeros(num1, num2);

        // 3 - Valida - Then
        System.out.println("----\ntestarSubtrairDoisNumeros");
        System.out.println("O resultado esperado é: " + resultadoEsperado + "\nO resultado Atual foi: " + resultadoAtual);
        assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testarMultiplicarDoisNumeros()
    {
        // 1 - Prepara - Configurar - Given
        int num1 = 5;
        int num2 = 8;
        int resultadoEsperado = 40;

        // 2 - Executa - When
        int resultadoAtual = Calc.multiplicarDoisNumeros(num1, num2);

        // 3 - Valida - Then
        System.out.println("----\ntestarMultiplicarDoisNumeros");
        System.out.println("O resultado esperado é: " + resultadoEsperado + "\nO resultado Atual foi: " + resultadoAtual);
        assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testarDividirDoisNumeros()
    {
        // 1 - Prepara - Configurar - Given
        int num1 = 20;
        int num2 = 5;
        String resultadoEsperado = "4";

        // 2 - Executa - When
        String resultadoAtual = Calc.dividirDoisNumeros(num1, num2);

        // 3 - Valida - Then
        System.out.println("----\ntestarDividirDoisNumeros");
        System.out.println("O resultado esperado é: " + resultadoEsperado + "\nO resultado Atual foi: " + resultadoAtual);
        assertEquals(resultadoAtual, resultadoEsperado);
    }

    @Test
    public void testarDividirPorZero()
    {
        // 1 - Prepara - Configurar - Given
        int num1 = 5;
        int num2 = 0;
        String resultadoEsperado = "Não divida por Zero!";

        // 2 - Executa - When
        String resultadoAtual = Calc.dividirDoisNumeros(num1, num2);

        // 3 - Valida - Then
        System.out.println("----\ntestarDividirPorZero");
        System.out.println("O resultado esperado é: " + resultadoEsperado + "\nO resultado Atual foi: " + resultadoAtual);
        assertEquals(resultadoAtual, resultadoEsperado);
    }
}
