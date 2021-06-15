## Transition : 애니메이션 담당(변화를 부드럽게)
변화의 처음과 끝을 `:` 을 이용하여 지정하고, transition 속성을 통해서 변화를 부드럽게 한다.

```css
.box1:hover{
  background-color: blueviolet; //mouse를 올리면 블루바이올렛 색으로
  transition-property : background-color; //트렌지션이 적용될 특성 선택
  transition-duration : 300ms; //트렌지션이 지속되는 시간
  transition-timing-function : linear; // 트렌지션의 방식(ease, ease in, linear 등등)
  transition : all 300ms linear; //한번에 선언 가능
}
```

### cubic-bezier
에니메이팅 되는 방식(linear, ease-in 등)을 커스터마이징 할 수 있다. 값은 `cubic-beizer()`함수를 쓰면 된다. 커스터마이징 하는 웹사이트는 [cubic-beizer](https://cubic-bezier.com/#.17,.67,.83,.67)이다.
