import java.util.ArrayList;
import java.util.List;

public class MainS {
    public static void main(String[] args) {
        
        //CREO LISTADO PRODUCTOS DISPONIBLES
        List<Producto> listaProductos = new ArrayList<>();
        CuentaSupermercado cuenta = new CuentaSupermercado (listaProductos);
        ValidadorS validador = new ValidadorS(listaProductos);

        //AÑADO PRODUCTOS Y PRECIO
        listaProductos.add(new Producto("Leche", 1.20));
        listaProductos.add(new Producto("Arroz", 1.85));
        listaProductos.add(new Producto("Huevos", 1.75));
        listaProductos.add(new Producto("Tomate", 0.20));
        listaProductos.add(new Producto("Agua", 0.80));
        listaProductos.add(new Producto("Naranjas", 1.55));
        listaProductos.add(new Producto("Pasta", 2.50));
        listaProductos.add(new Producto("Yogurt", 2.25));
        
        System.out.print("    \n");
        System.out.print("LISTA DE PRODUCTOS DISPONIBLES \n");
        System.out.print("------------------------------\n");

        //RECORRE LA LISTA REALIZADA Y LA IMPRIME PARA VER LOS PRODUCTOS QUE HAY
        for (Producto producto : listaProductos){
            System.out.printf(producto.getNombre() + " - " + producto.getPrecio() + "€\n");
        }
        System.out.print("    \n");

        //RECOGER EL NUMERO DE PRODUCTOS TOTAL COMPRADOS
        double numProd = validador.validadorNumProd();

        //AÑADE LOS PRODUCTOS "ESCANEADOS" A UNA NUEVA LISTA DONDE ACUMULA LAS UNIDADES
        double i=0;
        while (i<numProd){
            String productoEscaneado = validador.validadorProductos();
            Double unidadesProducto = validador.validarUnidadesTotales(i, numProd);
            cuenta.addProducto(productoEscaneado, unidadesProducto);
            i=i+unidadesProducto;
        }

        //IMPRIME EL TICKET
        System.out.print(cuenta.imprimirTicket());
    }
}