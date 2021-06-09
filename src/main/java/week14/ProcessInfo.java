package week14;

public class ProcessInfo {
    int processID;
    int duration;//시간이 얼마나 걸릴것이다
    int allocatedAddress;//할당받은 메모리가 몇번째부터다
    int endingTime;//듀레이션이 언제 끝난다

    public ProcessInfo(int processNum, int currentTime) {
        processID = processID;
        duration = getDuration();
        allocatedAddress = -1;
        endingTime = currentTime + duration;
    }

    private int getDuration() { //얼마나 걸릴지를 랜덤으로 해봄
        return (int) (Math.random()*100 + 1); //0은 없게 하려고 1을 더함
    }

    public String toString() {
        return "ID:"+processID+"--Duration="+duration+
                "\nAddress="+allocatedAddress;
    }
}
