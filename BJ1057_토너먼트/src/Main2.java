import java.util.Scanner;
 
public class Main2 {
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int kim = sc.nextInt();
        int im = sc.nextInt();
        int count = 0;
        while(kim != im) {
            kim = kim/2 + kim%2;
            im = im/2 + im%2;
            count++;
        }
        System.out.println(count);
    }
 
}
 


