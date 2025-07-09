class Car {
    final String name;
    final int speed;

    public static final int MIN_SPEED = 1;
    public static final int MAX_SPEED = 250;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }
}