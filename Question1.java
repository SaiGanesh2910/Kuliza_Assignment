import java.util.*;

public class Question1 {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            String str1=sc.next();
            String str2=sc.next();
            boolean b=CheckCommon(str1,str2);
            if(b)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
        sc.close();
    }
    public static boolean CheckCommon(String str1, String str2){
        int arr[]=new int[26];
        Arrays.fill(arr,0);
        for(int i=0;i<str1.length();i++){
            arr[str1.charAt(i)-'a']++;                  //  Checking all characters present in the first string
        }
        for(int i=0;i<str2.length();i++){
            if(arr[str2.charAt(i)-'a']!=0)              // Checking if one charcter of second string is available in first string 
                return true;
        }
        return false;
    }
}
