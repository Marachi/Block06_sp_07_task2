package shape;

/**
 * Created by User on 07.04.2016.
 */
public class Rectangle extends Shape implements Cloneable{
    private Point leftTop;// = new Point();
    private Point rightBottom;// = new Point();

    public Rectangle(Point leftTop, Point rightBottom) {
        this.leftTop = leftTop.clone();
        this.rightBottom = rightBottom.clone();
    }

    public Rectangle(double left, double top, double right
            , double bottom){
        this.leftTop = new Point(left,top);
        this.rightBottom = new Point( right , bottom );
    }

    @Override
    public void move(double dx, double dy) {
        leftTop.setX( leftTop.getX() + dx);
        leftTop.setY( leftTop.getY() + dy);
        rightBottom.setX( rightBottom.getX() + dx);
        rightBottom.setY( rightBottom.getY() + dy);
    }

    @Override
    public double perimeter() {
        return 2.*(Math.abs(rightBottom.getX() - leftTop.getX()) +
                Math.abs(rightBottom.getY() - leftTop.getY()));
    }

    @Override
    public double square() {
        return Math.abs((rightBottom.getX() - leftTop.getX())*
                (rightBottom.getY() - leftTop.getY()));
    }

    public Point getRightBottom() {
        return rightBottom.clone();
    }

    public void setRightBottom(Point rightBottom) {
        this.rightBottom = rightBottom.clone();
    }

    public Point getLeftTop() {
        return leftTop.clone();
    }

    public void setLeftTop(Point leftTop) {
        this.leftTop = leftTop.clone();
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "leftTop=" + leftTop +
                ", rightBottom=" + rightBottom +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Rectangle rectangle = (Rectangle) super.clone();
        //rectangle.setLeftTop(this.getLeftTop().clone()); <-- useless, getLeftTop() has been already returning a clone
        rectangle.setLeftTop(this.getLeftTop());
        rectangle.setRightBottom(this.getRightBottom());
        return rectangle;
    }
}
