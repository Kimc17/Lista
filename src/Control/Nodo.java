package Control;



public class Nodo  <T> {

	

		private T valor;
	    private String name;
	    private Nodo <T> siguiente;
	    
	    public Nodo(T valor) {
			this.valor = valor;
				siguiente=null;
			
		}
		public Nodo <T> getSiguiente() {
			return siguiente;
		}
		
		
		public void setSiguiente(Nodo <T> siguiente) {
			this.siguiente = siguiente;
		}
	
		
		public T getValor() {
			return valor;
		}
		
		public void setValor(T valor) {
			this.valor=valor;
		}
		
		
		public String getName() {
			return name;
		}
	    
		public void setName(String name) {
			this.name= name;
		}
	    

	  
	}
	  





          
        
  
