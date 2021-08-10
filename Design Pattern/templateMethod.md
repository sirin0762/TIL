## 템플릿 메서드

### 정의
- 템플릿 메서드 패턴이란 같은 형식을 가진 특정 작업들의 세부 방식을 다양화하고자 할 때 사용합니다.
- 예를 들어, 쿠키를 만드려 할 때, 다음과 같은 3가지 방식이 있다고 가정합시다.
  1. 쿠키에 들어가는 재료를 정한다.
  2. 쿠키 반죽을 한다.
  3. 쿠키를 굽는다.

- 같은 작업 처럼 보이지만 그 정도를 어떻게 하느냐에 따라 다양한 쿠키가 나옵니다. 이럴 때 사용하는 패턴이 템플릿 메서드 입니다.
- [전략]() 패턴의 경우, 이러한 각각의 방식을 갈아끼워넣을 수 있는 모듈화된 형식으로 만듭니다.
- 템플릿 메서드는 이와는 달리, 다양화된 방식을 각각 자식 클래스들에서 오버라이드하는 방식으로 구현하는 것입니다.
![image](https://user-images.githubusercontent.com/60607880/128880410-9b304932-afe4-4a08-81f7-688c22ed317a.png)

### 사용법
- 템플릿 메서드에서의 상속은 일정 형식이 있습니다.
- 부모클래스에 전반 과정을 수행하는 메인 메서드가 있고, 그 과정 안에 세부 메서드가 있습니다. 메인 메서드를 호출하면 세부 메서드들이 호출되는 형태인 것입니다.
- 자식 템플릿은 이 세부 메서드들을 오버라이드 합니다.
- 위의 예시에서, 쿠키를 만드는 3가지 단계를 각각 세부 메서드로 지정하고, 이 전체 과정을 메인 메서드로 지정하면 됩니다.
- 이 때, 전체 과정은 자식들이 바꿀 수 없습니다. 자식들이 바꾸면 쿠키가 아닌 다른게 되버릴 것입니다.
- 하지만 세부 메서드들은 자식들이 오버라이드 하여, 다양한 쿠키를 만드는 것이 가능하게 됩니다.
```java
abstract class Cookies {
    // 세부 메서드들은 자식 클래스에서 오버라이드
    protected abstract void addIngredients();
    protected abstract void makeDoughs();
    protected abstract void bakeCookies();
    
    // 메인 메서드는 자식들이 건들지 못하게
    public void initMakeCookies(){
        addIngredients();
        makeDoughs();
        bakeCookies();
    }
}

class CacaoCookies extends Cookies {

    @Override
    protected void addIngredients() {
        System.out.println("카카오 가루, 초코칩, 강력분 넣고");
    }

    @Override
    protected void makeDoughs() {
        System.out.println("조금 뻑뻑한 질감으로");
    }

    @Override
    protected void bakeCookies() {
        System.out.println("180도 온도에서 30분으로 굽는다!");
    }
}

class StrawberryCookies extends Cookies {

    @Override
    protected void addIngredients() {
        System.out.println("딸기 시럽, 설탕, 강력분 넣고");
    }

    @Override
    protected void makeDoughs() {
        System.out.println("촉촉한 질감으로");
    }

    @Override
    protected void bakeCookies() {
        System.out.println("120도 온도에서 45분 굽는다!");
    }
}

public class Main {
    public static void main(String[] args) {
        new CacaoCookies().initMakeCookies();
        new StrawberryCookies().initMakeCookies();
    }
}
```
