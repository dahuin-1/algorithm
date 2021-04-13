package week5;

public class hanoi1 {

    public void hanoi(int level, char start, char via, char end) {
        if(level == 1) {
            move(level,start,end);
        }else{
            hanoi(level-1,start,end,via);
            move(level, start, end);
            hanoi(level-1,via,start,end);
        }
    }

    private void move(int level,char from, char to) {
        System.out.println("Plate"+ level+" moved from"+from+" to"+to);
    }

    public static void main(String[] args) {
        hanoi1 me = new hanoi1();
        int n = 4;
        me.hanoi(n,'A','B','C');
    }

}
