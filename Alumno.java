import java.util.Map;
import java.util.HashMap;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Alumno {
    static Scanner scanner = new Scanner(System.in);
    private String nombre;
    private String apellidos;
    HashMap<String, Double> asignaturaYNota = new HashMap<>();
    Asignaturas asignaturas = new Asignaturas(null, null);
   
    //CONSTRUCTOR
    public Alumno (String nombre, String apellidos){
        this.nombre = nombre;
        this.apellidos = apellidos;
    }
    //DEVUELVE NOMBRE Y APELLIDOS CONCATENADOS
    public String getInfo(){
        return capitalize(nombre) + " " + capitalize(apellidos);
    }
    
    //AÑADE ASIGN Y NOTA A HASHMAP ASIGNATURAYNOTA
    public void añadirAsignaturaYNota(String materia, Double nota){
        asignaturaYNota.put(asignaturas.setMateria(materia), asignaturas.setNota(nota));
    }

    //HACE EL PROMEDIO DE NOTAS
    public String notaMedia(){
        double sumaDeNotas=0;
        double longitud=asignaturaYNota.size();
        for (Double nota:asignaturaYNota.values()){
            sumaDeNotas+=nota;
        }
        double promedio = sumaDeNotas/longitud;
        DecimalFormat df = new DecimalFormat("#.##");
        String promedioString= df.format(promedio);
        return promedioString;
    }

    //PONE LA PRIMERA LETRAS EN MAYUSCULAS
    public String capitalize(String palabra){
        String palabraCap = palabra.substring(0,1).toUpperCase()+palabra.substring(1).toLowerCase();
        return palabraCap;
    }

    //DEVUELVE EL BOELTIN
    public String mostrarBoletin(String promedio){

        StringBuilder sb = new StringBuilder();
        sb.append("ASIGNATURA               NOTA\n");
        sb.append("-----------------------------\n");
        
        for (Map.Entry<String, Double> entry : asignaturaYNota.entrySet()){
            String asignatura = capitalize(entry.getKey());
            String nota = String.format("%.2f",entry.getValue());
            sb.append(String.format("%-25s%s\n", asignatura, nota));
        }
        sb.append("-----------------------------\n");
        sb.append("Nota media:              " + promedio+"\n");
        sb.append("-                          -\n");

        return sb.toString();
    }

    //MODIFICA LA NOTA DE LAS ASIGNATURAS
    public String modificarNotaAsignaturas(){
        String asignModificar = " ";
        boolean siguePidiendo=true;
        boolean pideMas = true;
        while(pideMas){
            while (siguePidiendo){
                System.out.print("Asignatura a modificar. Pulsa -e- para salir: ");
                asignModificar = scanner.nextLine();
                if (asignModificar.equalsIgnoreCase("e")) {
                    siguePidiendo=false;
                }
                boolean asignaturaEncontrada = false;
                for (Map.Entry<String, Double> entry : asignaturaYNota.entrySet()){
                    String asignatura = entry.getKey();
                    Double nota = entry.getValue();
                    if (asignatura.equalsIgnoreCase(asignModificar)){
                        asignaturaEncontrada = true;
                        System.out.printf("Nota actual: %.2f\n", nota);
                        System.out.print("Introduce la nueva nota: ");
                        Double nuevaNota = scanner.nextDouble();
                        scanner.nextLine();
                        asignaturaYNota.put(asignatura,nuevaNota);
                        boolean pide = true;
                        while(pide){
                            System.out.print("Desea modificar otra asignatura? Y/N: ");
                                    asignModificar = scanner.nextLine();
                                    if (asignModificar.equalsIgnoreCase("y")){
                                        siguePidiendo=true;
                                        pide=false;
                                    }else if (asignModificar.equalsIgnoreCase("n")){
                                        pide=false;
                                        pideMas=false;
                                        siguePidiendo=false;
                                    }else{
                                        System.out.print("Por favor introduce un valor correcto.");
                                    }
                        }
                    }
                }
                if (asignaturaEncontrada==false){
                    System.out.println("Valor erróneo. Por favor, elija una asignatura del boletín.");
                }
            }      
        }
        return asignModificar;
    }  
}
    

