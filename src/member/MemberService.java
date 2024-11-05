package member;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class MemberService {
    private final MemberQueryService memberQuery = new MemberQueryService();
    private final MemberInput input = new MemberInput();

    public void createMember() {
        Scanner sc = new Scanner(System.in);
        Member member = new Member();

        member.setName(input.promptInput("이름: "));
        member.setPhone(input.promptValidPhone());
        member.setEmail(input.promptValidEmail());
        member.setGroupName(input.promptInput("그룹명: "));
        member.setBirthDate(input.promptValidBirthDate());
        member.setRegistrationDate(new Date(System.currentTimeMillis()));

        System.out.print("회원을 등록하시겠습니까?(y/n): ");
        if (sc.nextLine().equalsIgnoreCase("y")) {
            memberQuery.createMemberQuery(member);
            System.out.println("회원이 성공적으로 등록되었습니다.");
        } else {
            System.out.println("회원 등록이 취소되었습니다.");
        }
        sc.close();
    }

    public void readMembers() {
        printMembers(getMembers());
    }

    public void updateMember() {
        List<Member> members = getMembers();
        printMembers(members);

        int id = input.promptValidMemberId(members, "수정할 멤버 번호를 입력: ");
        Member member = Validate.getExistMember(members, id);

        System.out.println("입력하지 않으면 기존의 정보가 유지됩니다.");

        String name = input.promptInput("수정할 이름을 입력 ( 현재: " + member.getName() + " ): ");
        if (!name.isEmpty()) member.setName(name);

        String phone = input.promptValidPhone("수정할 연락처 입력 ( 현재: " + member.getPhone() + " ): ", member.getPhone());
        if (!phone.equals(member.getPhone())) member.setPhone(phone);

        String email = input.promptValidEmail("수정할 이메일 입력 ( 현재: " + member.getEmail() + " ): ", member.getEmail());
        if (!email.equals(member.getEmail())) member.setEmail(email);

        String groupName = input.promptInput("수정할 그룹명 입력 ( 현재: " + member.getGroupName() + " ): ");
        if (!groupName.isEmpty()) member.setGroupName(groupName);

        Date birthDate = input.promptValidBirthDate("수정할 생년월일 입력 ( 현재: " + member.getBirthDate() + " ): ", member.getBirthDate());
        if (!birthDate.equals(member.getBirthDate())) member.setBirthDate(birthDate);

        memberQuery.updateMemberQuery(member);
        System.out.println("회원 수정이 완료 되었습니다.");
    }

    public void deleteMember() {
        List<Member> members = getMembers();
        printMembers(members);

        int id = input.promptValidMemberId(members, "삭제할 멤버 번호를 입력 : ");

        memberQuery.deleteMemberQuery(id);
        System.out.println("회원 삭제가 완료 되었습니다.");
    }

    public void sendEmail() {

    }

    private List<Member> getMembers() {
        return memberQuery.readMembersQuery();
    }

    private void printMembers(List<Member> members) {
        System.out.printf("========================================================================================================================\n" +
                        "%-6s\t %-10s\t\t %-15s\t %-8s\t\t\t %-12s\t %-20s\t %-20s\n",
                "번호", "이름", "연락처", "이메일", "그룹명", "생년월일", "등록일");
        System.out.println("========================================================================================================================");

        for (Member member : members) {
            System.out.println(member.toString());
        }

        System.out.println("========================================================================================================================");
        System.out.println("총 회원 수 : " + members.size());
    }
}
