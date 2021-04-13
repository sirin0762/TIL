## Array

### new Array()
```js
let arr = new Array("사과", "배", "기타");
```
대괄호를 사용하면 더 짧은 문법으로 배열을 만들 수 있기 때문에 new Array()는 잘 사용되지 않는 편입니다. new Array()엔 다루기 까다로운 기능도 있어서 더욱더 그렇습니다.   

숫자형 인수를 하나 넣어서 new Array를 호출하면 배열이 만들어지는데, 이 배열엔 요소가 없는 반면 길이는 인수와 같아집니다.   
```js
let arr = new Array(2); // 이렇게 하면 배열 [2]가 만들어질까요?

alert( arr[0] ); // undefined가 출력됩니다. 요소가 하나도 없는 배열이 만들어졌네요.

alert( arr.length ); // 길이는 2입니다.
```

### 배열 매서드와 thisArg
함수로 호출하는 대부분의 배열 메서드(find, filter, map, 등)은 thisArg라는 매개변수를 옵션으로 받을 수 있습니다. 자주 사용되는 인수가 아니어서 지금까진 이 매개변수에 대해 언급하지 않았는데, 튜토리얼의 완성도를 위해 thisArg에 대해 잠깐 언급하고 넘어가도록 하겠습니다.   
thisArg는 아래와 같이 활용할 수 있습니다.
```js
arr.find(func, thisArg);
arr.filter(func, thisArg);
arr.map(func, thisArg);
```
thisArg는 func의 this가 됩니다.   

아래 예시에서 객체 army의 메서드를 filter의 인자로 넘겨주고 있는데, 이때 thisArg는 canJoin의 컨텍스트 정보를 넘겨줍니다.   
```js
let army = {
  minAge: 18,
  maxAge: 27,
  canJoin(user) {
    return user.age >= this.minAge && user.age < this.maxAge;
  }
};

let users = [
  {age: 16},
  {age: 20},
  {age: 23},
  {age: 30}
];

// army.canJoin 호출 시 참을 반환해주는 user를 찾음
let soldiers = users.filter(army.canJoin, army);

alert(soldiers.length); // 2
alert(soldiers[0].age); // 20
alert(soldiers[1].age); // 23
```
