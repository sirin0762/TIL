## 정렬

### 1. margin : auto
일단 margin 속성에 대해 알아보면, 여러개일때는 무조건 수직부터, 4개일 때는 시계방향으로 생각하면됨
```css
/* 네 면 모두 적용 */
margin: 1em;
margin: -3px;

/* 세로방향 | 가로방향 */
margin: 5% auto;

/* 위 | 가로방향 | 아래 */
margin: 1em auto 2em;

/* 위 | 오른쪽 | 아래 | 왼쪽 */
margin: 2px 1em 0 auto;

/* 전역 값 */
margin: inherit;
margin: initial;
margin: unset;
```
auto는 block element에 적용되고, 요소를 수평 가운데 정렬 시켜줌

### 2. text-align : center
inline 요소들을 모두 수평 정렬 가능하게 해줌, block 요소는 안됨

### 3. translate(50%, 50%);
translate() CSS 함수는 요소를 수평 및/또는 수직 방향으로 재배치한다. 결과는 <transform-function> 데이터 유형입니다.
```css
/* Single <length-percentage> values */
transform: translate(200px);  // x축만 이동
transform: translate(50%);

/* Double <length-percentage> values */
transform: translate(100px, 200px);   // x, y축 이동
transform: translate(100px, 50%);
transform: translate(30%, 200px);
transform: translate(30%, 50%);
```
즉 50%, 50% 는 가운데 정렬이다.

### 4. Text centering(hacky 함)
line-height 속성은 텍스트의 길이를 정한다. 이때 부모의 길이와 동일하게 설정하면 텍스트가 수직 정렬이 되는 효과를 줄 수 있다.
  
### 5. justify-content, align-items
사실 이 방법이 가장 쉽고 모던하다. 부모를 flexbox로 만들어 해당 두 속성을 center로 주면된다.
