package com.project.questapp.responses;

import java.util.List;

import com.project.questapp.entities.Like;
import com.project.questapp.entities.Post;
import com.project.questapp.entities.Like;

import lombok.Data;

@Data
public class PostResponse {
	Long id;
	Long userId;
	String userName;
	String title;
	String text;

	List<LikeResponse> postLikes;
	//içerisine post entity si alıyor,bunu postresponse ye çeviriyor
	//bir nevi mapping yapıyor diyebiliriz.
	//constracter base mapping
	public PostResponse(Post entity,List<LikeResponse> likes) {
		this.id = entity.getId();
		this.userId = entity.getUser().getId();
		this.userName = entity.getUser().getUserName();
		this.title = entity.getTitle();
		this.text = entity.getText();
		this.postLikes=likes;
	}
}
