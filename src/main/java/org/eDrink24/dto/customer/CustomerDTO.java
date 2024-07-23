package org.eDrink24.dto.customer;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class CustomerDTO {
    private String userName;
    private String loginId;
    private String pw;
    private LocalDateTime birthdate;
    private String phoneNum;
    private String email;
    private String address1;
    private String address2;
    private String currentLocation;
    private String currentStore;
    private Integer totalPoint;
    private String role;
}
