package com.example.baseball.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="player", schema = "public")
@Entity // ①
public class Player {
	
	@Id // ②
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ③
    private Long id;
	
	@NotEmpty(message = "必須項目です")
    private String name;
	
	@NotNull
	@Min(value = 0, message = "0以上にしてください")
	@Max(value = 150, message = "150以下にしてください")
    private Integer age;
	
	@Size(max = 20, message = "0文字以上20文字以下にしてください")
	@NotEmpty(message = "必須項目です") 
    private String team;
	
	@NotEmpty(message = "必須項目です") 
    private String position;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(nullable = true, name = "username")
	private User user;
	
	
	
	/*
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getTeam() {
        return team;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    */
    @Override
    public String toString() {
        return "Player [id=" + id + ", name=" + name + ", age=" + age + ", team=" + team + ", position=" + position + "]";
    }
}
