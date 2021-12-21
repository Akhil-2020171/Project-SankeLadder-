import javafx.animation.PathTransition;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Paths {
    private static Rectangle P;

    // Ladders //
    private static final Line ladder1 = new Line(90,570,150,390);
    private static final Line ladder2 = new Line(390,570,390,510);
    private static final Line ladder3 = new Line(450,570,570,390);
    private static final Line ladder4 = new Line(330,510,330,450);
    private static final Line ladder5 = new Line(30,450,90,330);
    private static final Line ladder6 = new Line(450,450,210,90);
    private static final Line ladder7 = new Line(270,390,210,330);
    private static final Line ladder8 = new Line(570,270,390,210);
    private static final Line ladder9 = new Line(150,150,150,30);
    private static final Line ladder10 = new Line(570,150,570,30);
    private static final Line ladder11 = new Line(390,90,390,30);

    // Snake //
    private static final Polyline Snake1 = new Polyline(270,510,210,570,330,570);;
    private static final Polyline Snake2 = new Polyline(330,330,330,390,210,420,270,450);;
    private static final Polyline Snake3 = new Polyline(510,330,450,360,510,450,510,510,570,510);;
    private static final Polyline Snake4 = new Polyline(210,210,30,270);;
    private static final Polyline Snake5 = new Polyline(90,210,90,330,150,330,150,390,90,450,30,480,90,510);;
    private static final Polyline Snake6 = new Polyline(390,150,345,180,390,210,390,270,360,270,360,240,390,240,450,270);;
    private static final Polyline Snake7 = new Polyline(510,30,450,90);;
    private static final Polyline Snake8 = new Polyline(330,30,300,90,330,150);;
    private static final Polyline Snake9 = new Polyline(90,30,90,90,30,90,30,150);;

    Paths(Rectangle R){
        P = R;
    }    

    public int move(int k){
        int p = k;
        PathTransition move = new PathTransition(Duration.millis(2000),P);
        if(k==2){
            move.setNode(P);
            move.setPath(ladder1);
            move.setAutoReverse(false);
            move.play();
            p = 38;
            return p;
        }
        if(k==7){
            move.setNode(P);
            move.setPath(ladder2);
            move.setAutoReverse(false);
            move.play();
            p = 14;
            return p;
        }
        if(k==8){
            move.setNode(P);
            move.setPath(ladder3);
            move.setAutoReverse(false);
            move.play();
            p = 31;
            return p;
        }
        if(k==15){
            move.setNode(P);
            move.setPath(ladder4);
            move.setAutoReverse(false);
            move.play();
            p = 26;
            return p;
        }
        if(k==21){
            move.setNode(P);
            move.setPath(ladder5);
            move.setAutoReverse(false);
            move.play();
            p = 42;
            return p;
        }
        if(k==28){
            move.setNode(P);
            move.setPath(ladder6);
            move.setAutoReverse(false);
            move.play();
            p = 84;
            return p;
        }
        if(k==36){
            move.setNode(P);
            move.setPath(ladder7);
            move.setAutoReverse(false);
            move.play();
            p = 44;
            return p;
        }
        if(k==51){
            move.setNode(P);
            move.setPath(ladder8);
            move.setAutoReverse(false);
            move.play();
            p = 67;
            return p;
        }
        if(k==78){
            move.setNode(P);
            move.setPath(ladder9);
            move.setAutoReverse(false);
            move.play();
            p = 98;
            return p;
        }
        if(k==71){
            move.setNode(P);
            move.setPath(ladder10);
            move.setAutoReverse(false);
            move.play();
            p = 91;
            return p;
        }
        if(k==87){
            move.setNode(P);
            move.setPath(ladder11);
            move.setAutoReverse(false);
            move.play();
            p = 94;
            return p;
        }

        if(k==16){
            move.setNode(P);
            move.setPath(Snake1);
            move.setAutoReverse(false);
            move.play();
            p = 6;
            return p;
        }
        if(k==46){
            move.setNode(P);
            move.setPath(Snake2);
            move.setAutoReverse(false);
            move.play();
            p = 25;
            return p;
        }
        if(k==49){
            move.setNode(P);
            move.setPath(Snake3);
            move.setAutoReverse(false);
            move.play();
            p = 11;
            return p;
        }
        if(k==64){
            move.setNode(P);
            move.setPath(Snake4);
            move.setAutoReverse(false);
            move.play();
            p = 60;
            return p;
        }
        if(k==62){
            move.setNode(P);
            move.setPath(Snake5);
            move.setAutoReverse(false);
            move.play();
            p = 19;
            return p;
        }
        if(k==74){
            move.setNode(P);
            move.setPath(Snake6);
            move.setAutoReverse(false);
            move.play();
            p = 53;
            return p;
        }
        if(k==92){
            move.setNode(P);
            move.setPath(Snake7);
            move.setAutoReverse(false);
            move.play();
            p = 88;
            return p;
        }
        if(k==95){
            move.setNode(P);
            move.setPath(Snake8);
            move.setAutoReverse(false);
            move.play();
            p = 75;
            return p;
        }
        if(k==99){
            move.setNode(P);
            move.setPath(Snake9);
            move.setAutoReverse(false);
            move.play();
            p = 80;
            return p;
        }

        return p;
    }
}