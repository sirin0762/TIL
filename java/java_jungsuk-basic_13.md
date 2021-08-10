## 13강 : 쓰레드(1)

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
- 두 쓰레드가 서로 다른 자원을 사용하는 경우라면 싱글쓰레드 보다 멀티쓰레드의 프로세스가 더 효율적입니다.
- 만약 싱글쓰레드에서 입력이 생길 경우, 프로그램은 사용자의 입력이 들어올때까지 기다려야하는 상황이 생깁니다. 이러한 입출력에 의해 쓰레드가 기다리는 현상을 `I/O 블락킹` 이라고 합니다.
- 아래코드는 멀티쓰레드로 I/O 블락킹이 없이 동작하는 예시입니다. 싱글쓰레드라면 입력이 생길때 까지 카운트가 일어나지 않습니다.
```java
class MyThread extends Thread {
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                sleep(1000);
            } catch (Exception e){}
        }
    }
}


public class Main {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
        System.out.println("입력하신 값은 " + input + " 입니다");

    }
}
// 결과값
0
1
2
3
4
5
6
입력하신 값은 안녕 입니다
7
8
9
```

### 쓰레드의 우선순위
- 쓰레드는 우선순위라는 속성을 가지고 있습니다. 이 값에 따라서 쓰레드가 얻는 실행 시간이 달라집니다.
- 우선 순위를 다르게 하여 특정 쓰레드가 더 많은 작업시간을 가지도록 설정할 수 있습니다. 단, 쓰레드의 우선순위의 범위는 1 ~ 10 입니다. 숫자가 높을 수록 우선순위가 높습니다.
- 멀티쓰레드의 경우, 2개의 쓰레드가 2가지의 일을 한다고 가정하면, 우선순위는 크게 의미가 없습니다. 허나 싱글쓰레드라면, 우선순위가 높은쪽의 작업이 먼저 끝납니다.
- 아래는 관련 메서드 및 예시입니다.
```java
void setPriority(int newPriority)   // 쓰레드의 우선순위를 지정
int getPriority()   // 쓰레드의 우선순위 반환
```
```java
class MyThread extends Thread {
    // Thread 클래스의 Run을 Override
    @Override
    public void run(){
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
            for (int j = 0; j < 10000000; j++) {
                
            }
        }
    }
}

class MyThread2 extends Thread {
    // Thread 클래스의 Run을 Override
    @Override
    public void run(){
        for (int i = 0; i < 300; i++) {
            System.out.print("|");
            for (int j = 0; j < 10000000; j++) {
                
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
        // Thread를 상속 받았을 때
        MyThread myThread = new MyThread();
        MyThread2 myThread2 = new MyThread2();
        
        // default는 5
        myThread2.setPriority(7);

        System.out.println("myThread(-) : " + myThread.getPriority());
        System.out.println("myThread2(|) : " + myThread2.getPriority());

        myThread.start();
        myThread2.start();

    }
}
// 결과값
myThread(-) : 5
myThread2(|) : 7
-||-||||||||||||||||||||||||||||||||||||-------------||------||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||----||||||||||||||||||||||||||||||||||---------------------|||||||||----------|||||||||||||||||||||||||||||||||||||||||||----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

```

### 쓰레드 그룹
- 쓰레드 그룹은 서로 관련된 쓰레드를 그룹으로 다루기 위한 것입니다.
- 보안상의 이유로 도입된 개념이며, 자신이 속한 쓰레드 그룹은 변경할 수 있으나, 다른 쓰레드 그룹의 쓰레드를 변경 할 수 없습니다.
- 쓰레드를 쓰레드 그룹에 포함시키려면 Thread 생성자를 이용하면 됩니다.
```java
Thread(ThreadGroup group, String name)
...
```
- 모든 쓰레드는 반드시 쓰레드 그룹에 포함되어 있어야합니다. 우리가 생성하는 쓰레드와 쓰레드 그룹은 Main 쓰레드 그룹의 하위 쓰레드 그룹이 됩니다.

### 데몬 쓰레드
- 데몬쓰레드는 다른 일반 쓰레드의 작업을 돕는 보조적인 역할을 하는 쓰레드입니다. 예를 들면, 자동저장, 화면 자동 갱신, 가비지컬렉터 같은 역할을 합니다.
- 데몬 쓰레드는 무한루프와 조건문을 이용해서 실행 후 대기하고 있다가, 특정 조건이 만족되면 작업을 수행하고 다시 대기하도록 작성됩니다.
- 데몬 쓰레드는 일반 쓰레드가 종료되면 같이 종료됩니다.
- 아래는 관련 메서드 및 예시입니다.
```java
boolean isDeamon()
void setDeamon(boolean on) // 쓰레드를 데몬 쓰레드, 또는 사용자 쓰레드로 변환합니다. on값이 true면 데몬 쓰레드가 됩니다.
```
```java
public class Main implements Runnable{

    private static boolean autoSave = false;

    public static void main(String[] args) {
        Thread thread = new Thread(new Main());

        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 15; i++) {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){}
            System.out.println(i);

            if(i == 5){
                autoSave = true;
            }
        }


    }

    @Override
    public void run() {
        while (true) {
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){}

            if(autoSave) autoSave();
        }
    }

    private void autoSave() {
        System.out.println("자동 저장 중입니다...");
    }
}

// 결과값
0
1
2
3
4
5
6
7
자동 저장 중입니다...
8
9
10
자동 저장 중입니다...
11
12
13
자동 저장 중입니다...
14

Process finished with exit code 0

```
