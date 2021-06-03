## EMMET
emmet은 html을 빠르게 적을 수 있게 도와준다. 적은양의 타이핑으로 많은 양의 코드를 만들어 낸다

1. 완전 기본
- ! : html 포멧 생성
- div.class => 클래스가 자동으로 들어간 div태그생성
- div#id => 클래스가 자동으로 들어간 div태그생성

2. nesting 요소
- div>ul>li -> : `>` 자식으로
- div>ul+li -> : `+` 형제로
- div>ul>li^ol : `^` 부모로

3. 반복   
- ul>li*5 : 반복생성

4. 그룹
- div>(header>ul>li*2>a)+footer>p : `()` 그룹화  

5. 택스트
- p{} : {}안에 택스트를 넣으면 택스트 생성됨
- {$} : 자동으로 숫자 할당
- p>lorem[숫자] : 더미용 텍스트 


