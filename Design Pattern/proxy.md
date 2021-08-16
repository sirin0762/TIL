## Proxy
> 일반적으로 프록시는 다른 무언가와 이어지는 인터페이스의 역할을 하는 클래스이다. 프록시는 어떠한 것(이를테면 네트워크 연결, 메모리 안의 커다란 객체, 파일, 또 복제할 수 없거나 수요가 많은 리소스)과도 인터페이스의 역할을 수행할 수 있다.
> - 위키백과

### 정의

- 프록시는 대리인을 의미하는 패턴으로 비서를 떠올리면 쉽게 이해가 됩니다.
- 어느 정도 규모가 있는 회사의 대표는 만나기 어렵습니다. 대부분은 비서와 면담을 할 것입니다.
- 프로그래밍에서도 이와 비슷하게 인터넷에서 받아와야해서 시간이 걸리거나, 메모리를 많이 쓰는 등의 이유로 객체로 여럿 생성하기 부담되는 것이 있습니다.
- 이럴 때 해당 클래스의 proxy, 대리자 역할을 하는 클래스를 따로 두어서 가벼운 일은 proxy 클래스가 처리하게 하는 방식입니다.



### 구현
- 유투브 처럼 평소에는 썸네일만 보이다가, 마우스 커서를 올리면 프리뷰가 재생되는 방식을 통해서 구현을 해보겠습니다.
![image](https://user-images.githubusercontent.com/60607880/129503034-8c72d4ff-b32a-406d-952d-e340c00190cd.png)

1. 인터페이스를 생성
```java
public interface Thumbnail {
    public void showTitle();
    public void showPreview();
}
```
2. 해당 인터페이스를 real과 proxy에 구현해줍니다.
```java
class RealThumbnail implements Thumbnail {
    private String title;
    private String movieUrl;

    public RealThumbnail(String title, String movieUrl) {
        this.title = title;
        this.movieUrl = movieUrl;

        // URL로부터 영상을 다운 받는 작업 - 시간 소모
        System.out.println(movieUrl + "에서" + title + "의 영상 데이터를 다운로드");
    }

    @Override
    public void showTitle() {
        System.out.println("제목 : " + title);
    }

    @Override
    public void showPreview() {
        System.out.println(title + "의 프리뷰 재생");
    }
}

class ProxyThumbnail implements Thumbnail {
    public String title;
    public String movieUrl;

    private RealThumbnail realThumbnail;

    public ProxyThumbnail(String title, String movieUrl) {
        this.title = title;
        this.movieUrl = movieUrl;
    }

    @Override
    public void showTitle() {
        System.out.println("제목 : " + title);
    }

    @Override
    public void showPreview() {
        if(realThumbnail == null){
            realThumbnail = new RealThumbnail(title, movieUrl);
        }
        realThumbnail.showPreview();
    }
}
```
- realThumbnail 클래스는 URL을 통해서 영상을 받아와야하기 때문에 무겁고 객체 생성이 오래 걸립니다.
- 하지만 proxyThumbnail 클래스는 객체 생성이 빠른대신, 제목만 보여줄수 있고, preview의 경우에는 realThumbnail 객체를 생성해서 사용합니다.
- 이러한 방식을 통해서 proxy는 가벼운 업무를 real은 무거운 업무를 따로 할 수 있게 만들어줍니다.
