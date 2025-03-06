## 💡 part1-4 자바 기본 문법 2 (class, constructor)

### 🔹 class 기본문법

```java
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
		Friend friend = new Friend("nam",12);
		System.out.println(friend.name + ' ' +  friend.age);
	}

}

class  Friend {
    // field, attribute
	String name ="kim";
	int age = 20;

    // constructor
	Friend(String name, int age){
		this.name = name;
		this.age = age;
	}

    // method
	void hello() {
		System.out.println("ㅎㅇ");
	}
}
```
