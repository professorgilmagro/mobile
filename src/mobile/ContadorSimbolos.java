/*

- O método público “getTotalConsoantes” que deverá retornar a quantidade total
de consoantes armazenadas na String (variável de instância).
- O método público “getConsoante” que deverá retornar a quantidade de uma
consoante específica (parâmetro do método) que esteja armazenada na String
(variável de instância).
- O método público “getTotalVogais” que deverá retornar a quantidade total de
vogais armazenadas na String (variável de instância).
- O método público “getVogal” que deverá retornar a quantidade de uma vogal
específica (parâmetro do método) que esteja armazenada na String (variável de
instância).
- O método público “getPalavras” que deverá retornar a quantidade total de
palavras armazenadas na String (variável de instância).
- O método público “equals” (sobrescrita de Object) para determinar se dois
objetos são ou não iguais.
- O método público “hashCode” (sobrescrita de Object) para determinar o valor
hash do objeto
- O método públic “toString” (sobrescrita de Object) para exibir o estado do
objeto.
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
    private String vogais = "aeiou";
    private String consoantes = "bcdfghjklmnpqrstvxwyz";
    
    /**
     * Construtor da classe
     * 
     * @param text 
     */
    public ContadorSimbolos(String text) {
        this.text = text;
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
     * de entrada desta instância
     * 
     * @param letra
     * 
     * @return Integer
     * @throws java.lang.Exception
     */
    public Integer getLetra( String letra ) throws Exception{
        char[] letters = letra.toCharArray();
        if ( ! Character.isLetter(letters[0]) ) {
            throw new Exception( "Somente letra é permitido." ) ;
        }
        
        if ( letters.length > 1 ) {
            throw new Exception( "Informe apenas uma letra." ) ;
        }
        
        return this.text.split(letra).length-1;
    }
    
    /**
     * Retorna o total de consoantes contidas no texto armazenado neste objeto
     * 
     * @return Integer
     */
    public Integer getTotalConsoantes(){
        Integer total = 0;
        for (Character ch : this.text.toCharArray()) {
            if ( this.consoantes.contains(ch.toString().toLowerCase()) ){
                total ++;
            }
        }
                
        return total;
    }
    
    /**
     * Retorna o total de ocorrências de uma consoante sensível a maiúsculas e
     * minúsculas
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
        
        if ( ! this.consoantes.contains(consoante.toLowerCase()) ) {
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
     * Retorna o total de vogais contidas no texto armazenado neste objeto
     * 
     * @return Integer
     */
    public Integer getTotalVogais(){
        Integer total = 0;
        String texto = this.stripAccents(this.text);
        for (Character ch : texto.toCharArray()) {
            if ( this.vogais.contains(ch.toString().toLowerCase()) ){
                total ++;
            }
        }
                
        return total;
    }
    
    /**
     * Retorna o total de ocorrências de uma vogal específica contida na
     * instância desta classe
     * 
     * @param vogal
     * 
     * @return Integer
     * @throws java.lang.Exception
     */
    public Integer getVogal( String vogal ) throws Exception{
        if ( vogal.length() > 1 ) {
            throw new Exception( "Informe apenas uma vogal." ) ;
        }
        
        vogal = this.stripAccents(vogal).toLowerCase();
        if ( ! this.vogais.contains(vogal) ) {
            throw new Exception( "Não é uma vogal" ) ;
        }
                        
        return this.text.split(vogal).length-1;
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
     * instância desta classe
     * 
     * @param palavra
     * 
     * @return Integer
     */
    public Integer getPalavra( String palavra ) throws Exception{
        if ( palavra.split(" ").length > 1 ) {
            throw new Exception( "Informe apenas uma palavra." ) ;
        }
        
        palavra = this.stripAccents(palavra);
        Integer total = 0 ;
        for( String item : this.text.split(" ") ) {
            if ( item.equalsIgnoreCase(palavra) ) {
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

