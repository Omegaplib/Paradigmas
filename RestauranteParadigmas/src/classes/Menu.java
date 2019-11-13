package classes;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Menu {


		private List<Item> items;
		
		Scanner sc = new Scanner(System.in);
		
		public Menu() {
			items = new ArrayList<>();
		}
		
		public void addItems(Integer n) {
			for(int i = 0; i < n; i++) {
				System.out.println("Nome do produto: ");
				String name = sc.nextLine();
				System.out.println("Preco: ");
				double price = sc.nextDouble();
				items.add(new Item(name, price));
				sc.nextLine();
			}
		}
		
		public double getPrice(String name) {
			double price2 = 0.0;
			for(Item paper : items) {
				if(name.equals(paper.getName())) {
					price2 = paper.getPrice();
				}
			}
			return price2;
		}
		
		public Integer getSize() {
			return items.size();
		}
		
		public void printMenu() {
			System.out.println("---Menu---");
			for(Item paper : items) {
				System.out.println(paper);
				
				
			}
		}

		@Override
		public String toString() {
			return "Menu [items=" + items + ", sc=" + sc + "]";
		}
	}


