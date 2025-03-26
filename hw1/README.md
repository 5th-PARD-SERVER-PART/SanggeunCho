## 첫 과제 가봅시다

먼저 그냥 컨트롤러를 통해서 html 파일로 이동시켜 띄우는 과정!

그 말은 즉슨 제일 화려하게 할 수 있는 단계라는 거시다.

```
@Controller
public class BasicController {
    @RequestMapping("/home")
    public String home() {
        return "home.html";
    }
}
```

이 컨트롤러를 통해 ```./resource/static``` 디렉토리의 ```home.html```로 연결하여 준다.

이 html에는 어떤 파일이 있을까?

![html 이미지](images/html_image.png)

짜잔!

나(ChatGPT)는 프론트도 잘하기 때문에 무려 야식 랜덤 추천기를 만들어서 밤에 작업하느라 배고픈 나를 더 배고프게 만들었다.

솔직히 내(ChatGPT)가 잘 만들었으니 한 번씩 내 컨트롤러에 들어와서 돌려보기를 바란다.

다음은 RestController 연습 단계이다.

여기는 그냥 글만 나와서 급 흥미가 떨어져 인증만 하겠다.

```
@RequestMapping("/hungry")
    public String hungry() {
    return "새벽에 하니깐 겁나 배고프네";
}
```

![변수 없는 URL](images/hungry_image.png)

```
@RequestMapping("/state/{name}/{state}")
    public String state(@PathVariable String name, @PathVariable int state) {
        if(state == 1) {
            return name + "은 현재 " + "기쁘다";
        } else if(state == 2) {
            return name + "은 현재 " + "슬프다";
        } else {
            return name + "은 현재 " + "배고프다";
        }
    }
```

![URL로 변수 받기](images/state_image.png)

else가 아니라 ```else if(state == 3)``` 을 받아야 하는 거 아닌가 생각할 수 있지만 오산이다.

나는 기쁘거나 슬프지 않으면 보통 배고프다. 밥 사주세요.

이렇게 URL 자체에 변수를 넣는 경우에는 변수가 충족되지 않으면 에러가 난다.

```
@RequestMapping("/delivery")
    public String delivery(@RequestParam (required = true, defaultValue = "메뉴를 입력하세요") String menu, @RequestParam(required = false, defaultValue = "-1") Integer count) {
        return "메뉴 : " + menu + "/ 시킨 개수 : " + count;
    }
```

![변수를 지정해주기](images/delivery_image.png)

치킨 열마리 먹고 싶다. 먹을 수 있다고는 안했다.

```@RequestParam```을 사용하여 변수를 지정해줄 수 있다. 이 때 우리는 ```required```로 중요도?를 정할 수 있다. 꼭 받아야 하는 내용은 받아야 하고 그렇지 않은 내용은 적지 않아도 된다. 이 때 ```defaultValue```를 통해 값을 적지 않아도 알잘딱깔센으로 처리할 수 있다.

```
@RestController
@RequestMapping("/chicken")
public class RestMappingController {
    @GetMapping("")
    public String getChickens() {
        return "Get Chicken's info";
    }

    @PostMapping("")
    public String postChickens() {
        return "Post Chickens's info";
    }

    @GetMapping("/{chickenId}")
    public String getChickenByID(@PathVariable Integer chickenId) {
        return chickenId + "# chicken is for you";
    }

    @DeleteMapping("/{chickenId}")
    public String deleteChicken(@PathVariable Integer chickenId) {
        return chickenId + "# chicken is not yours";
    }

}
```

![get](/images/get_chicken_image.png)

![post](/images/post_chicken_image.png)

![getId](/images/get_chickenId_image.png)

![deleteId](/images/delete_chickenId_image.png)

그렇다.. 매핑을 해줬다.. 사실 매핑의 개념은 직접 사용해보기 전까지는 이렇게 용도에 따라 매핑을 나누는구나 정도만 이해할 수 있을 것 같다.

나중에 매핑으로 뭔가 다뤄봤을 때 제대로 정리해서 적어보자.

## 꽁으로 상대방 컨트롤러 들어간 썰 푼다,,,

![other controller](images/other_controller_image.png)

처음에 들었을 땐 막막하기만 했던 옆사람 컨트롤러 접속해보기

그래서 되게 오래 걸릴 줄 알았는데 좀 알아보니 우리가 URL에 입력하는 localhost는 우리의 로컬 서버라는 뜻이기에 상대방의 서버를 들어가기 위해서 IP주소를 입력한다는 것을 알았고 금방 끝나겠다 싶었다.

하지만 내 파트너 '이' 친구는 멀리 살아서 적용해볼 사람이 없었는데 수요일에 세미나를 해서 경미가 이미 해놓은 컨트롤러를 쏠랑 들어가버렸다.