package week5;

public class hanoi3 {
    int maxSize;
    MyStack[] poles;

    public hanoi3(String[] plates) {
        maxSize = plates.length;
        poles = new MyStack[3];

        for(int i=0; i<3; i++)
            poles[i] = new MyStack();

        for(int i=0; i<maxSize; i++)
            poles[0].push(plates[i]);
    }

    private void hanoi(int i, int j) {
        hanoi(maxSize, i-1, j-1);
    }

    public void hanoi(int level, int from, int to) {
        if(level==1)
            move(level,from,to);
        else {
            int via = (3-from-to)%3;
            hanoi(level-1,from,via);
            showTower();
            move(level,from,to);
            showTower();
            hanoi(level-1, via, to);
        }
    }

    public void showTower() {
        System.out.println();
        for(int i = 0; i<3; i++) {
            System.out.println("pole"+(i+1)+": "+poles[i].toString());
        }
    }

    private void move(int level, int from, int to) {
        poles[to].push(poles[from].pop());
    }

    public static void main(String[] args) {
        String[] plates = {"빨","주","노","초","파","남","보"};
        hanoi3 me = new hanoi3(plates);

        me.showTower();
        me.hanoi(1,2);
        me.showTower();
    }

    private class MyStack{
        String[] stack = new String[maxSize+1];
        int stackPointer = 0;

        private void push(String s) {
            if(stackPointer==maxSize) {
                System.out.println("Stack Full...");
                return;
            }
            stack[stackPointer]=s;
            stackPointer++;
        }
        private String pop() {
            if(stackPointer==0){
                System.out.println("Stack empty...");
                return null;
            }
            stackPointer--;
            return stack[stackPointer];
        }
        private int sizeOf() {
            return stackPointer;
        }
        public String toString() {
            String ret = "|";
            for(int i=0; i<stackPointer; i++){
               ret += stack[i] + "|";
            }
            return ret;
        }
    }
}
