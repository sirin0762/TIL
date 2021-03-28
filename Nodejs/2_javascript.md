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
