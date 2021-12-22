import javafx.animation.TranslateTransition;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Move implements Runnable{
    private static int T;
    private static Rectangle P;

    Move(Rectangle R,int k){
        P = R;
        T = k;
    }

    @Override
    public void run() {
        if(T==1){
            P1move();
        }
        if(T==2){
            P2move();
        }
    }

    private static void P1move(){
        for(int i = 0; i<App.random ; i++){
            if(App.P1pos%2==0){
                App.P1posX += 60;
            }
            if(App.P1pos%2!=0){
                App.P1posX -= 60;
            }
            if(App.P1posX >  600){
                App.P1posY -= 60;
                App.P1posX -= 60;
                App.P1pos++;
            }
            if(App.P1posX < 0){
                App.P1posY-=60;
                App.P1posX+=60;
                App.P1pos++;
            }
            if(App.P1posX < 20 && App.P1posY < 20){
                App.P1posX = 30;
                App.P1posY = 30;
                App.Result.setText("Player 1 has won!");
                App.gameb.setText("Start game again!");
                App.start = false;
                App.arrow1.setVisible(false);
                App.arrow2.setVisible(false);
            }
            animation(P, App.P1posX, App.P1posY);
            // App.win = App.checkWin();
        }

    }
    private static void P2move(){
        for(int i = 0 ; i< App.random ; i++){
            if(App.P2pos%2==0){
                App.P2posX += 60;
            }
            if(App.P2pos%2!=0){
                App.P2posX -= 60;
            }
            if(App.P2posX >  600){
                App.P2posY -= 60;
                App.P2posX -= 60;
                App.P2pos++;
            }
            if(App.P2posX < 10){
                App.P2posY-=60;
                App.P2posX+=60;
                App.P2pos++;
            }
            if(App.P2posX <  30 && App.P2posY < 30){
                App.P2posX = 30;
                App.P2posY = 30;
                App.Result.setText("Player 2 has won!");
                App.gameb.setText("Start game again!");
                App.start = false;
                App.arrow1.setVisible(false);
                App.arrow2.setVisible(false);
            }
            animation(P,App.P2posX,App.P2posY);
            // App.win = App.checkWin();
        }
    }

    private static void animation(Rectangle R , int a, int b){
        TranslateTransition animate = new TranslateTransition(Duration.millis(1000),R);
        animate.setToX(a);
        animate.setToY(b);
        animate.setAutoReverse(false);
        animate.play();
    }
    
}