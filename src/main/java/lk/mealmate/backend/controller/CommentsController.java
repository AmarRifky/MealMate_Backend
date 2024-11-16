package lk.mealmate.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.mealmate.backend.dto.CommentsDto;
import lk.mealmate.backend.entity.CommentsEntity;
import lk.mealmate.backend.service.CommentsService;

@RestController
@RequestMapping("/api/comments")
@CrossOrigin(origins = "*")
public class CommentsController {
    @Autowired
    private CommentsService commentsService;

    /**
     * Retrieves a list of all comments.
     * 
     * @return A list of CommentsEntity objects.
     */
    @GetMapping
    public ResponseEntity<List<CommentsEntity>> getAllComments() {
        List<CommentsEntity> comments = commentsService.getAllComments();
        return ResponseEntity.ok(comments);
    }

    /**
     * Retrieves a specific comment by its ID.
     * 
     * @param id The ID of the comment to retrieve.
     * @return The CommentsEntity object with the specified ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CommentsEntity> getCommentById(@PathVariable Long id) {
        CommentsEntity comment = commentsService.getCommentsById(id);
        return ResponseEntity.ok(comment);
    }

    /**
     * Creates a new comment.
     * 
     * @param commentsDto Data transfer object containing comment details.
     * @return The created CommentsEntity object.
     */
    @PostMapping
    public ResponseEntity<CommentsEntity> createComment(@RequestBody CommentsDto commentsDto) {
        CommentsEntity newComment = commentsService.createComments(commentsDto);
        return ResponseEntity.ok(newComment);
    }

    /**
     * Deletes a specific comment by its ID.
     * 
     * @param id The ID of the comment to delete.
     * @return The deleted CommentsEntity object.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<CommentsEntity> deleteComment(@PathVariable Long id) {
        CommentsEntity deletedComment = commentsService.deleteComments(id);
        return ResponseEntity.ok(deletedComment);
    }
}
