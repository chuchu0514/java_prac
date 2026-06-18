## 빠른 지도 (전체 그림)

| 장 | 주제 | 한 줄 요약 |
|----|------|-----------|
| 1 | 자바 시작 | JVM, 바이트코드, WORA, JDK/JRE |
| 2 | 기본 프로그래밍 | 데이터타입, Scanner 입력, 연산자, 조건문 |
| 3 | 반복문·배열·예외 | for/while, 배열(객체), try-catch |
| 4 | 클래스와 객체 | 생성자, this, static, 접근지정자, 캡슐화 |
| 5 | 상속 | extends, super, 오버라이딩, 다형성, 추상/인터페이스 |
| 6 | 패키지·기본 API | import, Object, String, Wrapper, Math |
| 7 | 제네릭·컬렉션 | `<T>`, ArrayList, HashMap, Iterator |
| 8 | 스윙 기초 | JFrame, 컨테이너, 배치관리자 |
| 9 | 이벤트 | 리스너, 이벤트 객체, 어댑터 |
| 10 | 스윙 컴포넌트 | JButton, JLabel, JTextField 등 |
| 11 | 그래픽 | paintComponent, Graphics, repaint |
| 12 | 스레드 | Thread, Runnable, 동기화 |
| 13 | 파일 입출력 | 스트림, 텍스트/바이너리, File 클래스 |

> **시험 전략**: 비중 큰 4·5·7장(OOP·컬렉션)을 먼저 확실히. 8~13장은 "이 기능 어디서 찾지"만 알면 됨.

---

# 1장. 자바 시작

## 핵심 개념
- **WORA (Write Once, Run Anywhere)**: 한 번 작성한 코드가 OS에 상관없이 실행됨. 비결은 "기계어로 컴파일하지 않고 **바이트코드**로 컴파일" + "각 OS에 맞는 **JVM**이 그걸 실행".
- **컴파일 과정**: `.java` → (javac 컴파일러) → `.class`(바이트코드) → (JVM이 해석/실행) → 결과
  - C: 소스 → 기계어 실행파일 (OS마다 다시 컴파일 필요, 플랫폼 종속)
  - Java: 소스 → 바이트코드 (어디서나 JVM만 있으면 실행, 플랫폼 독립)
- **JVM (Java Virtual Machine)**: 바이트코드를 해석/실행하는 가상 기계. OS마다 다른 JVM이 깔림. "바이트코드는 같고 JVM이 다르다"가 WORA의 핵심.
- **JDK vs JRE**
  - JRE(Java Runtime Environment) = 실행 환경 (JVM + 표준 라이브러리). "실행만" 하려면 충분.
  - JDK(Java Development Kit) = 개발 도구(javac, 디버거 등) + JRE. "개발하려면" 필요.
  - 포함 관계: **JDK ⊃ JRE ⊃ JVM**

## 자바의 특징 (시험에 "특징 고르기"로 자주 나옴)
- 플랫폼 독립적 (바이트코드)
- 객체지향 (모든 코드가 클래스 안에)
- 자동 메모리 관리 (가비지 컬렉션 — C의 malloc/free 없음)
- 멀티스레드 지원
- 포인터 직접 조작 불가 (C와 큰 차이 — 안전성↑)

## 프로그램 기본 구조
```java
public class Hello {                          // 파일명과 동일해야 함
    public static void main(String[] args) {  // 프로그램 시작점
        System.out.println("Hello");          // 출력 + 줄바꿈
        System.out.print("줄바꿈 없음");
        System.out.printf("%d %s\n", 10, "텍스트");  // C의 printf와 유사
    }
}
```
- **파일명 == public 클래스명** (Hello.java ↔ public class Hello). 안 맞으면 컴파일 에러.
- `main`은 반드시 `public static void main(String[] args)` 형태 — JVM이 이 시그니처를 찾음.
- 한 파일에 클래스 여러 개 가능하지만 `public` 클래스는 1개만, 그게 파일명.

## 출력 함정
- `System.out.println(1 + 2)` → `3` (덧셈)
- `System.out.println("1" + 2)` → `12` (문자열 연결! 문자열이 끼면 + 는 연결)
- `System.out.println(1 + 2 + "3")` → `33` (왼쪽부터: 1+2=3, 그다음 "3" 연결)

---

# 2장. 기본 프로그래밍

## 데이터 타입 (★ 기본형 8개)
| 분류 | 타입 | 크기 | 비고 |
|------|------|------|------|
| 논리 | `boolean` | 1byte | true/false (C와 달리 0/1 아님) |
| 문자 | `char` | 2byte | **유니코드**, C와 달리 2바이트 |
| 정수 | `byte` | 1 | -128 ~ 127 |
| | `short` | 2 | |
| | `int` | 4 | **기본 정수형** |
| | `long` | 8 | 리터럴에 `L`: `100000000000L` |
| 실수 | `float` | 4 | 리터럴에 `f`: `3.14f` |
| | `double` | 8 | **기본 실수형** |

- C와 차이: 자바는 타입 크기가 **플랫폼 무관 고정** (int는 항상 4byte). C는 시스템마다 다를 수 있음.
- `String`은 기본형이 아니라 **클래스(참조형)**.
  - C와 차이: C는 문자열이 `char[]`(널 종료 배열)이지만, **자바는 문자열을 `String` 객체로** 다룸. 그래서 비교도 `==`(주소)가 아니라 `.equals()`(내용).
- **char 연산**: `char c = 'A'; int n = c + 1;` → 66 (유니코드 값). `(char)(c+1)` → 'B'.

## 형 변환 (캐스팅)
```java
int n = 10;
double d = n;          // 자동 형변환 (작은 → 큰, 손실 없음)
double d2 = 3.99;
int n2 = (int) d2;     // 강제 형변환 (큰 → 작은, 소수점 버림 → 3)
```
- 자동: byte→short→int→long→float→double (작은 그릇 → 큰 그릇)
- 강제: 큰→작은은 명시적 `(타입)` 필요, 데이터 손실 가능.

