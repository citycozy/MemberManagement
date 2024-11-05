package member;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Validate {
    public static Date getValidBirthDate(String birthStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);

        try {
            java.util.Date utilDate = formatter.parse(birthStr);
            return new Date(utilDate.getTime());
        } catch (ParseException e) {
            System.out.println("잘못된 날짜 형식입니다. 다시 입력해 주세요.");
            return null;
        }
    }

    public static boolean isValidEmail(String email) {
        String EMAIL_REGEX =
                "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (!email.matches(EMAIL_REGEX)) {
            System.out.println("잘못된 이메일 형식입니다. 다시 입력해 주세요.");
        }
        return email.matches(EMAIL_REGEX);
    }

    public static boolean isValidPhone(String phone) {
        String PHONE_REGEX = "^\\d{3}-\\d{4}-\\d{4}$";
        if (!phone.matches(PHONE_REGEX)) {
            System.out.println("잘못된 전화번호 형식입니다. 다시 입력해 주세요.");
        }
        return phone.matches(PHONE_REGEX);
    }

    public static boolean isExistMember(List<Member> members, int id) {
        return members.stream().anyMatch(member -> member.getId() == id);
    }

    public static Member getExistMember(List<Member> members, int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }


}
