## 어뎁터
- 어뎁터는 형식이 다른 둘 사이에 연결되어 호환되게 해주는 패턴입니다.
- 보통 인터페이스가 서로 다른 기능들이 같은 형식 아래 작동할 수 있도록 하는 역할을 합니다.
- 아래 코드를 보시면, 위 아래의 인터페이스와, 메서드, 메서드의 형식이 다 달라서 호환이 안됩니다.
```java
public interface FindAlgorithm {
    void find(boolean global);
}

class FindMovieAlgorithm implements FindAlgorithm {

    @Override
    public void find(boolean global) {
        System.out.println(
                "find movie" + (global ? "globally" : "")
        );
        // 영화 검색하는 코드
    }
}
```
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
...

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
- 어텝터는 이러한 호환 문제를 해결해줍니다. 둘을 연결하는 별도의 클래스를 만들어서 이용하는 방식입니다.
- 호환하는 인터페이스를 implements 하고 반대쪽의 인터페이스 참조변수를 생성자로 넣어줍니다.
- 이후 오버라이드 한 메서드 내에서, 반대쪽의 인터페이스 참조변수에 연결된 인스턴스의 메서드를 넣어주면 둘 사이의 호환이 되는 것을 알 수 있습니다.
```java
// 호환하는 쪽의 인터페이스를 implements
public class SearchMovieAdapter implements SearchStrategy{
    private FindAlgorithm findAlgorithm;
    
    // 반대쪽의 인터페이스 인스턴스와 연결
    public SearchMovieAdapter(FindAlgorithm findAlgorithm) {
        this.findAlgorithm = findAlgorithm;
    }
    
    // 호환하는 쪽의 메서드에 반대쪽 인터페이스 인스턴스의 메서드를 호출하여 연결
    @Override
    public void search() {
        findAlgorithm.find(true);
    }
}

```
- 전략패턴이랑 합쳐지면, 매개변수에 들어가는 생성자를 호환에 맞춰서 생성해주면됩니다.
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
    
    public void setModeMovie() {
        // 기존에 쓰던 메서드를 수정없이 어뎁터를 통한 인스턴스 호환으로 해결
        searchButton.setSearchStrategy(new SearchMovieAdapter(new FindMovieAlgorithm()));
    }

    public void testProgram(){
        searchButton.onClick();
        setModeImage();
        searchButton.onClick();
        setModeNews();
        searchButton.onClick();
        setModeMap();
        searchButton.onClick();
        setModeMovie();
        searchButton.onClick();

    }
}

public class Main {
    public static void main(String[] args) {
        new MyProgram().testProgram();
    }
}
```
### 정리
- 어뎁터는 서로 호환이 되지 않는 두 인터페이스를 implement와 반대쪽 인터페이스의 구상체를 이용한 새로운 클래스로 호환하는 방법입니다.

### reference
[https://www.youtube.com/watch?v=lJES5TQTTWE](https://www.youtube.com/watch?v=lJES5TQTTWE)
