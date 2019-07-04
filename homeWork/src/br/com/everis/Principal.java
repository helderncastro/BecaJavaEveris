package br.com.everis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Principal {
	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		Set<Book> books = new HashSet<Book>();
		Set<Book> booksOrdenado = new HashSet<Book>();
		CSVFileReader arquivo = new CSVFileReader();

			try {
				books = arquivo.read("d:/livros.txt");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("###### Erro na leitura do arquivo: "+e.getMessage());
				e.printStackTrace();
			}
			
		booksOrdenado.addAll( ordenar(books) );
		
		for (Book book : booksOrdenado) {
			System.out.println( book.toString() );
		}		
		
	}
	
	
	public static Set<Book> ordenar(Set<Book> random) {

        Set<Book> sorted = new TreeSet<Book>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getIsbn().compareTo(o2.getIsbn());
            }
        });
        sorted.addAll(random);
        
        return sorted;
		
	}

}
