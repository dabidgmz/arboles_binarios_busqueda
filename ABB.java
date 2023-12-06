public class ABB {
    Nodo r;
    public ABB(){
        r=null;
    }

    public void PreOrder(Nodo nodo){    
        if(nodo != null){
            System.out.print(nodo.dato+",");
            PreOrder(nodo.izq);
            PreOrder(nodo.der);
        }
        
    
        
    }

    public void InOrder(Nodo nodo){
        if(nodo != null){
            InOrder(nodo.izq);
            System.out.print(nodo.dato+",");
            
            InOrder(nodo.der);
        }
        
    }

    public void PostOrder(Nodo nodo){
        if(nodo!=null){
            PostOrder(nodo.izq);
            PostOrder(nodo.der);
            System.out.print(nodo.dato+",");
        }
    }

    public void EliminarABB(Nodo nodo){
        if(nodo!= null){
            EliminarABB(nodo.izq);
            nodo.izq=null;
            EliminarABB(nodo.der);
            nodo.der=null;
            r=null;
        }
        
    }

    public Nodo Buscar(Nodo N, int valor, int nivel) {
        if (N == null) {
            return null;
        } else {
            if (N == r && r.dato == valor) {
                N.nivel = nivel;
                return N;
            } else {
                if (valor < N.dato) {
                    if (N.izq != null && N.izq.dato == valor) {
                        N.izq.nivel = nivel + 1;
                        return N;
                    } else {
                        return Buscar(N.izq, valor, nivel + 1);
                    }
                } else {
                    if (N.der != null && N.der.dato == valor) {
                        N.der.nivel = nivel + 1;
                        return N;
                    } else {
                        return Buscar(N.der, valor, nivel + 1);
                    }
                }
            }
        }
    }
    
    public void BuscarMostrar(int valor){
        Nodo R = Buscar(r, valor,0);
        if(R==null){
            System.out.println("Elemento no encontrado");
        }
        else{
            if(r.dato == valor){
                System.out.println("Elemento encontrado en el nivel 0");
            }
            else{
                System.out.println("Elemento encontrado en nivel"+(R.nivel+1));
            }
        }
    }

    public void Insertar(Nodo nodo, int valor) {
        if (r == null) {
            Nodo T = new Nodo();
            T.dato = valor;
            r = T;
            System.out.println("Valor insertado correctamente");
        } else {
            if (valor <= nodo.dato) {
                if (nodo.izq != null) {
                    Insertar(nodo.izq, valor);
                } else {
                    Nodo T = new Nodo();
                    T.dato = valor;
                    nodo.izq = T;
                    System.out.println("Valor insertado correctamente");
                }
            } else {
                if (nodo.der != null) {
                    Insertar(nodo.der, valor);
                } else {
                    Nodo T = new Nodo();
                    T.dato = valor;
                    nodo.der = T;
                    System.out.println("Valor insertado correctamente");
                }
            }
        }
    }

    public Nodo Eliminar(int valor){
        Nodo R = Buscar(r, valor,0);
        if(R == null){
            return null;
        }
        else{
            Nodo T = new Nodo();
            if(R.dato==valor){
                T=R;
            }
            else{
                if(valor<R.dato){
                    T=R.izq;
                }
                else{
                    T=R.der;
                }
            }
            if(T==R && T.izq==null && T.der==null){
                r=null;
                return T;
            }
            else if(T==R &&(T.izq==null||T.der==null)){
                if(T.izq!=null){
                    r=T.izq;
                    T.izq = null;
                }
                else{
                    r=T.der;
                    T.der=null;
                    return T;
                }
            }
            else if(T.izq==null && T.der==null){
                if(R.izq == T){
                    R.izq =null;
                }
                else{
                    R.der=null;
                }
                return T;
            }
            else if(T.izq == null){
                if(R.izq == T){
                    R.izq=T.der;
                }
                else{
                    R.der=T.der;
                }
                T.der=null;
                return T;
            }
            else if(T.der == null){
                if(R.izq==T){
                    R.izq=T.izq;
                }
                else{
                    R.der=T.izq;
                }
                T.izq=null;
                return T;
            }
            return T;
        }
    }

    public void Modificar(int valorM, int valorN){
        Nodo nodoModificar = Buscar(r, valorM,0);
        if (nodoModificar == null){
            System.out.println("El valor " + valorM + " no existe en el árbol.");
            return;
        }
        Eliminar(valorM);
        Insertar(nodoModificar, valorN);
        System.out.println("El valor " + valorM + " ha sido modificado a " + valorN + " en el árbol.");
    }
}
