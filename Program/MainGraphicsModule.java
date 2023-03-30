import java.util.List;

/**
 * Основной модуль графики
 * @author KattrinSue
 * @version 1.0.1
 */
public class MainGraphicsModule {

    public void setShapeDrawing(ShapeType shapeType) {
    }

    public enum ShapeType {
        RECTANGLE,
        ELLIPSE,
        TRIANGLE
    }
    public class Point2D {
    }
    public class Point {
    }
    public class Rectangle {
    }
    public class Path2D {
    }
    public class Shape {
    }

    public void moveObjects(List<Shape> shapes, Point2D startPoint, Point2D endPoint) {
        // Реализовать инструмент перемещения
    }

    public void selectRectangularArea(Point startPoint, Point endPoint) {
        // Реализовать инструмент прямоугольной области выделения
    }
    
    public void selectLassoArea(List<Point> lassoPoints) {
        // Реализовать инструмент лассо для произвольной области выделения
    }
  
    public void selectObjects() {
        // Реализовать инструмент выделения объектов
    }
  
    public void cropImage(Rectangle cropRect) {
        // Реализовать инструмент обрезки и расширения края изображения
    }
  
    public void createFrame(Rectangle frameRect) {
        // Реализовать инструмент создания кадров-местозаполнителей
    }
  
    public void pickColor(Point pickedPoint) {
        // Реализовать инструмент пипетки для взятия образца цвета
    }

    public void removeMarks(List<Point> points) {
        // Реализовать инструмент точечной восстанавливающей кисти
    }

    public void drawStroke() {
        // Реализовать инструмент кисти для рисования штрихов заказной кистью
        List<Point> points;
    }

    public void stamp(List<Point> points) {
        // Реализовать инструмент штамп для рисования пикселями из другой области изображения
    }

    public void erase() {
        // Реализовать инструмент ластика для изменения цвета пикселей на фоновый или прозрачный
        List<Point> points;
    }

    public void createGradient(Rectangle gradientRect) {
        // Реализовать инструмент градиента для создания постепенного перехода между цветами
    }

    public void createPen(Path2D path) {
        // Реализовать инструмент пера для создания и изменения контуров или фигур
    }

    public void horizontalText(String text) {
        // Реализовать инструмент горизонтального текста
    }

    public void blur(Rectangle rect) {
        // Реализовать инструмент "Размытие" для размытия области изображения
    }

    public void brighten(Rectangle rect) {
        // Реализовать инструмент "Осветлитель" для осветления области изображения
    }
    
    public void extractContour(Rectangle rect) {
        // Реализовать инструмент "Выделение контура"
    }

    /**
     * Инструмент "Фигура" рисует одной из трех видов фигур:
     *  - прямоугольник
     *  - эллипс
     *  - треугольник
     * @param shape принимает одно из трех состояний ShapeType: RECTANGLE, ELLIPSE, TRIANGLE
     */
    public void drawShape(Shape shape) {
        // Реализовать инструмент "Фигура" для рисования заданной фигуры
    }
    
    public void pan(Point2D startPoint, Point2D endPoint) {
        // Реализовать инструмент "Рука" для панорамирования по разным фрагментам изображения
    }
    
    public void scaleImage(double scaleFactor) {
        // Реализовать инструмент "Масштаб" для увеличения или уменьшения масштаба изображения.
    }

    public void setFillDrawing() {
    }
}
