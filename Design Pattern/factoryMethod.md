## 팩토리 메서드
- 팩토리 메서드는 인스턴스 생성을 특정 클래스에게 위임하는 방식
- 인스턴스의 생성자가 바뀌면 모든 생성자를 찾아다닐 필요 없이, 팩토리 클래스의 메서드만 바꿔주면된다.
- 구현 방식은 4가지 단계로 구성된다

### 1. 추상클래스를 통한 컴포넌트 구현
- 추상 클래스를 만들고 이를 상속받는 요소들을 만들어준다.
```java
// Component.java
abstract class Component {
    protected abstract String getCompName();

    public Component(){
        System.out.println(getCompName() + " 생성");
    }
}

class Button extends Component {

    @Override
    protected String getCompName() {
        return "버튼";
    }
}

class Switch extends Component {

    @Override
    protected String getCompName() {
        return "스위치";
    }
}

class Dropdown extends Component {

    @Override
    protected String getCompName() {
        return "드랍다운";
    }
}
```

### 2. 열거형을 통한 구분
- 인스턴스 생성시 구분을 해줄 요소들의 이름으로 구성한다.
```java
public enum ComponentType {
    BUTTON, SWITCH, DROPDOWN;
}
```

### 3. 팩토리 생성
- 열거형을 통한 구분으로 각각에 맞는 인스턴스를 만들어주는 팩토리를 만든다.
```java
// ComponentFactory.java
public class ComponentFactory {
    // ComponeneType을 인자로 받아 각각에 맞는 인스턴스를 리턴해줌
    public Component getComponent(ComponentType componentType){
        if(componentType == ComponentType.BUTTON){
            return new Button();
        } else if(componentType == ComponentType.SWITCH){
            return new Switch();
        } else {
            return new Dropdown();
        }
    }
}
```

### 4. 사용
```java
class Console {
    private ComponentFactory componentFactory = new ComponentFactory();

    Component com1;
    Component com2;
    Component com3;

    void withoutFactory(){
        com1 = new Button();
        com2 = new Switch();
        com3 = new Dropdown();
    }

    void withFactory(){
        com1 = componentFactory.getComponent(ComponentType.BUTTON);
        com2 = componentFactory.getComponent(ComponentType.SWITCH);
        com3 = componentFactory.getComponent(ComponentType.DROPDOWN);
    }

}

public class Main {
    public static void main(String[] args) {
        new Console().withFactory();
        new Console().withoutFactory();
    }
}
```

## 정리
