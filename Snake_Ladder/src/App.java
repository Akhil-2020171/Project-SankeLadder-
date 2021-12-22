import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Group;

public class App extends Application{
    private static final int tile_size = 60;
    private static final int length = 10;
    private static final int breadth = 10;
    private static final int ladder[] = {2,7,8,15,21,28,36,51,78,71,87};
    private static final int snake[]  = {16,46,49,64,74,92,95,99,62};

    private static Group tileG = new Group();

    private static int random;
    private static Button gameb;
    private static Label Result;
    private static ImageView Dice;
    private static ImageView arrow1;
    private static ImageView arrow2;

    private static boolean turnP1 = false;
    private static boolean turnP2 = false;
    private static boolean start = false;

    private static int P1posX = 670;
    private static int P1posY = 60;

    private static int P2posX = 810;
    private static int P2posY = 60;

    private static int P1pos;
    private static int P2pos;

    private static int P1onboard;
    private static int P2onboard;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primarystage) throws Exception {
        Scene scene = new Scene(Game());
        primarystage.setTitle("Snake and Ladder");
        primarystage.setScene(scene);
        primarystage.show();
    }

    private static Parent Game(){
        Pane root = new Pane();
        root.setPrefSize(breadth*tile_size+320,length*tile_size);
        root.getChildren().addAll(tileG);

        for(int i = 0; i<length ; i++){
            for(int j =0 ; j<breadth ; j++){
                Slot slot = new Slot(tile_size,tile_size);
                slot.setTranslateX(j*tile_size);
                slot.setTranslateY(i*tile_size);
                tileG.getChildren().add(slot);
            }
        }

        arrow1 = new ImageView("arrow.gif");
        arrow1.setFitWidth(40);
        arrow1.setFitHeight(40);
        arrow1.setTranslateX(620);
        arrow1.setTranslateY(25);
        arrow1.setVisible(false);

        arrow2 = new ImageView("arrow.gif");
        arrow2.setFitWidth(40);
        arrow2.setFitHeight(40);
        arrow2.setTranslateX(760);
        arrow2.setTranslateY(25);
        arrow2.setVisible(false);

        Rectangle P1 = new Rectangle(30, 30, Color.RED);
        P1.setId("Player 1");
        P1.setTranslateX(P1posX);
        P1.setTranslateY(P1posY);

        Rectangle P1Demo = new Rectangle(30, 30, Color.RED);
        P1Demo.setId("Player 1");
        P1Demo.setTranslateX(670);
        P1Demo.setTranslateY(60);

        Rectangle P2 = new Rectangle(30, 30, Color.YELLOWGREEN);
        P2.setId("Player 2");
        P2.setTranslateX(P2posX);
        P2.setTranslateY(P2posY);

        Rectangle P2Demo = new Rectangle(30, 30, Color.YELLOWGREEN);
        P2Demo.setId("Player 2");
        P2Demo.setTranslateX(810);
        P2Demo.setTranslateY(60);

        Result = new Label("Dice value : 0");
        Result.setTranslateX(720);
        Result.setTranslateY(120);

        Label Position1text = new Label("Player 1 Position : "+P1onboard);
        Position1text.setTranslateX(620);
        Position1text.setTranslateY(200);

        Label Position2text = new Label("Player 2 Position : "+P2onboard);
        Position2text.setTranslateX(620);
        Position2text.setTranslateY(250);

        Label StartText = new Label("Discription : Press this button to start the game");
        StartText.setTranslateX(620);
        StartText.setTranslateY(430);

        gameb = new Button("Start the Game");
        gameb.setTranslateX(660);
        gameb.setTranslateY(400);
        gameb.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                gameb.setText("Game has been started");
                start = true;
                arrow1.setVisible(true);
                arrow2.setVisible(true);
            }
        });

        Label stopText = new Label("Discription : Press this button to Reset the game");
        stopText.setTranslateX(620);
        stopText.setTranslateY(540);

        Button stop = new Button("Stop the Game");
        stop.setTranslateX(660);
        stop.setTranslateY(500);
        stop.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                gameb.setText("Start the Game");
                P1posX = 670;
                P1posY = 60;
                P2posX = 810;
                P2posY = 60;

                P1.setTranslateX(P1posX);
                P1.setTranslateY(P1posY);
                P2.setTranslateX(P2posX);
                P2.setTranslateY(P2posY);

                P1pos = 0;
                P2pos = 0;

                P1onboard = 0;
                P2onboard = 0;

                Position1text.setText("Player 1 Position : "+String.valueOf(P1onboard));
                Position2text.setText("Player 2 Position : "+String.valueOf(P2onboard));

                start = false;
                arrow1.setVisible(false);
                arrow2.setVisible(false);
                Result.setText("Dice value : 0");
            }
        });
        
        Button button1 = new Button("Player 1");
        button1.setTranslateX(660);
        button1.setTranslateY(30);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                arrow1.setVisible(false);
                arrow2.setVisible(true);
                if(start){
                    getRandom();
                    showdice();
                    Result.setText("Dice value : "+String.valueOf(random));
                    if(!turnP1 && P1onboard==0){
                        if(random==1){
                            turnP1 = true;
                            P1posX = 10;
                            P1posY = 550;
                            P1.setTranslateX(P1posX);
                            P1.setTranslateY(P1posY);
                            P1onboard = 1;
                            Position1text.setText("Player 1 Position : "+String.valueOf(P1onboard));
                        }
                    }
                    else if((turnP1 || !turnP2) && P1onboard>=1){
                        P1onboard = addposition(P1onboard);
                        P1move(P1);
                        Position2text.setText("Player 2 Position : "+String.valueOf(P2onboard));
                        boolean checkLadder = false;
                        boolean checkSnake = false;
                        for(int i = 0 ; i<11 ; i++){
                            if(ladder[i] == P1onboard){
                                checkLadder = true;
                                break;
                            }
                        }
                        if(checkLadder){
                            Paths pm = new Paths(P1);
                            P1onboard =  pm.move(P1onboard);
                            transportP1(P1onboard);
                        }
    
                        for(int i = 0 ; i<9 ; i++){
                            if(snake[i] == P1onboard){
                                checkSnake = true;
                                break;
                            }
                        }
                        if(checkSnake){
                            Paths pm = new Paths(P1);
                            P1onboard = pm.move(P1onboard);
                            transportP1(P1onboard);
                        }
                        Position1text.setText("Player 1 Position : "+String.valueOf(P1onboard));
                        turnP1 = false;
                        if(P2onboard>=1){
                            turnP2 = true;
                        }
                    }
                }
            }
        });

        Button button2 = new Button("Player 2");
        button2.setTranslateX(800);
        button2.setTranslateY(30);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
                arrow2.setVisible(false);
                arrow1.setVisible(true);
                if(start){
                    getRandom();
                    showdice();
                    Result.setText("Dice value : "+String.valueOf(random));
                    if(!turnP2 && P2onboard==0){
                        if(random==1){
                            turnP2 = true;
                            P2posX = 20;
                            P2posY = 550;
                            P2.setTranslateX(P2posX);
                            P2.setTranslateY(P2posY);
                            P2onboard = 1;
                            Position2text.setText("Player 2 Position : "+String.valueOf(P2onboard));
                        }
                    }
                    else if((turnP2 || !turnP1) && P2onboard>=1){
                        P2onboard = addposition(P2onboard);
                        P2move(P2);
                        Position2text.setText("Player 2 Position : "+String.valueOf(P2onboard));
                        boolean checkLadder = false;
                        boolean checkSnake = false;
                        for(int i = 0 ; i<11 ; i++){
                            if(ladder[i] == P2onboard){
                                checkLadder = true;
                                break;
                            }
                        }
                        if(checkLadder){
                            Paths pm = new Paths(P2);
                            P2onboard =  pm.move(P2onboard);
                            transportP2(P2onboard);
                        }
    
                        for(int i = 0 ; i<9 ; i++){
                            if(snake[i] == P2onboard){
                                checkSnake = true;
                                break;
                            }
                        }
                        if(checkSnake){
                            Paths pm = new Paths(P2);
                            P2onboard = pm.move(P2onboard);
                            transportP1(P2onboard);
                        }
                        Position2text.setText("Player 2 Position : "+String.valueOf(P2onboard));
                        turnP2 = false;
                        if(P1onboard>=1){
                            turnP1 = true;
                        }
                    }    
                }
            }
        });
      

        Image img = new Image("SnakeLadder.jpg");
        ImageView bgimg = new ImageView();
        bgimg.setImage(img);
        bgimg.setFitHeight(600);
        bgimg.setFitWidth(600);

        Dice = new ImageView("dice4.png");
        Dice.setFitHeight(90);
        Dice.setFitWidth(90);
        Dice.setTranslateX(700);
        Dice.setTranslateY(300);

        tileG.getChildren().addAll(bgimg,gameb,stop,StartText,stopText,Dice,P1,P1Demo,P2,P2Demo,button1,button2,arrow1,arrow2,Result,Position1text,Position2text);
        return root;
    }

    private static void showdice(){
        Image img;
        // for(int i = 0 ; i<15 ; i++){
        //     img = new Image("dice"+(int)(Math.random()*6+1)+".png");
        //     Dice = new ImageView();
        //     Dice.setImage(img);
        //     Dice.setFitHeight(90);
        //     Dice.setFitWidth(90);
        // }
        img = new Image("dice"+random+".png");
        Dice = new ImageView();
        Dice.setImage(img);
        Dice.setFitHeight(90);
        Dice.setFitWidth(90);
        Dice.setTranslateX(700);
        Dice.setTranslateY(300);
        tileG.getChildren().add(Dice);
    }

    private static void getRandom(){
        random = (int)(Math.random()*6 + 1);
    }

    private static int addposition(int position){
        if(position<=100){
            return position+random;
        }
        else return position;
    }

    private static void animation(Rectangle R , int a, int b){
        TranslateTransition animate = new TranslateTransition(Duration.millis(1000),R);
        animate.setToX(a);
        animate.setToY(b);
        animate.setAutoReverse(false);
        animate.play();
    }

    private static void P1move(Rectangle P1){
        for(int i = 0; i<random ; i++){
            if(P1pos%2==0){
                P1posX += 60;
            }
            if(P1pos%2!=0){
                P1posX -= 60;
            }
            if(P1posX >= 600 && P1onboard <100){
                P1posY -= 60;
                P1posX -= 60;
                P1pos++;
            }
            if(P1posX <= 0 && P1onboard <100){
                P1posY-=60;
                P1posX+=60;
                P1pos++;
            }
            if(P1posX <= 0 && P1posY <=0){
                P1posX = 30;
                P1posY = 30;
                Result.setText("Player 1 has won!");
                gameb.setText("Start game again!");
                start = false;
            }
            animation(P1, P1posX, P1posY);
        }

    }

    private static void P2move(Rectangle P2){
        for(int i = 0 ; i< random ; i++){
            if(P2pos%2==0){
                P2posX += 60;
            }
            if(P2pos%2!=0){
                P2posX -= 60;
            }
            if(P2posX >= 600 && P2onboard <100){
                P2posY -= 60;
                P2posX -= 60;
                P2pos++;
            }
            if(P2posX <= 10 && P2onboard <100){
                P2posY-=60;
                P2posX+=60;
                P2pos++;
            }
            if(P2posX <= 60 && P2posY <= 60){
                P2posX = 30;
                P2posY = 30;
                Result.setText("Player 2 has won!");
                gameb.setText("Start game again!");
                start = false;
            }
            animation(P2,P2posX,P2posY);
        }
    }

    private static void transportP1(int k){
        if(k == 38){
            P1posX = 140;
            P1posY = 380;
            P1pos = 3;
        }
        if(k == 14){
            P1posX = 380;
            P1posY = 500;
            P1pos = 1;
        }
        if(k == 31){
            P1posX = 560;
            P1posY = 380;
            P1pos = 3;
        }
        if(k == 26){
            P1posX = 320;
            P1posY = 440;
            P1pos = 2;
        }
        if(k == 42){
            P1posX = 80;
            P1posY = 320;
            P1pos = 4;
        }
        if(k == 84){
            P1posX = 200;
            P1posY = 80;
            P1pos = 8;
        }
        if(k == 44){
            P1posX = 200;
            P1posY = 320;
            P1pos = 4;
        }
        if(k == 67){
            P1posX = 380;
            P1posY = 200;
            P1pos = 6;
        }
        if(k == 98){
            P1posX = 140;
            P1posY = 20;
            P1pos = 9;
        }
        if(k == 91){
            P1posX = 580;
            P1posY = 20;
            P1pos = 9;
        }
        if(k == 94){
            P1posX = 380;
            P1posY = 20;
            P1pos = 9;
        }

        if(k==6){
            P1posX = 320;
            P1posY = 560;
            P1pos = 0;
        }
        if(k==25){
            P1posX = 260;
            P1posY = 440;
            P1pos = 2;
        }
        if(k==11){
            P1posX = 560;
            P1posY = 500;
            P1pos = 1;
        }
        if(k==60){
            P1posX = 20;
            P1posY = 260;
            P1pos = 6;
        }
        if(k==53){
            P1posX = 440;
            P1posY = 260;
            P1pos = 5;
        }
        if(k==88){
            P1posX = 440;
            P1posY = 260;
            P1pos = 8;
        }
        if(k==75){
            P1posX = 320;
            P1posY = 140;
            P1pos = 7;
        }
        if(k==80){
            P1posX = 20;
            P1posY = 140;
            P1pos = 8;
        }
        if(k==19){
            P1posX = 80;
            P1posY = 500;
            P1pos = 1;
        }
    }

    private static void transportP2(int k){
        if(k == 38){
            P2posX = 140;
            P2posY = 380;
            P2pos = 3;
        }
        if(k == 14){
            P2posX = 380;
            P2posY = 500;
            P2pos = 1;
        }
        if(k == 31){
            P2posX = 560;
            P2posY = 380;
            P2pos = 3;
        }
        if(k == 26){
            P2posX = 320;
            P2posY = 440;
            P2pos = 2;
        }
        if(k == 42){
            P2posX = 80;
            P2posY = 320;
            P2pos = 4;
        }
        if(k == 84){
            P2posX = 200;
            P2posY = 80;
            P2pos = 8;
        }
        if(k == 44){
            P2posX = 200;
            P2posY = 320;
            P2pos = 4;
        }
        if(k == 67){
            P2posX = 380;
            P2posY = 200;
            P2pos = 6;
        }
        if(k == 98){
            P2posX = 140;
            P2posY = 20;
            P2pos = 9;
        }
        if(k == 91){
            P2posX = 580;
            P2posY = 20;
            P2pos = 9;
        }
        if(k == 94){
            P2posX = 380;
            P2posY = 20;
            P2pos = 9;
        }

        if(k==6){
            P1posX = 320;
            P1posY = 560;
            P1pos = 0;
        }
        if(k==25){
            P1posX = 260;
            P1posY = 440;
            P1pos = 2;
        }
        if(k==11){
            P1posX = 560;
            P1posY = 500;
            P1pos = 1;
        }
        if(k==60){
            P1posX = 20;
            P1posY = 260;
            P1pos = 6;
        }
        if(k==53){
            P1posX = 440;
            P1posY = 260;
            P1pos = 5;
        }
        if(k==88){
            P1posX = 440;
            P1posY = 260;
            P1pos = 8;
        }
        if(k==75){
            P1posX = 320;
            P1posY = 140;
            P1pos = 7;
        }
        if(k==80){
            P1posX = 20;
            P1posY = 140;
            P1pos = 8;
        }
        if(k==19){
            P1posX = 80;
            P1posY = 500;
            P1pos = 1;
        }
    }
}