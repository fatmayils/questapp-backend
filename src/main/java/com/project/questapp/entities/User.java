package com.project.questapp.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //bu class databaseye map lenecek
@Table(name = "user") //tablo adı
@Data //loombok-getter setter için
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String userName;
	String password;
	int avatar;
}
