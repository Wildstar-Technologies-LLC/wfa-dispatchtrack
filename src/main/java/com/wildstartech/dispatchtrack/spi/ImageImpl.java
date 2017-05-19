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

import com.wildstartech.dispatchtrack.Image;

public class ImageImpl implements Image {
   private static final String _CLASS=ImageImpl.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   
   private Date createdAt=null;
   private String source=null;
   private String thumbnail=null;
   
   /** 
    * Default, no-argument constructor.
    */
   public ImageImpl() {
      logger.entering(_CLASS, "ImageImpl()");
      logger.exiting(_CLASS, "ImageImpl()");
   }
   
   //***** createdAt
   @Override
   public Date getCreatedAt() {
      logger.entering(_CLASS, "getCreatedAt()");
      logger.exiting(_CLASS, "getCreatedAt()",this.createdAt);
      return this.createdAt;
   }
   @Override
   public void setCreatedAt(Date date) {
      logger.entering(_CLASS, "setCreatedAt(Date)",date);
      this.createdAt=date;
      logger.exiting(_CLASS, "setCreatedAt(Date)");
   }

   //***** source
   @Override
   public String getSource() {
      logger.entering(_CLASS, "getSource()");
      logger.exiting(_CLASS, "getSource()",this.source);
      return this.source;
   }
   @Override
   public void setSource(String source) {
      logger.entering(_CLASS, "setSource(String)",source);
      this.source=source;
      logger.exiting(_CLASS, "setSource(String)");
   }

   //***** thumbnail
   @Override
   public String getThumbnail() {
      logger.entering(_CLASS, "getThumbnail()");
      logger.exiting(_CLASS, "getThumbnail()",this.thumbnail);
      return this.thumbnail;
   }
   @Override
   public void setThumbnail(String thumbnail) {
      logger.entering(_CLASS, "setThumbnail(String)",thumbnail);
      this.thumbnail=thumbnail;
      logger.exiting(_CLASS, "setThumbnail(String)");
   }
}