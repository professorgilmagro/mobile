/*
 * Disciplina: Programação Mobile
 * Professor: Guilherme Veloso Neves Oliveira
 * Atividade: Contador de Símbolos
 * Objetivo da Atividade: Escreva um aplicativo que aceita como entrada uma
 * String qualquer e consiga contar a quantidade de cada símbolo que a compõem.
 */
package mobile;

/**
 *
 * @author Grupo GRA (Anne, Gilmar e Ricardo) <aiec.br>
 */
public class Mobile {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        String text = " Este é    um teste - EEEÊÈÉ S de TY ~ mesmo 2000 !!!!. ";
        ContadorSimbolos cs = new ContadorSimbolos(text);
        System.out.println(cs);
        System.out.println(cs.getPalavras());
    }
    
}
