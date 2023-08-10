# Dust's game(농서스)


### :game_die:[게임화면]
---------
![image](https://github.com/FineDust1598/JavaGameStudy/assets/135123667/6d04f4b4-e552-4752-be63-332366603884)

1. 게임을 시작할 수 있음
2. 관련 스토리를 볼 수 있고 다 보면 초기화면으로 돌아옴

![image](https://github.com/FineDust1598/JavaGameStudy/assets/135123667/4b5509d7-252e-4dba-b094-2c9a45e3a468)




### :video_game:[게임 화면]
---
![image](https://github.com/FineDust1598/JavaGameStudy/assets/135123667/840e6798-390a-4e2e-adc6-f7670975035d)

-자신이 선택하는 숫자에 따라 행동이 달라짐

-작물에는 3가지 종류가 있음(wheat, vege, fruit)

-나서스의 도구가 어떤것인지에 따라 완전수확이라는 개념 존재

-완전 수확시 원래 수확 후 들어오는 재화 x 1.5배

-마나는 스킬을 사용하는데 필요함

-스킬 사용시 가지고 있는 도구에 상관없이 수확 후 들어오는 재화 x 2.5배


![image](https://github.com/FineDust1598/JavaGameStudy/assets/135123667/26fca35a-bf94-4354-a657-d59881546729)

-수확 시 스킬의 사용 여부를 물어보고 선택시 스킬 사용

-선택을 안 할 경우 가지고 있는 도구에 따라 완전수확 할 지 정함

![image](https://github.com/FineDust1598/JavaGameStudy/assets/135123667/5ed3332c-f612-4859-999f-0a514368e090)

-아래와 같이 마나가 소비되게 되고 원래 받게 될 금액의 x 2.5배를 벌게 됨

-이후 다시 원래 화면으로 이동

-이때 마나가 없는데도 스킬을 사용하게 되면 30초 이후 자연스럽게 마나 2칸이 차오르게됨(스레드를 이용하여 따로 멈추지 않음)

![image](https://github.com/FineDust1598/JavaGameStudy/assets/135123667/932e3729-008c-40e4-b7c6-44fa24fb5186)

-현재 사진이 도구가 안맞을 경우임

![image](https://github.com/FineDust1598/JavaGameStudy/assets/135123667/6c4ea2f5-fbcb-49fd-b8bd-e45a1fe7c066)

-현재 사진이 도구가 맞을 경우임

-도구가 작물의 타입과 맞을 경우 완전수확으로 1.5배의 금액을 더 벌게됨.

-이후에는 계속 반복적으로 랜덤한 타입의 작물이 나와 수확할 수 있게됨.

### 🏃‍♂️[지나침 화면]
---
![image](https://github.com/FineDust1598/JavaGameStudy/assets/135123667/ce3b1f26-d507-49b6-8170-20ab5be2ddab)

-작물의 타입등이 마음에 안들어 바꾸고 싶을 경우 현재 작물을 지나치고 다음 작물을 볼 수 있음.

### :cocktail:[상점 화면]
---
![image](https://github.com/FineDust1598/JavaGameStudy/assets/135123667/b70c54df-2c7e-44e5-a8a3-15fcbe245f3b)

1. 도구 구매가능
2. 마나 수급가능

##### -도구 구매의 경우 앞선 작물 타입에 맞는 도구를 구매하여 사용하여 완전수확 가능
![image](https://github.com/FineDust1598/JavaGameStudy/assets/135123667/e5538f91-6c70-4554-955e-359deb15b47f)

-위와 같이 도구가 보이게 되고 각 도구에 맞는 작물의 타입들이 적혀져있음

-맨 오른쪽의 경우 내가 가지고 있는지 혹은 없는지를 나타내는 것

-이후 아래쪽에는 선택지와 함께 현재 가지고 있는 재화를 보여줌

![image](https://github.com/FineDust1598/JavaGameStudy/assets/135123667/d8e049b4-c1a1-4a76-a261-ce644c6528be)

![image](https://github.com/FineDust1598/JavaGameStudy/assets/135123667/dfdf917a-7792-4788-bf4c-f18ba72852a1)

-구매를 유미로 선택하였고 위 처럼 이미 가지고 있어 전체 메세지로 이미 가지고 있을 수 있다고 이야기함
-혹은 돈이 없을 경우도 구매가 불가능함

##### -마나 수급의 경우 스킬을 사용하는데에 있어 필요한 마나를 금액을 주고 회복 가능

![image](https://github.com/FineDust1598/JavaGameStudy/assets/135123667/f43b781b-b393-4619-bb96-b0de4986f26f)

-위와 같이 마나를 일정량의 재화를 주고 다시 채울수 있음

### 💔[게임 종료]

-선택 시 현재 게임이 종료됨.

