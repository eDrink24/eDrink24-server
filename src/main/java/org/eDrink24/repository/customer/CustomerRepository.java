package org.eDrink24.repository.customer;

import org.eDrink24.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public Customer findByLoginId(String loginId);

    @Query("select c from Customer c where c.loginId= :loginId AND c.pw= :pw")
    public Customer authenticate(String loginId, String pw);

    // sms 인증 전 가입된 번호확인
    public Customer findByPhoneNum(String phoneNum);
    
    // 아이디 찾기
    @Query("select c from Customer c where c.userName = :userName AND c.email = :email")
    public Customer findByUserNameAndEmail(String userName, String email);

}
