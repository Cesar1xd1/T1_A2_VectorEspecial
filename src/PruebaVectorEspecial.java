import java.util.Arrays;
import java.util.Scanner;

class VectorEspecial{
	
	private int vec[];
	Scanner entrada = new Scanner(System.in);
	
	public VectorEspecial() {}
	public VectorEspecial(int tamaño) {
		this.vec = new int[tamaño];
	}
	public int[] getVec(){
		return this.vec;
	}
	public void setVec(int[] vec){
		this.vec = vec;
	}
	public int validacion() {
		int t = 0;
		boolean f = false;
		do {
			try {
				t = entrada.nextInt();
			} catch (java.util.InputMismatchException e) {
				System.out.println("El valor ingresado no es valido, intenta otra vez");
				entrada.nextLine();
				f=true;
				continue;
			}
			if (t>0) {
				f=false;
			}else {
				System.out.println("Solo puedes ingresar numero mayores a 0");
				f=true;
			}
		}while(f);
		return t;
	}
public void llenarVector() {
		for (int i = 0; i < vec.length; i=i+1) {
			System.out.println("ingrese los datos"+ (i+1) +" : ");
			vec[i]=this.validacion();
		}
	}
	public void mostrarVector() {
		System.out.println(Arrays.toString(vec));
	}
	public int obtenerPosicionI() {
		return this.vec[0];
	}
	public int obtenerPosicionF() {
		return this.vec[this.vec.length-1];
	}
	public int mostrarCantidadElementos() {
		return this.vec.length;
	}
	public void mostrarElementoI() {
		System.out.println(this.vec[0]);
	}
	public void mostrarElementoF() {
		System.out.println(this.vec[this.vec.length-1]);
	}
	public void aumentarTamaño(int magnitud) {
		while (magnitud<1) {
			System.out.println("la magnitud para aumentar el tamaño debe ser positiva, ingresela de nuevo: ");
			magnitud = entrada.nextInt();
		}
		int[] newArray = Arrays.copyOf(vec, vec.length + magnitud);
		this.setVec(newArray);
		System.out.println("el vector se aumentó éxitosamete en "+magnitud);
	}
	public void disminuirTamaño(int m) {
		boolean feil=false;
		do {
			feil=false;
			try {
				int[] nuevo = Arrays.copyOf(vec, vec.length - m);
				this.setVec(nuevo);
			} catch (NegativeArraySizeException e) {
				do {
					System.out.println("No puedes ingresar un valor mayor o igual al actual, intenta de nuevo:");
					m=entrada.nextInt();
					feil=true;
					continue;
				} while (m>this.mostrarCantidadElementos());
			}
		} while (feil);
		System.out.println("Se ha disminuido el vecto con: "+m);
	}
	public void insertarElementoPosiscion(int a, int b) {
		boolean fk=false;
		do {
			fk=false;
			try {
				this.getVec()[a-1]=b;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("solo peuedes tener de 1 a n posiciones, no puedes pasarte ni estar debajo,ni ser igual a 0, ingrese otra vez los datos");
				System.out.println("La posicion: ");
				a=this.validacion();
				System.out.println("El elemento: ");
				b=this.validacion();
				fk=true;
			}
		} while (fk);
	}
	public void eliminarElementoPosiscion(int i) {
		boolean f=false;
		do {
			f=false;
			try {
				this.getVec()[i-1]=0;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("solo se puede tener de 1 a n posiciones, no se puede exceder o ser inferior o igual a 0, vuelva a introducir la posicion: ");
				i = this.validacion();
				f=true;
			}
		} while (f);
		System.out.println("elemento eliminado exitosamente");
	}
	public void invertir() {
		int[] aux = Arrays.copyOf(vec, vec.length);
		int ivec[]=this.getVec();
		for (int i = 0; i < aux.length; i++) {
			aux[i]=ivec[ivec.length-1-i];
		}
		this.setVec(aux);
		System.out.println("vector invertido correctamente");
	}
}
public class PruebaVectorEspecial {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);

		boolean exit = false;
		byte opcion = 0;
		VectorEspecial ve = new VectorEspecial();
		System.out.println("tamaño del vector:");
		VectorEspecial ve1 = new VectorEspecial(ve.validacion());
		
		do {
			System.out.println(" 1)llenar vector \n 2)mostrar vector \n 3)obtener posicion inicio \n 4)obtener posicion final \n 5)obtener cantidad elementos \n 6)mostrar elemento inicio"
					+ " \n 7)mostrar elemento final \n 8)aumentar tamaño del arreglo \n 9)disminuir tamaño del arreglo \n 10)insertar elemento posicion especifica "
					+ "\n 11)eliminar elemento posicion especifica \n 12)invertir el vector \n 13)salir");
			
			try {
				opcion = entrada.nextByte();
			} catch (java.util.InputMismatchException e) {
				System.out.println("entrada no valida");
				entrada.nextLine();
			}
			if (opcion<1||opcion>13) {
				System.out.println("opcion no valida");
			}
			
			switch (opcion) {
			case 1:	ve1.llenarVector();break;
			case 2:	ve1.mostrarVector();break;
			case 3:	System.out.println(ve1.obtenerPosicionI());break;
			case 4:	System.out.println(ve1.obtenerPosicionF());break;
			case 5:	System.out.println(ve1.mostrarCantidadElementos());break;
			case 6:	ve1.mostrarElementoI();;break;
			case 7:	ve1.mostrarElementoF();;break;
			case 8:	
				System.out.println("ingresa el tamaño a aumentar: ");
				int t = ve.validacion();
				ve1.aumentarTamaño(t);;break;
			case 9:
				System.out.println("ingresa el tamaño a disminuir: ");
				int t1 = ve.validacion();
				ve1.disminuirTamaño(t1);;break;
			case 10:
				System.out.println("Ingresa la posiscion deseada:  ");
				int posicion = ve.validacion();
				System.out.println("Ingresa el elemento a insertar: ");
				int elemento = ve.validacion();
				ve1.insertarElementoPosiscion(posicion, elemento);
				break;
			case 11:
				System.out.println("Ingresa el elemento a eliminar:");
				int ele = ve.validacion();
				ve1.eliminarElementoPosiscion(ele);
				break;
			case 12:ve1.invertir();break;
			case 13:exit=true;break;
			default:break;
			}
			
		} while (!exit);
		System.out.println("Gracias por usar el programa!");
	}


	}


