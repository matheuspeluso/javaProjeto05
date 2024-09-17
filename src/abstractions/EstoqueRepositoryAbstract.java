package abstractions;

import java.io.File;

import entities.Estoque;

public abstract class EstoqueRepositoryAbstract {
	//método para criar a pasta onde os arquivos serão gravados
	public void criarDiretorio(String caminho) {
		var file = new File(caminho);
		
		if(!file.exists()) {
			file.mkdir(); // se o caminho não existir vai criar a pasta!
			System.out.println("Diretorio criado com sucesso!");
		}
		else {
			System.out.println("Diretorio já existente!");
		}
	}
	
	public abstract void exportarDados(Estoque estoque);
}
