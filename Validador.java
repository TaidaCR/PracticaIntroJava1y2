import java.util.InputMismatchException;
import java.util.Scanner;

public class Validador {
    static Scanner input = new Scanner(System.in);

    public Validador(){
    }

    //VALIDA QUE EL NUMERO DE ALUMNOS INTRODUCIDO SEA UN ENTERO
    public int validadorNumAlumn(){
        int numAlumn = 0;
        boolean siguePidiendo = true;
        while (siguePidiendo){
            try{
                System.out.print("    \n");
                System.out.print("Introduce el numero de alumnos: ");
                numAlumn=input.nextInt();
                input.nextLine();
                siguePidiendo = false;

            }catch (InputMismatchException e){
                System.out.print("Valor erróneo. Tiene que introducir una cifra. ");
                input.nextLine();
            }
        }
        return numAlumn;
    }
    
    //VALIDA QUE EL STRING DEL INPUT SEA CORRECTO
    public String validadorString(String mensaje){
        System.out.print(mensaje);
        String nombre = input.nextLine();
        boolean pideMas = true;
        while (pideMas){
            if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ -]+")){
                pideMas = false;
            }else{
                System.out.print("Valor erróneo, por favor, introduce letras:  ");
                nombre = input.nextLine();
            }
        }
        return nombre;
    }

    //VALIDA QUE LA MATERIA INTRODUCIDA SEA CORRECTA
    public String validadorMateria(String mensaje){
        System.out.print(mensaje);
        String nombre = input.nextLine();
        boolean pideMas = true;
        while (pideMas){
            if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ -]+")){
                pideMas = false;
            }else{
                System.out.print("Valor erróneo, por favor, introduce letras:  ");
                nombre = input.nextLine();
            }
        }
        return nombre;
    }

    //VALIDA QUE LA NOTA SEA UN DOUBLE DE 0 A 10
    public Double validadorNota(){
        boolean siguePidiendo = true;
        boolean pideMAs = true;
        Double nota = 0.0;
        while (siguePidiendo){
            try {
                System.out.print("Introduce la nota: ");
                nota=input.nextDouble();
                input.nextLine();
                while (pideMAs){
                    if (nota>=0 && nota<=10){
                        siguePidiendo = false;
                        pideMAs = false;
                        break;
                    }else{
                        System.out.print("La nota tiene que oscilar entre 0 y 10. Introduce la nota: ");
                        nota=input.nextDouble();
                        input.nextLine();
                    }
                }
            } catch (InputMismatchException e){
                System.out.print("Número erróneo. ");
                input.nextLine();
            }
        }
        return nota;
    }
}