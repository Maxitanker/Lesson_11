interface Shape {

    String getColorFill();
    String getBorderColor();
    void setColorFill(String color);
    void setBorderColor(String color);

    double calculateArea();
    double calculatePerimeter();
    default double getPerimeter() {
        return calculatePerimeter();
    }
}

// круг
class Circle implements Shape {
    private final double radius;
    private String ColorFill;
    private String borderColor;

    public Circle(double radius, String ColorFill, String borderColor) {
        this.radius = radius;
        this.ColorFill = ColorFill;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        return 3.14 * radius * radius;
    }
    @Override
    public double calculatePerimeter() {
        return 2 * 3.14 * radius;
    }
    @Override
    public String getColorFill() {
        return ColorFill;
    }
    @Override
    public String getBorderColor() {
        return borderColor;
    }
    @Override
    public void setColorFill(String color) {
        this.ColorFill = color;
    }
    @Override
    public void setBorderColor(String color) {
        this.borderColor = color;
    }
}

// прямоугольник
class Rectangle implements Shape {
    private final double width;
    private final double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }
    @Override
    public String getColorFill() {
        return fillColor;
    }
    @Override
    public String getBorderColor() {
        return borderColor;
    }
    @Override
    public void setColorFill(String color) {
        this.fillColor = color;
    }
    @Override
    public void setBorderColor(String color) {
        this.borderColor = color;
    }
}

// Класс Triangle (Треугольник)
class Triangle implements Shape {
    private final double side1;
    private final double side2;
    private final double side3;
    private String fillColor;
    private String borderColor;

    public Triangle(double side1, double side2, double side3, String fillColor, String borderColor) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }
    @Override
    public double calculateArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3)); // формула герона, вроде правильно получается
    }
    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
    @Override
    public String getColorFill() {
        return fillColor;
    }
    @Override
    public String getBorderColor() {
        return borderColor;
    }
    @Override
    public void setColorFill(String color) {
        this.fillColor = color;
    }
    @Override
    public void setBorderColor(String color) {
        this.borderColor = color;
    }
}

// класс для теста
public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5, "Красный", "Желтый");
        Shape rectangle = new Rectangle(4, 6, "Зеленый", "Синий");
        Shape triangle = new Triangle(3, 4, 5, "Желтый", "Белый");

        System.out.println("Круг:");
        System.out.println("Периметр: " + circle.getPerimeter());
        System.out.println("Площадь: " + circle.calculateArea());
        System.out.println("Цвет заливки: " + circle.getColorFill());
        System.out.println("Цвет границы: " + circle.getBorderColor());
        System.out.println();

        System.out.println("Прямоугольник:");
        System.out.println("Периметр: " + rectangle.getPerimeter());
        System.out.println("Площадь: " + rectangle.calculateArea());
        System.out.println("Цвет заливки: " + rectangle.getColorFill());
        System.out.println("Цвет границы: " + rectangle.getBorderColor());
        System.out.println();

        System.out.println("Треугольник:");
        System.out.println("Периметр: " + triangle.getPerimeter());
        System.out.println("Площадь: " + triangle.calculateArea());
        System.out.println("Цвет заливки: " + triangle.getColorFill());
        System.out.println("Цвет границы: " + triangle.getBorderColor());
        System.out.println();
    }
}
