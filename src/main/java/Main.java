import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        for (int i = 1; i <= 3; i++) {
            System.out.println("Введите название машины №" + i + ":");
            String name = scanner.nextLine().trim();
            while (name.isEmpty()) {
                System.out.println("Название машины не может быть пустым. Введите название машины №" + i + ":");
                name = scanner.nextLine().trim();
            }

            int speed = -1;
            while (speed < Car.MIN_SPEED || speed > Car.MAX_SPEED) {
                System.out.println("Введите скорость машины №" + i + ":");
                while (!scanner.hasNextInt()) {
                    System.out.println("Неправильный ввод. Введите целое число от " + Car.MIN_SPEED + " до " + Car.MAX_SPEED + ".");
                    scanner.next();
                }
                speed = scanner.nextInt();
                scanner.nextLine();
                if (speed < Car.MIN_SPEED || speed > Car.MAX_SPEED) {
                    System.out.println("Неправильная скорость. Скорость должна быть от " + Car.MIN_SPEED + " до " + Car.MAX_SPEED + " км/ч.");
                }
            }

            Car car = new Car(name, speed);
            race.determineNewLeader(car);
        }

        System.out.println("Самая быстрая машина: " + race.getLeaderName());
        scanner.close();
    }
}