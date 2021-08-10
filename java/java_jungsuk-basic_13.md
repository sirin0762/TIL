## 13강 : 쓰레드

### 쓰레드의 구현과 실행
- 쓰레드를 구현하는 방법은 Thread 클래스를 상속받는 방법과 Runnable 인터페이스를 구현하는 방법, 2가지가 있습니다.
- Thread 클래스를 상속받으면 다른 클래스를 상속받을수 없기에, Runnable 인터페이스를 구현하는 방법이 일반적입니다.
```java
// 1. 쓰레드 클래스를 상속받는다.
class MyThread extends Thread {
    // Thread 클래스의 Run을 Override
    @Override
    public void run(){
        
    }
}

// 2. Runnable interface를 구현한다.
class MyThread implements Runnable {
    // Runnable의 추상 메서드 run()을 override
    @Override
    public void run() {
        
    }
}
```
- 다만, 이 둘은 인스턴스 생성 방법이 다릅니다.
```java
public class Main {

    public static void main(String[] args) {
        // Thread를 상속 받았을 때
        MyThread myThread = new MyThread();
        myThread.start();

        // Runnable을 구현했을 때
        Thread myThread2 = new Thread(new MyThread2());
        myThread2.start();
    }
}
```

### start() 와 run()
- start() 메서드를 통해서 쓰레드를 실행시킬 수 있습니다. 다만, 바로 실행되는 것이 아니라 일단 실행 대기 상태에 있다가 자신의 차례가 올때 실행됩니다.
- 한번 실행이 종료된 쓰레드는 다시 실행할 수 없습니다. 다시 실행시키기 위해선 새로운 인스턴스를 할당해주어야합니다.
```java
public class Main {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        // 다시 실행시키기 위해서 인스턴스 새로 할당
        myThread = new MyThread();
        myThread.start();
    }
}

```
- start() 메서드는 새로운 호출스택을 불러 그 안에 run 함수를 첫번쨰로 올립니다.
![image](https://user-images.githubusercontent.com/60607880/128839050-e62c4000-ae9d-4da9-909c-6e4fad7e7f25.png)
  1. main 스레드 내부에서 main 메서드가 호출되고, main 메서드 내부의 start() 메서드가 호출됩니다
  2. start() 메서드는 새로운 호출스택을 생성하고 이 안에 run 메서드를 실행합니다.
  3. run 메서드가 실행되고 스택 순서에 맞게 돌아옵니다

### 쓰레드의 I/O 블락킹
