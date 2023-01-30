package bizwiz.study01.SingleTon;

public class SingleTonTest {
    public static void main(String[] args) {
        CompanyInfo companyInfo1 = CompanyInfo.getInstance();

        // setter로 접근
        companyInfo1.setCompanyName("비즈위즈 시스템");
        companyInfo1.setCompanyAddr("상암동 월드컵북로 402 1013호");

        getSingleTon();

    }

    private static void getSingleTon() {
        CompanyInfo companyInfo2 = CompanyInfo.getInstance();

        // getter로 접근
        System.out.println("회사명::"+companyInfo2.getCompanyName());
        System.out.println("회사명::"+companyInfo2.getCompanyAddr());
    }
}
