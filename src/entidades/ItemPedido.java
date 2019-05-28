package entidades;

public class ItemPedido {
	
	private Integer quantidade;
	private Double precoItemPedido;
	
	private Produto produto;
	
	// Construtores

	public ItemPedido(Integer quantidade, Double precoItemPedido, Produto produto) {
		this.quantidade = quantidade;
		this.precoItemPedido = precoItemPedido;
		this.produto = produto;
	}
	
	// Getters e Setters

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoItemPedido() {
		return precoItemPedido;
	}

	public void setPrecoItemPedido(Double precoItemPedido) {
		this.precoItemPedido = precoItemPedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	//metodo subtotal -- Calcula o valor quantidade * valor item
	
	public double subTotal() {
		return quantidade * precoItemPedido;
	}
	
	// toString
	
	public String toString() {
		return
				produto.getNomeProduto()
				+ ", $"
				+ String.format("%.2f", precoItemPedido)
				+ ", Quantidade: "
				+ quantidade
				+ ", SubTotal: $"
				+ String.format("%.2f", subTotal());
	}
}
