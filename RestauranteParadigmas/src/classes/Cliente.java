package classes;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
	
	private String name;
	
	private Double contaValor;
	
	private List<String> pedidos; // Cliente é uma lista de pedidos.
	
	Scanner sc = new Scanner(System.in);
	
	public Cliente() {
	}
	
	public Cliente(String name) {
		this.name = name;
		this.contaValor = 0.0;
		pedidos = new ArrayList<>();
	}

	public Double getContaValor() {
		return contaValor;
	}

	public void setContaValor(Double contaValor) {
		this.contaValor = contaValor;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public Double getConta() {
		return contaValor;
	}
	
	public void addPedido(Menu menu) {
		if(menu.getSize() > 0) {
			menu.printMenu();
			double price = 0.0;
			System.out.print("Nome do produto: ");
			String name = sc.nextLine();
			System.out.print("Quantidade: ");
			int quant = sc.nextInt();
			price = menu.getPrice(name);
			this.contaValor += (price * quant);
			if(quant > 0 && price > 0.0) { 
				pedidos.add(name);
			}
		}
	}
		
	public void printPedidos() {
		System.out.println("Cliente " + name);
		System.out.println("Pedidos:");
		for(String printer : pedidos) {
			System.out.println(printer);
		}
	}
	
	public Integer getSize() {
		return pedidos.size();
	}
	
	public void removePedido(Menu menu) {
		double price = 0.0;
		if(this.getSize() > 0) {
			this.printPedidos();
			System.out.println("Qual produto deve ser cancelado?: ");
			sc.nextLine();
			String name = sc.nextLine();
			price = menu.getPrice(name);
			this.contaValor -= price;
			pedidos.remove(name);
		}
	}
	public void esvaziaPedido() {
		pedidos.clear();
	}
	@Override
	public String toString() {
		return "Cliente [name=" + name + ", contaValor=" + contaValor + "]";
	}
}
