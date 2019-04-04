package cn.com.vcloud.test.model.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Table(name="sys_test")
public class SysTest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(value = "id")
	private Long id;
	
	@JsonProperty(value = "name")
	private String name;
	 
	@JsonProperty(value = "age")
	private Long age;
	
	@JsonProperty(value = "address")
	private String address;
}
