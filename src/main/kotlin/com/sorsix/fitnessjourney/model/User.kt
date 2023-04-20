package com.sorsix.fitnessjourney.model

import com.sorsix.fitnessjourney.model.enums.Gender
import com.sorsix.fitnessjourney.model.enums.Role
import lombok.Data
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.time.LocalDate
import java.util.*
import javax.persistence.*


@Entity
@Table(name = "fitness_user")
@Data
data class User(
    @GeneratedValue
    @Id
    val id:Int,
    val name:String,
    val surname:String,
    private var username:String,
    private val password:String,
    @Enumerated(EnumType.STRING)
    val gender: Gender,
    val dateOfBirth: LocalDate,
    @OneToOne(cascade = arrayOf(CascadeType.ALL))
    val journal:Journal = Journal(),
    @Enumerated(EnumType.STRING)
    val role: Role = Role.ROLE_USER
):UserDetails {
    constructor() : this(0, "", "", "", "", Gender.FEMALE, LocalDate.now(), Journal())

    override fun getAuthorities(): Collection<GrantedAuthority?>? {
        return Collections.singletonList(role)
    }

    override fun getPassword(): String {
        return password;
    }

    override fun getUsername(): String {
        return this.username;
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }


}
