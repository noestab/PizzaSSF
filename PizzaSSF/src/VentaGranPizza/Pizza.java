/**
 * 
 */
package VentaGranPizza;

/**
 * @author noestab
 *
 */
public class Pizza {
	private String Tipo;
	private String[] Ingredientes;
	
	public Pizza(String tipo, String[] ingredientes) {
		super();
		Tipo = tipo;
		Ingredientes = ingredientes;
	}

	public Pizza() {
		super();
		Tipo = new String();
		Ingredientes = new String[0];
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public String[] getIngredientes() {
		return Ingredientes;
	}

	public void setIngredientes(String[] ingredientes) {
		Ingredientes = ingredientes;
	}
	
	
}
