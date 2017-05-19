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
package com.wildstartech.dispatchtrack.spi.xml.serviceorder.survey;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.wildstartech.dispatchtrack.Localization;
import com.wildstartech.dispatchtrack.Question;
import com.wildstartech.dispatchtrack.Survey;
import com.wildstartech.dispatchtrack.spi.QuestionImpl;
import com.wildstartech.dispatchtrack.spi.xml.XMLElementProcessor;
import com.wildstartech.dispatchtrack.spi.xml.XMLElementProcessorMessages;

public class QuestionElementProcessor extends XMLElementProcessor<Survey> {
   private static final String _CLASS=QuestionElementProcessor.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   private static final String elementLabel="question";
   
   @Override
   public String getElementLabel() {
      logger.entering(_CLASS, "getElementLabel()");
      logger.exiting(_CLASS, "getElementLabel()",
            QuestionElementProcessor.elementLabel);
      return QuestionElementProcessor.elementLabel;
   }

   @Override
   public void processElement(Survey survey, XMLStreamReader reader) 
   throws XMLStreamException {
      logger.entering(_CLASS, "processElement(Image,XMLStreamReader)",
            new Object[] {survey,reader});
      int number=0;
      int rating=0;
      Question question=null;
      String comment=null;
      String msg=null;
      String numberText=null;
      String ratingText=null;
      String text=null;
      
      if ((survey != null) && (reader != null)) {
         question=new QuestionImpl();
         comment=reader.getAttributeValue("", "comment");
         numberText=reader.getAttributeValue("", "number");
         try {
            number=Integer.valueOf(numberText);
         } catch (NumberFormatException ex) {
            logger.log(
               Level.WARNING,
               "Error processing the number attribute.",
               ex);
         } // END try/catch
         
         ratingText=reader.getAttributeValue("", "rating");
         if ((ratingText != null) && (!ratingText.isEmpty())) {
            try {
               rating=Integer.valueOf(ratingText);
            } catch (NumberFormatException ex) {
               logger.log(
                  Level.WARNING,
                  "Error processing the rating attribute.",
                  ex);
            } // END try/catch
         } // END if ((ratingText != null) && (!ratingText.isEmpty()))
         text=getElementText(reader);
         question.setComment(comment);
         question.setNumber(number);
         question.setRating(rating);
         question.setText(text);    
         survey.addQuestion(question);
      }  else {
         if (survey == null) {
            msg=Localization.getString(
               XMLElementProcessor._RESOURCE_BUNDLE, 
               XMLElementProcessorMessages.OBJECT_PARAM_NULL, 
               null,    // locale, 
               null,    // cl, 
               new Object[] {"Survey"});
            logger.severe(msg);
         } // END if (order == null)
         if (reader == null) {
            msg=Localization.getString(
                  XMLElementProcessor._RESOURCE_BUNDLE, 
                  XMLElementProcessorMessages.XML_STREAM_READER_NULL, 
                  null,    // locale, 
                  null,    // cl, 
                  null);   // parameters
            logger.severe(msg);
         } // if (reader == null)
      } // END if ((order != null) && (reader != null))        
      logger.exiting(_CLASS, "processElement(Image,XMLStreamReader)");
   }
}