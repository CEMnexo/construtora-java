package fag;

import java.util.ArrayList;
import java.util.Scanner;
import fag.objetos.Funcionario;
import fag.objetos.Construcoes;

public class PrincipalConstrutora {
	
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Funcionario> ListaDeFuncionario = new ArrayList<>();
	static ArrayList<Construcoes> ListaDeConstrucoes = new ArrayList<>();
	
	
	
	
	public static void main(String[] args) {
		mostrarMenu(); // Inicia o programa
	}
	
	
	
	
	// Imprime o nosso Menu principal
	public static void mostrarMenu() {
		int resp = 1000;
				
		do {
			System.out.println("\n\n----Menu----");
			System.out.println("1-Cadastrar");
			System.out.println("2-Consultar");
			System.out.println("3-Atualizar");
			System.out.println("4-Excluir");
			System.out.println("5-Alocar Funcionario"); // ADICIONADO
			System.out.println("0-Sair");
			resp = scan.nextInt();
			scan.nextLine(); // Limpa o buffer
			validarResp(resp);
		} while(resp != 0);
	}
	
	
	
	
	// Confere oque o usuario vai querer fazer no menu
	public static void validarResp(int resposta) {
		switch(resposta) {
		case 1:
			cadastroFeC();
			break;
		case 2:
			consultarFeC();
			break;
		case 3:
			atualizarFeC();
			break;
		case 4:
			excluirFeC();
			break;
		case 5: // ADICIONADO
			alocarFuncionario();
			break;
		case 0:
			System.out.println("agradeço por usar nosso sistema (´▽`ʃ♡ƪ)");
			break;
		default:
			System.out.println("ESCOLHA UMA OPÇÃO VALIDA!!!");
			break;
		}
	}

	
	
	
	public static void cadastroFeC() {
		System.out.println("oque voce quer cadastrar?");
		System.out.println("1-Funcionario");
		System.out.println("2-construção");
		int respCadas = scan.nextInt();
		scan.nextLine();
		
		switch(respCadas) {
		case 1:							// Leva para o menu de cadastro
			cadastrarFuncionario();		//(funcionario ou construção)
			break;
		case 2:
			cadastrarConstrução();
			break;
		default:
			System.out.println("ESCOLHA UMA OPÇÃO VALIDA!!!");
			break;
		}
	}
	
	
	
	
	// Pede os dados e cadastra o funcionario
	public static void cadastrarFuncionario() {
		System.out.println("Cadastro de Funcionario:");
		System.out.println("Nome do Funcionario:");
		String nome = scan.nextLine();
		System.out.println("Cargo do Funcionario:");
		String cargo = scan.nextLine();
		System.out.println("salario do Funcionario:");
		double salario = scan.nextDouble();
		System.out.println("idade do Funcionario:");
		int idade = scan.nextInt();
		scan.nextLine();
		
		Funcionario novoFuncionario = new Funcionario(nome, cargo, salario, idade);
		ListaDeFuncionario.add(novoFuncionario);
		
		System.out.println("\nFuncionário " + novoFuncionario.getNome() + " cadastrado com sucesso!");
	}

	
	
	
	// Pede os dados e cadastra da obra
	public static void cadastrarConstrução() {
		System.out.println("Cadastro da Construção:");
		System.out.println("Nome da obra:");
		String nomeCons = scan.nextLine();
		System.out.println("Endereço:");
		String endereco = scan.nextLine();
		System.out.println("Custo da obra:");
		double custo = scan.nextDouble();
		System.out.println("Data de início:");
		int data = scan.nextInt();
		scan.nextLine();
		
		Construcoes novaConstrucao = new Construcoes(nomeCons, endereco, custo, data);
		ListaDeConstrucoes.add(novaConstrucao);
		
		System.out.println("\nConstrução " + nomeCons + " cadastrada com sucesso!");
	}
	
	
	
	
	// --- MÉTODOS DE ATUALIZAÇÃO
	
	public static void atualizarFeC() {
		System.out.println("oque vai desejar atualizar?");
		System.out.println("1-Funcionario");
		System.out.println("2-construção");
		int resp = scan.nextInt();
		scan.nextLine();
		
		switch(resp) {
		case 1:						// Leva para o menu de atualização
			atualizarFunci();		//(funcionario ou construção)
			break;
		case 2:
			atualizarObra();
			break;
		}
	}
	
	
	
	
	// Lógica para atualizar um funcionário
	public static void atualizarFunci() {
		consultaFunc(); 
		System.out.println("que funcionario deve ser atualizado?");
		
		int resp = scan.nextInt();
		scan.nextLine();
		resp--;
		
		if(resp < ListaDeFuncionario.size()) {
			ListaDeFuncionario.remove(resp);
			cadastrarFuncionario();
		}
		
	}
	
	
	
	
	public static void atualizarObra() {
		consultaObra();
		System.out.println("que Obra deve ser atualizada?");
		
		int resp = scan.nextInt();
		scan.nextLine();
		resp--;
		
		if(resp < ListaDeConstrucoes.size()) {
			ListaDeConstrucoes.remove(resp);
			cadastrarConstrução();
		}
	}
	
	
	
	
	// --- MÉTODOS DE EXCLUSÃO 
	public static void excluirFeC() {
		System.out.println("oque voce quer excluir?");
		System.out.println("1-Funcionario");
		System.out.println("2-construção");
		int resp = scan.nextInt();
		scan.nextLine();
		
		switch(resp) {				// Leva para o menu de exclusão
		case 1:						//(funcionario ou construção)
			excluirFunc();
			break;
		case 2:
			excluirObra();
			break;
		default:
			System.out.println("ESCOLHA UMA OPÇÃO VALIDA!!!");
			break;
		}
	} 
		
		
		
