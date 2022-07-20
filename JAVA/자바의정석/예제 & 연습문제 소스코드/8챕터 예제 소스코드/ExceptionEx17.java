public class ExceptionEx17 {
    public static void main(String[] args) {
        try {
            startInstall();
            copyFiles();
            // deleteTempFiles();
        } catch (Exception e) {
            e.printStackTrace();
            // deleteTempFiles();
        } finally {
            deleteTempFiles();
        }
    }

    static void startInstall() {
        /* 프로그램 설치에 필요한 준비를 하는 코드 작성 */
    }

    static void copyFiles() {}
    static void deleteTempFiles() {}
}
