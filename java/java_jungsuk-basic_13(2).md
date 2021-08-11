## 13강 : 쓰레드(2)

### 쓰레드의 상태

- 쓰레드는 여러 상태를 가질 수 있습니다.   


상태|설명
--- |---
New | 쓰레드가 생성되고 아직 start()가 호출되지 않은 상태
Runnable | 실행 중, 또는 실행 가능한 상태
Blocked | 동기화블럭에 의해 일시정지된 상태(lock이 걸려서 기다리는 상태)
Waiting | 쓰레드의 작업이 종료되지는 않았지만 실행가능하지 않은 일시정지 상태
Timed_wating | 쓰레드의 작업이 종료된 상태


- 다음 그림은 쓰레드의 생성부터 소멸까지의 모든 과정을 그린 것 입니다.

![image](https://user-images.githubusercontent.com/60607880/129022830-675e1318-333f-46c6-a318-35662f06a09a.png)

1. 쓰레드를 생성하고 start()를 호출하면 바로 실행되는 것이 아니라 실행대기열에 저장되어 자신의 차례가 될 때까지 기다려야한다. 실행 대기열은 규의 구조로 먼저 들어온 쓰레드 부터 처리한다.
2. 실행대기 상태에 있다가 자신의 차례가 되면 실행상태가 된다.
3. 주어진 실행 시간이 다되거나 yield()를 만나면 다시 실행대기상태가 되고 다음 차례의 쓰레드가 실행상태가 된다.
4. 실행중에, suspend(), sleep(), wait(), join(), I/O block에 의해 일시정지 상태가 될 수 있다.
5. 지정된 일시정지 시간이 다되거나, notify(), resume(), interrupt() 가 호출되면 일시정지 상태를 벗어나 다시 실행대기열에 저장되어 자신의 차례를 기다린다.
6. 실행을 모두 마치거나 stop()이 호출되면 쓰레드는 소멸된다.

___

## 쓰레드의 메서드들

### sleep()
- sleep()은 지정된 시간동안 쓰레드를 멈추게 합니다.
```java
static void sleep(long millis, int nanos)
```
- sleep()에 의해 일시정지 상태가 된 쓰레드는 지정된 시간이 다 되거나 interrupt()가 호출되면, InterruptedException이 발생되어 실행대기 상태로 전환됩니다.
- sleep()을 호출할 때는 위와같은 상황때문에 try~catch문으로 예외처리를 해줘야 합니다. 
```java
void delay(long millis){
  try {
    Thread.sleep(millis);
  } catch(InterruptedException e){}
}
```

### interrupt()
- 인터럽트는 쓰레드에게 작업을 멈추라고 요청합니다. 단지 멈추라고 요청만 하는 것이고 쓰레드를 강제로 종료시키지는 못합니다.
- interrupt() 메서드는 쓰레드의 interrupted 상태를 바꿉니다. interrupted() 메서드는 쓰레드에 대해 interrupt() 가 호출되었는지 알려줍니다. interrupt() 가 호출됬었다면 true, 아니면 false를 리턴하고 쓰레드의 interrupted 상태를 false로 초기화합니다.
```java
class MyThread extends Thread {
    @Override
    public void run(){
        int i = 0;

        while(i != 10 && !isInterrupted()){
            System.out.println(i++);
            for (long j = 0; j < 2500000000L; j++) {

            }
        }
        System.out.println("카운터가 종료됬습니다.");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
        System.out.println("입력하신 값은" + input + " 입니다.");
        thread.interrupt();

    }
}
```

### join() 과 yield()
- join() : 다른 쓰레드의 작업을 기다립니다.
- 쓰레드 자신이 하던 작업을 잠시 멈추고 다른 쓰레드가 지정된 시간동안 작업을 수행하도록 할 때 join()을 실행합니다.
```java
void join()
void join(long millis)
void join(long millis, int nanos)
```
- 시간을 지정하지 않으면 해당 쓰레드가 작업을 모두 마칠 때 까지 기다리게 됩니다.
- join() 도 sleep() 처럼 interrupt() 메서드에 의해 대기상태에서 벗어날 수 있습니다. 따라서 try~catch 문으로 감싸는 것이 권장됩니다.

- yield() : 다른 쓰레드에게 양보합니다.
- yield() 는 쓰레드 자신에게 주어진 실행시간을 다음 차례의 쓰레드에게 양보합니다.


### synchronized 를 이용한 동기화
- synchronized 키워드는 임계 영역을 설정하는데 사용됩니다.
```java
// 1. 메서드 전체를 임계 영역으로 지정
public synchronized void calcSum(){
  //
}
// 2. 특정한 영ㅇ역을 임계영역으로 지정
synchronized(객체의 참조변수){

}
```
- 2번의 경우, 참조변수는 락을 걸고자하는 객체를 참조하는 것이어야 합니다. 영역 안에 들어가면서 부터 쓰레드는 지정된 객체의 lock을 얻게 되고, 이 블럭을 벗어나면 lock을 반납합니다.
- 모든 객체는 lock을 하나씩 가지고 있으며, 해당 객체의 lock을 가지고 있는 쓰레드만 임계영역의 코드를 수행할 수 있습니다.
- 단 synchronized 키워드는 속도가 굉장히 느립니다. 가능하면 최소화하여 사용되는 것이 권장됩니다.

### wait()과 notify()
- 두 메서드 다 동기화 블럭 내에서 사용하는 메서드입니다.
- wait()의 경우, 해당 쓰레드를 정지하고 lock을 반납합니다.
- notify()의 경우, 정지인 상태에서 lock을 다시 얻어와 작업을 진행 할 수 있게 해줍니다.
- wait()과 notify() 모두 특정 객체에 대한 것이므로 Object 클래스에 정의되어있습니다.
