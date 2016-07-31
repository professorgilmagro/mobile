/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        String text = "Este é    um teste - EEEÊÈÉ S de TY ~ mesmo 2000 !!!!.";
        ContadorSimbolos cs = new ContadorSimbolos(text);
        System.out.println(cs);
        System.out.println(cs.getPalavras());
    }
    
}
