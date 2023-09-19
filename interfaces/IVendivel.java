package interfaces;

public interface IVendivel {
	double preco = 0;
	boolean vendido = false;
	
	double getPreco();
	void setPreco(double preco);
	
	void vender();
	
	boolean getVendido();
	void setVendido(boolean vendido);
}
