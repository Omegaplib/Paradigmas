package classes;

import java.util.List;
import java.util.ArrayList;

public class Restaurante {
	private Integer maxTables;
	private Menu menu;
	private List<Mesa> mesas; // Restaurante é uma lista de mesas

	public Restaurante() {
	}
	
	public Restaurante(Integer maxTables, Menu menu) {
		this.maxTables = maxTables;
		this.menu = menu;
		mesas = new ArrayList<>();
	}

	
	public Integer getMaxTables() {
		return maxTables;
	}
	
	public Integer getNmrTables() {
		return mesas.size();
	}
	
	public void printMenu() {
		menu.printMenu();
	}
	
	public void addMesa(Mesa mesa) {
		mesas.add(mesa);
	}
	
	public void addClienteMesaN(String name, Integer nmrMesa) {
		mesas.get(nmrMesa - 1).addClientes(name);
	}
	
	public void removerCliente(Integer nmrMesa, String name) {
		mesas.get(nmrMesa - 1).removerCliente(name);
	}
	
	public void addPedido(Integer nmrMesa, String name) {
		mesas.get(nmrMesa - 1).addPedido(name, menu);
	}
	
	public void removePedido(Integer nmrMesa, String name) {
		mesas.get(nmrMesa - 1).removePedido(name, menu);
	}
	
	public void fechaConta(Integer nmrMesa) {
		double contaMesa = 0.0;
		if(this.getNmrTables() > 0) {
			contaMesa = mesas.get(nmrMesa - 1).fechaConta();
			System.out.println("Conta Mesa " + nmrMesa + " - R$" + contaMesa);
		}
	}
	
	
	public void printMesas() {
		for(Mesa printer : mesas) {
			System.out.println(" " + printer);
			printer.printClientes();
		}
	}

	@Override
	public String toString() {
		return "Restaurante [mesas=" + mesas + "]";
	}
}
