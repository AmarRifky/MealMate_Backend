package lk.mealmate.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lk.mealmate.backend.dto.CommentsDto;
import lk.mealmate.backend.entity.CommentsEntity;


@Service
public interface CommentsService {
    CommentsEntity createComments(CommentsDto commentsDto);
    CommentsEntity getCommentsById(Long id);
    List<CommentsEntity> getAllComments();
    CommentsEntity deleteComments(Long id);
}
