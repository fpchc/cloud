package com.pch.auth.authorization.exceaption;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pch.auth.authorization.constant.AuthErrorEnum;
import com.pch.common.response.CommonResult;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = true)
@JsonSerialize(using = CustomOauthExceptionSerializer.class)
public class CustomOauthException extends OAuth2Exception {

    @Getter
    @Setter
    private CommonResult commonResult;

    CustomOauthException(OAuth2Exception oAuth2Exception) {
        super(oAuth2Exception.getSummary(), oAuth2Exception);
        this.commonResult = CommonResult.failed(
                AuthErrorEnum.valueOf(oAuth2Exception.getOAuth2ErrorCode().toUpperCase()).getCode(), oAuth2Exception
        );
    }
}
