import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.text.Format;
import java.awt.Font;
import java.awt.Color;
import java.io.InputStream;
import java.io.FileInputStream;
import java.net.URL;

public class GeradoraDeFigurinhas{
	
	public void cria(InputStream inputStream, String nomeArquivo) throws Exception
	{
		//leitura da imagem
			//InputStream inputStream = new FileInputStream(new File("entrada/image1.jpg"));

			// O input stream está pegando a imagem da url. 
			// O imput stream é uma classe abstrata que pega bytes e ler.
			
			//InputStream inputStream = new URL("https://img.ibxk.com.br/materias/5866/21577.jpg").openStream();
			BufferedImage imagemOriginal = ImageIO.read(inputStream);

			//BufferedImage imagemOriginal = ImageIO.read(new File("entrada/image1.jpg"));
		
		
		//criar uma nova imagem em memória com transparência e com tamanho novo
			int largura = imagemOriginal.getWidth();
			int altura = imagemOriginal.getHeight();
			int novaAltura = altura + 200;
			
			BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
		
		
		// copiar a imagem original para nova imagem (em memória)
		Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
		graphics.drawImage(imagemOriginal, 0, 0, null);
		
		
		//configurar a fonte
		var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 52);
		graphics.setFont(fonte);
		graphics.setColor(Color.YELLOW);
		
		
		//escrever uma frase na nova imagem
			graphics.drawString("Alguma coisa ai", 100, novaAltura - 100);
		
		
		//escrever a nova imagem em um arquivo
		ImageIO.write(novaImagem, "png", new File("saida/ "+nomeArquivo));
		
	}
	
	
}


































