package com.project.questapp.requests;

import lombok.Data;

@Data
public class LikeCreateRequest {
private Long Id;
private Long userId;
private Long postId;
}