### 캐스팅 함정 (★ study 실습 출처)
```java
System.out.println((char)0x12340041);   // 'A' — char는 2byte라 하위 16비트(0x0041)만 살아남음
System.out.println((byte)(127 + 100));  // -29 — byte 범위(-128~127) 넘쳐서 오버플로우
System.out.println((int)2.9 + 1.8);     // 3.8 — (int)2.9=2 먼저, 그 다음 2 + 1.8
System.out.println((int)(2.9 + 1.8));   // 4   — 괄호 먼저 4.7, 그 다음 (int)로 버림
System.out.println((int)2.9 + (int)1.8);// 3   — 각각 버림 2 + 1
```
- **캐스트는 바로 옆 값에만** 붙음. `(int)2.9 + 1.8`은 2.9만 변환되고 1.8은 그대로 → 결과는 double.
- 좁은 타입으로 강제 변환 시 **상위 비트가 잘려 나가** 엉뚱한 값이 나올 수 있음 (char·byte 함정).

## 키 입력 — Scanner
```java
import java.util.Scanner;
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();        // 정수
double d = sc.nextDouble();  // 실수
String s = sc.next();        // 공백 전까지 한 단어 next()는 읽기 전에 앞에 있는 공백·탭·개행을 싹 무시하고 넘어가서, 진짜 글자가 나오는 데서부터 읽기 시작해. 그래서 버퍼에 \n이 남아있어도 그냥 건너뛰어버려.
String line = sc.nextLine(); // 한 줄 전체(엔터 전까지) 앞쪽을 안 건너뛰고 그 자리에서 바로 읽어.
boolean b = sc.nextBoolean();
sc.close();
```
- 파이썬 `input()`과 달리 타입별 메소드가 따로 있음.
- **함정**: `nextInt()` 다음 `nextLine()` 쓰면 엔터(\n)가 남아서 빈 줄이 읽힘. 주의.
so 쓸거면 nextLine() 으로 개행문자 날리고 ㄱㄱ 

## 연산자
- C/파이썬과 거의 동일. 주의점:
  - `==`는 **기본형 값 비교**용. **객체(String 등) 비교는 `.equals()`** (★★ 시험 단골)
  - 정수 나눗셈: `5/2 == 2` (C와 같음). 실수 결과 원하면 `5.0/2 == 2.5`
  - `%` 나머지: `7 % 3 == 1`
  - 삼항: `조건 ? a : b` → `int max = (a>b) ? a : b;`
  - 증감 `++`, `--` 있음 (파이썬엔 없음). 전위 `++i` vs 후위 `i++` 구분.
  - 논리: `&&`(and), `||`(or), `!`(not) — 파이썬의 and/or/not과 동일 기능
  - 비트: `&`, `|`, `^`, `~`, `<<`, `>>`

### 증감 함정
```java
int i = 5;
int a = i++;   // a=5 (먼저 대입, 그다음 증가) → i=6
int j = 5;
int b = ++j;   // b=6 (먼저 증가, 그다음 대입) → j=6
```

## 조건문
```java
if (x > 0) { ... }
else if (x == 0) { ... }
else { ... }

switch (n) {       // C와 거의 동일, break 필수!
    case 1:
        System.out.println("일");
        break;      // break 없으면 다음 case로 흘러감(fall-through)
    case 2: case 3: // 묶기 가능
        System.out.println("이나 삼");
        break;
    default:
        System.out.println("기타");
}
```
- switch는 int, char, String 등에 사용 가능 (자바는 String도 switch 됨, C는 안 됨).
- **break 빠뜨림**이 가장 흔한 함정.

---

# 3장. 반복문·배열·예외

## 반복문
```java
for (int i = 0; i < 10; i++) { ... }   // C와 동일
while (조건) { ... }
do { ... } while (조건);               // 최소 1번 실행 (조건을 뒤에서 검사)
```
- 향상된 for (for-each), 파이썬 `for x in list`와 유사:
```java
int[] a = {1,2,3};
for (int x : a) { System.out.println(x); }   // 읽기 전용 순회에 적합
```
- `break` 루프 탈출, `continue` 현재 반복 건너뛰고 다음으로.
- **중첩 루프 + 라벨**:
```java
outer:
for (int i=0; i<5; i++)
    for (int j=0; j<5; j++)
        if (j==2) break outer;   // 바깥 루프까지 한 번에 탈출
```

## 배열 (★ 자바 배열은 "객체")
```java
int[] a = new int[5];        // 길이 5, 자동 0으로 초기화  중요 자동초기화 
int[] b = {1, 2, 3};         // 선언과 동시에 초기화
int[] c;                     // 선언만
c = new int[]{4, 5, 6};      // 나중에 생성
System.out.println(a.length); // 길이 — 필드! 괄호 없음
```
- C와 차이: 배열은 **힙에 생성되는 객체**, `length` 필드로 길이를 앎.
- 자동 초기값: 정수 0, 실수 0.0, boolean false, 참조형 null.
- 범위 벗어나면 `ArrayIndexOutOfBoundsException` (C처럼 조용히 깨지지 않고 예외 발생).

### 2차원 배열
```java
int[][] m = new int[3][4];   // 3행 4열
m[1][2] = 7;
int[][] n = {{1,2},{3,4,5}}; // 비정방형(가변) 가능
System.out.println(n[1].length);  // 3 — 행마다 길이 다를 수 있음
```

### 배열을 리턴하는 메소드 (★ 3장 실습 단골)
```java
static int[] makeArray(int size) {
    int[] r = new int[size];
    for (int i=0; i<size; i++) r[i] = i*i;
    return r;   // 배열(참조)을 리턴
}
// 사용: int[] arr = makeArray(5);
```

### 배열 복사
```java
int[] src = {1,2,3};
int[] dst = new int[3];
System.arraycopy(src, 0, dst, 0, 3);   // 또는 Arrays.copyOf(src, 3)
```
- **주의**: `int[] x = src;` 는 복사가 아니라 같은 배열을 가리키는 것(참조 공유). x를 바꾸면 src도 바뀜.

## 예외 처리
```java
try {
    int r = 10 / 0;          // 위험한 코드
} catch (ArithmeticException e) {
    System.out.println("0으로 나눔: " + e.getMessage());
} catch (Exception e) {      // 위에서 안 잡힌 모든 예외 (맨 아래에)
    System.out.println("기타 예외");
} finally {
    System.out.println("항상 실행 — 자원 정리");
}
```
- 파이썬 `try/except/finally`와 구조 동일 (`except` → `catch`).
- **catch 순서**: 구체적인 예외를 먼저, 일반적인 `Exception`을 나중에. (순서 바뀌면 컴파일 에러)

