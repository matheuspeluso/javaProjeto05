package repositories;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import abstractions.EstoqueRepositoryAbstract;
import entities.Estoque;

public class EstoqueRepositoryJsonImpl extends EstoqueRepositoryAbstract {

	@Override
	public void exportarDados(Estoque estoque) {
		try {
			var diretorio = "c:\\arquivos_json";
			criarDiretorio(diretorio);
			
			//esportar os dados do estoque para JSON
			var objectMapper = new ObjectMapper();
			objectMapper.writeValue(new File(diretorio + "\\estoque_"+estoque.getId()+".json"), estoque);
			System.out.println("\nArquivo JSON gravado com sucesso!");
		}
		catch(Exception e) {
			System.out.println("\nFalha ao exportar arquivo Json! \nError: "+e.getMessage());
		}
		
	}
	
}
