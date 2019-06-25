package com.learnrest.rest.webservices.restfulwebservices.jwt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class JwtUserDetails implements UserDetails {

	@Transient
	private static final long serialVersionUID = 5155720064139820502L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	private  String username;
	private  String password;
	private  String fullname;
	private  String city;
	private  String zip;
	private  long phonenumber;
	private  String roles;

	 private JwtUserDetails() {}

	@Transient
	private Collection<? extends GrantedAuthority> authorities;



	public JwtUserDetails(final Long id, final String username,final String password,final String fullname,
						  final String city,final String zip,final long phonenumber,final String roles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.city = city;
		this.zip = zip;
		this.phonenumber = phonenumber;
		this.roles = roles;

		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(roles));

		this.authorities = authorities;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getRoles() {
		return roles;
	}

	public String getFullname() {
		return fullname;
	}

	public String getCity() {
		return city;
	}

	public String getZip() {
		return zip;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	@JsonIgnore
	public Long getId() {
		return id;
	}

	@Override
	public String getUsername() {
		return username;
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
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", fullname='" + fullname + '\'' +
				", city='" + city + '\'' +
				", zip='" + zip + '\'' +
				", phonenumber=" + phonenumber +
				", roles='" + roles + '\'' +
				", authorities=" + authorities +
				'}';
	}
}