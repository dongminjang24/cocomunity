package hidongmin37.com.cocomunity.app.repository.mybatis;

import hidongmin37.com.cocomunity.app.domain.user.User;
import hidongmin37.com.cocomunity.app.domain.user.UserUpdateDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {

    void userRegister(User user);

    void userUpdate(UserUpdateDto userUpdateDto);
}
