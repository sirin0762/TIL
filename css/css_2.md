## display
display를 통해 element의 박스 상태를 조절할 수 있다. 
- block은 전체 박스 범위
- inline은 박스 내부의 내용물의 범위만
- inline-block은 지정한 박스 범위 전체이지만, 한 줄을 다 쓰는 것이 아닌 inline 처럼 범위에 따라 한 줄로 정렬   

## position
1. static : default 포지션 값
2. relative : static 위치를 기준으로 top, left 등을 통해 박스를 옮길수 있음
3. absolute : relative는 원래 박스가 있어야하는 자리를 기준으로 움직이는 반면에, absolute는 부모 상자의 위치를 기준으로 움직임
4. fixed : 상자에서 완전히 벗어나 윈도우를 기준으로 움직임
5. sticky : 스크롤링 되도 원래 있는 위치에 그대로 붙어있는 포지션   

만약 본인이 쓰고 있는 css 스타일링의 브라우저 호환성이 궁금하다면 can i use 홈페이지에 들어가서 확인 할 수 있다.    
[can i use 공식 홈페이지](https://caniuse.com/)

## Flexbox
1. container에 적용되는 속성값
  - display
  - flex-direction
  - flex-wrap
  - flex-flow
  - justify-content
  - align-items
  - align-content
2. items에 적용되는 속성값
  - order
  - flex-grow
  - flex-shrink
  - flex
  - align-self

flexbox는 Main-axis 와 Cross-axis를 이용하여 정렬. [flex-box docs](https://css-tricks.com/snippets/css/a-guide-to-flexbox/) 참조하면된다.


## css 반응형 개념 
`content is like a water` 라는 말 같이, 담는 용기에 따라 내용물이 채워지도록 만드는 방식이다. px 을 이용하는 것이 아닌, flex, grid, %, vw, vh 를 이용하여 고정된 크기가 아닌 값이 변할수 있도록 하게 만든다.   

![image](https://user-images.githubusercontent.com/60607880/120652704-fe0a9680-c4ba-11eb-9d39-0cd1709726b3.png)   

반응형으로 만드는 기준 값들을 아래 이미지로 알아보자.    
![image](https://user-images.githubusercontent.com/60607880/120653053-4e81f400-c4bb-11eb-9e5d-ec6550b582ff.png)   

문법은 다음과 같다.
```css
@media media-type and (media-feature-rule) {
  /* CSS rules go here */
}
```   
- media-type : all, print, screen, speech
- and : and, not, only, comma(.)
- media feature : [미디어 쿼리 문서](https://developer.mozilla.org/ko/docs/Learn/CSS/CSS_layout/Media_queries)

