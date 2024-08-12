abstract class Animal {

    // counter
    private static int animalCount = 0;
    public Animal() {
        animalCount++;
    }

    public abstract void run(int distance);
    public abstract void swim(int distance);
    public static int getAnimalCount() {
        return animalCount;
    }
}

// Класс Собака
class Dog extends Animal {
    private final String name;
    private static int dogCount = 0;
    public Dog(String name) {
        super();
        this.name = name;
        dogCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м.");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}

// Класс Кот
class Cat extends Animal {
    private final String name;
    private boolean isFull;
    private static int catCount = 0;

    public Cat(String name) {
        super();
        this.name = name;
        this.isFull = false; // Задание 2, не сыт
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public static int getCatCount() {
        return catCount;
    }



    public void eat(FoodBowl bowl, int amount) {
        if (bowl.getFoodAmount() >= amount) {
            bowl.decreaseFood(amount);
            this.isFull = true;
            System.out.println(name + " поел.");
        } else {
            System.out.println(name + " не хватает еды в миске.");
        }
    }

    public boolean isFull() {
        return isFull;
    }


}

// Класс Миска
class FoodBowl {
    private int foodAmount;

    public FoodBowl(int initialFood) {
        this.foodAmount = initialFood;
    }

    public int getFoodAmount() {
        return foodAmount;
    }
    // чек на -еды, задание 1
    public void decreaseFood(int amount) {
        if (amount <= foodAmount) {
            foodAmount -= amount;
        } else {
            foodAmount = 0;
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
        }
    }
}

// Задания, выводы
public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Шарик");
        Dog dog2 = new Dog("Бобик");

        Cat cat1 = new Cat("Мурка");
        Cat cat2 = new Cat("Ракси");
        Cat cat3 = new Cat("Том");

        System.out.println("Общее количество животных: " + Animal.getAnimalCount());
        System.out.println("Количество собак: " + Dog.getDogCount());
        System.out.println("Количество котов: " + Cat.getCatCount());
        System.out.println();
        System.out.println();

        FoodBowl bowl = new FoodBowl(20);

        System.out.println("Задание 1, бег/плавание");

        dog1.run(300);
        dog1.swim(5);
        dog2.run(600);  // false
        dog2.swim(15);  // false
        System.out.println();

        cat1.run(150);
        cat1.swim(5);  // false
        cat2.run(250);  // false
        cat2.swim(10);  // False
        cat3.run(50);
        cat3.swim(20);  //false
        System.out.println();
        System.out.println();

        System.out.println("Задание 1_2, коты едят");
        cat1.eat(bowl, 5);  // 15
        cat2.eat(bowl, 7);  // 8
        cat3.eat(bowl, 10); // false
        System.out.println("");

        System.out.println("Мурка сыта: " + cat1.isFull());
        System.out.println("Ракси сыта: " + cat2.isFull());
        System.out.println("Том сыт: " + cat3.isFull());
        System.out.println();

        // добавление еды, третий кот снова ест
        bowl.addFood(10);
        cat3.eat(bowl, 10);
        System.out.println("Том сыт: " + cat3.isFull());


    }
}