	public static void excluirFunc() {
		consultaFunc();
		System.out.println("que funcionario deseja excluir?");
		
		int resp = scan.nextInt();
		scan.nextLine();
		resp--;
		
		if(resp < ListaDeFuncionario.size()) {
			ListaDeFuncionario.remove(resp);
		}
	}
	
	
	
	
	public static void excluirObra() {
		consultaObra();
		System.out.println("que Obra deseja excluir?");
		
		int resp = scan.nextInt();
		scan.nextLine();
		resp--;
		
		if(resp < ListaDeConstrucoes.size()) {
			ListaDeConstrucoes.remove(resp);
		}
	}
	
	
	
	
	// --- MÉTODOS DE CONSULTA ---
	
	public static void consultarFeC() {
		System.out.println("oque voce quer consultar?");
		System.out.println("1-Funcionario");
		System.out.println("2-construção");
		System.out.println("3-Obras de um Funcionario"); // ADICIONADO
		int resp = scan.nextInt();
		scan.nextLine();
		
		switch(resp) {				// Leva para o menu de consulta
		case 1:						//(funcionario ou construção)
			consultaFunc();
			break;
		case 2:
			consultaObra();
			break;
		case 3: // ADICIONADO
			consultarObrasPorFuncionario();
			break;
		default:
			System.out.println("ESCOLHA UMA OPÇÃO VALIDA!!!");
			break;
		}
	}
	
	
	
	
	// Parte da consulta de funcionarios
	public static void consultaFunc() {
		System.out.println("--Lista de Funcionarios Cadastrados--");
		if (ListaDeFuncionario.isEmpty()) {
			System.out.println("Nenhum funcionário cadastrado.");
			return;
		}
		
		for(int x=0; x < ListaDeFuncionario.size(); x++){
			System.out.printf("%d - ", x+1); // Mostra o índice (1, 2, 3...)
			ListaDeFuncionario.get(x).exibirFuncionario(); 
		}
	}
	
	
	
	
	public static void consultaObra() {
		System.out.println("--Lista de Obras Cadastradas--");
		if (ListaDeConstrucoes.isEmpty()) {
			System.out.println("Nenhuma obra cadastrada.");
			return;
		}
		
		for(int x = 0; x < ListaDeConstrucoes.size(); x++){
			System.out.printf("%d - ", x+1);
			ListaDeConstrucoes.get(x).exibirConstrucao(); 
		}
	}
	
	
	
	
	// --- MÉTODOS DE ALOCAÇÃO (NOVOS) ---
	
	public static void alocarFuncionario() {
		System.out.println("--- Alocar Funcionário em Obra ---");
		
		System.out.println("Selecione a obra:");
		consultaObra();
		if (ListaDeConstrucoes.isEmpty()) return;
		
		System.out.print("Digite o número da obra: ");
		int indiceObra = scan.nextInt() - 1;
		
		System.out.println("\nSelecione o funcionário para alocar:");
		consultaFunc();
		if (ListaDeFuncionario.isEmpty()) return;
		
		System.out.print("Digite o número do funcionário: ");
		int indiceFunc = scan.nextInt() - 1;
		scan.nextLine();

		if (indiceObra >= 0 && indiceObra < ListaDeConstrucoes.size() &&
			indiceFunc >= 0 && indiceFunc < ListaDeFuncionario.size()) {
			
			Construcoes obra = ListaDeConstrucoes.get(indiceObra);
			Funcionario func = ListaDeFuncionario.get(indiceFunc);
			
			obra.adicionarFuncionario(func);
			
		} else {
			System.out.println("Número de obra ou funcionário inválido.");
		}
	}
	
	
	
	
	public static void consultarObrasPorFuncionario() {
		System.out.println("--- Consultar Obras por Funcionário ---");
		
		consultaFunc();
		if (ListaDeFuncionario.isEmpty()) return;
		
		System.out.print("Digite o número do funcionário: ");
		int indiceFunc = scan.nextInt() - 1;
		scan.nextLine();

		if (indiceFunc < 0 || indiceFunc >= ListaDeFuncionario.size()) {
			System.out.println("Número inválido.");
			return;
		}
		
		Funcionario funcEscolhido = ListaDeFuncionario.get(indiceFunc);
		boolean encontrado = false;

		System.out.println("\nO funcionário '" + funcEscolhido.getNome() + "' está alocado nas seguintes obras:");
		
		for (Construcoes obra : ListaDeConstrucoes) {
			if (obra.getFuncionariosDaObra().contains(funcEscolhido)) {
				System.out.println("- " + obra.getNomeCons());
				encontrado = true;
			}
		}

		if (!encontrado) {
			System.out.println("(Este funcionário não está alocado em nenhuma obra)");
		}
	}
	
	
	
	
}