package com.learnrest.rest.webservices.restfulwebservices.jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "user")
public class JwtUserDetails implements UserDetails {

	@Transient
	private static final long serialVersionUID = 5155720064139820502L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	@Column(name = "user_name", nullable = false, unique = true)
	private String userName;
	@Column(name = "password", nullable = false, unique = true, length = 255)
	private String password;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "middle_name")
	private String middleName;
	@Column(name = "display_name")
	private String displayName;
	@Column(name = "country", length = 20)
	private String country;
	@Column(name = "county", length = 20)
	private String county;
	@Column(name = "phone_number", length = 20, unique = true)
	private String phoneNumber;
	@Column(name = "roles")
	private String roles;
	@Column(name = "id_number", unique = true)
	private long idNumber;
	@Column(name = "email_address", unique = true)
	private String emailAddress;
	@Column(name = "po_box_address")
	private String poBoxAddress;
	@Column(name = "join_date")
	private Date joinDate;

	@Transient
	private Collection<? extends GrantedAuthority> authorities;

	public JwtUserDetails() {
	}

	public JwtUserDetails(String userName, String password, String firstName, String lastName,
						  String middleName, String displayName, String country, String county, String phoneNumber,
						  String roles, long idNumber, String emailAddress, String poBoxAddress, Date joinDate) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.displayName = displayName;
		this.country = country;
		this.county = county;
		this.phoneNumber = phoneNumber;
		this.roles = roles;
		this.idNumber = idNumber;
		this.emailAddress = emailAddress;
		this.poBoxAddress = poBoxAddress;
		this.joinDate = joinDate;

		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(roles));

		this.authorities = authorities;
	}

	@JsonIgnore
	public Long getId() {
		return id;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

//	@JsonIgnore
//	@Override
//	public String getPassword() {
//		return this.password;
//	}


	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String toString() {
		return "JwtUserDetails{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", password='" + password + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", middleName='" + middleName + '\'' +
				", displayName='" + displayName + '\'' +
				", country='" + country + '\'' +
				", county='" + county + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", roles='" + roles + '\'' +
				", idNumber=" + idNumber +
				", emailAddress='" + emailAddress + '\'' +
				", poBoxAddress='" + poBoxAddress + '\'' +
				", joinDate=" + joinDate +
				", authorities=" + authorities +
				'}';
	}
}