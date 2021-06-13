## border box VS content box

### border box
```css
.box{
  box-sizing : border-box; // border box는 박스의 사이즈에 border 와 padding, content가 다 포함 된다.
  padding : 20px
  border : 10px solid black; // box 사이즈가 100px 이라면, border(10) + padding(20) + content(70)
}
```

### content box
```css
.box{
  box-sizing : content-box; // content box는 박스의 사이즈가 content 에만 국한되고, padding과  border는 예외한다.
  padding : 20px
  border : 10px solid black; // box 사이즈가 100px 이라면, border(10) + padding(20) + content(100) = 130 사이즈가 됨
}
```

## Position           

### 1. static
요소를 일반적인 문서 흐름에 따라 배치합니다. top (en-US), right (en-US), bottom (en-US), left (en-US), z-index 속성이 아무런 영향도 주지 않습니다. 기본값입니다.

### 2. relative
relative
요소를 일반적인 문서 흐름에 따라 배치하고, 자기 자신을 기준으로 top, right, bottom, left의 값에 따라 오프셋을 적용합니다. 오프셋은 다른 요소에는 영향을 주지 않습니다. 따라서 페이지 레이아웃에서 요소가 차지하는 공간은 static일 때와 같습니다.   

z-index의 값이 auto가 아니라면 새로운 쌓임 맥락을 생성합니다.

### 3. absolute
요소를 일반적인 문서 흐름에서 제거하고, 페이지 레이아웃에 공간도 배정하지 않습니다. 대신 가장 가까운 위치 지정 조상 요소(static을 제외한 요소)에 대해 상대적으로 배치합니다. 단, 조상 중 위치 지정 요소가 없다면 초기 컨테이닝 블록을 기준으로 삼습니다. 최종 위치는 top, right, bottom, left 값이 지정합니다.
z-index의 값이 auto가 아니라면 새로운 쌓임 맥락을 생성합니다. 절대 위치 지정 요소의 바깥 여백은 서로 상쇄되지 않습니다.

### 4. sticky
해당 요소를 품고있는 부모를 기준으로 붙어있는 위치를 지정한다(스크롤 시). 따라서 top, left 등의 속성 값이 반드시 있어야 한다.
```css
.box{
  position : sticky;
  top : 20px;
  left : 20px // 반드시 top, left 등의 위치 속성이 들어가 있어야함.
}
```

### 5. fixed
요소를 일반적인 문서 흐름에서 제거하고, 페이지 레이아웃에 공간도 배정하지 않습니다. 대신 뷰포트(브라우저)의 초기 컨테이닝 블록을 기준으로 삼아 배치합니다. 단, 요소의 조상 중 하나가 transform, perspective, filter 속성 중 어느 하나라도 none이 아니라면 (CSS Transforms 명세 참조) 뷰포트 대신 그 조상을 컨테이닝 블록으로 삼습니다. (perspective와 filter의 경우 브라우저별로 결과가 다름에 유의) 최종 위치는 top, right, bottom, left 값이 지정합니다.

