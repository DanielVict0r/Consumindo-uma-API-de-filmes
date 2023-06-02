import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

import java.net.URL;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.File;

public class App {

    public static void main(String[] args) throws Exception {

        // fazer uma conexão HTTP e buscar os top 250 filmes
        
        
        
           String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        		ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();
		//Não precisa ser ExtratorDeConteudoDaNasa ou ExtratorDeConteudoDoIMDB porque tem a interface
		
		
        
       		//String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/NASA-APOD.json";
       		//ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();

       		
       		var http = new ClienteHttp();
       		String json = http.buscaDados(url);
       
      

        // exibir e manipular os dados 
                	  	List<Conteudo> conteudos = extrator.extraiConteudos(json);
        	GeradoraDeFigurinhas geradora = new GeradoraDeFigurinhas();





        for (Conteudo conteudox : conteudos)
        		{
        
        			//Conteudo conteudo = conteudos.get(i);
        		
        		InputStream inputStream = new URL(conteudox.getUrlImagem()).openStream();
			
			String nomeArquivo = conteudox.getTitulo() + ".png";
			geradora.cria(inputStream, nomeArquivo);
        		
           	System.out.println("\u001b[97m \u001b[104m"+conteudox.getTitulo()+"\u001b[m" );
                	System.out.println();
        	}
        
        
        
    }
}
