### 자주 나오는 예외
| 예외 | 발생 상황 |
|------|----------|
| `ArithmeticException` | 정수를 0으로 나눔 |
| `NullPointerException` | null인 참조의 멤버 접근 |
| `ArrayIndexOutOfBoundsException` | 배열 범위 초과 |
| `NumberFormatException` | `Integer.parseInt("abc")` |
| `ClassCastException` | 잘못된 다운캐스팅 |
| `InputMismatchException` | Scanner에 잘못된 타입 입력 |

- **checked vs unchecked**: 파일 입출력 등 일부 예외(checked)는 반드시 try-catch 하거나 `throws`로 떠넘겨야 컴파일됨. 위의 RuntimeException들(unchecked)은 강제 아님.

---

# 4장. 클래스와 객체 (★★ OOP 핵심)

## 클래스 기본 구조
```java
public class Circle {
    int radius;                 // 필드(멤버 변수)
    String name;

    public Circle(int r) {      // 생성자: 클래스명과 동일, 리턴타입 없음
        this.radius = r;        // this = 자기 객체 자신 (파이썬 self)
    }

    public double getArea() {   // 메소드
        return 3.14 * radius * radius;
    }
}
```
객체 생성:
```java
Circle c = new Circle(5);   // new로 힙에 생성, 참조를 c에 저장
double area = c.getArea();
```
- 파이썬 `__init__` ↔ 자바 생성자. 파이썬 `self` ↔ 자바 `this`.
- **참조 변수**: `c`는 객체 자체가 아니라 객체의 주소(참조)를 담음. C의 포인터와 비슷하나 직접 조작 불가.

### 참조 함정 (★)
```java
Circle a = new Circle(5);
Circle b = a;          // 같은 객체를 가리킴 (복사 아님!)
b.radius = 10;
System.out.println(a.radius);  // 10 (a도 바뀜 — 같은 객체니까)
```

## 생성자
- 클래스명과 같은 이름, **리턴타입 없음**.
- **오버로딩 가능**: 매개변수가 다른 생성자 여러 개.
```java
class Circle {
    int radius;
    Circle() { radius = 1; }              // 기본
    Circle(int r) { radius = r; }         // 오버로딩
    Circle(Circle c) { radius = c.radius; } // 복사 생성자
}
```
- 생성자를 **하나도 안 만들면** 기본 생성자(매개변수 없는 것)가 자동 제공. 단, **하나라도 만들면 자동 제공 안 됨** (★ 함정).
- `this()`로 같은 클래스의 다른 생성자 호출 (첫 줄에서만):
```java
Circle(int r) { this.radius = r; }
Circle() { this(1); }   // 위 생성자 호출 그럼 반지름이 1인 게 생성이됨 
```

## static (★★ 시험 단골)
| 구분 | 인스턴스 멤버 | static 멤버 |
|------|--------------|-------------|
| 소속 | 객체마다 따로 | 클래스에 1개 (모든 객체 공유) |
| 접근 | `객체.멤버` | `클래스명.멤버` (객체 없이도) |
| 생성 시점 | 객체 생성 시 | 클래스 로딩 시 (프로그램 시작) |
| this 사용 | 가능 | **불가** |

```java
class Counter {
    static int count = 0;   // 모든 객체가 공유하는 카운터
    int id;
    Counter() { count++; id = count; }
    static int getCount() { return count; }  // static 메소드
}
// Counter.getCount() — 객체 없이 클래스로 직접 호출
```
- static 메소드 안에서는 `this` 사용 불가, **인스턴스 멤버 직접 접근 불가** (객체가 없을 수도 있으니까).
- `main`이 static인 이유: 객체 생성 전에 JVM이 실행해야 하니까.
- 상수: `static final double PI = 3.14;` (한 번 정하면 못 바꿈, 공유)

## 접근 지정자 (캡슐화)
| 지정자 | 같은 클래스 | 같은 패키지 | 자식 클래스 | 전체 |
|--------|:--:|:--:|:--:|:--:|
| `private` | O | X | X | X |
| (default, 안 씀) | O | O | X | X |
| `protected` | O | O | O | X |
| `public` | O | O | O | O |

- **캡슐화**: 필드는 `private`, 접근은 `public` getter/setter로 (정보 은닉).
```java
class Person {
    private int age;
    public int getAge() { return age; }
    public void setAge(int a) {
        if (a >= 0) age = a;   // 검증 로직 넣을 수 있음 — 캡슐화의 장점
    }
}
```

## 객체 소멸 / 가비지 컬렉션
- C의 `free()`, C++의 `delete` **없음**. **참조가 끊긴 객체를 GC가 자동 회수**.
- `obj = null;` 하면 참조가 끊겨 GC 대상이 됨.
- 언제 수거할지는 JVM이 결정 (개발자가 시점 제어 불가).

---

# 5장. 상속 (★★ OOP 핵심)

## 기본
```java
class Animal {
    String name;
    void breathe() { System.out.println("숨쉬기"); }
}
class Dog extends Animal {   // Animal을 상속
    void bark() { System.out.println("멍멍"); }
}
// Dog는 name, breathe(), bark() 모두 가짐
```
- 자바는 **단일 상속만** 가능 (C++ 다중상속 X). 대신 인터페이스로 보완.
- `extends`는 하나만.
- 부모 = 슈퍼클래스 = 상위 클래스, 자식 = 서브클래스 = 하위 클래스.

## super
- `super.메소드()`: 부모 메소드 호출.
- `super(...)`: 부모 생성자 호출 (자식 생성자 **첫 줄**에 와야 함).
- **생성자 호출 순서**: 자식 객체 생성 시 부모 생성자가 **먼저** 실행됨.
```java
class Animal {
    Animal() { System.out.println("Animal 생성자"); }
}
class Dog extends Animal {
    Dog() {
        super();   // 생략하면 컴파일러가 자동 삽입 (부모 기본생성자)
        System.out.println("Dog 생성자");
    }
}
// new Dog() 출력: "Animal 생성자" → "Dog 생성자"
```
- **함정**: 부모에 기본 생성자가 없고 매개변수 생성자만 있으면, 자식에서 `super(인자)`를 **명시적으로** 호출해야 함.

