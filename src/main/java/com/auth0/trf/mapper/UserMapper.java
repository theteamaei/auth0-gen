package com.auth0.trf.mapper;

import com.auth0.trf.model.bo.WebUserBo;
import com.auth0.trf.model.bo.WebUserRoleBo;
import com.auth0.trf.model.dto.AppMetadataInfoDto;
import com.auth0.trf.model.dto.RoleDto;
import com.auth0.trf.model.dto.UserDto;
import com.auth0.trf.model.dto.UserMetadataInfoDto;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    private ModelMapper modelMapper = new ModelMapper();
    private static final String AUTH0_CONNECTION = "IELTSDatabase";
    private static final String GENERAL_PASSWORD = "Password123!";

    public UserMapper() {
        this.initModelMapper();
    }

    private void initModelMapper() {
        Converter<WebUserBo, UserDto> userDtoConverter = new AbstractConverter<WebUserBo, UserDto>() {
            @Override
            protected UserDto convert(WebUserBo webUserBo) {
                UserDto userDto = new UserDto();

                userDto.setPassword(UserMapper.GENERAL_PASSWORD);
                userDto.setName(webUserBo.getFirstName() + " " + webUserBo.getLastName());
                userDto.setEmail(webUserBo.getEmailAddress());
                userDto.setGivenName(webUserBo.getFirstName());
                userDto.setFamilyName(webUserBo.getLastName());
                userDto.setConnection(UserMapper.AUTH0_CONNECTION);

                List<RoleDto> roleDtoList = new ArrayList<>();
                for (WebUserRoleBo webUserRoleBo : webUserBo.getWebUserRoleBo()) {
                    RoleDto roleDto = new RoleDto();
                    roleDto.setRoleName(webUserRoleBo.getRoleBo().getName());
                    roleDtoList.add(roleDto);
                }

                AppMetadataInfoDto appMetadataInfoDto = new AppMetadataInfoDto();
                appMetadataInfoDto.setRoleDtoList(roleDtoList);
                appMetadataInfoDto.setOrganisationId(webUserBo.getWebUserOrganisationBo().get(0).getOrganisationId());

                UserMetadataInfoDto userMetadataInfoDto = new UserMetadataInfoDto();
                userMetadataInfoDto.setPhoneNumber(webUserBo.getTelephone());
                userMetadataInfoDto.setFax(webUserBo.getIeltsUserBo().getFaxNo());
                userMetadataInfoDto.setTitle(webUserBo.getTitle());

                userDto.setAppMetadataInfoDto(appMetadataInfoDto);
                userDto.setUserMetadataInfoDto(userMetadataInfoDto);
                return userDto;
            }
        };

        modelMapper.addConverter(userDtoConverter);
    }

    private ModelMapper getModelMapper() {
        return this.modelMapper;
    }

    public UserDto mapEntityToDto(WebUserBo webUserBo) {
        UserDto userDto = this.getModelMapper().map(webUserBo, UserDto.class);
        return userDto;
    }

    public List<UserDto> mapEntityListToDtoList(List<WebUserBo> webUserBoList) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (WebUserBo webUserBo : webUserBoList) {
            UserDto userDto = this.mapEntityToDto(webUserBo);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }
}
