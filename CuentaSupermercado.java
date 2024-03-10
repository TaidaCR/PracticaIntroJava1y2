import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CuentaSupermercado {
    String nombreProd;
    Double unidadesProd=0.0;

    //PARA DAR ACCESO A LA ARRAY DE MAIN
    private List<Producto>listaProductos;
    
    HashMap <String, Double> numUnidades = new HashMap<>();
    Producto producto = new Producto(nombreProd,unidadesProd);

    //CONSTRUCTOR
    public CuentaSupermercado(List<Producto> listaProductos){
        this.listaProductos = listaProductos;
    }

    //CALCULA PRECIO TOTAL UNITARIO
    public double precioTotalUnidades(Double precioProducto, Double unidades){
        return unidades*precioProducto;
    }

    //AÑADE PRODUCTOS A LA CUENTA
    public void addProducto(String productoEscaneado, Double unidadesProducto){
        boolean siguePidiendo = true;
        while (siguePidiendo==true){
            for (Producto producto : listaProductos){
                String prod1 = producto.getNombre();
                if (prod1.equals(productoEscaneado)){
                    if (numUnidades.containsKey(productoEscaneado)){
                        Double unidadesYaAñadidas = numUnidades.get(productoEscaneado);
                        Double sumaUnidades = unidadesYaAñadidas + unidadesProducto;
                        numUnidades.put(productoEscaneado,sumaUnidades);
                    }else{
                        numUnidades.put(productoEscaneado,unidadesProducto);
                    }
                    siguePidiendo=false;
                }
            }
        }
    }

    //IMPRIME EL TICKET
    public String imprimirTicket(){
        StringBuilder sb = new StringBuilder();
        Double precioTotalCuenta = 0.0;
        Random random = new Random ();
        int numeroTicket = random.nextInt(1000);
        sb.append("   \n");
        sb.append("TICKET NUMERO: " +numeroTicket +" \n");
        sb.append("   \n");
        sb.append("Producto       Ud.     PU      Total \n");
        sb.append("------------------------------------\n");
        sb.append("   \n");
        for (Map.Entry<String, Double> entry : numUnidades.entrySet()){
            String nombre = entry.getKey();
            Double unidades = entry.getValue();
            Double precioProducto = 0.0;
            for (Producto producto: listaProductos){
                if (producto.getNombre().equalsIgnoreCase(nombre)){
                    precioProducto = producto.getPrecio();
                }
            }
            Double precioTotalUd = precioTotalUnidades(precioProducto, unidades);
            sb.append(String.format("%-15s%-8.2f%-8.2f%-3.2f€\n", nombre, unidades, precioProducto, precioTotalUd));
            precioTotalCuenta += precioTotalUd;
        }
        sb.append("------------------------------------\n");
        sb.append(String.format("Total:                         %.2f€\n", precioTotalCuenta));
        sb.append("   \n");
        return sb.toString();
    }
}   