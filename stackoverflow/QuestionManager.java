package stackoverflow;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionManager {

    Map<Integer, Post> questions = new HashMap<>();

    void postQuestion(PostBO postBO) {
        Post post = new Question();
        post.setPostId(1);
        post.setCreatedAt(new Date());
        post.setCreator(postBO.user);
        post.setDescription(postBO.description);
        post.setTags(postBO.tags);
        questions.put(post.getPostId(), post);
    }

    void postAnswer(int questionId, PostBO postBO) {
        Post post = new Answer();
        post.setPostId(1);
        post.setCreatedAt(new Date());
        post.setCreator(postBO.user);
        post.setDescription(postBO.description);
        post.setTags(postBO.tags);
        Question q = ((Question)questions.get(questionId));
        q.answers.put(post.getPostId(),post);

    }

    void postComment(int questionId, int answerId, PostBO postBO) {
        Post post = new Comment();
        post.setPostId(1);
        post.setCreatedAt(new Date());
        post.setCreator(postBO.user);
        post.setDescription(postBO.description);
        post.setTags(postBO.tags);
        Question q = (Question) questions.get(questionId);
        Answer answer = (Answer) q.answers.get(answerId);
        answer.comments.put(post.getPostId(),post);
    }

    void editPost(Integer questionId, Integer answerId, Integer commentId, String description){
        if(questionId != null && answerId != null && commentId != null){
            Question q = (Question) questions.get(questionId);
            Answer answer = (Answer) q.answers.get(answerId);
            answer.comments.get(commentId).setDescription(description);
            return;
        }

        if(questionId != null && answerId != null) {
            Question q = (Question) questions.get(questionId);
            Answer answer = (Answer) q.answers.get(answerId);
            answer.setDescription(description);
            return;
        }

        if(questionId != null) {
            Question q = (Question) questions.get(questionId);
            q.setDescription(description);
        }
    }

    void deletePost(Integer questionId, Integer answerId, Integer commentId) {
        if(questionId != null && answerId != null && commentId != null){
            Question q = (Question) questions.get(questionId);
            Answer answer = (Answer) q.answers.get(answerId);
            answer.comments.remove(commentId);
            return;
        }

        if(questionId != null && answerId != null) {
            Question q = (Question) questions.get(questionId);
            q.answers.remove(answerId);
            return;
        }

        if(questionId != null) {
            questions.remove(questionId);
        }
    }

    void upVote(Integer questionId, Integer answerId, Integer commentId) {
        if(questionId != null && answerId != null && commentId != null){
            Question q = (Question) questions.get(questionId);
            Answer answer = (Answer) q.answers.get(answerId);
            int currentVotes =   answer.comments.get(commentId).getUpvotes();
            answer.comments.get(commentId).setUpvotes(currentVotes+1);
            return;
        }

        if(questionId != null && answerId != null) {
            Question q = (Question) questions.get(questionId);
            Answer answer = (Answer) q.answers.get(answerId);
            int currentVotes = answer.getUpvotes();
            answer.setUpvotes(currentVotes+1);
            return;
        }

        if(questionId != null) {
            Question q = (Question) questions.get(questionId);
            int currentVotes = q.getUpvotes();
            q.setUpvotes(currentVotes+1);
        }
    }

    void downVote(Integer questionId, Integer answerId, Integer commentId) {
        if(questionId != null && answerId != null && commentId != null){
            Question q = (Question) questions.get(questionId);
            Answer answer = (Answer) q.answers.get(answerId);
            int currentVotes =   answer.comments.get(commentId).getDownvotes();
            answer.comments.get(commentId).setDownvotes(currentVotes-1);
            return;
        }

        if(questionId != null && answerId != null) {
            Question q = (Question) questions.get(questionId);
            Answer answer = (Answer) q.answers.get(answerId);
            int currentVotes = answer.getDownvotes();
            answer.setDownvotes(currentVotes-1);
            return;
        }

        if(questionId != null) {
            Question q = (Question) questions.get(questionId);
            int currentVotes = q.getDownvotes();
            q.setDownvotes(currentVotes-1);
        }
    }

    void updateStatus(Integer questionId, Integer answerId, Integer commentId, Status status) {
        if(questionId != null && answerId != null && commentId != null){
            Question q = (Question) questions.get(questionId);
            Answer answer = (Answer) q.answers.get(answerId);
            answer.comments.get(commentId).setStatus(status);
            return;
        }

        if(questionId != null && answerId != null) {
            Question q = (Question) questions.get(questionId);
            Answer answer = (Answer) q.answers.get(answerId);
            answer.setStatus(status);
            return;
        }

        if(questionId != null) {
            Question q = (Question) questions.get(questionId);
            q.setStatus(status);
        }
    }

    void updateTags(Integer questionId, Integer answerId, Integer commentId, List<Tag> tags) {
        if(questionId != null && answerId != null && commentId != null){
            Question q = (Question) questions.get(questionId);
            Answer answer = (Answer) q.answers.get(answerId);
            answer.comments.get(commentId).setTags(tags);
            return;
        }

        if(questionId != null && answerId != null) {
            Question q = (Question) questions.get(questionId);
            Answer answer = (Answer) q.answers.get(answerId);
            answer.setTags(tags);
            return;
        }

        if(questionId != null) {
            Question q = (Question) questions.get(questionId);
            q.setTags(tags);
        }
    }
    Post getQuestionDetails(Integer questionId) {
        return questions.get(questionId);
    }
}
