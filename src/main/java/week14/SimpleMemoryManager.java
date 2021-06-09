package week14;


import java.util.ArrayList;

public class SimpleMemoryManager {
    int maxMemorySize = 1000;
    int memorySlotSize = 50;
    int [] memory;
    int freePointer;

    public SimpleMemoryManager(int maxTime) {
        memory = new int[maxMemorySize];
        freePointer = 0;
        memory[0] = -1; //pre
        memory[1] = freePointer + memorySlotSize; //next 0+50
        int p = memorySlotSize; //다음칸
        while (p < maxMemorySize) { //초기화
            memory[p] = p - memorySlotSize; //pre 50번 주소는 0을 가리키고 100번 주소는 50을 가리키고
            memory[p + 1] = p + memorySlotSize; //next 51번 주소는 100을 가리킴 101번 주소는 150을 가리킨다
            p += memorySlotSize;
        }
        p = p - memorySlotSize; //lastblock  1000(maxMemorySize)-50 = 950
        memory[p + 1] = -1; //last slot
    }

    public int malloc() {
        //맨 마지막거의 next가 free point로 넘어오겠죠 다쓰면 더이상 얼로케이트 할 메모리가 없으면 얘는 -1이 되겠죠
        if(freePointer >= 0) { //그게 아닌 0보다 큰 경우에는
            int p = getAFreeSlot(); //slot 하나 받아오고
            System.out.print(" *** memory allocated : "+p+"  FreeHead "+freePointer);
            return p;
        }
        else {
            System.out.println(" >>> Memory run out...");
            return -1;
        }
    }

    private int getAFreeSlot() {
        int p = freePointer;
        freePointer = memory[freePointer+1]; //다음블락 = 원래 메모리 + 1
        if(freePointer > 0) //마지막 블락이 아니라면 (마지막 fp = -1)
            memory[freePointer] = -1;

        return p;
    }

    public void free(int p) {
        System.out.print(" +++ memory freed : "+p);
        if(freePointer == -1) {
            memory[p] = -1;
            memory[p+1] = -1;
        }
        else {
            memory[p] = -1;
            memory[freePointer] = p;
            memory[p+1] = freePointer;
        }
        freePointer = p;
    }

    public static void main(String[] args) {
        int timeLimit = 1000;
        SimpleMemoryManager smm = new SimpleMemoryManager(timeLimit);
        ArrayList<ProcessInfo> processTable = new ArrayList<>();

        int clock = 0;
        int processNum = 0;

        while(clock < timeLimit) {
            System.out.print("\n--clock = "+clock);

            if(Math.random() < 0.5) {
                ProcessInfo p = new ProcessInfo(processNum++, clock); //프로세스가 하나 발생했다
                p.allocatedAddress = smm.malloc(); //p가 값을 줘야하는데 smm 객체에 malloc이라는 메소드를 만들어서 여기 몇번째부터 니가 써라 하는거죠
                if(p.allocatedAddress < 0) { //받은 어드레스가 0보다 작으면 (준 메모리가 없으면)
                    System.out.print(">>>>Process Creation Failed "); //크리에이션 실패
                }
                else
                    processTable.add(p);
            }
            for (int i = 0; i < processTable.size(); i++) //만약
                if(processTable.get(i).endingTime <= clock) { //프로세스 테이블에 들어있는 애들의 끝나는 시간을 clock이랑 비교해서 ending 타임이 clock보다 작으면 (시간이 지나가면)
                    smm.free(processTable.get(i).allocatedAddress); //프로세스를 끝내야해요
                    processTable.remove(i); //프로세스 테이블에서 삭제
                }
            clock++;
        }


    }
}
