package com.project.questapp.entities;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "post")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@ManyToOne(fetch = FetchType.EAGER)//başta lazy idi,şimdi eager yaptık
	@JoinColumn(name = "user_id", nullable = false)//userId yi bağladığımızı söylememiz lazım
	@OnDelete(action = OnDeleteAction.CASCADE)
	//@JsonIgnore FetchType.LAZY yi eager yaptığımız için ignore ye gerek kalmadı
	User user;
	String title;
	@Lob
	@Column(columnDefinition = "text")
	String text;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	Date createDate;
	

}
