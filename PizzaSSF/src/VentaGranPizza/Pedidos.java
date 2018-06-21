/**
 * 
 */
package VentaGranPizza;

import java.util.concurrent.CompletableFuture;

import javax.swing.JOptionPane;

/**
 * @author noestab
 *
 */
public class Pedidos {
	private static Pizza PizzaAOrdenar = null;
	private static int Cantidad = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * CompletableFuture.runAsync(() -> { tomarPedido(); });
		 */
		tomarPedido();
		boolean continuar = true;
		while (continuar) {
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog(null, "Deseas tomar un nuevo pedido?", "Aviso",
					dialogButton);
			if (dialogResult == JOptionPane.YES_OPTION) {

				tomarPedido();

			} else {
				continuar = false;
			}
		}
	}

	public static void tomarPedido() {
		try {

			String Orden = JOptionPane.showInputDialog(
					"Ingresa la pizza que deseas ordenar y la cantidad separados por coma. Por Ejemplo: Chicago,2 ");
			String[] splitOrden = Orden.split(",");
			String Tipo = "";
			
			if (splitOrden.length != 2 || !splitOrden[1].matches("\\d+")) {
				System.out.println("Lo sentimos el pedido no puede ser procesado como se ingreso");
				return;
			} else {
				Tipo = splitOrden[0];
				Cantidad = Integer.parseInt(splitOrden[1]);
			}
			switch (Tipo) {
			case "Chicago":
				PizzaAOrdenar = new Pizza(Tipo, new String[] { "Pepperoni", "Queso Mozzarella", "Queso Parmesano" });
				break;
			case "Mexicana":
				PizzaAOrdenar = new Pizza(Tipo,
						new String[] { "Chorizo", "Chile Jalapeño", "Cebolla", "Jitomate", "Aguacate" });
				break;
			case "Hawaii":
				PizzaAOrdenar = new Pizza(Tipo, new String[] { "Jamón", "Piña", "Queso Mozzarella" });
				break;
			case "Classica":
				PizzaAOrdenar = new Pizza(Tipo, new String[] { "Queso Mozarella", "Pepperoni", "Salami" });
				break;
			default:
				break;
			}

			if (PizzaAOrdenar == null) {
				System.out.println("Lo sentimos el tipo ingresado no existe");
			} else {
				CompletableFuture.runAsync(() -> {					
					realizarPedido(PizzaAOrdenar, Cantidad);
				});
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void realizarPedido(Pizza pizza, int cantidad) {
		try {
			String[] Procesos = new String[] { "en pedido", "en armado", "en horno", "en empacado",
					"entregada al cliente" };		
			
			for (int i = 0; i < cantidad; i++) {				
				for (String proceso : Procesos) {
					Thread.sleep(1000);
					System.out.println(proceso);
					if (proceso == "en armado") {
						for (String ingrediente : pizza.getIngredientes()) {
							System.out.println("\t" + ingrediente);
						}
					}
				}				
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
