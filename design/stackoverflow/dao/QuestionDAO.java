package design.stackoverflow.dao;

import design.stackoverflow.model.Question;
import design.stackoverflow.model.User;

import java.util.List;
import java.util.Map;

public class QuestionDAO {
    Map<Integer, Question> questionMap;
    Map<Integer, List<Integer>> userIdQuestionListMap;

    public void addQuestion(Question question){

    }

    public void searchQuestion(String text){

    }

    public void searchQuestion(User user){

    }
}
