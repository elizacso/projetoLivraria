package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import interfaces.IPromocional;
import interfaces.IVendivel;

public class ControleLivraria {
	
	private static Scanner scanner = new Scanner(System.in);;
	private static List<ItemLivraria> itens = new ArrayList<>();;
	
	public static void main(String[] args) {
	
		itens.add(new Livro("O Código Da Vinci","Dan Brown", 300, 30));
		itens.add(new HQ("Guerra Civil", "Stuart Moore", 8));
		itens.add(new HQ("Homem-Aranha", "Dan Slott", 10));
		itens.add(new Filme("Crepúsculo", "Catherine Hardwicke", 122, 15));
		itens.add(new Ebook("Receitas - Mais Você"));
		itens.add(new Ebook("Aromaterapia - Mini Curso"));
		itens.add(new Livro("Comer, rezar e amar", "Elizabeth Gilbert", 233, 40));
		itens.add(new Filme("O abutre", "Dan Gilroy", 180, 20));
		
		menuPrincipal();
	}
	
	private static void menuPrincipal() {
		int opcao;
		
		while(true) {
			System.out.println("""
			----MENU LIVRARIA----		
			Selecione uma opção:
			1 - Listar itens
			2 - Comprar				
			3 - Calcular total vendido
			0 - Sair
			""");
			
			opcao = scanner.nextInt();
			
			if(opcao == 0) {
				System.out.println("Programa finalizado.");
				scanner.close();
				break;
				
			} else if(opcao == 1) {
				listarTodos();
			} else if(opcao == 2) {
				vender();
			} else if(opcao == 3) {
				calcularTotalVendido();
			} else {
				System.out.println("Opção inválida.");
			}
					
		}
	}



	private static void listarTodos() {
		for(int i=0; i<itens.size(); i++) {
			System.out.println("\nCódigo do item: " + (i+1));
			
			ItemLivraria item = itens.get(i);
			item.visualizar();
			
			try {
				
				boolean foiVendido = ( (IVendivel) item ).getVendido();
				System.out.println( foiVendido ? "O item foi vendido" : "");
				
			} catch(ClassCastException ex) {
				
			}
		}
	}

	
	private static void vender() {
		System.out.println("Informe o código do item: ");
		int codigo = scanner.nextInt();
		codigo -= 1;
		try {
			
			ItemLivraria item = itens.get(codigo); 
			item.visualizar();
			
			IVendivel vendavel = (IVendivel) item; 
			
			if(!confirmaOperacao()) {
				System.out.println("A operacao foi cancelada.");
				return;
			};
			
			boolean foiVendido = vendavel.getVendido();
			
			if(foiVendido) {
				System.out.println("O item já foi vendido.");
			} else {
				vendavel.setVendido(true);
				System.out.println("Venda concluída.");
			}
			
		} catch (ClassCastException ex) {
			
			System.out.println("Erro: O produto nao pode ser vendido separadamente.");
			
		} catch (IndexOutOfBoundsException ex) {
			
			System.out.println("Erro: Codigo inválido.");
			
		}
	}

	private static boolean confirmaOperacao() {
		System.out.println("""
		\nConfirma a venda do item?
		0 - Nao
		1 - Sim
		""");
		int confirmou = scanner.nextInt();
		
		if(confirmou == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	private static void calcularTotalVendido() {
		double totalVendido = 0;
		IVendivel vendivel;
		
		for(ItemLivraria item: itens) {
			
			if(item instanceof IVendivel) {
				
				vendivel = (IVendivel) item;
				
				if(vendivel.getVendido() == true) {
					if(vendivel instanceof IPromocional) {
						totalVendido += ( (IPromocional) vendivel ).precoComDesconto();
					} else {
						totalVendido += vendivel.getPreco();
					}
				}
			}
		}
		
		System.out.println("Total vendido: " + totalVendido);
	}
}
