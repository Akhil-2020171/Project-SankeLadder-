public class Transport implements Runnable{
    private static int p;
    private static int boardvalue;

    Transport(int t, int b){
        p = t;
        boardvalue = b;
    }

    @Override
    public void run() {
        if(p==1){
            transportP1(boardvalue);
        }
        if(p==2){
            transportP2(boardvalue);
        }
    }

    private static void transportP1(int k){
        if(k == 38){
            App.P1posX = 140;
            App.P1posY = 380;
            App.P1pos = 3;
        }
        if(k == 14){
            App.P1posX = 380;
            App.P1posY = 500;
            App.P1pos = 1;
        }
        if(k == 31){
            App.P1posX = 560;
            App.P1posY = 380;
            App.P1pos = 3;
        }
        if(k == 26){
            App.P1posX = 320;
            App.P1posY = 440;
            App.P1pos = 2;
        }
        if(k == 42){
            App.P1posX = 80;
            App.P1posY = 320;
            App.P1pos = 4;
        }
        if(k == 84){
            App.P1posX = 200;
            App.P1posY = 80;
            App.P1pos = 8;
        }
        if(k == 44){
            App.P1posX = 200;
            App.P1posY = 320;
            App.P1pos = 4;
        }
        if(k == 67){
            App.P1posX = 380;
            App.P1posY = 200;
            App.P1pos = 6;
        }
        if(k == 98){
            App.P1posX = 140;
            App.P1posY = 20;
            App.P1pos = 9;
        }
        if(k == 91){
            App.P1posX = 580;
            App.P1posY = 20;
            App.P1pos = 9;
        }
        if(k == 94){
            App.P1posX = 380;
            App.P1posY = 20;
            App.P1pos = 9;
        }

        if(k==6){
            App.P1posX = 320;
            App.P1posY = 560;
            App.P1pos = 0;
        }
        if(k==25){
            App.P1posX = 260;
            App.P1posY = 440;
            App.P1pos = 2;
        }
        if(k==11){
            App.P1posX = 560;
            App.P1posY = 500;
            App.P1pos = 1;
        }
        if(k==60){
            App.P1posX = 20;
            App.P1posY = 260;
            App.P1pos = 6;
        }
        if(k==53){
            App.P1posX = 440;
            App.P1posY = 260;
            App.P1pos = 5;
        }
        if(k==88){
            App.P1posX = 440;
            App.P1posY = 260;
            App.P1pos = 8;
        }
        if(k==75){
            App.P1posX = 320;
            App.P1posY = 140;
            App.P1pos = 7;
        }
        if(k==80){
            App.P1posX = 20;
            App.P1posY = 140;
            App.P1pos = 8;
        }
        if(k==19){
            App.P1posX = 80;
            App.P1posY = 500;
            App.P1pos = 1;
        }
    }

    private static void transportP2(int k){
        if(k == 38){
            App.P2posX = 140;
            App.P2posY = 380;
            App.P2pos = 3;
        }
        if(k == 14){
            App.P2posX = 380;
            App.P2posY = 500;
            App.P2pos = 1;
        }
        if(k == 31){
            App.P2posX = 560;
            App.P2posY = 380;
            App.P2pos = 3;
        }
        if(k == 26){
            App.P2posX = 320;
            App.P2posY = 440;
            App.P2pos = 2;
        }
        if(k == 42){
            App.P2posX = 80;
            App.P2posY = 320;
            App.P2pos = 4;
        }
        if(k == 84){
            App.P2posX = 200;
            App.P2posY = 80;
            App.P2pos = 8;
        }
        if(k == 44){
            App.P2posX = 200;
            App.P2posY = 320;
            App.P2pos = 4;
        }
        if(k == 67){
            App.P2posX = 380;
            App.P2posY = 200;
            App.P2pos = 6;
        }
        if(k == 98){
            App.P2posX = 140;
            App.P2posY = 20;
            App.P2pos = 9;
        }
        if(k == 91){
            App.P2posX = 580;
            App.P2posY = 20;
            App.P2pos = 9;
        }
        if(k == 94){
            App.P2posX = 380;
            App.P2posY = 20;
            App.P2pos = 9;
        }

        if(k==6){
            App.P1posX = 320;
            App.P1posY = 560;
            App.P1pos = 0;
        }
        if(k==25){
            App.P1posX = 260;
            App.P1posY = 440;
            App.P1pos = 2;
        }
        if(k==11){
            App.P1posX = 560;
            App.P1posY = 500;
            App.P1pos = 1;
        }
        if(k==60){
            App.P1posX = 20;
            App.P1posY = 260;
            App.P1pos = 6;
        }
        if(k==53){
            App.P1posX = 440;
            App.P1posY = 260;
            App.P1pos = 5;
        }
        if(k==88){
            App.P1posX = 440;
            App.P1posY = 260;
            App.P1pos = 8;
        }
        if(k==75){
            App.P1posX = 320;
            App.P1posY = 140;
            App.P1pos = 7;
        }
        if(k==80){
            App.P1posX = 20;
            App.P1posY = 140;
            App.P1pos = 8;
        }
        if(k==19){
            App.P1posX = 80;
            App.P1posY = 500;
            App.P1pos = 1;
        }
    }
}