import java.util.Scanner;
public class Battleship{
    public static String[][] boardH={{"~","~","~","~","~","~","~","~","~","~"},{"~","~","~","~","~","~","~","~","~","~"},{"~","~","~","~","~","~","~","~","~","~"},{"~","~","~","~","~","~","~","~","~","~"},{"~","~","~","~","~","~","~","~","~","~"},{"~","~","~","~","~","~","~","~","~","~"},{"~","~","~","~","~","~","~","~","~","~"},{"~","~","~","~","~","~","~","~","~","~"},{"~","~","~","~","~","~","~","~","~","~"},{"~","~","~","~","~","~","~","~","~","~"}};
    public static String[][] board={{"~","~","~","~","~","~","~","~","~","~"},{"~","~","~","~","~","~","~","~","~","~"},{"~","~","~","~","~","~","~","~","~","~"},{"~","~","~","~","~","~","~","~","~","~"},{"~","~","~","~","~","~","~","~","~","~"},{"~","~","~","~","~","~","~","~","~","~"},{"~","~","~","~","~","~","~","~","~","~"},{"~","~","~","~","~","~","~","~","~","~"},{"~","~","~","~","~","~","~","~","~","~"},{"~","~","~","~","~","~","~","~","~","~"}};    
    public static void main(String[]args){
        System.out.println("WELCOME TO SHIP DESTROYER");
        Scanner input=new Scanner(System.in);
        String letters="ABCDEFGHIJ";
        setShip1();
        setShip2();
        setShip3();
        setShip4();
        setShip5();
        printBoard(board);
        int countA=0;
        int countB=0;
        int countC=0;
        int countF=0;
        int countS=0;
        int hitsLeft=17;
        while(hitsLeft>0 &&countA+countB+countC+countF+countS<17){
            System.out.println("CPU has hit "+(17-hitsLeft)+" of your ships pieces out of 17");
            System.out.print("Enter Row to Hit: ");
            String row=input.nextLine().toUpperCase();
            System.out.print("\nEnter Column To Hit: ");
            int col=input.nextInt()-1;
            input.nextLine();
            int newRow=letters.indexOf(row);
            if(letters.indexOf(row)!=-1&&col<10 && col>=0 && board[newRow][col].equals("~")){
                if(boardH[newRow][col].equals("A")){
                    System.out.println("HIT");
                    board[newRow][col]="H";
                    countA++;
                    if(countA==5){
                        System.out.println("You sank the Aircraft carrier");
                        for(int i=0;i<board.length;i++){
                            for(int j=0;j<board[0].length;j++){
                                if(boardH[i][j].equals("A")){
                                    board[i][j]="A";
                                }
                            }
                        }
                    }
                    printBoard(board);
                }
                else if(boardH[newRow][col].equals("B")){
                    board[newRow][col]="H";
                    countB++;
                    if(countB==4){
                        System.out.println("You sank the Battleship");
                        for(int i=0;i<board.length;i++){
                            for(int j=0;j<board[0].length;j++){
                                if(boardH[i][j].equals("B")){
                                    board[i][j]="B";
                                }
                            }
                        }
                    }
                    printBoard(board);
                }
                else if(boardH[newRow][col].equals("C")){
                    System.out.println("HIT");
                    board[newRow][col]="H";
                    countC++;
                    if(countC==2){
                        System.out.println("You sank the Cruiser");
                        for(int i=0;i<board.length;i++){
                            for(int j=0;j<board[0].length;j++){
                                if(boardH[i][j].equals("C")){
                                    board[i][j]="C";
                                }
                            }
                        }
                    }
                    printBoard(board);
                }
                else if(boardH[newRow][col].equals("S")){
                    System.out.println("HIT");
                    board[newRow][col]="H";
                    countS++;
                    if(countS==3){
                        System.out.println("You sank the Submarine");
                        for(int i=0;i<board.length;i++){
                            for(int j=0;j<board[0].length;j++){
                                if(boardH[i][j].equals("S")){
                                    board[i][j]="S";
                                }
                            }
                        }
                    }
                    printBoard(board);
                }
                else if(boardH[newRow][col].equals("F")){
                    System.out.println("HIT");
                    board[newRow][col]="H";
                    countF++;
                    if(countF==3){
                        System.out.println("You sank the Frigate");
                        for(int i=0;i<board.length;i++){
                            for(int j=0;j<board[0].length;j++){
                                if(boardH[i][j].equals("F")){
                                    board[i][j]="F";
                                }
                            }
                        }
                    }
                    printBoard(board);
                }
                else{
                    board[newRow][col]="M";
                    printBoard(board);
                    System.out.println("MISS");
                }
                int CPUguess=(int)(Math.random()*100)+1;
                if(CPUguess<18){
                    hitsLeft--;
                }
            }
            else{
                System.out.println("INVALID MOVE, TRY AGAIN");
            }
        }
        if(hitsLeft==0){
            printBoard(boardH);
            System.out.println("YOU LOSE");
        }
        else{
            System.out.println("YOU WIN, I hope you enjoyed playing single player Ship Destroyer!");
        }
        input.close();
    }
    public static void setShip1(){
        int direction=(int)(Math.random()*2);
        if(direction==1){
            int row=(int)(Math.random()*5)+3;
            int col=(int)(Math.random()*10);
            boardH[row][col]="A";
            boardH[row+1][col]="A";
            boardH[row+2][col]="A";
            boardH[row-1][col]="A";
            boardH[row-2][col]="A";

        }
        else{
            int row=(int)(Math.random()*10);
            int col=(int)(Math.random()*5)+3;
            boardH[row][col]="A";
            boardH[row][col+1]="A";
            boardH[row][col+2]="A";
            boardH[row][col-1]="A";
            boardH[row][col-2]="A";
        }
    }
    public static void setShip2(){
        int direction=(int)(Math.random()*2);
        if(direction==1){
            int row=(int)(Math.random()*7)+1;
            int col=(int)(Math.random()*10);
            if(row==1){
                if(!boardH[row][col].equals("A")&&!boardH[row-1][col].equals("A")&&!boardH[row+1][col].equals("A")&&!boardH[row+2][col].equals("A")){
                    boardH[row][col]="B";
                    boardH[row+1][col]="B";
                    boardH[row+2][col]="B";
                    boardH[row-1][col]="B";
                }
                else{
                    setShip2();
                }
            }
            else if(row==8){
                if(!boardH[row][col].equals("A")&&!boardH[row-1][col].equals("A")&&!boardH[row+1][col].equals("A")&&!boardH[row-2][col].equals("A")){
                    boardH[row][col]="B";
                    boardH[row+1][col]="B";
                    boardH[row-2][col]="B";
                    boardH[row-1][col]="B";
                }
                else{
                    setShip2();
                }
            }
            else{
                if(!boardH[row][col].equals("A")&&!boardH[row-1][col].equals("A")&&!boardH[row+1][col].equals("A")&&!boardH[row-2][col].equals("A")){
                    boardH[row][col]="B";
                    boardH[row+1][col]="B";
                    boardH[row-2][col]="B";
                    boardH[row-1][col]="B";
                }
                else{
                    setShip2();
                }
            }
        }
        else{
            int col=(int)(Math.random()*7)+1;
            int row=(int)(Math.random()*10);
            if(col==1){
                if(!boardH[row][col].equals("A")&&!boardH[row][col-1].equals("A")&&!boardH[row][col+1].equals("A")&&!boardH[row][col+2].equals("A")){
                    boardH[row][col]="B";
                    boardH[row][col+1]="B";
                    boardH[row][col+2]="B";
                    boardH[row][col-1]="B";
                }
                else{
                    setShip2();
                }
            }
            else if(col==8){
                if(!boardH[row][col].equals("A")&&!boardH[row][col-1].equals("A")&&!boardH[row][col+1].equals("A")&&!boardH[row][col-2].equals("A")){
                     boardH[row][col]="B";
                    boardH[row][col+1]="B";
                    boardH[row][col-2]="B";
                    boardH[row][col-1]="B";
                }
                else{
                    setShip2();
                }
            }
            else{
                if(!boardH[row][col].equals("A")&&!boardH[row][col-1].equals("A")&&!boardH[row][col+1].equals("A")&&!boardH[row][col+2].equals("A")){
                     boardH[row][col]="B";
                    boardH[row][col+1]="B";
                    boardH[row][col+2]="B";
                    boardH[row][col-1]="B";
                }
                else{
                    setShip2();
                }
            }
        }
    }
    public static void setShip3(){
        int direction=(int)(Math.random()*2);
        if(direction==1){
            int row=(int)(Math.random()*8)+1;
            int col=(int)(Math.random()*10);
            if(boardH[row][col].equals("~")&&boardH[row-1][col].equals("~")&&boardH[row+1][col].equals("~")){
                boardH[row][col]="F";
                boardH[row+1][col]="F";
                boardH[row-1][col]="F";
            }
            else{
                setShip3();
            }
        }
        else{
            int col=(int)(Math.random()*8)+1;
            int row=(int)(Math.random()*10);
            if(boardH[row][col].equals("~")&&boardH[row][col-1].equals("~")&&boardH[row][col+1].equals("~")){
                boardH[row][col]="F";
                boardH[row][col+1]="F";
                boardH[row][col-1]="F";
            }
            else{
                setShip3();
            }
        }
    }
    public static void setShip4(){
        int direction=(int)(Math.random()*2);
        if(direction==1){
            int row=(int)(Math.random()*8)+1;
            int col=(int)(Math.random()*10);
            if(boardH[row][col].equals("~")&&boardH[row-1][col].equals("~")&&boardH[row+1][col].equals("~")){
                boardH[row][col]="S";
                boardH[row+1][col]="S";
                boardH[row-1][col]="S";
            }
            else{
                setShip4();
            }
        }
        else{
            int col=(int)(Math.random()*8)+1;
            int row=(int)(Math.random()*10);
            if(boardH[row][col].equals("~")&&boardH[row][col-1].equals("~")&&boardH[row][col+1].equals("~")){
                boardH[row][col]="S";
                boardH[row][col+1]="S";
                boardH[row][col-1]="S";
            }
            else{
                setShip4();
            }
        }
    }
    public static void setShip5(){
        int direction=(int)(Math.random()*2);
        if(direction==1){
            int row=(int)(Math.random()*9)+1;
            int col=(int)(Math.random()*10);
            if(boardH[row][col].equals("~")&&boardH[row-1][col].equals("~")){
                boardH[row][col]="C";
                boardH[row-1][col]="C";
            }
            else{
                setShip5();
            }

        }
        else{
            int col=(int)(Math.random()*9)+1;
            int row=(int)(Math.random()*10);
            if(boardH[row][col].equals("~")&&boardH[row][col-1].equals("~")){
                boardH[row][col]="C";
                boardH[row][col-1]="C";
            }
            else{
                setShip5();
            }
        }
    }
    public static void printBoard(String[][] board){
        String letters="ABCDEFGHIJ";
        System.out.println("   1   2   3   4   5   6   7   8   9   10");
        for(int i=0;i<board.length;i++){
            System.out.print(letters.substring(i,i+1));
            for(int j=0;j<board[0].length;j++){
                System.out.print("| "+board[i][j]+" ");
            }
            System.out.print("|");
            System.out.println();
        }
    }
}