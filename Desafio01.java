import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Poligono {
    protected String nome;
    protected double lado;

    public Poligono(String nome, double lado) {
        this.nome = nome;
        this.lado = lado;
    }

    public abstract double calcularArea();

    @Override
    public String toString() {
        return nome + " de lado " + lado + "cm e área " + calcularArea() + "cm²";
    }
}

class Triangulo extends Poligono {
    public Triangulo(double lado) {
        super("Triângulo", lado);
    }

    @Override
    public double calcularArea() {
        return (lado * lado * Math.sqrt(3)) / 4;
    }
}

class Quadrado extends Poligono {
    public Quadrado(double lado) {
        super("Quadrado", lado);
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }
}

public class Desafio01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Poligono> poligonos = new ArrayList<>();

        while (true) {
            System.out.println("------------- Calculador de áreas -------------");
            System.out.print("Digite o número de lados (3 para triângulo, 4 para quadrado) ou 0 para finalizar o cálculo: ");
            int numeroLados = scanner.nextInt();

            
            if (numeroLados == 0) {
                break;
            } else if (numeroLados == 3 || numeroLados == 4) {
                System.out.print("Digite o tamanho do lado (em cm): ");
                double tamanhoLado = scanner.nextDouble();

                if (tamanhoLado > 0){
                    if (numeroLados == 3) {
                        poligonos.add(new Triangulo(tamanhoLado));
                    } else {
                        poligonos.add(new Quadrado(tamanhoLado));
                    }
                }else {
                    System.out.println("Valor do tamanho do lado inválido.");
                }
            } else {
                System.out.println("Número de lados inválido.");
            }
        }

        System.out.println("Polígonos inseridos:");
        double areaTotal = 0;

        for (Poligono poligono : poligonos) {
            System.out.println(poligono);
            areaTotal += poligono.calcularArea();
        }

        System.out.println("\nÁrea total: " + areaTotal + "cm²");
    
        scanner.close();
    }
}
