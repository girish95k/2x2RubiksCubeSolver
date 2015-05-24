import java.util.*;
 

public class ADARubik {
 
    static int[] cubiesPos = new int[8];
    static int[] cubiesRot = new int[8];
    static int movecount = 0;
    static String moveList = "";
    static String[] diffMoves = {"U", "F", "R", "U'", "F'", "R'"};
 
    public static void main(String[] args) {
 
        char scrambles[] = {'n', 'y', 'y', 'y', 'y', 'g', 'g', 'g', 'g', 'w', 'w', 'w', 'w', 'b', 'b', 'b', 'b', 'r', 'r', 'r', 'r', 'o', 'o', 'o', 'o'};
    	
    	System.out.println("Enter the scramble: ");
        Scanner s = new Scanner(System.in);
        String scramble = s.nextLine();
        s.close();
        String[] move = scramble.split("");
        
        for(int i=0; i<move.length; i++)
        {
        	//System.out.print(move[i]);
        	if(move[i].equals("U"))
        	{
        		char temp1 = scrambles[5];
        		char temp2 = scrambles[6];
        		char temp3 = scrambles[15];
        		char temp4 = scrambles[16];
        		char temp5 = scrambles[17];
        		char temp6 = scrambles[18];
        		char temp7 = scrambles[21];
        		char temp8 = scrambles[22];
        		
        		scrambles[5]=temp7;
        		scrambles[6]=temp8;
        		scrambles[17]=temp1;
        		scrambles[18]=temp2;
        		scrambles[15]=temp6;
        		scrambles[16]=temp5;
        		scrambles[21]=temp4;
        		scrambles[22]=temp3;       
        		

        		char t1 = scrambles[1];
        		char t2 = scrambles[2];
        		char t3 = scrambles[3];
        		char t4 = scrambles[4];
        		
        		scrambles[2]=t1;
        		scrambles[3]=t4;
        		scrambles[4]=t2;
        		scrambles[1]=t3;
        	}
        	else if(move[i].equals("F"))
        	{
        		char temp1 = scrambles[3];
        		char temp2 = scrambles[4];
        		char temp3 = scrambles[9];
        		char temp4 = scrambles[10];
        		char temp5 = scrambles[18];
        		char temp6 = scrambles[20];
        		char temp7 = scrambles[21];
        		char temp8 = scrambles[23];
        		
        		scrambles[3]=temp6;
        		scrambles[4]=temp5;
        		scrambles[9]=temp8;
        		scrambles[10]=temp7;
        		scrambles[18]=temp3;
        		scrambles[20]=temp4;
        		scrambles[21]=temp1;
        		scrambles[23]=temp2;             		

        		char t1 = scrambles[5];
        		char t2 = scrambles[6];
        		char t3 = scrambles[7];
        		char t4 = scrambles[8];
        		
        		scrambles[6]=t1;
        		scrambles[7]=t4;
        		scrambles[8]=t2;
        		scrambles[5]=t3;
        	}
        	else if(move[i].equals("R"))
        	{
        		char temp1 = scrambles[2];
        		char temp2 = scrambles[4];
        		char temp3 = scrambles[6];
        		char temp4 = scrambles[8];
        		char temp5 = scrambles[10];
        		char temp6 = scrambles[12];
        		char temp7 = scrambles[14];
        		char temp8 = scrambles[16];
        		
        		scrambles[2]=temp3;
        		scrambles[4]=temp4;
        		scrambles[6]=temp5;
        		scrambles[8]=temp6;
        		scrambles[10]=temp7;
        		scrambles[12]=temp8;
        		scrambles[14]=temp1;
        		scrambles[16]=temp2;
        		
        		char t1 = scrambles[21];
        		char t2 = scrambles[22];
        		char t3 = scrambles[23];
        		char t4 = scrambles[24];
        		
        		scrambles[22]=t1;
        		scrambles[23]=t4;
        		scrambles[24]=t2;
        		scrambles[21]=t3;
        	}
        	else if(move[i].equals("D"))
        	{
        		/*
        		char temp1 = scrambles[7];
        		char temp2 = scrambles[8];
        		char temp3 = scrambles[13];
        		char temp4 = scrambles[14];
        		char temp5 = scrambles[19];
        		char temp6 = scrambles[20];
        		char temp7 = scrambles[23];
        		char temp8 = scrambles[24];
        		
        		scrambles[7]=temp5;
        		scrambles[8]=temp6;
        		scrambles[13]=temp8;
        		scrambles[14]=temp7;
        		scrambles[19]=temp4;
        		scrambles[20]=temp3;
        		scrambles[23]=temp1;
        		scrambles[24]=temp2;
        		*/
        	}        	
        	else if(move[i].equals("L"))
        	{
        		
        	}
        	else if(move[i].equals("B"))
        	{
        		
        	}
        	//System.out.println(scrambles);
        }
        
        System.out.println(scrambles);
 
 
        char[] input = new char[24];
        for (int x = 0; x < 24; x++) {
            //input[x] = scannerInput.next().charAt(0);
        	input[x]=scrambles[x+1];
        }
         
 
        char[][] cubies = new char[8][3];
 
        cubies[0] = new char[]{input[0],    input[16],  input[14]};
        cubies[1] = new char[]{input[1],    input[15],  input[21]};
        cubies[2] = new char[]{input[2],    input[4],   input[17]};
        cubies[3] = new char[]{input[3],    input[20],  input[5]};
        cubies[4] = new char[]{input[10],   input[12],  input[18]};
        cubies[5] = new char[]{input[11],   input[23],  input[13]};
        cubies[6] = new char[]{input[8],    input[19],  input[6]};
        cubies[7] = new char[]{input[9],    input[7],   input[22]};
 
        char[][] cubieColors = new char[][]{
            {'y', 'r', 'b'}, {'r', 'b', 'y'}, {'b', 'y', 'r'},
            {'y', 'b', 'o'}, {'b', 'o', 'y'}, {'o', 'y', 'b'},
            {'y', 'g', 'r'}, {'g', 'r', 'y'}, {'r', 'y', 'g'},
            {'y', 'o', 'g'}, {'o', 'g', 'y'}, {'g', 'y', 'o'},
            {'w', 'b', 'r'}, {'b', 'r', 'w'}, {'r', 'w', 'b'},
            {'w', 'o', 'b'}, {'o', 'b', 'w'}, {'b', 'w', 'o'},
            {'w', 'r', 'g'}, {'r', 'g', 'w'}, {'g', 'w', 'r'},
            {'w', 'g', 'o'}, {'g', 'o', 'w'}, {'o', 'w', 'g'}
        };
 
        for (int x = 0; x < 8; x++){
            int index = 0;
            while (true){
                if (Arrays.equals(cubies[x], cubieColors[index])) {
                    break;
                }
                index++;
            }
            cubiesPos[x] = index / 3;
            cubiesRot[x] = index % 3;
        }
 
        //System.out.println(cubiesPos);
        long startTime = System.nanoTime();

        String[] turns = trymoves(14);
        for(int q = 0; q<turns.length; ++q){
            moveList += turns[q];
            moveList += " ";
            movecount++;
        }
        

        long stopTime = (System.nanoTime() - startTime)/1000;
 
        System.out.println(moveList);
        System.out.format("Number of moves: %d\n", movecount);
        System.out.println(stopTime + " micrcoseconds");
 
    }
 
