package classes;

import interfaces.IVendivel;

public class HQ extends ItemLivraria implements IVendivel{

	private String autor;
	
	private boolean vendido;
	private double preco;
	
	public HQ(String titulo,  String autor, int preco) {
		super(titulo, "HQ");
		this.autor = autor;
		this.preco = preco;
	}

	@Override
	public double getPreco() {
		return preco;
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
		System.out.println("Autor: " + autor + "\nPreço: R$" + preco);

	}
}

