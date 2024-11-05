import member.MemberService;

import java.util.Scanner;

public class View {
    MemberService service = new MemberService();

    public void run() {
        Scanner sc = new Scanner(System.in);

        while (true){
            printMenu();
            int num = sc.nextInt();
            selectMenu(num);
        }
    }

    public void printMenu() {
        System.out.println("========================================================================================================================");
        System.out.println("[1]회원 정보 목록 출력");
        System.out.println("[2]회원 정보 등록");
        System.out.println("[3]회원 정보 수정");
        System.out.println("[4]회원 정보 삭제");
        System.out.println("[5]쪽지 보내기");
        System.out.println("[6]프로그램 종료");
        System.out.println("========================================================================================================================");
        System.out.print("메뉴를 선택하세요 : ");
    }

    public void selectMenu(int num) {
        switch (num) {
            case 1:
                System.out.println("회원 정보 목록을 출력합니다.");
                service.readMembers();
                break;
            case 2:
                System.out.println("회원 정보를 등록합니다.");
                service.createMember();
                break;
            case 3:
                System.out.println("회원 정보를 수정합니다.");
                service.updateMember();
                break;
            case 4:
                System.out.println("회원 정보를 삭제합니다.");
                service.deleteMember();
                break;
            case 5:
                System.out.println("쪽지를 전송합니다.");
                service.sendEmail();
                break;
            case 6:
                System.out.println("프로그램을 종료합니다...");
                System.exit(0);
                break;
            default:
                System.out.println("다시 입력 해주세요.");
        }
    }
}
