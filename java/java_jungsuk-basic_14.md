# 14강 람다와 스트림

## java.util.function 패키지
- java.util.function 패키지에 일반적으로 자주 쓰이는 형식의 메서드를 함수형 인터페이스로 미리 정의해 놓았다.
- 제네릭 메서드로 정의되어 타입에 얽메이지 않는다.
- 자주 쓰이는 함수형 인터페이스들

  함수형 인터페이스 | 메서드 | 설명
  ----------------------|----------------|----------------
  Runnable        | void run()            | 매개변수(X), 반환값(X)
  Suppiler<T>     | T get()               | 매개변수(X), 반환값(O)
  Consumer<T>     | T accept()            | 매개변수(O), 반환값(X)
  Function<T, R>  | R apply(T t)          | 하나의 매개변수를 받아서 결과를 반환, 가장 일반적임
  Predicate<T>    | boolean test(T t)     | 조건식을 표현하는데 사용됨(if랑 연계), 매개변수(O), 반환값(boolean)
  > 타입문자 T는 Type을, R은 Return을 의미한다
  

