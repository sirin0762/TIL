## 선배의 팁 
[강의 소스](https://youtu.be/OoA70D2TE0A)    
HTML에 있는 태그는 2가지로 나뉜다. 레이아웃을 결정짖는 box와 동작을 해주는 item 으로 나뉠 수 있다.   
- box : header, footer, nav, aside, main, section, article, div, span, form
- item : a, button, input, label, img, video, audio, map, canvas, table

또한 각각의 요소는 layout 성격에 따라 inline과 block으로 나눌수 있다.

### input
input 태그는 보통 label 태그와 같이 사용된다. 어떠한 데이터를 넣어달라는 건지 사용자에게 알려줘야하기 떄문이다. TCP School의 글을 인용하면, 
 
> <label> 태그는 사용자 인터페이스(UI) 요소의 라벨(label)을 정의할 때 사용합니다.   
  
> <label> 요소는 for 속성을 사용하여 다른 요소와 결합할 수 있으며, 이때 <label> 요소의 for 속성값은 결합하고자 하는 요소의 id 속성값과 같아야 합니다. 또한, <label> 요소를 결합하고자 하는 요소 내부에 위치시키면 for 속성을 사용하지 않더라도 해당 요소와 결합시킬 수 있습니다.   
  
> 이러한 <label> 요소는 브라우저에 의해 일반적인 텍스트로 랜더링되지만, 사용자가 마우스로 해당 텍스트를 클릭할 경우 <label> 요소와 연결된 요소를 곧바로 선택할 수 있어 사용자의 편의성을 높일 수 있습니다.    

```html
  <body>
    <label for = "">Name:</label> // for의 속성 값은 다른 대상의 id값과 연동되어 있음
    <input type = "text">
  </body>
```
구글 개발자 도구의 Element Tab에서 Element inspector를 통해 해당 부분의 HTML 을 자세히 알 수 있다.
