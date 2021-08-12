## Strategy
> 전략 패턴 또는 정책 패턴은 실행 중에 알고리즘을 선택할 수 있게 하는 행위 소프트웨어 디자인 패턴이다. 전략 패턴은 특정한 계열의 알고리즘들을 정의하고 각 알고리즘을 캡슐화하며 이 알고리즘들을 해당 계열 안에서 상호 교체가 가능하게 만든다. -위키백과
- 전략 패턴은 각각의 동작을 모듈화하여 동작의 변화를 모듈을 갈아끼우는 방식으로 구현하는 패턴입니다.
- 아래의 코드를 보면, 검색 기능에서의 필터에 대한 부분인데, all, image, news, image 탭으로 구분되어있습니다. 전략 패턴 없이 구현해보겠습니다.
```java
public class MyProgram {
  private SearchButton searchButton = new SearchButton(this);
  public Mode mode = Mode.ALL;
  public void setModeAll(){mode = Mode.ALL;}
  public void setModeImage(){mode = Mode.IMAGE;}
  public void setNodeNews(){mode = Mode.NEWS;}
  public void setModeMap(){mode=Mode.MAP;}
}

public enum Mode{
  ALL, IMAGE, NEWS, MAP;
}

public class SearchButton {
  private MyProgram myProgram;
  
  public SearchButton(MyProgram myProgram){
    this.myProgram = myProgram;
  }
  
  public void onClick(){
    if(myProgram.mode == Mode.ALL){
      // 전체 검색하는 코드
    }
    else if(myProgram.mode == Mode.IMAGE){
      // 이미지 검색하는 코드
    }
    else if(myProgram.mode == MODE.NEWS){
      // 뉴스 검색하는 코드
    }
    else if(myProgram.mode == Mode.MAP){
      // 지도 검색하는 코드
    }
  }
}
```
- 위와같은 방식은 각각의 메서드에 수정 사항이 생기거나, 새로운 기능이 추가되면, onClick() 메서드를 다시 수정해야합니다. 이는 OCP에 어긋납니다. 확장성이 좋지않고, 복잡할 수록 관리가 어렵습니다.
- 전략 패턴은 위와 같은 코드에서, 동작을 하는 기능을 모듈화하여, 동작이 변할 때마다 모듈을 갈아끼우는 방식으로 구현합니다.
- 방식은 다음과 같습니다.
1. 동작의 접점을 만들어줄 추상체와 해당 추상체의 메서드를 오버라이드하여 구체적인 동작을 할 클래스를 만듭니다.
   - 접점이 될 interface인 SearchStragegy를 만들고, 블럭내에 구체적인 동작을 오버라이드 할 메서드를 만듭니다.
   - SearchStragegy 인터페이스를 implements 하여 오버라이드 하기만 하면 동작이 추가됩니다.
```java
interface SearchStrategy {
    public void search();
}

class SearchStrategyAll implements SearchStrategy {
    @Override
    public void search() {
        System.out.println("Search All");
    }
}

class SearchStrategyImage implements SearchStrategy {
    @Override
    public void search() {
        System.out.println("Search Image");
    }
}

class SearchStrategyNews implements SearchStrategy {
    @Override
    public void search() {
        System.out.println("Search News");
    }
}

class SearchStrategyMap implements SearchStrategy {
    @Override
    public void search() {
        System.out.println("Search Map");
    }
}
```
2. 해당 동작들을 사용할 경우, 사용하는 클래스에서 `추상체 참조변수 = new 구상체()` 로, 인터페이스를 통한 형변환이 이루어지게 가져와 사용합니다.
```java
public class SearchButton {

    private MyProgram myProgram;
    private SearchStrategy searchStrategy = new SearchStrategyAll();


    public SearchButton(MyProgram myProgram) {
        this.myProgram = myProgram;
    }

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public void onClick(){
        searchStrategy.search();
    }
}
```
3. 동작을 바꿀 경우, 앞서 만들었던 모듈을 생성하여 인터페이스 참조변수에 할당해주면 됩니다. 메서드가 오버라이드 되있기 때문에 동작 실행이 가능합니다.
```java

public class MyProgram {

    private SearchButton searchButton = new SearchButton(this);

    public void setModeAll(){
        searchButton.setSearchStrategy(new SearchStrategyAll());
    }

    public void setModeImage(){
        searchButton.setSearchStrategy(new SearchStrategyImage());
    }

    public void setModeNews(){
        searchButton.setSearchStrategy(new SearchStrategyNews());
    }

    public void setModeMap(){
        searchButton.setSearchStrategy(new SearchStrategyMap());
    }
}

```

### 정리
- SearchButton 클래스를 보시면, 인터페이스의 참조 변수를 구현된 클래스에 연결하여 오버라이드와 형변환을 통해 모듈을 끼워넣을 수 있습니다.
- 이처럼 옵션들 마다의 행동들을 모듈화하여 독립적이게 교체 가능하게 만드는 것이 전략 패턴 입니다.

### reference
[https://www.youtube.com/watch?v=lJES5TQTTWE&t=410s](https://www.youtube.com/watch?v=lJES5TQTTWE&t=410s)













































