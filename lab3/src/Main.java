import functions.FunctionPoint;
import functions.TabulatedFunction;
import functions.ArrayTabulatedFunction;
import functions.LinkedListTabulatedFunction;
import functions.InappropriateFunctionPointException;

public class Main {
    public static void main(String[] args) {
        try {
            double[] values = {0, 1, 128, 2187, 16384};

            TabulatedFunction f = new ArrayTabulatedFunction(0, 4, values);

            System.out.println("Исходная функция:");
            printFunction(f);

            FunctionPoint p = f.getPoint(3);
            System.out.println("\nКопия точки с индексом 3: (" + p.getX() + "; " + p.getY() + ")");

            f.setPointY(3, 7);
            System.out.println("\nИзменение координаты Y точки с индексом 3:");
            printFunction(f);

            f.addPoint(new FunctionPoint(0.7, 11));
            System.out.println("\nДобавление точки (0.7; 11):");
            printFunction(f);

            f.deletePoint(2);
            System.out.println("\nУдаление точки с индексом 2:");
            printFunction(f);

            System.out.println("\nЗначение функции в точке x = -1:");
            try {
                double y = f.getFunctionValue(-1);
                System.out.println("y = " + y);
            } catch (Exception e) {
                System.out.println("Исключение при вычислении функции: " + e.getMessage());
            }

            System.out.println("\nЗначение функции в точке x = 3.4:");
            try {
                double y = f.getFunctionValue(3.4);
                System.out.println("y = " + y);
            } catch (Exception e) {
                System.out.println("Исключение при вычислении функции: " + e.getMessage());
            }

            System.out.println("\nПроверка исключения:");
            try {
                f.getPoint(100);
            } catch (Exception e) {
                System.out.println("Исключение: " + e.getMessage());
            }

        } catch (IndexOutOfBoundsException | InappropriateFunctionPointException e) {
            System.out.println("Исключение: " + e.getMessage());
        }
    }

    private static void printFunction(TabulatedFunction f) {
        for (int i = 0; i < f.getPointsCount(); i++) {
            System.out.println("Point " + i + ": (" + f.getPointX(i) + "; " + f.getPointY(i) + ")");
        }
    }
}