## 의미, 정의
CSS(Cascading style sheet)은 html을 스타일링 하는 문서로, Author style -> User style -> browser 순으로 해당 스타일링이 되어있는가를 판단하여 브라우저에 렌더링 해준다.
- Author style : 우리가 정의한 스타일
- User style : 네이버에서 폰트조절하는 것과 같이 사용자를 위해 만들어진 스타일
- browser : 브라우저가 기본으로 제공하는 스타일

단, important를 만났을 경우, 해당 부분이 최우선이 되기에 이러한 cascading을 무시할 수 있다. 허나 이런걸 쓴 것은 당연히 나쁜 아키택처일 확률이 높다. 가능하면 쓰지 않는 것이 좋다.   

## 선택자
- Universal : *
- type : Tag
- id : #id
- class : .class
- state : :
- attribute : []

```css
button:hover{
  background : beige;   // 버튼에 마우스를 올렸을 때 -> :(state)는 특정 상태에서의 스타일을 나타낸다
}

a[href^=naver]{
  color: purple;  // 특성 속성으로 선택자를 지정함
}

a[href$=naver]{
  color: purple;  // 특성 속성으로 선택자를 지정함
}
```
