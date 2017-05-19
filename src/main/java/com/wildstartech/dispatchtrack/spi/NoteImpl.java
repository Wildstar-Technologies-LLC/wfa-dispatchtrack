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

import java.util.Date;
import java.util.logging.Logger;

import com.wildstartech.dispatchtrack.Note;

public class NoteImpl implements Note {
   private static final String _CLASS=NoteImpl.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   private Date createdAt=null;
   private String author=null;
   private String noteText=null;
   private String type=null;
   
   /**
    * Default, no-argument constructor;
    */
   public NoteImpl() {
      logger.entering(_CLASS, "NoteImpl()");
      this.createdAt=new Date();
      this.author="";
      this.noteText="";
      this.type="";
      logger.exiting(_CLASS, "NoteImpl()");
   }
   
   @Override
   public Date getCreatedAt() {
      logger.entering(_CLASS, "getCreatedAt()");
      logger.exiting(_CLASS, "getCreatedAt()",this.createdAt);
      return this.createdAt;
   }

   @Override
   public void setCreatedAt(Date createdAt) {
      logger.entering(_CLASS, "setCreatedAt(Date)",createdAt);
      if (createdAt != null) {
         this.createdAt=new Date(createdAt.getTime());
      } // END if (createdAt != null)
      logger.exiting(_CLASS, "setCreatedAt(Date)");
   }

   @Override
   public String getAuthor() {
      logger.entering(_CLASS, "getAuthor()");
      logger.exiting(_CLASS, "getAuthor()",this.author);
      return this.author;
   }

   @Override
   public void setAuthor(String author) {
      logger.entering(_CLASS, "setAuthor(String)",author);
      this.author=author;
      logger.entering(_CLASS, "setAuthor(String)");
   }

   @Override
   public String getType() {
      logger.entering(_CLASS, "getType()");
      logger.exiting(_CLASS, "getType()",this.type);
      return this.type;
   }

   @Override
   public void setType(String noteType) {
      logger.entering(_CLASS, "setType(String)",noteType);
      this.type=noteType;
      logger.entering(_CLASS, "setType(String)");
   }

   @Override
   public String getNoteText() {
      logger.entering(_CLASS, "getNoteText()");
      logger.exiting(_CLASS, "getNoteText()",this.noteText);
      return this.noteText;
   }

   @Override
   public void setNoteText(String noteText) {
      logger.entering(_CLASS, "setNoteText(String)",noteText);
      this.noteText=noteText;
      logger.entering(_CLASS, "setNoteText(String)");
   }
}