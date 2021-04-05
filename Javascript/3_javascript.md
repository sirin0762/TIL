## 객체
객체를 만드는 방법은 두가지가 있음
```js
let user = new Object(); //객체 생성자 문법
let user = {}; //객체 리터럴 문법

let user = {     // 객체
  name: "John",  // 키: "name",  값: "John"
  age: 30        // 키: "age", 값: 30
};
```
여러 단어를 조합 할 경우는 따움표로 묶어줘야함
```js
let user = {
  name: "John",
  age: 30,
  "likes birds": true  // 복수의 단어는 따옴표로 묶어야 합니다.
};
```

### 대괄호 표기법
```js
// 문법 에러가 발생합니다.
user.likes birds = true
```
이런 경우에는 
```js
let user = {};

// set
user["likes birds"] = true;

// get
alert(user["likes birds"]); // true

// delete
delete user["likes birds"];

//or
let key = "likes birds";

// user["likes birds"] = true; 와 같습니다.
user[key] = true;
```

### 단축 프로퍼티
실무에서는 프로퍼티 값을 기존 변수에서 받아와 사용하는 경우가 종종 있음
```js
function makeUser(name, age) {
  return {
    name: name,
    age: age,
    // ...등등
  };
}

let user = makeUser("John", 30);
alert(user.name); // John
```
위의 예시의 프로퍼티 들은, 이름과 값이 변수의 이름과 동일, 이런 경우 단축이 가능함
```js
function makeUser(name, age) {
  return {
    name, // name: name 과 같음
    age,  // age: age 와 같음
    // ...
  };
}
### ‘in’ 연산자로 프로퍼티 존재 여부 확인하기
js 객체의 중요한 특징 중 하나는 다른 언어와는 달리, 존재하지 않는 프로퍼티에 접근하려 해도 에러가 발생하지 않고 undefined를 반환함   

따라서 이런 특징을 이용하면 프로퍼티에 존재여부를 알 수있음
```js
let user = { name: "John", age: 30 };

alert( "age" in user ); // user.age가 존재하므로 true가 출력됩니다.
alert( "blabla" in user ); // user.blabla는 존재하지 않기 때문에 false가 출력됩니다
```

### ‘for…in’ 반복문
for..in 반복문을 사용하면 객체의 모든 키를 순회할 수 있음. for..in은 앞서 학습했던 for(;;) 반복문과는 완전히 다른 개념.
```js
let user = {
  name: "John",
  age: 30,
  isAdmin: true
};

for (let key in user) {
  // 키
  alert( key );  // name, age, isAdmin
  // 키에 해당하는 값
  alert( user[key] ); // John, 30, true
}
```

### 참조에 의한 객체 복사
원시값(문자열, 숫자, 불린 값)은 call by value 이지만, 객체의 경우는 call by reference
```js
// 다른 메모리에 저장
let message = "Hello!";
let phrase = message;

let user = { name: "John" };

let admin = user; // 참조값을 복사함
```
### 객체 복사, 병합과 Object.assign
객체를 call by value 로 복사하고 싶으면 다음과 같이 하면 됨
```js
let user = {
  name: "John",
  age: 30
};

let clone = {}; // 새로운 빈 객체

// 빈 객체에 user 프로퍼티 전부를 복사해 넣습니다.
for (let key in user) {
  clone[key] = user[key];
}

// 이제 clone은 완전히 독립적인 복제본이 되었습니다.
clone.name = "Pete"; // clone의 데이터를 변경합니다.

alert( user.name ); // 기존 객체에는 여전히 John이 있습니다.
```
혹은 Object.assign을 사용
```js
let user = { name: "John" };

let permissions1 = { canView: true };
let permissions2 = { canEdit: true };

// permissions1과 permissions2의 프로퍼티를 user로 복사합니다.
Object.assign(user, permissions1, permissions2);

// now user = { name: "John", canView: true, canEdit: true }

let user = {
  name: "John",
  age: 30
};

let clone = Object.assign({}, user);
```
### 중첩 객체 복사
만약 객체안에 객체가 있는 형태라면? 이 경우는 내부 객체는 프로퍼티를 공유하고 있는 상황이 됨
```js
let user = {
  name: "John",
  sizes: {
    height: 182,
    width: 50
  }
};

let clone = Object.assign({}, user);

alert( user.sizes === clone.sizes ); // true, 같은 객체입니다.

// user와 clone는 sizes를 공유합니다.
user.sizes.width++;       // 한 객체에서 프로퍼티를 변경합니다.
alert(clone.sizes.width); // 51, 다른 객체에서 변경 사항을 확인할 수 있습니다.
```
이 문제를 해결하려면 user[key]의 각 값을 검사하면서, 그 값이 객체인 경우 객체의 구조도 복사해주는 반복문을 사용해야 합니다. 이런 방식을 '깊은 복사(deep cloning)'라고 합니다.   

깊은 복사 시 사용되는 표준 알고리즘인 Structured cloning algorithm을 사용하면 위 사례를 비롯한 다양한 상황에서 객체를 복제할 수 있습니다.   

자바스크립트 라이브러리 lodash의 메서드인 _.cloneDeep(obj)을 사용하면 이 알고리즘을 직접 구현하지 않고도 깊은 복사를 처리할 수 있으므로 참고하시기 바랍니다.   
