package fag.objetos;

public class Funcionario {
private String nome;
private String cargo;
private double salario;
private int idade;

	public Funcionario(String nome, String cargo, double salario, int idade) {
		setNome(nome);
		setCargo(cargo);
		setSalario(salario);
		setIdade(idade);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome != null && !nome.isBlank()) {
			this.nome = nome;
		}
	}
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		if(cargo != null && !cargo.isBlank()) {
			this.cargo = cargo;
		}
	}
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		if(salario > 0) {
			this.salario = salario;
		}
	}
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		if(idade > 0) {
			this.idade = idade;
		}
	}
	
	
	public void exibirFuncionario() {
		System.out.println("Nome: "+ nome +", cargo: "+cargo+", salario: " +salario+", idade: " +idade);
	}
}
