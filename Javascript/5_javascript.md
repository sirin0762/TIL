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
