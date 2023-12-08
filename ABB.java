public class ABB {
    Nodo r;

    public ABB() {
        r = null;
    }

    public void PreOrder(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + ",");
            PreOrder(nodo.izq);
            PreOrder(nodo.der);
        }
    }

    public void InOrder(Nodo nodo) {
        if (nodo != null) {
            InOrder(nodo.izq);
            System.out.print(nodo.dato + ",");
            InOrder(nodo.der);
        }
    }

    public void PostOrder(Nodo nodo) {
        if (nodo != null) {
            PostOrder(nodo.izq);
            PostOrder(nodo.der);
            System.out.print(nodo.dato + ",");
        }
    }

    public void EliminarABB(Nodo nodo) {
        if (nodo != null) {
            EliminarABB(nodo.izq);
            nodo.izq = null;
            EliminarABB(nodo.der);
            nodo.der = null;
            r = null;
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
                        return N.izq;
                    } else {
                        return Buscar(N.izq, valor, nivel + 1);
                    }
                } else {
                    if (N.der != null && N.der.dato == valor) {
                        N.der.nivel = nivel + 1;
                        return N.der;
                    } else {
                        return Buscar(N.der, valor, nivel + 1);
                    }
                }
            }
        }
    }

    public void BuscarMostrar(int valor) {
        Nodo R = Buscar(r, valor, 0);
        if (R == null) {
            System.out.println("Elemento no encontrado");
        } else {
            if (r.dato == valor) {
                System.out.println("Elemento encontrado en el nivel 0");
            } else {
                System.out.println("Elemento encontrado en nivel " + (R.nivel + 1));
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
            if (valor == nodo.dato) {
                System.out.println("El valor " + valor + " ya existe en el árbol.");
            } else if (valor < nodo.dato) {
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

    public Nodo Eliminar(Nodo raizSubarbol, int valor) {
        if (raizSubarbol == null) {
            System.out.println("El valor no se encuentra en el ABB, o el ABB está vacío.");
            return raizSubarbol;
        }

        if (valor < raizSubarbol.dato) {
            raizSubarbol.izq = Eliminar(raizSubarbol.izq, valor);
        } else if (valor > raizSubarbol.dato) {
            raizSubarbol.der = Eliminar(raizSubarbol.der, valor);
        } else {
            if (raizSubarbol.izq == null) {
                return raizSubarbol.der;
            } else if (raizSubarbol.der == null) {
                return raizSubarbol.izq;
            }
            Nodo sucesor = encontrarSucesor(raizSubarbol.der);
            raizSubarbol.der = Eliminar(raizSubarbol.der, sucesor.dato);
            raizSubarbol.dato = sucesor.dato;
            System.out.println("Se eliminó el valor: " + valor);
        }
        return raizSubarbol;
    }

    private Nodo encontrarSucesor(Nodo nodo) {
        while (nodo.izq != null) {
            nodo = nodo.izq;
        }
        return nodo;
    }

    public void Modificar(int valorM, int valorN) {
        Nodo nodoModificar = Buscar(r, valorM, 0);

        if (nodoModificar == null) {
            System.out.println("El valor " + valorM + " no existe en el árbol.");
            return;
        }
        r = Eliminar(r, valorM);
        Insertar(r, valorN);
        System.out.println("El valor " + valorM + " ha sido modificado a " + valorN + " en el árbol.");
    }
}
