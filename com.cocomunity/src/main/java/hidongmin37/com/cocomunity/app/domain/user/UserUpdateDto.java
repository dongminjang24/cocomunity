package hidongmin37.com.cocomunity.app.domain.user;


import lombok.Data;

@Data
public class UserUpdateDto {

    private  Long userId;


    private String userPassWord;

    private String userEmail;

    public UserUpdateDto(String userPassWord, String userEmail) {
        this.userPassWord = userPassWord;
        this.userEmail = userEmail;
    }
}
