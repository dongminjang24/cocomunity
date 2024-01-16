package hidongmin37.com.cocomunity.app.domain.user;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class User {

    private  Long userId;

    private String userAccountId;

    private String userPassWord;

    private String userEmail;

    private String nickName;

    private Date birthDate;

    private String phoneNumber;

    private LocalDateTime createdTime;

    public User(Long userId, String userAccountId, String userPassWord, String userEmail, String nickName, Date birthDate, String phoneNumber, LocalDateTime createdTime) {
        this.userId = userId;
        this.userAccountId = userAccountId;
        this.userPassWord = userPassWord;
        this.userEmail = userEmail;
        this.nickName = nickName;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.createdTime = createdTime;
    }
}
