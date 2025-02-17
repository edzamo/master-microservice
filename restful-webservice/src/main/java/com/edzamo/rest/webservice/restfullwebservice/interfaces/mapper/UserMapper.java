package com.edzamo.rest.webservice.restfullwebservice.interfaces.mapper;


import com.edzamo.rest.webservice.restfullwebservice.domain.model.User;
import com.edzamo.rest.webservice.restfullwebservice.interfaces.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring"
)
public interface UserMapper {

  UserDto userToUserDto(User user);

}
