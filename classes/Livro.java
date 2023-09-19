package classes;

import interfaces.IPromocional;
import interfaces.IVendivel;

public class Livro extends ItemLivraria implements IVendivel, IPromocional{

	private int paginas;
	private String autor;
	
	private double preco;
	private boolean vendido = false;
	
	public Livro(String titulo, String autor, int paginas, int preco) {
		super(titulo, "Livro");
		this.preco = preco;
		this.paginas = paginas;		
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
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
	public double precoComDesconto() {
		return preco * 0.9;
	}


	@Override
	public void vender() {
		this.vendido = true;
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
		System.out.println("Páginas: " + paginas + "\nPreço: R$" + preco);

	}
}
