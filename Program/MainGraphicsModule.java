// Е) основной модуль графики
public class MainGraphicsModule {
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

    public void drawStroke(List<Point> points) {
        // Реализовать инструмент кисти для рисования штрихов заказной кистью
    }

    public void stamp(List<Point> points) {
        // Реализовать инструмент штамп для рисования пикселями из другой области изображения
    }

    public void erase(List<Point> points) {
        // Реализовать инструмент ластика для изменения цвета пикселей на фоновый или прозрачный
    }

    public void createGradient(Rectangle gradientRect) {
        // Реализовать инструмент градиента для создания постепенного перехода между цветами
    }

    public void createPen(Path2D path) {
        // Реализовать инструмент пера для создания и изменения контуров или фигур
    }

    public void horizontalText(Path2D path) {
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
    
    public void drawShape(Shape shape) {
        // Реализовать инструмент "Фигура" для рисования заданной фигуры
    }
    
    public void pan(Point2D startPoint, Point2D endPoint) {
        // Реализовать инструмент "Рука" для панорамирования по разным фрагментам изображения
    }
    
    public void scaleImage(double scaleFactor) {
        // Реализовать инструмент "Масштаб" для увеличения или уменьшения масштаба изображения.
    }
}