### 다단계 상속 생성자 순서 (★ study 실습 출처)
```java
class A { A() { System.out.println("A 생성자"); } }
class B extends A { B() { System.out.println("B 생성자"); } }
class C extends B { C() { System.out.println("C 생성자"); } }

new C();
// 출력: A 생성자 → B 생성자 → C 생성자
//   "제일 위 조상부터" 실행되고 자기 자신이 마지막.
```
- 각 자식 생성자 첫 줄에 `super()`가 자동 삽입되므로, 호출은 위로 타고 올라갔다가 **실행은 최상위 조상부터** 내려옴.

## 오버라이딩 (overriding)
- 부모 메소드를 자식이 **같은 시그니처로 재정의**.
```java
class Animal {
    void breathe() { System.out.println("숨쉬기"); }
}
class Cat extends Animal {
    @Override                      // 어노테이션 (오타 방지용, 권장)
    void breathe() { System.out.println("고양이 숨쉬기"); }
}
```
- `@Override`는 "이건 부모 메소드를 재정의한 것"이란 표시. **없어도 동작은 하지만**, 붙여두면 부모에 같은 시그니처 메소드가 없을 때 **컴파일러가 오류를 내줘서** 오타(예: `breath()`)를 잡아줌.
- **오버라이딩 vs 오버로딩** (★ 시험 단골 비교):

| | 오버라이딩(Overriding) | 오버로딩(Overloading) |
|---|---|---|
| 관계 | 부모-자식 간 | 같은 클래스 내 |
| 메소드명 | 같음 | 같음 |
| 매개변수 | **같음** | **다름** |
| 효과 | 부모 기능 덮어쓰기 | 같은 이름 여러 버전 |

## 다형성 & 업/다운캐스팅 (★★)
```java
Animal a = new Dog();   // 업캐스팅 (자식 → 부모 타입, 자동/암시적)
a.breathe();            // OK (Animal에 있는 것)
// a.bark();            // 컴파일 에러 (Animal 타입엔 bark 없음)

Dog d = (Dog) a;        // 다운캐스팅 (부모 → 자식, 명시적 캐스트 필요)
d.bark();               // OK
```
- **업캐스팅**: 여러 자식을 부모 타입 하나로 묶어 다룰 때. 예:
```java
Animal[] zoo = { new Dog(), new Cat() };  // 서로 다른 자식을 한 배열에
for (Animal x : zoo) x.breathe();          // 각자 자기 방식대로 (동적 바인딩)
```
- **다운캐스팅**: 원래 자식 기능을 다시 쓰려 되돌릴 때. 잘못하면 `ClassCastException`.
- `instanceof`로 안전 확인:
```java
for (Animal x : zoo) {
    if (x instanceof Dog) ((Dog)x).bark(); //instanceof는 "실제 객체(내용물)"를 봄 → Dog인 거 알아챔
}
```

## 동적 바인딩 (★★ 다형성의 핵심)
```java
Animal a = new Cat();
a.breathe();   // 실행되는 건 Cat의 breathe() — 컴파일 타입(Animal)이 아니라 실제 객체(Cat) 기준
```
- 컴파일 시 타입이 아니라 **실행 시 실제 객체**를 기준으로 메소드가 결정됨.
- 이게 다형성을 가능하게 함: "같은 호출, 객체마다 다른 동작".

## 추상 클래스 (abstract)
```java
abstract class Shape {
    abstract double area();      // 추상 메소드: 몸체 없음 → 자식이 반드시 구현
    void info() {                // 일반 메소드도 가질 수 있음
        System.out.println("넓이: " + area());
    }
}
class Circle extends Shape {
    int r;
    Circle(int r) { this.r = r; }
    double area() { return 3.14 * r * r; }   // 반드시 구현
}
```
- 추상 메소드를 1개라도 가지면 추상 클래스 → **객체 생성 불가** (`new Shape()` 에러).
- 상속해서 추상 메소드를 모두 구현해야 객체 생성 가능.
- "공통 코드는 물려주되 일부는 자식이 채우게" 강제하는 용도.

## 인터페이스 (interface)
```java
interface Drawable {
    void draw();             // 자동으로 public abstract
    int SIZE = 10;           // 자동으로 public static final (상수)
}
class Circle implements Drawable {
    public void draw() { System.out.println("원 그리기"); }  // 반드시 구현 + public
}
```
- **다중 구현 가능**: `class A implements X, Y, Z` (단일 상속의 한계 보완)
- `extends`(상속)와 함께: `class A extends B implements X, Y`
- 인터페이스끼리는 상속 가능: `interface Y extends X`

### 추상 클래스 vs 인터페이스 (★ 비교)
| | 추상 클래스 | 인터페이스 |
|---|---|---|
| 관계 | "is-a" (강한 종속) | "can-do" (기능 규약) |
| 메소드 | 일반+추상 혼합 | (전통적으로) 전부 추상 |
| 필드 | 일반 필드 가능 | 상수만 (public static final) |
| 상속/구현 | 단일 상속 | 다중 구현 |
| 키워드 | extends | implements |

- 파이썬엔 명시적 인터페이스가 없음(덕 타이핑) → 자바는 명시적 규약을 컴파일러가 강제.

---

# 6장. 패키지와 기본 API

## 패키지 / import
- 패키지 = 클래스들의 묶음(폴더 개념, 파이썬 모듈/패키지와 유사). 이름 충돌 방지 + 분류.
```java
package mypackage;            // 파일 맨 위 (이 클래스가 속한 패키지)
import java.util.Scanner;     // 특정 클래스 가져오기
import java.util.*;           // 패키지 전체 (와일드카드)
```
- `java.lang` 패키지(String, System, Math, Object, Integer 등)는 **import 없이 자동** 사용.
- 주요 패키지: `java.util`(컬렉션, Scanner), `java.io`(입출력), `javax.swing`(GUI), `java.awt`(그래픽/이벤트).

## Object 클래스 (모든 클래스의 최상위 부모)
- 모든 클래스는 자동으로 Object를 상속.
- 자주 오버라이딩하는 메소드:
  - `toString()`: 객체를 문자열로. `System.out.println(객체)` 시 자동 호출.
  - `equals(Object o)`: 내용 같은지 비교 (기본은 주소 비교 → 보통 재정의).
  - `hashCode()`: 해시값 (HashMap/HashSet에서 사용).
