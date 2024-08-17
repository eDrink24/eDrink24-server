package org.eDrink24.domain.store;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Store {
    @Id
    @Column(name = "storeId" , nullable = false)
    private Integer storeId;
    @Column(name = "storeName", nullable = false)
    private String storeName;
    @Column(name = "storeAddress", nullable = false)
    private String storeAddress;
    @Column(name = "storePhoneNum")
    private String storePhoneNum;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
}
