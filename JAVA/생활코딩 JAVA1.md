## 자바 설치 & 이클립스 설치

1. java development kit download 검색
2. oracle - window x64 설치
3. eclipse 설치


## Hello World!
자바의 출력은 System.out.println("Hello World!");
* print() 사용시 줄 바꿈 없음
* 자바 코드는 끝에 세미콜론(;)

## Java 동작 원리
* Java source code (.java) -> 사람이 이해할 수 있는 코드
----compile----            -> 컴퓨터가 이해 할 수 있게 전환
* Java Application (.class)
----  run  ----
* Java Virtual Machine
----  run  ----
* Computer

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

## 변수의 정의
* int    / Integer 정수
* double / 소수
* String / 문자열
```java
public class BootSpringBootApplication {
  public static void main(String[] args) {
    int a = 1;      // 정수 Integer
    double b = 2.0; // 소수
    
    double d = 1.1;
    int e = (int) 1.1; // 강제로 정수로 바꾸고 소수는 삭제
  }
}
```
* casting 강제로 데이터타입을 변환함 ex) (int), (double) 등
* casting Integer => String
String f = Integer.toString(1);
* f.getClass() -> String

## 프로그래밍이란?
* 프로그래밍을 하는 이유
=> 순차적이고 반복적인 작업을 기계에게 위임해서 효율적으로 수행하는것
즉, 자동화된 처리를 하기 위해서이다.

예시)
```java
// import를 통해 필요한 package를 로딩
import org.opentutorials.iot.DimmingLights; 
import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Security;
import org.opentutorials.iot.Lighting;

public class OkJavaGoInHome {

	public static void main(String[] args) {
		String id = "JAVA APT 507";
		
		Elevator myElevator = new Elevator(id);
		myElevator.callForUp(1);
		
		Security mySecurity = new Security(id);
		mySecurity.off();
		
		Lighting hallLamp = new Lighting(id+" / Hall Lamp");
		hallLamp.on();
		
		Lighting floorLamp = new Lighting(id+" / floorLamp");
		floorLamp.on();

	}
}
```

## 디버거
이클립스 상단의 ![image](https://user-images.githubusercontent.com/95890510/175848628-02cf37dc-6973-456c-b4d3-e2469881d67b.png) 버튼을 눌러 실행
왼쪽 줄번호에 더블클릭 = break point를 지정함

## 입력과 출력
* 입력받는 방법
import javax.swing.JOptionPane;
String id = JOptionPane.showInputDialog("Enter a ID");
» 문자열만 입력 받을 수 있음

* String => double
» Double.parseDouble(문자열);

* Run Configurations 설정
1. Java application 선택
2. Arguments 탭 선택
3. 테스트할 입력값을 적음
» "JAVA APT 507" "15.0" 큰따옴표로 묶음
```java
public class OkJavaGoInHomeInput {

	public static void main(String[] args) {
		String id = args[0];        // arguments 0부터 시작
		String bright = args[1];
		
		Elevator myElevator = new Elevator(id);
		myElevator.callForUp(1);
		
		Security mySecurity = new Security(id);
		mySecurity.off();
		
		Lighting hallLamp = new Lighting(id+" / Hall Lamp");
		hallLamp.on();
		
		Lighting floorLamp = new Lighting(id+" / floorLamp");
		floorLamp.on();
		
		DimmingLights moodLamp = new DimmingLights(id+" moodLamp");
		moodLamp.setBright(Double.parseDouble(bright));
		moodLamp.on();

	}

}
```
