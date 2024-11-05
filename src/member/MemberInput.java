package member;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class MemberInput {
    private final Scanner sc = new Scanner(System.in);

    public String promptInput(String message) {
        System.out.print(message);
        return sc.nextLine();
    }

    public String promptValidPhone() {
        return promptValidPhone("연락처(000-0000-0000): ", null);
    }

    public String promptValidPhone(String message, String currentPhone) {
        String phone;
        do {
            phone = promptInput(message);
            if(currentPhone != null && phone.isEmpty()) return currentPhone;
        } while (!Validate.isValidPhone(phone));
        return phone;
    }

    public String promptValidEmail() {
        return promptValidEmail("이메일: ", null);
    }

    public String promptValidEmail(String message, String currentEmail) {
        String email;
        do {
            email = promptInput(message);
            if (currentEmail != null && email.isEmpty()) return currentEmail;
        } while (!Validate.isValidEmail(email));
        return email;
    }

    public Date promptValidBirthDate() {
        return promptValidBirthDate("생년월일(yyyy-mm-dd): ", null);
    }

    public Date promptValidBirthDate(String message, Date currentDate) {
        Date birthDate = null;
        while (birthDate == null) {
           String input = promptInput(message);
            if (currentDate != null && input.isEmpty()) return currentDate;
            birthDate = Validate.getValidBirthDate(input);
        }
        return birthDate;
    }

    public int promptValidMemberId(List<Member> members, String message) {
        int id;
        while (true) {
            try {
                id = Integer.parseInt(promptInput(message));
                if (Validate.isExistMember(members, id)) {
                    return id;
                } else {
                    System.out.println("입력하신 ID에 해당하는 멤버가 존재하지 않습니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("유효한 숫자를 입력해주세요.");
            }
        }
    }

}
