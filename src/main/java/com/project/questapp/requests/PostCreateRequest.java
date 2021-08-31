package com.project.questapp.requests;

import lombok.Data;

@Data
public class PostCreateRequest {

	Long id;
	String text;
	String tittle;
	Long userId;
}
