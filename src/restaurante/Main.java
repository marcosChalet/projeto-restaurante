package restaurante;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) throws ParseException {
		
		List<Pessoas> clientes = new ArrayList<Pessoas>();
		List<Restaurante> restaurantes = new ArrayList<Restaurante>();
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		int idRestaurante = 1;
		int idCliente = 1;

		try {
			System.out.println("Funcionalidade #1");
			addUsuariosTeste(clientes, formatoData);
			consultaPessoas(clientes);
			removePessoasTeste(clientes);
			consultaPessoas(clientes);
			addUsuariosTeste(clientes, formatoData);
			
	
			System.out.println("Funcionalidade #3");
			cadastrarRestauranteTeste(restaurantes);
			cadastrarRestauranteTeste(restaurantes);
			cadastrarRestauranteTeste(restaurantes);
			buscaRestauranteTeste(restaurantes, "chalet 1");
			listaRestaurantesTeste(restaurantes);
			
			
			System.out.println("Funcionalidade #2");
			listarIntensCardapioTeste(restaurantes, idRestaurante);
			
			
			System.out.println("Funcionalidades #4/5");
			fazPedidoTeste(restaurantes.get(0), clientes.get(0), 1);
			fazPedidoTeste(restaurantes.get(0), clientes.get(0), 2);
			fazPedidoTeste(restaurantes.get(0), clientes.get(0), 3);
			fazPedidoTeste(restaurantes.get(0), clientes.get(5), 3);
			fazPedidoTeste(restaurantes.get(0), clientes.get(5), 3);
			fazPedidoTeste(restaurantes.get(0), clientes.get(5), 3);
			listaPedidosCliente(clientes.get(0));
			listaPedidosCliente(clientes.get(5));
			listaPedidosPJ(clientes, idCliente);
			
			
			System.out.println("Funcionalidade #6");
			cadastraCardapioJunino(restaurantes.get(0));
			listarIntensCardapioTeste(restaurantes, idRestaurante);
			
			
			System.out.println("Funcionalidade #7");
			listarPessoasPorPedidoTeste(clientes);
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public static void listarPessoasPorPedidoTeste(List<Pessoas> clientes){
		Collections.sort(clientes, new OrdenaPorQtdPedidos());
		
		consultaPessoas(clientes);
	}
	
	public static void cadastraPessoas(List<Pessoas> clientes, Pessoas pessoa){
		clientes.add(pessoa);
	}
	
	public static void addUsuariosTeste(List<Pessoas> clientes,
		SimpleDateFormat formatoData) throws ParseException {

		try {
			String cpf = "123.123.123-12";
			String cnpj = "12.123.123/0001-12";
			String cidade = "Juazeiro do Norte";
			Date dataNasc;
	
			for(int i = 0; i < 5; i++) {
				Juridica pj = new Juridica();
	
				pj.setId(clientes.size()+1);
				pj.setNome("Marcos" + (i+1));
				pj.setTelefone("(88) 98888-888" + i);
				pj.setCnpj(cnpj);
				pj.setCidade(cidade);
				pj.setEmail((i+1) + "marcos@gmail.com");
				pj.setSenha("senhapj" + (i+1));
				dataNasc = formatoData.parse((10+i) + "/10/2000");
				pj.setDataNascimento(dataNasc);
	
				cadastraPessoas(clientes, pj);
			}
	
			for(int i = 0; i < 5; i++) {
				Fisica pf = new Fisica();
				
				pf.setId(clientes.size()+1);
				pf.setNome("Lucas" + (i+1));
				pf.setTelefone("(77) 97777-777" + i);
				pf.setCpf(cpf);
				pf.setCidade(cidade);
				pf.setEmail((i+1) + "lucas@gmail.com");
				pf.setSenha("senhapf" + (i+1));
				dataNasc = formatoData.parse((20+i) + "/10/2000");
				pf.setDataNascimento(dataNasc);
	
				cadastraPessoas(clientes, pf);
			}
			System.out.println("10 usuários foram castrados\n");
		
		} catch(ParseException p) {
			System.out.println("Formato de data inválido!");
			p.printStackTrace();
		}
	}

	public static void consultaPessoas(List<Pessoas> clientes){
	
		System.out.println("=-=-=-=-=-= Mostrando Pessoas =-=-=-=-=-=\n");
		if ( !clientes.isEmpty() ) {
			for (Pessoas p : clientes) {
				System.out.println(p);
			}
		}else {
			System.out.println("Não há usuários cadastrados.\n");
		}
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
	}
	
	public static void removeUsuario(List<Pessoas> clientes, Pessoas p) {
		if(clientes.contains(p)) { 
			clientes.remove(p);
		}
	}
	
	public static void removePessoasTeste(List<Pessoas> clientes) {
		try {
			for (int i = 0; i < 10; i++) {
				removeUsuario(clientes, clientes.get(0));
			}
			System.out.println("Todos os usuarios foram removidos\n");
		} catch(IndexOutOfBoundsException e) {
			System.out.println("Elemento inválido!");
			e.printStackTrace();
		}
	}
	
	
	public static void cadastraRestaurante(List<Restaurante> restaurantes, Restaurante r) {
		restaurantes.add(r);
	}
	

	public static void cadastrarRestauranteTeste(List<Restaurante> restaurantes) {
		
		Restaurante restaurante = new Restaurante();
		Cardapio cardapio = new Cardapio();
		Produto produto;
		

		restaurante.setId(restaurantes.size()+1);
		restaurante.setNome("chalet " + (restaurantes.size()+1));
		restaurante.setEndereco("Rua da conceição, número " + (restaurantes.size()+1));
		
		cardapio.setId(restaurante.getCardapios().size()+1);
		cardapio.setDescricao("Cardapio principal");
		
		produto = new Produto();
		produto.setDescricao("Pizza de frango");
		produto.setImagem("pizzaFrango.png");
		produto.setValor(27.99);
		cardapio.setProduto(produto);
		
		produto = new Produto();
		produto.setDescricao("Pizza quatro queijos");
		produto.setImagem("pizza4Queijos.png");
		produto.setValor(29.99);
		cardapio.setProduto(produto);
		
		produto = new Produto();
		produto.setDescricao("X-tudo");
		produto.setImagem("xTudo.png");
		produto.setValor(18.99);
		cardapio.setProduto(produto);
		
		produto = new Produto();
		produto.setDescricao("Cachorro quente");
		produto.setImagem("CachorroQuente.png");
		produto.setValor(13.99);
		cardapio.setProduto(produto);
		
		restaurante.setCardapio(cardapio);
		
		cadastraRestaurante(restaurantes, restaurante);
		System.out.println("Restaurante cadastrado.\n");
	}
	
	public static void listarIntensCardapioTeste(List<Restaurante> restaurantes, int idRestaurante) {
		
		try {
			Restaurante restaurante = restaurantes.get(idRestaurante-1);
		
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-= Cardapios =-=-=-=-=-=-=-=-=-=-=-=\n");
			for(Cardapio cardapio : restaurante.getCardapios()) {
				System.out.println(cardapio);
				System.out.println("################ Itens do cardapio ################");
					for (Produto item : cardapio.getProdutos()) {
						System.out.println(item);
					}
				System.out.println("###################################################\n");
			}
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
		
		}catch(IndexOutOfBoundsException e) {
			System.out.println("Restaurante não cadastrado. Impossível listar seus cardapios.\n");
		}
	}
	
	public static Restaurante buscaRestauranteTeste(List<Restaurante> restaurantes, String nomeRestaurante) {
		
		Restaurante restaurante = null;
		for(Restaurante r : restaurantes) {
			if (r.getNome().equals(nomeRestaurante)) {
				restaurante = r;
			}
		}
		
		if(restaurante != null) {
			System.out.println("=-=-=-=-=-=-=-=-= Busca Restaurante =-=-=-=-=-=-=-=-=\n");
			System.out.println("########### Restaurante #" + restaurante.getId() + " ###########");
			System.out.println("Nome:     " + restaurante.getNome());
			System.out.println("Endereço: " + restaurante.getEndereco());
			System.out.println("######################################\n");
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
		}else {
			System.out.println("Restaurante não encontrado. <buscaRestauranteTeste>");
		}
		
		return restaurante;
	}
	public static void listaRestaurantesTeste(List<Restaurante> restaurantes) {
		
		System.out.println("=-=-=-=-=-=-=-=-= Restaurantes =-=-=-=-=-=-=-=-=\n");
		for(Restaurante r : restaurantes) {
			System.out.println("########### Restaurante #" + r.getId() + " ###########");
			System.out.println("Nome:     " + r.getNome());
			System.out.println("Endereço: " + r.getEndereco());
			System.out.println("######################################\n");
		}
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=\n");
	}
	
	
	public static void fazPedidoTeste(Restaurante restaurante, Pessoas cliente, int produto) {
		
		Pedidos pedido = new Pedidos();
		Produto p = restaurante.getCardapios().get(0).getProdutos().get(produto);
		
		pedido.setId(cliente.getPedidos().size()+1);
		pedido.setProduto(p);
		
		cliente.setPedido(pedido);
		restaurante.setCliente(cliente);
	}
	
	public static void listaPedidosCliente(Pessoas cliente) {
		try {
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-= Pedidos de "+ cliente.getNome() +" =-=-=-=-=-=-=-=-=-=-=-=-=\n");
			for (Pedidos pedido : cliente.getPedidos()) {
				System.out.println("#################### Pedido #" + pedido.getId() + " ####################");
				for (Produto produto : pedido.getProdutos()) {
					System.out.println(produto);
				}
				System.out.println("###################################################\n");
			}
			System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
		}catch (NullPointerException e) {
			System.out.println("O cliente não existe");
		}
	}
	
	public static void listaPedidosPJ(List<Pessoas>clientes, int idPj) {
		Pessoas cliente = null;
		for (Pessoas c : clientes) {
			if (c.getId() == idPj && c.getClass().getSimpleName().equals("Juridica")) {
				cliente = c;
			}
		}

		System.out.println("(*) Pedidos de uma PJ");
		listaPedidosCliente(cliente);
	}
	
	public static void cadastraCardapioJunino(Restaurante restaurante) {
		Cardapio cardapio = new Cardapio();
		Produto produto;
		
		cardapio.setId(restaurante.getCardapios().size()+1);
		cardapio.setDescricao("Cardapio especial de São João");
		
		produto = new Produto();
		produto.setDescricao("Milho verde");
		produto.setImagem("milho.png");
		produto.setValor(3.99);
		cardapio.setProduto(produto);
		
		produto = new Produto();
		produto.setDescricao("Vatapá");
		produto.setImagem("vatapa.png");
		produto.setValor(2.99);
		cardapio.setProduto(produto);
		
		produto = new Produto();
		produto.setDescricao("Canjica");
		produto.setImagem("canjica.png");
		produto.setValor(7.99);
		cardapio.setProduto(produto);
		
		produto = new Produto();
		produto.setDescricao("Pamonha");
		produto.setImagem("pamonha.png");
		produto.setValor(8.99);
		cardapio.setProduto(produto);
		
		restaurante.setCardapio(cardapio);
		
		System.out.println("Cardapio junino cadastrado\n");
	}
}
