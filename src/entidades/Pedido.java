package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.enums.OrderStatus;

public class Pedido {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date momentoPedido;
	private OrderStatus status;
	
	private Cliente cliente;
	
	private List<ItemPedido> itensPedido = new ArrayList<>();
	
	// Construtores

	public Pedido(Date momentoPedido, OrderStatus status, Cliente cliente) {
		this.momentoPedido = momentoPedido;
		this.status = status;
		this.cliente = cliente;
	}

	// Getters e Setters
	public Date getMomentoPedido() {
		return momentoPedido;
	}

	public void setMomentoPedido(Date momentoPedido) {
		this.momentoPedido = momentoPedido;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}
	
	// metodos
	
	public void addItemPedido(ItemPedido itemPedido) {
		itensPedido.add(itemPedido);
	}

	public void removeItemPedido(ItemPedido itemPedido) {
		itensPedido.remove(itemPedido);
	}
	
	public double totalPedido() {
		
		double soma = 0.0;
		
		for (ItemPedido c : itensPedido) {
			soma += c.subTotal();
		}
		
		return soma;
	}
	
	//stringBuilder
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Data dp Pedido: ");
		sb.append(sdf.format(momentoPedido) + "\n");
		sb.append("Status: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(cliente + "\n");
		sb.append("Itens do Pedido:\n");
		for (ItemPedido item : itensPedido) {
			sb.append(item + "\n");
		}
		sb.append("Total do Pedido: $");
		sb.append(String.format("%.2f", totalPedido()));
		
		return sb.toString();
	}
	
}
