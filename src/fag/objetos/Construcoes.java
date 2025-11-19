package fag.objetos;

import java.util.ArrayList; // ADICIONADO

public class Construcoes {
private String nomeCons;
private String endereco;
private double custo;
private int data;

// ADICIONADO
private ArrayList<Funcionario> funcionariosDaObra = new ArrayList<>();

	public Construcoes(String nomeCons, String endereco, double custo, int data) {
		setNomeCons(nomeCons);
		setEndereco(endereco);
		setCust(custo);
		setData(data);
	}

	public String getNomeCons() {
		return nomeCons;
	}
	public void setNomeCons(String nomeCons) {
		if(nomeCons != null && !nomeCons.isBlank()) {
			this.nomeCons = nomeCons;
		}
	}
	
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		if(endereco != null && !endereco.isBlank()) {
			this.endereco = endereco;
		}
	}
	
	
	public double getCusto() {
		return custo;
	}
	public void setCust(double custo) {
		if(custo > 0) {
			this.custo = custo;
		}
	}
	
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		if(data > 1000) {
			this.data = data;
		}
	}
	
	// MODIFICADO
	public void exibirConstrucao() {
		System.out.println("Nome: "+ nomeCons +", endereço: "+ endereco +", custo: " + custo +", data: " + data);
		
		// SEÇÃO ADICIONADA
		System.out.println("  Equipe Alocada:");
		if (funcionariosDaObra.isEmpty()) {
			System.out.println("  (Nenhum funcionário alocado)");
		} else {
			for (Funcionario f : funcionariosDaObra) {
				System.out.println("  - " + f.getNome() + " (" + f.getCargo() + ")");
			}
		}
	}
	
	// --- MÉTODOS ADICIONADOS ---
	
	public void adicionarFuncionario(Funcionario funcionario) {
		if (!this.funcionariosDaObra.contains(funcionario)) {
			this.funcionariosDaObra.add(funcionario);
			System.out.println("\nFuncionário " + funcionario.getNome() + " alocado na obra " + this.nomeCons);
		} else {
			System.out.println("\nFuncionário já está nesta obra.");
		}
	}
	
	public ArrayList<Funcionario> getFuncionariosDaObra() {
		return this.funcionariosDaObra;
	}
}