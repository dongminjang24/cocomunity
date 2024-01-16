package hidongmin37.com.cocomunity.app.service;

import hidongmin37.com.cocomunity.app.domain.user.User;
import hidongmin37.com.cocomunity.app.domain.user.UserUpdateDto;

public interface RegisterService {

    void userRegister(User user);

    void userUpdate(UserUpdateDto userUpdateDto);
}
