package Java17;

public class SealedClassVerification {

    public static void main(String[] args) {

        Shape circle = new Circle();
        Shape rectangle = new Square();
        Shape triangle = new RightTriangle();

        circle.draw();
        rectangle.draw();
        triangle.draw();
    }
}


// =====================================================
// Parent Sealed Class
// =====================================================

sealed abstract class Shape
        permits Circle, Rectangle, Triangle {

    abstract void draw();
}


// =====================================================
// CASE 1 : final
// No further inheritance allowed
// =====================================================

final class Circle extends Shape {

    @Override
    void draw() {
        System.out.println("Drawing Circle");
    }
}


//---------------------------------------------------------
//UNCOMMENT TO VERIFY COMPILATION ERROR
/* 
class SpecialCircle extends Circle {
}*/

//Error: cannot inherit from final Circle
//---------------------------------------------------------



// =====================================================
// CASE 2 : sealed
// Further inheritance allowed only to permitted classes
// =====================================================

sealed class Rectangle extends Shape
        permits Square {

    @Override
    void draw() {
        System.out.println("Drawing Rectangle");
    }
}

final class Square extends Rectangle {

    @Override
    void draw() {
        System.out.println("Drawing Square");
    }
}

/*
---------------------------------------------------------
UNCOMMENT TO VERIFY COMPILATION ERROR */
/* 
class ColoredRectangle extends Rectangle {
}*/

/* 
Error: class is not allowed to extend sealed class: Rectangle

Reason: Rectangle only permits Square
---------------------------------------------------------
*/


// =====================================================
// CASE 3 : non-sealed
// Further inheritance completely unrestricted
// =====================================================

non-sealed class Triangle extends Shape {

    @Override
    void draw() {
        System.out.println("Drawing Triangle");
    }
}

class RightTriangle extends Triangle {

    @Override
    void draw() {
        System.out.println("Drawing Right Triangle");
    }
}

class AdvancedRightTriangle extends RightTriangle {

    @Override
    void draw() {
        System.out.println("Drawing Advanced Right Triangle");
    }
}
