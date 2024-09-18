package repositories;

import java.io.File;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import abstractions.EstoqueRepositoryAbstract;
import entities.Estoque;

public class EstoqueRepositoryXmlImpl extends EstoqueRepositoryAbstract {

	@Override
	public void exportarDados(Estoque estoque) {
		try {
			var diretorio = "c:\\arquivos_xml";
			criarDiretorio(diretorio);
			
			//exportar dados do estoque para arquivo XML
			var xmlMapper = new XmlMapper();
			
			xmlMapper.writeValue(new File(diretorio + "\\estoque_"+ estoque.getId() + "xml"), estoque);
			
			System.out.println("\nArquivos gravados com sucesso!");
			
		}
		catch(Exception e) {
			System.out.println("\nFalha ao exportar dados em XML! \nError: "+e.getMessage());
		}
		
	}

}
