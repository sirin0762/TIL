## 1. 호출스택
- 함수 선언을 했다는 것은, 해당 함수를 메모리에 올렸다는 뜻, 함수 호출은 메모리 속에서 선언을 했는지를 찾아본다.
<img src = "https://user-images.githubusercontent.com/60607880/112757360-85074280-9024-11eb-88c6-92ae3d9aec9d.png" width="50%"></img>      
### 호출 스택(함수의 호출, 자료구조의 스택)   
- Anomymous는 가상의 전역 컨텍스트(항상 있다고 생각하는게 좋음)
- 함수 호출 순서대로 쌓이고, 역순으로 실행됨
- 함수 실행이 완료되면 스택에서 빠짐

이번엔 아래 코드를 보자   
```js
function run(){
  console.log('3초후 실행');
}
console.log('시작');
setTimeout(run, 3000);
console.log('끝');
```
- 시작 -> 끝 -> 3초후 실행
- 호출 스택만으로 생각한다면 시작 -> setTimeout -> run -> 끝 이 되야함
- 호출 스택 + 이벤트 루프로 설명 가능

## 2. 이벤트 루프
다시 한번 아래 코드를 보자
```js
function run(){
  console.log('3초후 실행');
}
console.log('시작');
setTimeout(run, 3000);
console.log('끝');
```
이 코드에 순서를 보면
0. 메모리에 run 함수가 올라간다.
1. 호출 스택에 console.log('시작')이 실행되고 호출스택을 빠져나간다.
2. setTimeout(run, 3000) 함수가 호출스택에 올라가고, 백그라운드에 타이머(run, 3초)를 올려준뒤 호출스택을 나간다(백그라운드와 호출스택은 동시에 실행됨, 다른 스레드).
3. 호출 스택에 console.log('끝')이 실행되고 호출스택을 빠져나간다.
4. 백그라운드에 있던 타이머 함수가 끝나고, run 함수를 테스크 큐에 보내준다.
5. 호출 스택이 비어있으면, 이벤트 루프가 테스크 큐에 있는 함수를 하나씩 보내준다.
6. 3초후 실행이라는 문자가 출력된다.
7. 실행완료
8. 
