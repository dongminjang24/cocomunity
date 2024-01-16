package hidongmin37.com.cocomunity.app.service;

import hidongmin37.com.cocomunity.app.domain.user.User;
import hidongmin37.com.cocomunity.app.domain.user.UserUpdateDto;
import hidongmin37.com.cocomunity.app.repository.mybatis.RegisterMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService{

    private final RegisterMapper  registerMapper;

    @Override
    public void userRegister(User user) {
        registerMapper.userRegister(user);
    }

    @Override
    public void userUpdate(UserUpdateDto userUpdateDto) {
        registerMapper.userUpdate(userUpdateDto);

    }
}
