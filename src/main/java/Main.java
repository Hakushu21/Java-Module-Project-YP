import java.util.Scanner;

class Car{
    private String name;
    private int speed;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName(){
        return name;
    }

    public int getSpeed(){
        return speed;
    }
}

class Race {
    private String leaderName = "";
    private int leaderDistance = 0;

    public void determineNewLeader(Car car) {
        int distance = 24 * car.getSpeed();
        if (distance > leaderDistance) {
            leaderDistance = distance;
            leaderName = car.getName();
        }
    }

    public String getLeaderName() {
        return leaderName;

    }
}

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
            while (speed < 0 || speed > 250) {
                System.out.println("Введите скорость машины №" + i + ":");
                while (!scanner.hasNextInt()) {
                    System.out.println("Неправильный ввод. Введите целое число от 0 до 250.");
                    scanner.next(); // очищаем неправильный ввод
                }
                speed = scanner.nextInt();
                scanner.nextLine(); // очищаем буфер после nextInt()
                if (speed < 0 || speed > 250) {
                    System.out.println("Неправильная скорость. Скорость должна быть от 0 до 250 км/ч.");
                }
            }

            Car car = new Car(name, speed);
            race.determineNewLeader(car);
        }

        System.out.println("Самая быстрая машина: " + race.getLeaderName());
        scanner.close();
    }
}