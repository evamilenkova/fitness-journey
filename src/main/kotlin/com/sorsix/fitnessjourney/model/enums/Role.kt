package com.sorsix.fitnessjourney.model.enums
import org.springframework.security.core.GrantedAuthority


enum class Role : GrantedAuthority {
    ROLE_ADMIN,
    ROLE_USER;

    override fun getAuthority(): String {
        return name
    }
}