```java
class Point {
    int x, y;
    Point(int x, int y) { this.x=x; this.y=y; }
    @Override
    public String toString() { return "(" + x + "," + y + ")"; }
    @Override
    public boolean equals(Object o) {
        Point p = (Point) o;
        return this.x == p.x && this.y == p.y;
    }
}
```

## String (★ ==와 equals)
```java
String s1 = "hi";
String s2 = "hi";
s1 == s2;          // 주소 비교 (리터럴 풀 때문에 true일 수 있으나 신뢰 X)
String s3 = new String("hi");
s1 == s3;          // false (new는 새 객체)
s1.equals(s3);     // ★ true — 내용 비교, 이걸 써야 함
```
- String은 **불변(immutable)**. `s = s + "!"` 처럼 바꾸는 것 같아도 새 객체가 생기는 것.

### 자주 쓰는 String 메소드
| 메소드 | 기능 | 예 |
|--------|------|-----|
| `length()` | 길이 (메소드, 괄호!) | `"abc".length()` → 3 |
| `charAt(i)` | i번째 문자 | `"abc".charAt(0)` → 'a' |
| `substring(a,b)` | 부분 문자열 [a,b) | `"abcd".substring(1,3)` → "bc" |
| `indexOf(s)` | 위치 (없으면 -1) | `"abc".indexOf("b")` → 1 |
| `equals(s)` | 내용 비교 | |
| `equalsIgnoreCase(s)` | 대소문자 무시 비교 | |
| `compareTo(s)` | 사전순 비교 | |
| `toUpperCase()` / `toLowerCase()` | 대/소문자 | |
| `trim()` | 앞뒤 공백 제거 | |
| `replace(a,b)` | 치환 | |
| `split(d)` | 구분자로 분리 → 배열 | `"a,b,c".split(",")` |
| `contains(s)` | 포함 여부 | |

- 문자열 많이 합칠 땐 **StringBuffer / StringBuilder** (가변, 성능↑):
```java
StringBuilder sb = new StringBuilder();
sb.append("a"); sb.append("b");
String result = sb.toString();   // "ab"
```
- `StringBuffer`는 동기화(스레드 안전), `StringBuilder`는 비동기(더 빠름).

## Wrapper 클래스
- 기본형을 객체로 감싼 것: `int`→`Integer`, `double`→`Double`, `char`→`Character`, `boolean`→`Boolean`...
- 컬렉션(ArrayList 등)엔 기본형을 못 넣어서 Wrapper 필요 (`ArrayList<Integer>`).
- **오토박싱/언박싱**: 자동 변환.
```java
Integer obj = 10;        // 오토박싱 (int → Integer)
int n = obj;             // 언박싱 (Integer → int)
```
- **문자열 ↔ 숫자 변환** (자주 씀):
```java
int x = Integer.parseInt("123");      // 문자열 → int
double d = Double.parseDouble("3.14"); // 문자열 → double
String s = Integer.toString(456);      // int → 문자열 (또는 "" + 456)
String s2 = String.valueOf(789);
```

## Math 클래스 (전부 static)
```java
Math.abs(-5);       // 5
Math.sqrt(16);      // 4.0
Math.pow(2, 10);    // 1024.0
Math.max(3, 7);     // 7
Math.min(3, 7);     // 3
Math.round(3.6);    // 4
Math.ceil(3.1);     // 4.0 (올림)
Math.floor(3.9);    // 3.0 (내림)
Math.random();      // 0.0 이상 1.0 미만 난수
// 1~6 주사위: (int)(Math.random()*6) + 1
Math.PI;            // 원주율 상수
```

---

# 7장. 제네릭과 컬렉션

## 제네릭 (Generics)
- "타입을 매개변수로" — 타입 안정성 + 캐스팅 제거.
```java
ArrayList<String> list = new ArrayList<>();  // String만 담음 (다이아몬드 <>)
list.add("a");
String s = list.get(0);   // 캐스팅 불필요 (제네릭 없으면 (String) 필요했음)
// list.add(10);          // 컴파일 에러 — 잘못된 타입을 미리 차단
```
- C++ 템플릿과 유사. `<T>`, `<E>`, `<K,V>`는 타입 자리표시자.
- **제네릭 클래스 직접 정의**:
```java
class Box<T> {
    private T item;
    void set(T item) { this.item = item; }
    T get() { return item; }
}
Box<String> b = new Box<>();
b.set("hello");
```

## 주요 컬렉션
| 컬렉션 | 특징 | 파이썬 대응 |
|--------|------|------------|
| `ArrayList<E>` | 순서O, 중복O, 인덱스 접근 빠름 | list |
| `LinkedList<E>` | 연결리스트, 중간 삽입/삭제 빠름 | (deque) |
| `Vector<E>` | ArrayList의 동기화 버전(구식) | - |
| `HashMap<K,V>` | 키-값, 순서X, 검색 빠름 | dict |
| `LinkedHashMap` | 키-값 + 입력 순서 유지 | (OrderedDict) |
| `TreeMap<K,V>` | 키-값 + 키 자동 정렬 | - |
| `HashSet<E>` | 중복X, 순서X | set |
| `TreeSet<E>` | 중복X + 자동 정렬 | - |

> 핵심 분류: **List**(순서O 중복O) / **Set**(중복X) / **Map**(키-값).

## ArrayList 핵심
```java
ArrayList<Integer> a = new ArrayList<>();
a.add(10);            // 끝에 추가
a.add(0, 5);          // 인덱스 0에 삽입
a.get(0);             // 조회 → 5
a.set(0, 99);         // 변경
a.remove(0);          // 인덱스 0 삭제
a.remove(Integer.valueOf(99));  // 값 99 삭제 (int면 인덱스로 해석되니 주의!)
a.size();             // 크기 — 메소드! (배열 length는 필드)
a.contains(10);       // 포함 여부
a.isEmpty();          // 비었나
a.clear();            // 전체 삭제
```
- **함정**: `remove(int)`는 인덱스 삭제, `remove(Object)`는 값 삭제. `ArrayList<Integer>`에서 값 삭제하려면 `Integer.valueOf()` 감싸기.

## HashMap 핵심
```java
HashMap<String, Integer> m = new HashMap<>();
m.put("kim", 90);       // 추가/수정 (같은 키면 덮어씀)
m.get("kim");           // 90
m.get("none");          // null (없는 키)
m.getOrDefault("none", 0);  // 0 (기본값)
m.containsKey("kim");   // true
m.containsValue(90);    // true
m.remove("kim");
m.size();
m.keySet();             // 모든 키 (Set)
m.values();             // 모든 값
```

