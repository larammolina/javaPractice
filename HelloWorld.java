
public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
        int primerValorIngresado;
        primerValorIngresado = input.nextInt();
        System.out.println("Ud ingreso el valor:" + primerValorIngresado);
        System.out.println("Ingrese otro valor");
        Scanner input2 = new Scanner (System.in);
        int segundoValorIngresado = input2.nextInt();
        System.out.println("Ud ingreso el valor:" + segundoValorIngresado);
        int suma = primerValorIngresado + segundoValorIngresado;
        System.out.println("la suma es: " + suma);

	}

}
