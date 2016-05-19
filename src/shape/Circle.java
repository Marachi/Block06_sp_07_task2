package shape;


public class Circle extends Shape implements Cloneable{
    private Point centerCircle;
    private double radius;

    public Circle(Point centerCircle, double radius) {
        this.centerCircle = centerCircle.clone();
        checkRadius(radius);
    }

    public Circle(double x, double y, double radius) {
        this.centerCircle = new Point(x, y);
        checkRadius(radius);
    }

    private void checkRadius(double radius) throws IllegalArgumentException {
        if( radius <= 0 ){
            throw new IllegalArgumentException("radius must be greater then 0");
        }
        this.radius = radius;
    }

    @Override
    public void move(double dx, double dy) {
        centerCircle.setX( centerCircle.getX() + dx);
        centerCircle.setY( centerCircle.getY() + dy);
    }

    @Override
    public double square() {
        return 3.14*radius*radius;
    }

    @Override
    public double perimeter() {
        return 2*3.14*radius;
    }

    public Point getCenterCircle() {
        return centerCircle.clone();
    }

    public void setCenterCircle(Point centerCircle) {
        this.centerCircle = centerCircle.clone();
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        checkRadius(radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "centerCircle=" + centerCircle +
                ", radius=" + radius +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
            Circle circle = (Circle) super.clone();
            //circle.setCenterCircle(this.getCenterCircle().clone());  <-- useless, getCenterCircle() has been already returning a clone!!!!
            circle.setCenterCircle(this.getCenterCircle());
            return circle;
    }
}
