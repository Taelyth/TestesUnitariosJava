// 1 � Pacote
package devcalc;

// 2 � Bibliotecas
import java.util.Scanner;

// 3 � Classe
public class Calc {
    // 3.1 � Atributos
    static Scanner entrada = new Scanner(System.in); //entrada = input do console

    // 3.2 � M�todos e Fun��es
    public static void main (String[] args)
    {
        System.out.println(">> CALCULADORA <<");
        System.out.println("(1) Somar");
        System.out.println("(2) Subtrair");
        System.out.println("(3) Multiplicar");
        System.out.println("(4) Dividir");
        System.out.print("Escolha o C�lculo desejado: ");

        // Recebe a op��o desejada
        int opcao = entrada.nextInt();
        int num1 = 0;
        int num2 = 0;

        // Pergunta os valores a serem usados no c�lculo
        if (opcao >= 1 && opcao <= 4)
        {
            System.out.print("Entre o 1� n�mero: ");
            num1 = entrada.nextInt();

            System.out.print("Entre o 2� n�mero: ");
            num2 = entrada.nextInt();

            System.out.print("O resultado �: ");
        }

        //Chama fun��o de c�lculo desejada
        switch (opcao)
        {
            case 1:
                System.out.println(somarDoisNumeros(num1,num2));
                break;

            case 2:
                System.out.println(subtrairDoisNumeros(num1,num2));
                break;

            case 3:
                System.out.println(multiplicarDoisNumeros(num1,num2));
                break;

            case 4:
                System.out.println(dividirDoisNumeros(num1,num2));
                break;

            default:
                System.out.println("Op��o inv�lida");
                break;
        }

        //System.out.println("Passou pelo m�todo main");
    }

    public static int somarDoisNumeros(int num1, int num2)
    {
        //System.out.println("Passou pelo m�todo somarDoisNumeros");
        return num1 + num2;
    }

    public static int subtrairDoisNumeros(int num1, int num2)
    {
        return num1 - num2;
    }

    public static int multiplicarDoisNumeros(int num1, int num2)
    {
        return num1 * num2;
    }

    public static String dividirDoisNumeros(int num1, int num2)
    {
        if(num2 != 0) {
            int resultado = num1 / num2;
            return String.valueOf(resultado);
        }
        else
            return "N�o divida por Zero!";
    }

}