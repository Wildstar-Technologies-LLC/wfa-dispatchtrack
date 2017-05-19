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

import java.util.logging.Logger;

import com.wildstartech.dispatchtrack.Question;

public class QuestionImpl implements Question {
   private static final String _CLASS=QuestionImpl.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   
   private int number=0;
   private int rating=0;
   private String comment=null;
   private String text=null;
   
   /**
    * Default, no-argument constructor.
    */
   public QuestionImpl() {
      logger.entering(_CLASS, "QuestionImpl()");
      this.number=-1;
      this.rating=-1;
      this.comment="";
      this.text="";
      logger.exiting(_CLASS, "QuestionImpl()");
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
      if (comment != null) {
         this.comment=comment;
      } else {
         this.comment="";
      } // END if (comment != null)
      logger.exiting(_CLASS, "setComment()");
   }
   //***** number
   @Override
   public int getNumber() {
      logger.entering(_CLASS, "getNumber()");
      logger.exiting(_CLASS, "getNumber()",this.number);
      return this.number;
   }
   @Override
   public void setNumber(int number) {
      logger.entering(_CLASS, "setNumber(int)",number);
      this.number=number;
      logger.exiting(_CLASS, "setNumber(int)");
   }

   //***** rating
   @Override
   public int getRating() {
      logger.entering(_CLASS, "getRating()");
      logger.exiting(_CLASS, "getRating()",this.rating);
      return this.rating;
   }
   @Override
   public void setRating(int rating) {
      logger.entering(_CLASS, "setRating(int)",rating);
      this.rating=rating;
      logger.exiting(_CLASS, "setRating(int)");
   }

   //***** text
   @Override
   public String getText() {
      logger.entering(_CLASS, "getText()");
      logger.entering(_CLASS, "getText()",this.text);
      return this.text;
   }
   @Override
   public void setText(String text) {
      logger.entering(_CLASS, "setTetxt(String)",text);
      if (text != null) {
         this.text=text;
      } else {
         this.text="";
      } // END if (text != null)
      logger.exiting(_CLASS, "setTetxt(String)");
   }
}