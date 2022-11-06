import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        System.out.println("Введите длины трёх сторон треугольника:");
        System.out.print("Первая сторона равна ");
        double a = enterNum();
        System.out.print("Вторая сторона равна ");
        double b = enterNum();
        System.out.print("Третья сторона равна ");
        double c = enterNum();
        if (!isTriangle(a, b, c)) {
            System.out.println("По введённым длинам невозможно построить треугольник");
            return;
        }
        System.out.println("Радиус описанной окружности равен " + radius(a, b, c));
    }
    // метод задания длины стороны треугольника
    public static double enterNum() {
        double x = -1;
        Scanner scanner = new Scanner(System.in);
        while (x <= 0) {
            if (scanner.hasNextDouble()) {
                x = scanner.nextDouble();
                if (x > 0) {
                    return x;
                } else {
                    System.out.println("Отрицательное число, введите снова!");
                }
            } else {
                System.out.println("Вы ввели не число, введите снова!");
                scanner.nextLine();
                continue;
            }
        }
        return x;
    }
    // проверка корректности соотношения сторон
    public static boolean isTriangle(double a, double b, double c) {
        if ((a < b + c) && (b < c + a) && (c < a + b)) {
            return true;
        }
        return false;
    }
    // метод вычисления площади треугольника по формуле Герона
    public static double area(double a, double b, double c) {
        double p = ((a + b + c) / 2);
        double squareTriangle = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return squareTriangle;
    }
    // метод вычисления радиуса окружности описывающей треугольник
    public static double radius(double a, double b, double c) {
        double radiusTriangle = (a * b * c) / (4 * area(a, b, c));
        return radiusTriangle;
    }
}
