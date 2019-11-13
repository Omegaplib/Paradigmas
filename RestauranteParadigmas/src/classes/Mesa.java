package classes;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Mesa { 
	private Integer number;
	private Integer maxClients;
	public static int nmr = 0;
	private List<Cliente> clientes; // Lista de clientes é uma mesa
	
	Scanner sc = new Scanner(System.in);
	
	public Mesa() {
	}
	
	public Mesa(Integer maxClients) {
		this.number = nmr;
		this.maxClients = maxClients;
		clientes = new ArrayList<>();
	}
	
	public Integer getTableNumber() {
		return number;
	}
	
	public Integer getMaxClients() {
		return maxClients;
	}
	
	public void addClientes(String name) {
		clientes.add(new Cliente(name));
	}
	
	public Integer getNmrClientes() {
		return clientes.size();
	}
	public void addPedido(String name, Menu menu) {
		for(Cliente obj : clientes) {
			if(name.equals(obj.getName())) {
				obj.addPedido(menu);
			}
		}
	}
	
	public void removePedido(String name, Menu menu) {
		for(Cliente obj : clientes) {
			if(name.equals(obj.getName())) {
				obj.removePedido(menu);
			}
		}
	}
	
	public void removerCliente(String name) {
		for(Cliente obj : clientes) {
			if(name.equals(obj.getName())) {
				System.out.println("Conta do cliente: R$" + obj.getConta());
				clientes.remove(obj);
			}
		}
	}
	
	public Double fechaConta() {
		double contaMesa = 0.0;
		if(this.getNmrClientes() > 0) {
			for(Cliente obj : clientes) {
				contaMesa += obj.getConta();
				obj.esvaziaPedido();
			}
			clientes.clear();
		}
		return contaMesa;
	}
	
	public void printClientes() {
		System.out.println("Clientes:");
		for(Cliente printer : clientes) {
			System.out.println(" " + printer);
		}
	}

	@Override
	public String toString() {
		return "Mesa [number=" + number + ", clientes=" + clientes + "]";
	}

	
}

