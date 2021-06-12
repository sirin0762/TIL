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
