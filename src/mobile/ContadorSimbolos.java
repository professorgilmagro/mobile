/*
* Classe principal do aplicativo que aceita como entrada uma
* String qualquer e consiga contar a quantidade de cada símbolo que a compõem
*/
package mobile;

import java.text.Normalizer;
import java.util.Objects;

/**
 *
 * @author Grupo GRA (Anne, Gilmar e Ricardo) <aiec.br>
 */
public class ContadorSimbolos {
    
    private String text ;
    private final String VOGAIS = "aeiou";
    private final String CONSOANTES = "bcdfghjklmnpqrstvxwyz";
    
    /**
     * Construtor da classe
     * 
     * @param texto 
     */
    public ContadorSimbolos(String texto) {
        this.text = texto.trim();
    }

    @Override
    public String toString() {
        return String.format(
            "%d palavras, %d letras, %d vogais e %d consoantes.",
            this.getPalavras(),
            this.getTotalLetras() ,
            this.getTotalVogais() ,
            this.getTotalConsoantes()
        );
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.text);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ContadorSimbolos other = (ContadorSimbolos) obj;
        if (!Objects.equals(this.text, other.text)) {
            return false;
        }
        return true;
    }
    
    /**
     * Retorna o total de letras contidas no texto
     * 
     * @return Integer
     */
    public Integer getTotalLetras(){
        Integer total = 0;
        for (char ch : this.text.toCharArray()) {
            if ( Character.isLetter(ch) ){
                total ++;
            }
        }
                
        return total;
    }
    
    /**
     * Retorna o total de ocorrências de uma determinada letra contida no texto
     * de entrada ignorando (não sensível) maiúsculas e minúsculas
     * 
     * @param letra
     * 
     * @return Integer
     * @throws java.lang.Exception
     */
    public Integer getLetra( String letra ) throws Exception{
        return this.getLetra(letra, false) ;
    }
    
    /**
     * Retorna o total de ocorrências de uma determinada letra contida no texto
     * de entrada desta instância
     * 
     * @param letra
     * @param caseSensitive
     * 
     * @return Integer
     * @throws java.lang.Exception
     */
    public Integer getLetra( String letra, Boolean caseSensitive ) throws Exception{
        char[] letters = letra.toCharArray();
        if ( ! Character.isLetter(letters[0]) ) {
            throw new Exception( "Somente letra é permitido." ) ;
        }
        
        if ( letters.length > 1 ) {
            throw new Exception( "Informe apenas uma letra." ) ;
        }
        
        String texto = this.text ;
        if ( ! caseSensitive ) {
            letra = letra.toLowerCase() ;
            texto = texto.toLowerCase() ;
        }
        return texto.split(letra).length-1;
    }
    
    /**
     * Retorna o total de CONSOANTES contidas no texto armazenado neste objeto
     * 
     * @return Integer
     */
    public Integer getTotalConsoantes(){
        Integer total = 0;
        for (Character ch : this.text.toCharArray()) {
            if ( this.CONSOANTES.contains(ch.toString().toLowerCase()) ){
                total ++;
            }
        }
                
        return total;
    }
    
    /**
     * Retorna o total de ocorrências de uma consoante não-sensível a maiúsculas 
     * e minúsculas
     * 
     * @param consoante
     * 
     * @return Integer
     * @throws java.lang.Exception
     */
    public Integer getConsoante( String consoante ) throws Exception{
        return this.getConsoante(consoante, false) ;
    }
    
    /**
     * Retorna o total de ocorrências de uma consoante específica contida na
     * instância desta classe
     * 
     * @param consoante
     * @param caseSensitive
     * 
     * @return Integer
     * @throws java.lang.Exception
     */
    public Integer getConsoante( String consoante, Boolean caseSensitive ) throws Exception{
        if ( consoante.length() > 1 ) {
            throw new Exception( "Informe apenas uma consoante." ) ;
        }
        
        if ( ! this.CONSOANTES.contains(consoante.toLowerCase()) ) {
            throw new Exception( "Não é uma consoante" ) ;
        }
        
        String str = this.text ;
        if ( ! caseSensitive ) {
            str = str.toLowerCase();
            consoante = consoante.toLowerCase();
        }
        
        return str.split(consoante).length-1;
    }
    
    /**
     * Retorna o total de VOGAIS contidas no texto armazenado neste objeto
     * 
     * @return Integer
     */
    public Integer getTotalVogais(){
        Integer total = 0;
        String texto = this.stripAccents(this.text);
        for (Character ch : texto.toCharArray()) {
            if ( this.VOGAIS.contains(ch.toString().toLowerCase()) ){
                total ++;
            }
        }
                
        return total;
    }
    
    /**
     * Retorna o total de ocorrências de uma vogal não-sensível a maiúsculas 
     * e minúsculas
     * 
     * @param vogal
     * 
     * @return Integer
     * @throws java.lang.Exception
     */
    public Integer getVogal( String vogal ) throws Exception{
        return this.getVogal(vogal, false) ;
    }
    
    /**
     * Retorna o total de ocorrências de uma vogal específica contida na
     * instância desta classe
     * 
     * @param vogal
     * @param caseSensitive
     * 
     * @return Integer
     * @throws java.lang.Exception
     */
    public Integer getVogal( String vogal, Boolean caseSensitive ) throws Exception{
        if ( vogal.length() > 1 ) {
            throw new Exception( "Informe apenas uma vogal." ) ;
        }
        
        vogal = this.stripAccents(vogal).toLowerCase();
        if ( ! this.VOGAIS.contains(vogal) ) {
            throw new Exception( "Não é uma vogal" ) ;
        }
        
        String texto = this.text ;
        if ( ! caseSensitive ) {
            vogal = vogal.toLowerCase() ;
            texto = texto.toLowerCase() ;
        }
                        
        return texto.split(vogal).length-1;
    }
    
    /**
     * Retorna o total de palavras contidas no texto armazenado neste objeto
     * 
     * @return Integer
     */
    public Integer getPalavras(){
        return this.text
                .replace("  ", " ")
                .replaceAll("[,;:.!?-]", "")
                .split(" ").length;
    }
    
    /**
     * Retorna o total de ocorrências de uma palavra específica contida na
     * instância desta classe sem diferenciação de maiúsculas/minúsculas
     * 
     * @param palavra
     * 
     * @return Integer
     * @throws java.lang.Exception
     */
    public Integer getPalavra( String palavra ) throws Exception{
        return this.getPalavra(palavra, false);
    }
    
    /**
     * Retorna o total de ocorrências de uma palavra específica contida na
     * instância desta classe
     * 
     * @param palavra
     * @param caseSensitive
     * 
     * @return Integer
     * @throws java.lang.Exception
     */
    public Integer getPalavra( String palavra, Boolean caseSensitive ) throws Exception{
        if ( palavra.split(" ").length > 1 ) {
            throw new Exception( "Informe apenas uma palavra." ) ;
        }
        
        palavra = this.stripAccents(palavra);
        String texto = this.text ;
        if ( ! caseSensitive ) {
            palavra = palavra.toLowerCase() ;
            texto = texto.toLowerCase();
        }
        
        Integer total = 0 ;
        for( String item : texto.split(" ") ) {
            if ( item.equals(palavra) ) {
                total++;
            }
        }
                        
        return total;
    }
    
    /**
     * Método auxiliar para remover acentos de string
     * 
     * @param texto
     * 
     * @return String
     */
    private String stripAccents( String texto ) {
       texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
       return texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
    }
}