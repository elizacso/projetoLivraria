package classes;

public class ItemLivraria {
	private String tipo;
	private String titulo;
	

	public ItemLivraria(String titulo, String tipo) {
		super();
		this.titulo = titulo;
		this.tipo = tipo;
	}

	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void visualizar() {
		System.out.println("Tipo: " + tipo + ", Título: " + titulo );
	}
}
