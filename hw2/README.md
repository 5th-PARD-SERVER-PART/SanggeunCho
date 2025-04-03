# HW2

---
## 🍕제일 중요한거🍕

컨셉을 뭘로 잡을까...

**"피자"**

- ID
- 이름
- 가격
- 엣지

---

### 나중에 한번에 정리하면 받아적기 밖에 안될 것 같아서 코딩하면서 시작하는 마크다운 작성기, 그냥 눈에 보이는대로 정리한 다음에 나중에 다시 공부하지 뭐 인정? 이것도 나름대로 나쁘지 않은 것 같습니다.

### 민규띠의 추천 순서: ENTITY ➡ CONTROLLER ➡ DTO ➡ SERVICE ➡ REPOSITORY
<img src="images/letsgo.webp" width="150" height="150"/>

---

### Entity

```
@Getter
@Setter
@NoArgsConstructor
@AllArgsContructor
@Builder
```
엔티티에서 필요한 애노테이션들이다.

```
public class Pizza {
    private int PizzaID;
    private String PizzaName;
    private int PizzaPrice;
    private String PizzaEdge;
}
```
피자에서 가장 중요한 부분은 토핑과 엣지... 토핑은 이름으로 퉁치자, ID는 왜 넣었느냐! 필요할 것 같아서 넣었다.

---

### Controller
```
@RestController
@RequiredArgsConstructor
@RequestMapping("/pizza")
```
컨트롤러에 필요한 애노테이션들.

뭐 컨트롤러는 이전에 했던 그대로다.
URL을 통해서 연결할 수 있도록 한다. 그런데 이전에는 URL로만 다뤘어서 뭔가 겉핥기만 했던 것에 비해 이번에는 CRUD에 맞는 매핑을 하면서 좀 더 뭔가 알게 된 것 같은 느낌이다. 아닐 수도 있다.

컨트롤러에서는 DTO의 함수들을 사용한다.

---
### DTO

Entity와 구조는 같다. 하지만 이는 장바구니.. 필요한 것만 담아야 하는데 피자에서 필요없는 것 따윈 없어서 다 담았다.

DTO는 더 큰 프로젝트에서 다뤄야 그 진가를 제대로 발휘할 것 같다. DTO는 장바구니에 담은 정보들을 모두 준다고 한다. 내 쿠팡 장바구니에 담긴 물건들도 누가 나한테 다 사주면 좋겠다.

---
### Service
```
@Service
@RequiredArgsConstructor
```
애노테이션 히히

Service는 로직을 처리하는 장소라고 한다. 하지만 우리는 애송이라 아직 DB를 다루지 않는다. 고로 나의 Service는 그저 Repo에게 '응애.' 할 뿐이다. 나의 모습과 비슷한 것 같다.

🗣️ **"사장님, 부사장님 해줘~"** > 둘이 합치면 나 민규임... 좋은데?

여튼 서비스는 DB를 다룰 때 본격적으로 해보자

---
### Repository

```
@Repository
```
전용 애노테이션... 머시ㄸr

우리 금고 관리자님 Repository, 여기서는 그저 Service의 응애 받이일 뿐이다. 즉, 로직 구현이 여기에서 다 되어있다.

이도 DB를 다룰 때 제대로 ㅇrㄹr보ㅈr