interface functional {
    int operation(int a, int b);
}
class testing{
    public static void main(String[] args) {
        functional add = (int a, int b) -> a + b;
        functional multi = (int a, int b) -> a * b;

        System.out.println(add.operation(5,6));
        System.out.println(multi.operation(6,7));
    }
}
