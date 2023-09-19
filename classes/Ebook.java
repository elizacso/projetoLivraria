package classes;

public class Ebook extends ItemLivraria {

	public Ebook(String titulo) {
		super(titulo, "Ebook");
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Este item nao pode ser vendido separadamente.");
	}

}
