## 자바 설치 & 이클립스 설치

1. java development kit download 검색
2. oracle - window x64 설치
3. eclipse 설치


## Hello World!
자바의 출력은 System.out.println("Hello World!");
* print() 사용시 줄 바꿈 없음
* 자바 코드는 끝에 세미콜론(;)

## Java 동작 원리
1. Java source code (.java) -> 사람이 이해할 수 있는 코드
*----compile----             -> 컴퓨터가 이해 할 수 있게 전환
2. Java Application (.class)
*----  run  ----
3. Java Virtual Machine
*----  run  ----
4. Computer

## Java 활용
세가지 예시
1. 데스트콥 어플리케이션 만들기
2. 사물을 자바로 제어하기
3. 안드로이드 어플리케이션 만들기

## Datatype
Number 숫자형
String 문자형
* 문자열 다루기
```java
public class BootSpringBootApplication {
  public static void main(String[] args) {
    System.out.println("Hello World".length); // 11
    System.out.println("[[[name]]] World".replace("[[[name]]]", bogeun); //bogeun World
  }
}
```
