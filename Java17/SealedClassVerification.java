package Java17;

public class SealedClassVerification {

    public static void main(String[] args) {

        DrawingShape circle = new DrawingCircle();
        DrawingShape rectangle = new DrawingSquare();
        DrawingShape triangle = new DrawingRightTriangle();

        circle.draw();
        rectangle.draw();
        triangle.draw();
    }
}


// =====================================================
// Parent Sealed Class
// =====================================================

sealed abstract class DrawingShape
        permits DrawingCircle, DrawingRectangle, DrawingTriangle {

    abstract void draw();
}


// =====================================================
// CASE 1 : final
// No further inheritance allowed
// =====================================================

final class DrawingCircle extends DrawingShape {

    @Override
    void draw() {
        System.out.println("Drawing Circle");
    }
}


//---------------------------------------------------------
//UNCOMMENT TO VERIFY COMPILATION ERROR
/* 
class SpecialDrawingCircle extends DrawingCircle {
}*/

//Error: cannot inherit from final DrawingCircle
//---------------------------------------------------------



// =====================================================
// CASE 2 : sealed
// Further inheritance allowed only to permitted classes
// =====================================================

sealed class DrawingRectangle extends DrawingShape
        permits DrawingSquare {

    @Override
    void draw() {
        System.out.println("Drawing Rectangle");
    }
}

final class DrawingSquare extends DrawingRectangle {

    @Override
    void draw() {
        System.out.println("Drawing Square");
    }
}

/*
---------------------------------------------------------
UNCOMMENT TO VERIFY COMPILATION ERROR */
/* 
class ColoredDrawingRectangle extends DrawingRectangle {
}*/

/* 
Error: class is not allowed to extend sealed class: DrawingRectangle

Reason: DrawingRectangle only permits DrawingSquare
---------------------------------------------------------
*/


// =====================================================
// CASE 3 : non-sealed
// Further inheritance completely unrestricted
// =====================================================

non-sealed class DrawingTriangle extends DrawingShape {

    @Override
    void draw() {
        System.out.println("Drawing Triangle");
    }
}

class DrawingRightTriangle extends DrawingTriangle {

    @Override
    void draw() {
        System.out.println("Drawing Right Triangle");
    }
}

class DrawingAdvancedRightTriangle extends DrawingRightTriangle {

    @Override
    void draw() {
        System.out.println("Drawing Advanced Right Triangle");
    }
}
