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


## css 변수선언
css도 프로그래밍 언어처럼 변수 선언이 가능하다. `--변수명`으로 선언하면 된다. 이를 `custom property` 라고 한다.
```css
:root{
  --background-color : thistle; //background-color 라는 변수 선언 및 정의
}

.first-list{
  background-color : var(--background-color); //var() 함수를 이용하여 변수를 사용할 수 있다.
}
```   

일단 root 부터 보면, 
>CSS :root 의사 클래스는 문서 트리의 루트 요소를 선택합니다 HTML의 루트 요소는 <html> 요소이므로, :root의 명시도가 더 낮다는 점을 제외하면 html 선택자와 똑같습니다.   
  
그 다음은 변수의 적용범위 인데, 해당 요소와 요소 자식에만 국한되는 범위를 가지고 있다. 
  
### calc 함수
calc 함수는 css 내에서 계산을 할 수 있도록 해주는 함수이다. 
```css
  margin : calc(var(--margin)); // root 에서 --margin을 정의 후 사용
```
  
### Typography
Typography 란 웹페이지를 구성할 때 공통적으로 쓰는 텍스트의 스타일링 요소를 동일하게 하여 재생산성을 높이는 방식이다.
```css
  /* Typography */
h1 {
  font-size: var(--font-large);
  font-weight: var(--weight-bold);
  color: var(--color-black);
  margin: 8px 0px;
}

h2 {
  font-size: var(--font-regular);
  font-weight: var(--weight-semi-bold);
  color: var(--color-black);
  margin: 8px 0;
}

h3 {
  font-size: var(--font-regular);
  font-weight: var(--weight-regular);
  color: var(--color-black);
  margin: 8px 0px;
}
```