    public static String[] trymoves(int depth){
        String[] answer = {"NA"};
        int[] startPos = new int[8];
        int[] startRot = new int[8];
        startPos = cubiesPos;
        startRot = cubiesRot;
        // The number of senary digits to use.
        String sits = "";
        for(int s = 0; s<depth; ++s){
            sits += "5";
        }
        // Generates all numbers in base six up to 555555, which represent each possible sequence of six moves.
        for(long i = 0; i<=Long.parseLong(sits, 6); ++i){
            cubiesPos = startPos;
            cubiesRot = startRot;
            String movestring = Long.toString(i, 6);
            String[] moves = new String[movestring.length()];
            for(int d = 0; d<movestring.length(); ++d){
                String move = diffMoves[Integer.parseInt(movestring.substring(d,d+1))];
                moves[d] = move;
            }
            rotateFaces(moves);
            int correctcount = 0;
            for(int number = 0; number < 8; ++number){
                if(cubiesPos[number] == number && cubiesRot[number] == 0){
                    correctcount++;
                }
            } 
            if(correctcount==8){
                answer = moves;
                break;
            }
        }
        cubiesPos = startPos;
        cubiesRot = startRot;
        
        return answer;
    }

    public static void rotateFaces(String[] moves){ // Accepts an array of strings where each string corresponds to one move in the following switch statement
        for (String face : moves){                  // For example, if you want to rotate the top clockwise, the right counter-clockwise, and the front clockwise, you would do rotateFaces(new String []{"T", "R'", "F"});
            switch (face) {
                case "F":
                    cubiesPos = new int[]{cubiesPos[0], cubiesPos[1], cubiesPos[6], cubiesPos[2], cubiesPos[4], cubiesPos[5], cubiesPos[7], cubiesPos[3]};
                    cubiesRot = new int[]{cubiesRot[0], cubiesRot[1], (cubiesRot[6]+1) % 3, (cubiesRot[2]+2) % 3, cubiesRot[4], cubiesRot[5], (cubiesRot[7]+2) % 3, (cubiesRot[3]+1) % 3};
                    break;
                case "R":
                    cubiesPos = new int[]{cubiesPos[0], cubiesPos[3], cubiesPos[2], cubiesPos[7], cubiesPos[4], cubiesPos[1], cubiesPos[6], cubiesPos[5]};
                    cubiesRot = new int[]{cubiesRot[0], (cubiesRot[3]+2) % 3, cubiesRot[2], (cubiesRot[7]+1) % 3, cubiesRot[4], (cubiesRot[1]+1) % 3, cubiesRot[6], (cubiesRot[5]+2) % 3};
                    break;
                case "U":
                    cubiesPos = new int[]{cubiesPos[2], cubiesPos[0], cubiesPos[3], cubiesPos[1], cubiesPos[4], cubiesPos[5], cubiesPos[6], cubiesPos[7]};
                    cubiesRot = new int[]{cubiesRot[2], cubiesRot[0], cubiesRot[3], cubiesRot[1], cubiesRot[4], cubiesRot[5], cubiesRot[6], cubiesRot[7]};
                    break;
                case "F'":
                    cubiesPos = new int[]{cubiesPos[0], cubiesPos[1], cubiesPos[3], cubiesPos[7], cubiesPos[4], cubiesPos[5], cubiesPos[2], cubiesPos[6]};
                    cubiesRot = new int[]{cubiesRot[0], cubiesRot[1], (cubiesRot[3]+1) % 3, (cubiesRot[7]+2) % 3, cubiesRot[4], cubiesRot[5], (cubiesRot[2]+2) % 3, (cubiesRot[6]+1) % 3};
                    break;
                case "R'":
                    cubiesPos = new int[]{cubiesPos[0], cubiesPos[5], cubiesPos[2], cubiesPos[1], cubiesPos[4], cubiesPos[7], cubiesPos[6], cubiesPos[3]};
                    cubiesRot = new int[]{cubiesRot[0], (cubiesRot[5]+2) % 3, cubiesRot[2], (cubiesRot[1]+1) % 3, cubiesRot[4], (cubiesRot[7]+1) % 3, cubiesRot[6], (cubiesRot[3]+2) % 3};
                    break;
                case "U'":
                    cubiesPos = new int[]{cubiesPos[1], cubiesPos[3], cubiesPos[0], cubiesPos[2], cubiesPos[4], cubiesPos[5], cubiesPos[6], cubiesPos[7]};
                    cubiesRot = new int[]{cubiesRot[1], cubiesRot[3], cubiesRot[0], cubiesRot[2], cubiesRot[4], cubiesRot[5], cubiesRot[6], cubiesRot[7]};
                    break;
                default:
                    break;
            }
        }
    }
}
 
