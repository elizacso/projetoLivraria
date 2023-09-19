package classes;

import interfaces.IPromocional;
import interfaces.IVendivel;

public class Filme extends ItemLivraria implements IVendivel, IPromocional{
	double preco;
	String diretor;
	boolean vendido;
	int duracao; 
	
	public Filme(String titulo, String diretor, int duracao, double preco) {
		super(titulo, "Filme");
		this.diretor = diretor;
		this.duracao = duracao;
		this.preco = preco;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	@Override
	public double precoComDesconto() {
		return preco * 0.8;
	}

	@Override
	public double getPreco() {
		return preco;
	}

	
	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	@Override
	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public void vender() {
		setVendido(true);
	}

	@Override
	public boolean getVendido() {
		return vendido;
	}

	@Override
	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Diretor: " + diretor + ", Duração: " + duracao + "\nPreço: R$" + preco);
	}




	
}
