## Head

### link의 속성 정리
<link> 태그는 해당 문서와 외부 소스(external resource) 사이의 관계를 정의할 때 사용합니다.    

- type : 링크된 외부 리소스의 미디어 타입을 명시함   
- rel : 현재 문서와 외부 리소스 사이의 연관 관계를 명시함. link 태그내에서 반드시 있어야하는 속성

```html
<link type="미디어 타입">
```

## BEM
BEM(Block Element Modifier)은 클래스 이름 등의 컴포넌트의 이름을 작성하는 방법에 대해 정의한 규칙이다.    
`block__element--modifier`  이 문법을 따르면 된다. 몇가지 예시를 들어보면
- .card__img
- .card__title
- .card__description
- .card--dark
- .card__button--blue

등으로 표시할 수 있다. 만약, nesting 단계가 많다면 (ex. card 들을 감싸고 있는 cards) cards__card 가 아닌, cards 와 card 로 구분하면 된다.

### i 태그
`<i>`태그는 기본 텍스트와는 다른 분위기나 음성을 위한 텍스트 영역을 정의할 때 사용합니다.   

`<i>` 요소의 텍스트는 보통 이탤릭체로 표현되며, 전문용어나 다른 언어의 관용구, 문어체, 서양 문헌에 나오는 배 이름 등을 나타낼 때 사용됩니다.



