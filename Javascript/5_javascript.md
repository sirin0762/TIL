## 메서드와 this

객체는 사용자, 주문 등과 같이 실제 존재하는 개체(entity)를 표현하고자 할 때 생성
```js
let user = {
  name: "John",
  age: 30
};
```

### 메서드 만들기
```js
let user = {
  name: "John",
  age: 30
};

user.sayHi = function() {
  alert("안녕하세요!");
};

user.sayHi(); // 안녕하세요!
```
함수 표현식으로 함수를 만들고, 이를 객체 프로퍼티 user.sayHi에 함수를 할당해줌

```js
// 메서드 단축 구문
// 아래 두 객체는 동일하게 동작합니다.

user = {
  sayHi: function() {
    alert("Hello");
  }
};

// 단축 구문을 사용하니 더 깔끔해 보이네요.
user = {
  sayHi() { // "sayHi: function()"과 동일합니다.
    alert("Hello");
  }
};
```

### 메서드와 this
메서드 내부에서 this 키워드를 사용하면 객체에 접근할 수 있음
```js
let user = {
  name: "John",
  age: 30,

  sayHi() {
    // 'this'는 '현재 객체'를 나타냅니다.
    alert(this.name);
  }

};

user.sayHi(); // John
```

### 자유로운 this
자바스크립트의 this는 다른 프로그래밍 언어의 this와 동작 방식이 다름. 자바스크립트에선 모든 함수에 this를 사용할 수 있다.
```js
//No Error
function sayHi() {
  alert( this.name );
}
```
this의 값은 런타임에 결정됨, 컨텍스트에 따라 달라짐. 동일한 함수라도 다른 객체에서 호출하면 this가 참조하는 값이 달라짐
```js
let user = { name: "John" };
let admin = { name: "Admin" };

function sayHi() {
  alert( this.name );
}

// 별개의 객체에서 동일한 함수를 사용함
user.f = sayHi;
admin.f = sayHi;

// 'this'는 '점(.) 앞의' 객체를 참조하기 때문에
// this 값이 달라짐
user.f(); // John  (this == user)
admin.f(); // Admin  (this == admin)

admin['f'](); // Admin (점과 대괄호는 동일하게 동작함)
```

## new 연산자와 생성자 함수
개발을 하다보면 유사한 객체를 여러 개 만들어야 할 때가 있다. 이럴 때, new 연산자와 생성자 함수를 사용하면 유사한 객체 여래 개를 쉽게 만들 수 있다

### 생성자 함수
생성자 함수와 일반 함수의 기술적인 차이는 없다. 다만 생성자 함수는 아래 두 관례를 따른다.
1. 함수이름의 첫 글자는 대문자로 시작
2. 반드시 "new" 연산자를 붙여 실행

예시:
```js
function User(name) {
  this.name = name;
  this.isAdmin = false;
}

let user = new User("Jack");

alert(user.name); // Jack
alert(user.isAdmin); // false
```

new User(...)를 써서 함수를 실행하면 아래와 같은 알고리즘이 동작
1. 빈 객체를 만들어서 this 에 할당
2. 함수 본문을 실행.
3. this를 반환

예시:
```js
function User(name) {
  // this = {};  (빈 객체가 암시적으로 만들어짐)

  // 새로운 프로퍼티를 this에 추가함
  this.name = name;
  this.isAdmin = false;

  // return this;  (this가 암시적으로 반환됨)
}
```

### 생성자와 return문
생성자 함수엔 보통 return 문이 없습니다. 반환해야 할 것들은 모두 this에 저장되고, this는 자동으로 반환되기 때문에 반환문을 명시적으로 써 줄 필요가 없습니다.   

그런데 만약 return문이 있다면 어떤 일이 벌어질까요? 아래와 같은 간단한 규칙이 적용됩니다.

- 객체를 return 한다면, this 대신 객체가 반환됨
- 원시형을 return 한다면 return 문이 무시됨

예시:
```js
function BigUser() {

  this.name = "John";

  return { name: "Godzilla" };  // <-- this가 아닌 새로운 객체를 반환함
}

alert( new BigUser().name );  // Godzilla
// -----------------------------------------------------------------
function SmallUser() {

  this.name = "John";

  return; // <-- this를 반환함
}

alert( new SmallUser().name );  // John
```
