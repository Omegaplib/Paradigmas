package principal;

import java.util.Scanner;


import classes.Menu;
import classes.Mesa; 
import classes.Restaurante; 

public class Main {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int userinput = 1;
		
		System.out.print("Quantas mesas o restaurante possui?:");
		int mesas = sc.nextInt();
		Menu menu = new Menu();
		System.out.print("Qual será o tamanho do menu?:");
		int size = sc.nextInt();
		menu.addItems(size);
		Restaurante open = new Restaurante(mesas, menu);
		
		while(userinput != 0 && open != null ) {
			System.out.println("----- Bem vindo ao restaurante -----");
			System.out.println("1 ----- Abrir Mesa -----");
			System.out.println("2 ----- Adicionar Cliente em Mesa -----");
			System.out.println("3 ----- Fazer pedido -----"); 
			System.out.println("4 ----- Remover Cliente -----"); 
			System.out.println("5 ----- Cancelar pedido -----"); 
			System.out.println("6 ----- Remover mesa -----"); 
			System.out.println("0 ----- Finalizar o programa -----");
			System.out.println("----- Bem vindo ao restaurante -----");
			System.out.println("Escolha um numero: ");
			userinput = sc.nextInt();
			
			switch(userinput) {
				
				case 1:
					
					if(open != null && open.getNmrTables() < open.getMaxTables()) {
						System.out.print("Nome do cliente: ");
						sc.nextLine();
						String name = sc.nextLine();
						System.out.println("Quantos lugares terá na mesa?");
						int lugares = sc.nextInt();
						Mesa.nmr++;
						Mesa mesa = new Mesa(lugares);
						mesa.addClientes(name);
						open.addMesa(mesa);
						System.out.println("Cliente e Mesa adicionados!");
						}else {
							System.out.println("Não tem mesas disponíveis");
						}
					break;
				
				case 2:
					if(open.getNmrTables() > 0){
						System.out.print("Nome do cliente: ");
						sc.nextLine();
						String name = sc.nextLine();
						open.printMesas();
						System.out.println("A qual mesa o cliente irá sentar? ");
						int nMesa = sc.nextInt();
						open.addClienteMesaN(name, nMesa);
						System.out.println("Cliente adicionado!");
					}else {
						System.out.println("Não foi possivel adicionar cliente");
					}
					break;
				
				case 3:
					if(open != null) {
						open.printMesas();
						System.out.println("Mesa a ser feito o pedido:");
						int nMesa = sc.nextInt();
						System.out.println("Nome do cliente:");
						sc.nextLine();
						String name = sc.nextLine();
						open.addPedido(nMesa, name);
						System.out.println("Pedido realizado!");
					}
					break;
				
				case 4:
					if(open != null) {
						open.printMesas();
						System.out.print("Escolha a mesa: ");
						int nMesa = sc.nextInt();
						System.out.print("Qual cliente irá sair?");
						sc.nextLine();
						String name = sc.nextLine();
						open.removerCliente(nMesa, name);
					}
					break;
				
				case 5:
					if(open != null) {
						open.printMesas();
						System.out.print("O pedido sera removido em qual mesa?: ");
						int nMesa = sc.nextInt();
						System.out.print("Qual cliente ira remover o pedido?: ");
						sc.nextLine();
						String name = sc.nextLine();
						open.removePedido(nMesa, name);
						System.out.println("Pedido removido!");
					}
					break;
				
				case 6:
					if(open != null) {
						open.printMesas();
						System.out.println("Qual mesa irá ser removida?");
						int nMesa = sc.nextInt();
						open.fechaConta(nMesa);
						System.out.println("Mesa removida!");
					}
					break;
				
				case 0:
					System.exit(0);	
					break;
		}
	}
 }	
}