## 순회 (Iterator / for-each)
```java
// Map 순회
for (String key : m.keySet()) {
    System.out.println(key + " = " + m.get(key));
}
// entrySet 사용 (키+값 한번에 — 더 효율적)
for (Map.Entry<String,Integer> e : m.entrySet()) {
    System.out.println(e.getKey() + " = " + e.getValue());
}

// List 순회 - Iterator
Iterator<Integer> it = a.iterator();
while (it.hasNext()) {
    System.out.println(it.next());
}
```
- **Iterator로 삭제**: 순회 중 `list.remove()`는 에러(ConcurrentModification). `it.remove()` 써야 함.

## 배열 vs ArrayList
| | 배열 | ArrayList |
|---|---|---|
| 크기 | 고정 | 가변(자동 확장) |
| 길이 | `length` (필드) | `size()` (메소드) |
| 접근 | `a[i]` | `a.get(i)` |
| 타입 | 기본형 OK | Wrapper만 (`Integer`) |

---
--------------------------------------------------------------------------------------------------------------------------------------------------------
# 8장. 스윙(Swing) 기초 — *오픈북: 구조 위주*

## 기본 틀
```java
import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        setTitle("제목");
        setSize(400, 300);
        setLayout(new FlowLayout());     // 배치관리자 지정
        add(new JButton("버튼1"));        // 컴포넌트 추가
        add(new JButton("버튼2"));
        setDefaultCloseOperation(EXIT_ON_CLOSE);  // X 누르면 종료
        setVisible(true);                // ★ 꼭 호출해야 화면에 보임
    }
    public static void main(String[] a) { new MyFrame(); }
}
```

## 핵심 구조
- **JFrame** = 최상위 윈도우. 그 안에 **컨테이너(JPanel)** + **컴포넌트(버튼 등)**.
- 계층: JFrame → (ContentPane) → JPanel → JButton/JLabel...
- `JFrame`의 내용은 사실 **ContentPane**에 추가됨 (`add()`가 자동 처리).

## 배치관리자 (Layout Manager) ★
| 배치관리자 | 방식 | 사용 |
|-----------|------|------|
| `FlowLayout` | 왼→오 순서대로, 줄 넘침 | `new FlowLayout()` |
| `BorderLayout` | 동/서/남/북/중앙 5구역 | `add(c, BorderLayout.NORTH)` |
| `GridLayout` | 격자(행×열) | `new GridLayout(2,3)` |
| (null) | 절대 위치 지정 | `setBounds(x,y,w,h)` |

- JFrame 기본 배치관리자 = **BorderLayout**, JPanel 기본 = **FlowLayout**.
- BorderLayout에서 영역 지정 안 하면 CENTER로 들어가고, 같은 영역에 여러 개 넣으면 마지막 것만 보임.

```java
setLayout(new BorderLayout());
add(new JButton("위"), BorderLayout.NORTH);
add(new JButton("아래"), BorderLayout.SOUTH);
add(new JButton("가운데"), BorderLayout.CENTER);
```

---

# 9장. 이벤트 처리 — *오픈북: 패턴 위주*

## 이벤트 모델 (위임 모델)
- 사용자 동작(클릭 등) → **이벤트 객체** 발생 → 등록된 **리스너**의 메소드 자동 호출.
- 3요소: **이벤트 소스**(버튼) + **이벤트 객체**(ActionEvent) + **이벤트 리스너**(ActionListener).

## 리스너 등록 (가장 흔한 패턴 — 익명 클래스)
```java
JButton b = new JButton("클릭");
b.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("눌림!");
    }
});
```

## 리스너 구현 방식 3가지
```java
// 1) 익명 클래스 (위 예시) — 가장 흔함
// 2) 클래스가 직접 implements
class MyFrame extends JFrame implements ActionListener {
    public void actionPerformed(ActionEvent e) { ... }
    // b.addActionListener(this);
}
// 3) 별도 리스너 클래스
class MyListener implements ActionListener { ... }
// b.addActionListener(new MyListener());
```

## 주요 리스너
| 동작 | 리스너 인터페이스 | 대표 메소드 |
|------|-----------------|------------|
| 버튼 클릭 | `ActionListener` | `actionPerformed` |
| 마우스 클릭 | `MouseListener` | `mouseClicked/Pressed/Released/Entered/Exited` |
| 마우스 이동 | `MouseMotionListener` | `mouseMoved`, `mouseDragged` |
| 키 입력 | `KeyListener` | `keyPressed/Released/Typed` |
| 창 | `WindowListener` | `windowClosing` 등 |

## 어댑터 클래스 (★)
- `MouseListener`는 메소드 5개를 **다** 구현해야 함 → 귀찮음.
- **MouseAdapter**(추상 클래스)를 상속하면 **필요한 메소드만** 오버라이딩.
```java
addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();   // 클릭 좌표
        int y = e.getY();
    }
});
```
- KeyAdapter, WindowAdapter도 같은 원리.

## 이벤트 객체에서 정보 꺼내기
- `e.getSource()`: 이벤트 발생 컴포넌트
- 마우스: `e.getX()`, `e.getY()`, `e.getButton()`
- 키: `e.getKeyCode()`, `e.getKeyChar()`

---

# 10장. 스윙 컴포넌트 — *오픈북: 찾아쓰기*

| 컴포넌트 | 용도 | 핵심 메소드 |
|----------|------|------------|
| `JLabel` | 텍스트/이미지 표시 | `setText()`, `getText()` |
| `JButton` | 버튼 | `addActionListener()`, `setText()` |
| `JTextField` | 한 줄 입력 | `getText()`, `setText()` |
| `JPasswordField` | 비밀번호 입력 | `getPassword()` |
| `JTextArea` | 여러 줄 입력 | `append()`, `getText()` |
| `JCheckBox` | 체크박스 | `isSelected()` |
| `JRadioButton` | 라디오 (ButtonGroup으로 묶음) | `isSelected()` |
| `JComboBox` | 드롭다운 | `getSelectedItem()`, `addItem()` |
| `JList` | 목록 | `getSelectedValue()` |
| `JSlider` | 슬라이더 | `getValue()` |

