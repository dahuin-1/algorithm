import java.util.Scanner;

public class hanoiTower {

    int count = 0;

    public static void main(String[] args) {
        hanoiTower ht = new hanoiTower();
        Scanner sc = new Scanner(System.in);
        System.out.println("몇개의 원판을 옮기고 싶은지 숫자를 입력하세요");
        int n = sc.nextInt();
        ht.hanoi(n,"A","B","C");
        ht.result();
    }

    public void hanoi(int n, String start, String via, String end){
        if(n==1){
            ++count;
            System.out.println(n+"번 원판을 "+start+"에서 "+end+"로 이동");
        }else{
            hanoi(n-1,start,end,via);
            ++count;
            System.out.println(n+"번 원판을 "+start+"에서 "+end+"로 이동");
            hanoi(n-1,via,start,end);
        }
    }

    public void result() {
        System.out.println("이동횟수 : "+count);
    }
}
