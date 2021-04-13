package week5;

public class hanoi2 {
    int maxSize;
    String[][] poles;
    int[] curPlates = {0,0,0};

    public hanoi2(String[] plates) {
        maxSize = plates.length;
        poles = new String[3][maxSize];
        poles[0] = plates;
        curPlates[0] = maxSize;
    }

    private void hanoi(int i, int k) {
        hanoi(maxSize, i-1, k-1);
    }

    public void hanoi(int level, int from, int to) {
        if(level==1) {
            move(level,from,to);
        } else {
            int via = (3-from-to)%3;
            hanoi(level-1,from,via);
            showTower();
            move(level,from,to);
            showTower();
            hanoi(level-1,via,to);
        }
    }

    public void showTower() {
        System.out.println();
        for(int i=0; i<3; i++){
            System.out.print("pole"+(i+1)+": |");
            for(int j=0; j<curPlates[i]; j++) {
                System.out.print(poles[i][j]+"|");
            }
            System.out.println();
        }
    }

    private void move(int level, int from, int to) {
       curPlates[from]--;
       if(curPlates[from]<0){
           System.out.println("Indexing Error..");
           return;
       }
       poles[to][curPlates[to]]=poles[from][curPlates[from]];
       curPlates[to]++;
    }

    public static void main(String[] args) {
        String[] plates = {"빨","주","노","초","파","남","보"};
        hanoi2 me = new hanoi2(plates);

        me.showTower();
        me.hanoi(1,2);
        me.showTower();
    }
}
