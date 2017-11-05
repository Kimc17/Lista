package Control;

import java.io.Serializable;


public class ColaEncadenada <T> implements Serializable
{

  private static final long serialVersionUID = 1L;
 
  
    protected NodoCola <T> primero;
 
  
    protected NodoCola <T> ultimo;
 
   
    protected int numElems;
 
 
    
    public ColaEncadenada( )
    {
        primero = null;
        ultimo = null;
        numElems = 0;
    }
 
    public int darLongitud( )
    {
        return numElems;
    }
 
   
    public <T> Object tomarElemento( ) throws ColaVaciaException
    {
        if( primero == null )
            throw new ColaVaciaException( "No hay elementos en la cola" );
        else
        {
            NodoCola <T> p = (NodoCola<T>) primero;
            primero = primero.desconectarPrimero( );
            if( primero == null )
                ultimo = null;
            numElems--;
            return p.darElemento( );
        }
    }
 
   
    public void insertar( T elemento )
    {
        NodoCola <T> nodo = new NodoCola<T>( elemento );
        if( primero == null )
        {
            primero = nodo;
            ultimo = nodo;
        }
        else
        {
            ultimo = ultimo.insertarDespues( nodo );
        }
        numElems++;
    }
 
  
    public NodoCola <T> darPrimero( )
    {
        return primero;
    }
 
       public NodoCola <T> darUltimo( )
    {
        return ultimo;
    }
 
   
    public boolean estaVacia( )
    {
        return primero == null;
    }
 
   
    @Override
    public String toString( )
    {
        String resp = "[" + numElems + "]:";
        for( NodoCola <T> p = primero; p != null; p = p.darSiguiente( ) )
        {
            resp += p.darElemento( ).toString( ) + "->";
        }
        return resp;
    }
}
