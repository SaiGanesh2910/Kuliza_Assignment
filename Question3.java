import java.util.*;

public class Question3 {
    static int n;
    static int destinationX,destinationY; 
    static long max=Integer.MAX_VALUE;
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        destinationX=n-1;destinationY=n-1;              // destinationX and destinationY is the destination that is (n-1,n-1) 
        int res[][]=new int[n-1][n-1];
        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++){
                HashMap<String,Integer> hm=new HashMap<>();             // To store the visited node or cell
                long v=countMoves(i,j,0,0,hm);
                if(v>=max){
                    v=-1;                                  // Unreachable point
                }
                res[i-1][j-1]=(int)v;           // Matrix storing
                hm.clear();
            }
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
        
        sc.close();
    }
    private static long countMoves(int a, int b,int sourceX,int sourceY,HashMap<String,Integer> hm) {
        String str=sourceX+","+sourceY;                      
        if(sourceX==destinationX && sourceY==destinationY){
            return 0;                 //  When node is reached
        }
        if(sourceX<0||sourceX>n-1||sourceY<0||sourceY>n-1)
        {
            return max;                 // when i or j values are not valid
        }
        if(hm.get(str)!=null){
            return max;                   // Checking whether node is visited or not
        }
        else{
            hm.put(str,1);          // If point is not visited marking it as visited
        }
        
        return Math.min(Math.min(Math.min(1+countMoves(a,b,sourceX+a,sourceY+b,hm), 1+countMoves(a,b,sourceX-a,sourceY-b,hm)),Math.min(1+ countMoves(a,b,sourceX+a,sourceY-b,hm) , 1+countMoves(a,b,sourceX-a,sourceY+b,hm))),
        Math.min(Math.min(1+countMoves(a,b,sourceX+b,sourceY+a,hm), 1+countMoves(a,b,sourceX-b,sourceY-a,hm)),Math.min(1+ countMoves(a,b,sourceX+b,sourceY-a,hm), 1+countMoves(a,b,sourceX-b,sourceY+a,hm))));

        // Minimum number of moves of all moves
    }
}
