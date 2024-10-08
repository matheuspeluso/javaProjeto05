package controllers;

import java.util.ArrayList;
import java.util.UUID;

import javax.swing.JOptionPane;

import abstractions.EstoqueRepositoryAbstract;
import entities.Estoque;
import entities.Produto;
import repositories.EstoqueRepositoryJsonImpl;
import repositories.EstoqueRepositoryTxtImpl;
import repositories.EstoqueRepositoryXmlImpl;

public class EstoqueController {
	public void cadastrarEstoque() {
		var estoque = obterDadosEstoque();
		
		//solicitando o usuário o numero de produtos que deseje cadastrar
		var quantidadeProdutos = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de produtos: "));
		
		if(quantidadeProdutos > 0) {
			var lista = new ArrayList<Produto>();
			
			//adicionando produtos na lista
			for(var i = 0; i < quantidadeProdutos; i++) {
				JOptionPane.showMessageDialog(null, "PRENCHIMENTO DO "+(i+1)+ "º PRODUTO:");
				lista.add(obterDadosProduto());
			}
			estoque.setProdutos(lista);
		}
		
		EstoqueRepositoryAbstract estoqueRepositoryAbstract = null;
		
		var formato = JOptionPane.showInputDialog("Escolha entre (TXT) ou (XML) ou (JSON): ");
		switch(formato) {
		case "TXT":
			estoqueRepositoryAbstract = new EstoqueRepositoryTxtImpl();
			break;
		case "JSON":
			estoqueRepositoryAbstract = new EstoqueRepositoryJsonImpl();
			break;
		case "XML":
			estoqueRepositoryAbstract = new EstoqueRepositoryXmlImpl();
			break;
		}
		
		estoqueRepositoryAbstract.exportarDados(estoque);
		
	}
	
	//método para ler e retornar os dados de um estoque
	private Estoque obterDadosEstoque() {
		var estoque =  new Estoque();
		
		estoque.setId(UUID.randomUUID());
		estoque.setNome(JOptionPane.showInputDialog("Digite o nome do estoque: "));
		
		return estoque;
	}
	
	//método para ler e retornar os dados de um produto
	
	private Produto obterDadosProduto() {
		var produto = new Produto();
		
		produto.setId(UUID.randomUUID());
		produto.setNome(JOptionPane.showInputDialog("Digite o nome do produto: "));
		produto.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do produto: ")));
		produto.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade: ")));
		
		
		return produto;
	}
}
