package Control;

public class ListaSimple <T> {
	
		
		private Nodo <T> inicio;
		private int size;
		public  T name;
		

		
		public ListaSimple() {
			super();
			this.inicio = null;
			this.size = 0;
		}
		
		
		
		public Nodo <T> getInicio() {
			return inicio;
		}
		public void setInicio(Nodo <T> inicio) {
			this.inicio = inicio;
		}
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
		public T getName() {
			return name;
		}
		public void setName(T name) {
			this.name = name;
		}
		

		
		
		
		public boolean esVacia(){
			return inicio == null;
		}
		
		public void agregarAlFinal(T obj){

			Nodo <T> nuevo = new Nodo <T>(obj);

			nuevo.setValor(obj);

			if (esVacia()) {

				inicio = nuevo;

			} else{
				Nodo <T> aux = inicio;

				while(aux.getSiguiente() != null){
					aux = aux.getSiguiente();
				}

				aux.setSiguiente(nuevo);
			}
			size++;
		}
		
		
		
	
		public boolean buscar(String referencia){
			Nodo <T> aux = inicio;
			boolean encontrado = false;
			while(aux != null && encontrado != true){
				if (referencia == aux.getName()){
					encontrado = true;
				}
				else{
					aux = aux.getSiguiente();
				}
			}
			return encontrado;
		}
		

		public Object Extraer(String referencia){
			Nodo <T> aux = inicio;
			boolean encontrado = false;
			while(aux != null && encontrado != true){
				if (referencia == aux.getName()){
					encontrado = true;
				}
				else{
					aux = aux.getSiguiente();
				}
			}
			return aux.getValor();
		}

		
		public void Print(){
			Nodo <T> aux = inicio;
			while(aux != null){
					System.out.println(aux.getValor());
					aux = aux.getSiguiente();
				}
		


	}
}



