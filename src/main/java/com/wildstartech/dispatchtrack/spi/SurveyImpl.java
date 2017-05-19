/* 
 *  Wildstar Foundation Architecture DispatchTrack API for Java
 *
 *  Copyright (C) 2017 Wildstar Technologies, LLC.
 *
 *  This program is free software; you can redistribute it and/or modify it
 *  under the terms of the GNU General Public License as published by the Free
 *  Software Foundation; either version 2 of the License, or (at your option)
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful, but WITHOUT
 *  ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 *  FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for
 *  more details.
 *
 *  You should have received a copy of the GNU General Public License along
 *  with this program; if not, write to the Free Software Foundation, Inc., 59
 *  Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *  
 *  Linking this library statically or dynamically with other modules is making
 *  a combined work based on this library.  Thus, the terms and conditions of
 *  the GNU General Public License cover the whole combination.
 *
 *  As a special exception, the copyright holders of this library give you
 *  permission to link this library with independent modules to produce an
 *  executable, regardless of the license terms of these independent modules,
 *  and to copy and distribute the resulting executable under terms of your
 *  choice, provided that you also meet, for each linked independent module,
 *  the terms and conditions of the license of that module.  An independent
 *  module is a module which is not derived from or based on this library.  If
 *  you modify this library, you may extend this exception to your version of
 *  the library, but you are not obligated to do so.  If you do not wish to do
 *  so, delete this exception statement from your version.
 *  If you need additional information or have any questions, please contact:
 *
 *      Wildstar Technologies, LLC.
 *      63 The Greenway Loop
 *      Inlet Beach, FL 32461
 *      USA
 *
 *      derek.berube@wildstartech.com
 *      www.wildstartech.com
 */
package com.wildstartech.dispatchtrack.spi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import com.wildstartech.dispatchtrack.Question;
import com.wildstartech.dispatchtrack.Survey;

public class SurveyImpl implements Survey {
   private static final String _CLASS=SurveyImpl.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   
   private List<Question> questions=null;
   private String comment=null;
   
   /**
    * Default, no-argument constructor.
    */
   public SurveyImpl() {
      logger.entering(_CLASS, "SurveyImpl()");
      this.questions=new ArrayList<Question>();
      logger.exiting(_CLASS, "SurveyImpl()");
   }
   
   //***** comment
   @Override
   public String getComment() {
      logger.entering(_CLASS, "getComment()");
      logger.exiting(_CLASS, "getComment()",this.comment);
      return this.comment;
   }
   @Override
   public void setComment(String comment) {
      logger.entering(_CLASS, "setComment(String)",comment);
      this.comment=comment;
      logger.exiting(_CLASS, "setComment(String)");      
   }

   //***** questions
   @Override
   public boolean addQuestion(Question question) {
      logger.entering(_CLASS, "addQuestion(Question)",question);
      boolean result=false;
      if (question != null) {
         result=this.questions.add(question);
      } // END if (question != null)
      logger.exiting(_CLASS, "addQuestion(Question)",result);
      return result;
   }
   @Override
   public Question getQuestion(int index) {
      logger.entering(_CLASS, "getQuestion(int)",index);
      Question question=null;
      question=this.questions.get(index);
      logger.exiting(_CLASS, "getQuestion(int)",question);
      return question;
   }
   
   @Override
   public List<Question> getQuestions() {
      logger.entering(_CLASS, "getQuestions()");
      List<Question> newList=null;
      newList=Collections.unmodifiableList(this.questions);
      logger.exiting(_CLASS, "getQuestions()",newList);
      return newList;
   }
   @Override
   public Question removeQuestion(int index) {
      logger.entering(_CLASS, "removeQuestion(int)",index);
      Question question=null;
      question=this.questions.remove(index);
      logger.exiting(_CLASS, "removeQuestion(int)",question);
      return question;
   }
   @Override
   public boolean removeQuestion(Question question) {
      logger.entering(_CLASS, "removeQuestion(Question)",question);
      boolean result=false;
      if (question != null) {
         result=this.questions.remove(question);
      } // END if (question != null)
      logger.exiting(_CLASS, "removeQuestion(Question)",result);
      return result;
   }
   @Override 
   public Question setQuestion(int index, Question question) {
      logger.entering(_CLASS, "setQuestion(int,Question)",new Object[] {index,question});
      Question result=null;
      result=this.questions.set(index, question);
      logger.exiting(_CLASS, "setQuestion(int,Question)",result);
      return result;
   }
   @Override
   public void setQuestions(Question... questions) {
      logger.entering(_CLASS, "setQuestions(Question)",questions);
      this.questions.clear();
      if (questions != null) {
         for (Question question: questions) {
            this.questions.add(question);
         } // END for (Question question: questions)
      } // END if (questions != null)
      logger.exiting(_CLASS, "setQuestions(Question)");
   }
   @Override
   public void setQuestions(List<Question> questions) {
      logger.entering(_CLASS, "setQuestions(Question)",questions);
      this.questions.clear();
      this.questions.addAll(questions);
      logger.exiting(_CLASS, "setQuestions(Question)");
   }
}
