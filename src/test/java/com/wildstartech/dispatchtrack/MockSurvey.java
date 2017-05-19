package com.wildstartech.dispatchtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MockSurvey implements Survey {
   private List<Question> questions=null;
   private String comment=null;
   
   /**
    * Default, no-argument constructor.
    */
   public MockSurvey() {
      this.questions=new ArrayList<Question>();      
   }
   
   //***** comment
   @Override
   public String getComment() {
      return this.comment;
   }
   @Override
   public void setComment(String comment) {
      this.comment=comment;      
   }

   //***** questions
   @Override
   public boolean addQuestion(Question question) {
      boolean result=false;
      if (question != null) {
         result=this.questions.add(question);
      } // END if (question != null)
      return result;
   }
   @Override
   public Question getQuestion(int index) {
      Question question=null;
      question=this.questions.get(index);
      return question;
   }
   
   @Override
   public List<Question> getQuestions() {
      List<Question> newList=null;
      newList=Collections.unmodifiableList(this.questions);
      return newList;
   }
   @Override
   public Question removeQuestion(int index) {
      Question question=null;
      question=this.questions.remove(index);
      return question;
   }
   @Override
   public boolean removeQuestion(Question question) {
      boolean result=false;
      if (question != null) {
         result=this.questions.remove(question);
      } // END if (question != null)
      return result;
   }
   @Override 
   public Question setQuestion(int index, Question question) {
      Question result=null;
      result=this.questions.set(index, question);
      return result;
   }
   @Override
   public void setQuestions(Question... questions) {
      this.questions.clear();
      if (questions != null) {
         for (Question question: questions) {
            this.questions.add(question);
         } // END for (Question question: questions)
      } // END if (questions != null)
   }
   @Override
   public void setQuestions(List<Question> questions) {
      this.questions.clear();
      this.questions.addAll(questions);
   }
}