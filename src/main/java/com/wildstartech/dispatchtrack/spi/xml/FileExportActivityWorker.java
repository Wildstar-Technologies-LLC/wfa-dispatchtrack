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
package com.wildstartech.dispatchtrack.spi.xml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

public class FileExportActivityWorker extends ExportActivityWorker {
   private static final String _CLASS=FileExportActivityWorker.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   
   private String fileName="";
   
   public FileExportActivityWorker() {
      logger.entering(_CLASS, "FileExportActivityWorker()");
      logger.exiting(_CLASS, "FileExportActivityWorker()");
   }
   
   //***** fileName
   public String getFileName() {
      logger.entering(_CLASS, "getFileName()");
      logger.exiting(_CLASS, "getFileName()",this.fileName);
      return this.fileName;
   }
   public void setFileName(String fileName) {
      logger.entering(_CLASS, "setFileName(String)",fileName);
      if (fileName != null) {
         this.fileName=fileName;
      } else {
         this.fileName="";
      } // END if (fileName != null)
      logger.exiting(_CLASS, "setFileName(String)");
   }
   
   // ********** doWork
   /**
    * Perform the work associated with the web service call.
    */
   public final void doWork() {
      logger.entering(_CLASS, "doWork()");
      InputStream in=null;
      String fileName=null;      
      
      try {
         fileName=getFileName();
         in=new FileInputStream(fileName);
         parse(in);                 
      } catch (IOException ex) {
         ex.printStackTrace();
      } finally {
         if (in != null) {
            try {
               in.close();               
            } catch (IOException ex) {
               // Error cleaning up.   
            } // END try/catch
         } // END if (in != null)         
      } // END try/catch
      
      logger.exiting(_CLASS, "doWork()");
   }
}