public class ClassEx1 {
    public static void main(String[] args) {
        Card c = new Card("HEART", 3);
        Card c2 = new Card();

        Class cObj = c.getClass();

        System.out.println(c);
        System.out.println(c2);
        System.out.println(cObj.getName());
        System.out.println(cObj.toGenericString());
        System.out.println(cObj.toString());
    }
}
