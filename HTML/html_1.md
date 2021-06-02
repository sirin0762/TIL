## HTML
마크업언어의 한 종류로 웹페이지에 전시되는 문서를 의미함. html 일반 문서와 달리 체계적인 문법이 있고 이를 통해서 웹페이지를 구현할 수 있음.

```html
<!DOCTYPE html> //문서 타입이 HTML 이라고 정의, 예전에는 브라우저가 
                  따라야하는 중요한 룰을 정의했었음 허나 최근에는 그냥 관습적으로 표기 
<html>  
  <head>  // 사용자에게 보여지는 UI 적인 요소가 아닌 구글에서 검색할 때 나오는 타이틀이나 부가설명,
             북마크 추가할 때 나오는 제목과 아이콘 등이 정의되어 있음. 즉 데이터를 위한 메타데이터가 저장되어있음
    
    <meta charset="utf-8">  // 글자 포멧을 utf-8을 따른다(현존하는 모든 언어를 지원함)
    
    <meta name="viewport" content="width=device-width"> // 뷰포트를 정의, 현재는 디바이스 전체 범위를 사용한다고함
    
    <title>JS Bin</title> // 브라우저에 검색하거나 북마크 추가할 때 보이는 타이틀
  </head>
  <body>  //  사용자에게 보여지는 UI를 담는 가장 큰 컨테이너. UI 관련 요소가 여기에 모두 들어간다.
    
  </body>
</html>
```   

## W3C(World Wide Web Consortium)
웹의 표준화를 추진하는 단체. html5 역시 w3c 에 의해서 표준화 됨. 우리는 당연히 이러한 표준을 알아야할 필요가 있음(모든 브라우저에서 호환되야하므로).

## MDN(Mozilla Developer Network)
웹의 관한 대부분의 정보가 표준화되어 정리된 곳. 가장 빠르게 정보의 업데이트가 일어나고 수많은 개발자들이 MDN을 이용하여 웹을 만들고있다. 웹페이지에서 구현해야하는 것을 무서워하지 않고 여기 들어가서 확인하면 표준화된 문법과 사용방식이 나오니 그대로 따라하면된다.   

[MDN HTML 공식 문서](https://developer.mozilla.org/ko/docs/Web/HTML)   

## HTML TAGS
말도 안되는 태그를 넣을 경우, 브라우저는 해당 컨텐츠만 문자로 보여준다. 혹시 내가 유효한 태그를 썼는지 안 썼는지 확인하고 싶다면 w3c validation service를 통해 확인 받을 수 있다.   

[HTML 유효성 검증 웹사이트](https://validator.w3.org/)   

## HTML structure
웹페이지를 만들 때 가장 노멀하게 구조를 나누는 방법은 header, navigation bar, main content, sidebar, footer 로 나누는 것이다.    
[웹사이트 구조]()

