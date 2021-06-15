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
  
## Transform
transform 은 요소를 변형하고 움직일 때 사용하는 속성이다. x, y 축 이동 및 skew, scale 등이 가능하다. 기본적인 것부터 알아보면
```css
.box2{
  transform : translateX(100px) // translate 함수 : x, y, z 축의 이동 담당
  transform : trnaslate(50px, -20px);
  transform : scale(1.2);  // 요소의 크기 변경
  transform : rotate(45deg) // 요소의 회전(시계 방향)
  transform : translate(100px, 100px) scale(2) rotate(45deg); // 합쳐서 사용가능
}
  ```

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

  
## responsive-background
반응형에 들어가는 백그라운드 이미지를 알아보자
```css
background-repeat : no-repeat; // 이미지 반복 x
background-position : center; // 이미지의 가운데를 중심으로 보이게
background-size : cover 

background : no-repeat center cover; // 한번에 선언가능
```
CSS background-size 속성은 요소 배경 이미지의 크기를 설정합니다. 그대로 두거나, 늘리고 줄이거나, 공간에 맞출                              수 있습니다. 배경 이미지로 덮이지 않은 공간은 background-color 속성으로 채워지고, 배경 이미지에서 투명하거나 반투명한 부분을 통해서도 배경색이 보입니다. cover는 이미지가 찌그러지지 않는 한도 내에서 제일 크게 설정. 이미지의 가로세로비가 요소와 다르다면 이미지를 세로 또는 가로방향으로 잘라내어 빈 공간이 생기지 않도록 설정합니다.
