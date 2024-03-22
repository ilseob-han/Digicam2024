public class MyClass {
    private int value;

    // 생성자
    public MyClass(int value) {
        this.value = value;
    }

    // 인스턴스 메소드
    public MyClass getInstance() {
        // 현재 객체를 반환
        return this;
    }
}