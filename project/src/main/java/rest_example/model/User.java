package rest_example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.util.StringUtils;

import rest_example.dto.UserDto;

/**
 * @author jelena.nikolic
 *
 */
@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false, name = "firstname")
	private String firstName;
	
	@Column(nullable = false, name = "lastname")
	private String lastName;
	
	@Column
	private Integer age;
	
	@Column
	private String address;
	
	@Column
	private String city;
	
	@Column(nullable = false, name = "phonenumber")
	private String phoneNumber;
	
	public User() {
	}
	
	public User(String firstName, String lastName, Integer age, String address, String city, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.city = city;
		this.phoneNumber = phoneNumber;
	}
	
	public User(String firstName, String lastName, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
	
	public User(UserDto dto) {
		this.firstName = dto.getFirstName();
		this.lastName = dto.getLastName();
		this.age = dto.getAge();
		this.address = dto.getAddress();
		this.city = dto.getCity();
		this.phoneNumber = dto.getPhoneNumber();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	// create representation
	public UserDto transferToDto() {
		UserDto dto = new UserDto();
		dto.setId(getId());
		dto.setFirstName(getFirstName());
		dto.setLastName(getLastName());
		dto.setAge(getAge());
		dto.setAddress(getAddress());
		dto.setCity(getCity());
		dto.setPhoneNumber(getPhoneNumber());
		return dto;
	}
	
	public void updateFromDto(UserDto dto) {
		if (StringUtils.isEmpty(dto.getFirstName())) {
			this.setFirstName(dto.getFirstName());
		}
		this.setLastName(dto.getLastName());
		this.setAge(dto.getAge());
		this.setAddress(dto.getAddress());
		this.setCity(dto.getCity());
		this.setPhoneNumber(dto.getPhoneNumber());
	}
	
}