## 자주 쓰는 패턴
```java
JTextField tf = new JTextField(10);   // 10칸 너비
String input = tf.getText();          // 입력값 읽기

JCheckBox cb = new JCheckBox("동의");
if (cb.isSelected()) { ... }

// 라디오버튼은 그룹으로 묶어야 하나만 선택됨
JRadioButton r1 = new JRadioButton("남");
JRadioButton r2 = new JRadioButton("여");
ButtonGroup g = new ButtonGroup();
g.add(r1); g.add(r2);
```
- 값 읽기 = `getText()` / `isSelected()` / `getSelectedItem()` / `getValue()` 패턴만 알면 됨.

---

# 11장. 그래픽 — *오픈북: 패턴 위주*

## paintComponent (★)
```java
class MyPanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);     // ★ 꼭 호출 (이전 그림/배경 정리)
        g.setColor(Color.RED);
        g.drawLine(0, 0, 100, 100);            // 선
        g.drawRect(10, 10, 50, 30);            // 사각형 외곽선
        g.fillRect(10, 10, 50, 30);            // 채운 사각형
        g.drawOval(20, 20, 40, 40);            // 타원 외곽선
        g.fillOval(20, 20, 40, 40);            // 채운 타원
        g.drawString("글자", 50, 50);           // 문자열
    }
}
```
- **Graphics 객체 g**가 붓 역할. 직접 만들지 않고 시스템이 넘겨줌 (paintComponent의 매개변수).
- `draw...` = 외곽선만, `fill...` = 색으로 채움.
- 좌표계: 왼쪽 위가 (0,0), 오른쪽/아래로 갈수록 증가.

## 색상
```java
g.setColor(Color.BLUE);              // 미리 정의된 색
g.setColor(new Color(255, 128, 0));  // RGB 직접
```

## repaint() (★)
- 화면을 다시 그리고 싶을 때 **`paintComponent`를 직접 부르지 않고** `repaint()` 호출 → 시스템이 알아서 paintComponent를 호출.
```java
// 마우스 클릭한 곳에 점 추가하는 패턴
addMouseListener(new MouseAdapter() {
    public void mousePressed(MouseEvent e) {
        x = e.getX(); y = e.getY();   // 좌표 저장
        repaint();                     // 다시 그리기 요청
    }
});
```
- 흐름: 데이터(좌표/색) 변경 → `repaint()` → paintComponent 재호출 → 새 그림.

---

# 12장. 스레드(Thread) — *오픈북: 개념 + 패턴*

## 스레드란
- 한 프로그램 안에서 **동시에 실행되는 흐름**. 여러 작업을 병행 (애니메이션 + 입력 등).
- 파이썬의 threading과 개념 유사.

## 두 가지 생성 방법
```java
// 방법 1: Thread 상속
class MyThread extends Thread {
    public void run() {              // 실행할 코드를 run()에
        for (int i=0; i<5; i++) System.out.println(i);
    }
}
new MyThread().start();              // ★ start()로 시작

// 방법 2: Runnable 구현 (★ 권장 — 단일상속 제약 회피)
class MyTask implements Runnable {
    public void run() { ... }
}
new Thread(new MyTask()).start();
```
- **`start()` vs `run()`** (★ 시험 단골): `start()`가 새 스레드를 만들어 그 안에서 run() 실행. `run()`을 직접 부르면 그냥 **일반 메소드 호출**(새 스레드 안 생김, 현재 스레드에서 실행).
- 방법 2를 권장하는 이유: 자바는 단일 상속이라 Thread를 상속하면 다른 클래스를 못 상속함. Runnable은 인터페이스라 자유.

## 주요 메소드
| 메소드 | 기능 |
|--------|------|
| `start()` | 스레드 시작 (run 실행) |
| `sleep(ms)` | 지정 시간 멈춤 (static, InterruptedException 처리 필요) |
| `interrupt()` | 종료 **신호** 보냄 (강제종료 아님) |
| `isInterrupted()` | 인터럽트 받았는지 확인 |
| `join()` | 해당 스레드 끝날 때까지 대기 |

```java
try {
    Thread.sleep(1000);   // 1초 멈춤
} catch (InterruptedException e) { }
```

## interrupt() — 종료 패턴
- 자바엔 안전한 강제종료가 없음. `interrupt()`로 신호를 보내면 스레드가 그걸 감지해서 스스로 정리하고 종료.
```java
public void run() {
    while (!isInterrupted()) {   // 인터럽트 신호 오면 루프 탈출
        // 작업...
    }
}
// 외부에서: t.interrupt();
```

## 동기화 synchronized (★)
- 여러 스레드가 **공유 자원**에 동시 접근하면 값이 깨질 수 있음 (race condition).
- `synchronized`로 한 번에 한 스레드만 접근하도록 잠금.
```java
class Bank {
    private int balance = 0;
    synchronized void deposit(int n) {   // 한 번에 한 스레드만 실행
        balance += n;
    }
}
```
- 블록 단위도 가능: `synchronized(객체) { ... }`

## wait() / notify() — 스레드 협력
- `wait()`: 현재 스레드를 멈추고 대기 (락 반납).
- `notify()`: 대기 중인 스레드 하나를 깨움. `notifyAll()`은 전부.
- **반드시 synchronized 블록 안에서** 사용.
```java
synchronized void consume() throws InterruptedException {
    while (비었음) wait();       // 생산될 때까지 대기
    // 소비 작업
    notify();                    // 생산자 깨움
}
```
- 생산자-소비자 패턴의 기본.

---

# 13장. 파일 입출력 — *오픈북: 클래스 찾아쓰기*

## 스트림 개념
- **스트림 = 데이터가 한 방향으로 흐르는 통로**. 입력용/출력용 따로.
- 두 종류:
  - **문자 스트림** (Reader/Writer): 텍스트 파일용 (2byte 문자 단위, 인코딩 처리).
  - **바이트 스트림** (InputStream/OutputStream): 이미지·동영상 등 모든 파일 (1byte 단위).
- **스트림은 반드시 close()** (★): OS 자원이라 안 닫으면 자원 누수 + 버퍼 내용이 파일에 안 써질 수 있음. try-with-resources로 자동 닫기 권장.

