package com.ready2die.app;

import com.ready2die.common.validation.AlphaNumeric;
import com.ready2die.common.validation.EqualsPropertyValues;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

//클래스 수준의 제약을 애너테이션으로 지정
@EqualsPropertyValues(property = "password", comparingProperty = "reEnteredPassword")
public class AccountCreateForm implements Serializable {

    private static final long serialVersionUID = -1673435991590803149L;

    @NotNull
    @Size(min = 1, max = 50)
    private String name;

    @NotNull
    @Size(min = 9, max = 11)
    private String tel;

    @NotNull
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date dateOfBirth;

    @NotNull
    @Size(min = 9, max = 256)
    private String email;

    private AccountForm account;
    private CardForm card;

//    @Pattern(regexp = "[a-zA-Z0-9]*")
    @AlphaNumeric // @Pattern이 아니라 독자적인 제약 애너테이션을 이용
    private String couponCode;

    @Digits(integer = 2, fraction = 2) // -99.99에서 99.99 이내일 것
    private BigDecimal rate;

    @AssertTrue //true일 것 예) 이용약관에 동의
    private boolean isAgreedTermsOfUse;

    @NotNull
    @Password
    private String password;

    private String reEnteredPassword;

}
