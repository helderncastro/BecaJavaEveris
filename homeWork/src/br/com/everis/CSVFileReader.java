package br.com.everis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CSVFileReader {

	public Set<Book> read(String fileName) throws IOException {
		
		File f = new File(fileName);
		Set<Book> books = new HashSet<Book>();
		Integer fim;
		Integer fimLinha;
		String auxiliar="";		
		
        //EFETUANDO A LEITURA
        try {
            FileReader fr = new FileReader(f);
            BufferedReader bufRead = new BufferedReader(fr);
            String s;
             
            //SALVAR OS DADOS EM UMA SET LIST
            while ((s = bufRead.readLine()) != null) {
                
            	Book book = new Book();
                fim = s.indexOf("\",");
                fimLinha = s.length();
                book.setTitle(s.substring(1, fim));
                
                auxiliar = s.substring(fim + 2,fimLinha);
                fim = (auxiliar.indexOf("\",") );
                book.setAuthor(auxiliar.substring(1,fim)); 
                
                fimLinha = auxiliar.length();
                auxiliar = auxiliar.substring(fim+2, fimLinha);
                fim = (auxiliar.indexOf("\","));
                book.setIsbn(auxiliar.substring(1,fim));
                
                fimLinha = auxiliar.length();
                book.setYear(Integer.parseInt(auxiliar.substring(fim+2, fimLinha)));
                
                books.add(book);
            }
                        
            bufRead.close();
            
        } catch (IOException e) {
            System.out.println("###### Erro: "+e.getMessage());
            e.printStackTrace();
        } 
        
		return books;
		
	}	
	

}