## 클래스 정리표
| 용도 | 클래스 | 비고 |
|------|--------|------|
| 텍스트 쓰기 | `FileWriter` | |
| 텍스트 읽기 | `FileReader` | |
| 텍스트 줄단위 읽기 | `BufferedReader` | `readLine()` |
| 텍스트 줄단위 쓰기 | `BufferedWriter` / `PrintWriter` | |
| 바이너리 쓰기 | `FileOutputStream` | |
| 바이너리 읽기 | `FileInputStream` | |
| 파일 속성 | `File` | 내용 아님 |

기본
import java.io.FileReader;
import java.io.IOException;

아니면
import java.io.*;

## 텍스트 파일 (문자 스트림)
```java
// 쓰기
FileWriter fw = new FileWriter("out.txt");
fw.write("안녕\n");
fw.write("두번째 줄");
fw.close();

// 읽기 (한 줄씩 — BufferedReader가 표준)
BufferedReader br = new BufferedReader(new FileReader("out.txt"));
String line;
while ((line = br.readLine()) != null) {   // null이면 파일 끝
    System.out.println(line);
}
br.close();
```
- `FileWriter("out.txt", true)` 두 번째 인자 true면 **이어쓰기(append)**.

### 키보드 입력 → 파일 쓰기 (InputStreamReader)
```java
InputStreamReader in = new InputStreamReader(System.in);  // 바이트 → 문자 변환기
FileWriter fout = new FileWriter("out.txt");
int c;
while ((c = in.read()) != -1) {   // 키보드에서 한 글자씩
    fout.write(c);                // 파일에 한 글자씩
}
in.close();
fout.close();
```
- `System.in`은 **바이트 단위**로만 읽음. `InputStreamReader`가 이걸 **문자 단위**로 바꿔주는 변환 다리 역할.

## 바이너리 파일 (바이트 스트림)
```java
FileInputStream  in  = new FileInputStream("a.jpg");
FileOutputStream out = new FileOutputStream("b.jpg");
int b;
while ((b = in.read()) != -1) {   // -1이면 파일 끝
    out.write(b);
}
in.close();
out.close();
```
- 위 패턴이 곧 **파일 복사** (13장 실습 단골).
- **왜 `int b`로 받나?** 파일 끝(EOF)을 `-1`로 표현해야 하는데, byte/char로 받으면 -1과 실제 데이터를 구분 못 함. 그래서 한 단계 큰 `int`로 받음. **C에서 `fgetc()`가 int를 반환하는 것과 완전히 같은 이유**. 출력할 땐 `(char)b`로 변환.
- 버퍼로 빠르게: `byte[] buf = new byte[1024]; int len; while((len=in.read(buf))!=-1) out.write(buf,0,len);`

## try-with-resources (자동 close — 권장)
```java
try (FileReader fr = new FileReader("a.txt");
     BufferedReader br = new BufferedReader(fr)) {
    String line;
    while ((line = br.readLine()) != null) System.out.println(line);
}   // 블록 끝나면 자동 close (예외 나도 닫힘)
catch (IOException e) { e.printStackTrace(); }
```
- 파일 입출력은 **checked 예외(IOException)** 라서 try-catch 또는 throws 필수.

## File 클래스 (파일 "속성" 다루기, 내용 X)
```java
File f = new File("a.txt");
f.exists();         // 존재 여부
f.length();         // 크기(byte)
f.isFile();         // 파일인가
f.isDirectory();    // 폴더인가
f.getName();        // 이름
f.getPath();        // 경로
f.delete();         // 삭제
f.mkdir();          // 폴더 생성
f.list();           // 폴더 내 파일명 배열
f.listFiles();      // 폴더 내 File 객체 배열
```

---

# 시험 직전 체크리스트 (★ 오답·헷갈림 포인트)

1. **`==` vs `.equals()`** — 객체(String) 내용 비교는 무조건 `.equals()`. `==`는 주소 비교.
2. **`length` vs `length()` vs `size()`** — 배열은 `length`(필드), 문자열은 `length()`(메소드), 컬렉션은 `size()`(메소드).
3. **오버로딩 vs 오버라이딩** — 같은 클래스 내 매개변수 다름(로딩) vs 부모-자식 재정의 매개변수 같음(라이딩).
4. **업캐스팅(자동)** vs **다운캐스팅(명시적 캐스트 + instanceof로 안전확인)**.
5. **동적 바인딩** — 오버라이딩된 메소드는 "실제 객체" 기준으로 실행 (컴파일 타입 아님).
6. **static** — 객체 없이 클래스명으로 접근. static 안에선 this·인스턴스 멤버 직접 사용 불가.
7. **생성자** — 하나라도 직접 만들면 기본 생성자 자동 제공 안 됨. `super()`는 자식 생성자 첫 줄.
8. **추상클래스(단일상속, 코드 일부 포함, extends)** vs **인터페이스(다중구현, 규약, implements)**.
9. **접근지정자 범위**: private < default < protected < public.
10. **스레드 `start()`** 로 시작 (run() 직접 호출하면 새 스레드 안 생김).
11. **스트림 `close()`** 잊지 말기 (try-with-resources 권장). 파일 입출력은 IOException 처리 필수.
12. **switch의 break** — 빠뜨리면 다음 case로 흘러감(fall-through).
13. **정수 나눗셈** `5/2 == 2`. 실수 결과는 `5.0/2`.
14. **String은 불변** — 바꾸는 것처럼 보여도 새 객체.
15. **ArrayList엔 기본형 못 넣음** — Wrapper(`Integer`) 사용. `remove(int)`는 인덱스, `remove(Object)`는 값.

---

## 부록: C/파이썬 → 자바 빠른 대응표
| 개념 | C | Python | Java |
|------|---|--------|------|
| 출력 | printf | print | System.out.println |
| 입력 | scanf | input() | Scanner |
| 문자열 비교 | strcmp | == | .equals() |
| 리스트 | 배열 | list | ArrayList |
| 딕셔너리 | - | dict | HashMap |
| 메모리 해제 | free() | (GC) | (GC, 자동) |
| 클래스 self | - | self | this |
| 생성자 | - | __init__ | 클래스명() |
| null | NULL | None | null |
| 주석 | /* */ | # | // 또는 /* */ |

---

*끝. 오픈북이니 세부 API는 이 문서에서 위치만 찾아 펼쳐 쓰면 됨. 4·5·7장은 개념까지 확실히 다지고 가자.*
