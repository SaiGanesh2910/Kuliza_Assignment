import java.util.*;

public class Question4 {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.next();
        String str2=sc.next();
        System.out.println(MaxLength(str1,str2));
        sc.close();
    }

    private static int MaxLength(String str1, String str2) {
        int l1=str1.length();
        int l2=str2.length();
        int [][] matrix=new int[l1+1][l2+1];
        Arrays.stream(matrix).forEach(a ->Arrays.fill(a,0));
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    matrix[i][j] = matrix[i-1][j-1] + 1 ;      //   Incrementing the value as character matched
                }
                else{
                    matrix[i][j]=Math.max(matrix[i-1][j],matrix[i][j-1]);    // Checking the max of both above and left point 
                }
            }
        }
        return matrix[l1][l2];
    }   
}