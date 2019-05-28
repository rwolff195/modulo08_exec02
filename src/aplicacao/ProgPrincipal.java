package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Cliente;
import entidades.ItemPedido;
import entidades.Pedido;
import entidades.Produto;
import entidades.enums.OrderStatus;

public class ProgPrincipal {

	public static void main(String[] args) throws ParseException {
		/*
		Ler os dados de um pedido com N itens (N fornecido pelo usuário). Depois, mostrar um
		sumário do pedido. Nota: o instante do pedido deve ser o instante do sistema: new Date()
		*/

		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("*** Entre com os dados do Cliente ***");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Data de Nascimento (DD/MM/YYYY): ");
		Date dataNascimento = sdf.parse(sc.next());
		
		Cliente cliente = new Cliente(nome, email, dataNascimento); // instância a classe Cliente
		
		System.out.println("Entre com os Dados do Pedido");
		System.out.print("Status: ");
		OrderStatus orderStatus = OrderStatus.valueOf(sc.next());// instância e lê a classe OrderStatus
		
		Pedido pedido = new Pedido(new Date(), orderStatus, cliente); // intânciei a classe pedido
		
		System.out.print("Entre com a quantidade de pedidos? ");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Entre com o #" + i + " item:");
			System.out.print("Nome do Produto: ");
			sc.nextLine();
			String nomeProduto = sc.nextLine();
			System.out.print("Product price: ");
			double precoProduto = sc.nextDouble();
			
			Produto produto = new Produto(nomeProduto, precoProduto);
			
			System.out.print("Quantidade: ");
			int quantidade = sc.nextInt();
			
			ItemPedido itemPedido = new ItemPedido(quantidade, precoProduto, produto);
			
			pedido.addItemPedido(itemPedido);
		}
		
		System.out.println();
		System.out.println("Resumo do Pedido:");
		System.out.println(pedido);
		
		sc.close();
		
	}

}
