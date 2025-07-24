package com.bmw.ecm.bank.processor.Specification;

import com.bmw.ecm.bank.processor.entities.UsersEntity;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecifications {

    public static Specification<UsersEntity> hasFirstName(String firstname){
        return(root, query, cb) -> firstname == null || firstname.isEmpty() ? null : cb.like(cb.lower(root.get("firstname")), "%" + firstname.toLowerCase() + "%");
    }

    public static Specification<UsersEntity> hasLastName(String lastname) {
        return(root, query, cb) -> lastname == null || lastname.isEmpty() ? null : cb.like(cb.lower(root.get("lastname")), "%" + lastname.toLowerCase() + "%");
    }
    public static Specification<UsersEntity> hasGender(String gender) {
        return(root, query, cb) -> gender == null || gender.isEmpty() ? null : cb.like(cb.lower(root.get("gender")), "%" + gender.toLowerCase() + "%");
    }

    public static Specification<UsersEntity> hasEmail(String email) {
        return(root, query, cb) -> email == null || email.isEmpty() ? null : cb.like(cb.lower(root.get("email")), "%" + email.toLowerCase() + "%");
    }

}
