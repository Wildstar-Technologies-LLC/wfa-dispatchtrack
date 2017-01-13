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
package com.wildstartech.dispatchtrack;

import java.util.ListResourceBundle;

public class ServiceManagerMessages extends ListResourceBundle {
   public static final String ERR_CONFIG_FILE_NOT_FOUND=
         "ERR_CONFIG_FILE_NOT_FOUND";
   public static final String ERR_CONFIG_PROPERTY_MISSING=
         "ERR_CONFIG_PROPERTY_MISSING";
   public static final String ERR_INIT_FAILED="ERR_INIT_FAILED";
   public static final String ERR_NOT_INITIALIZED=
         "ERR_NOT_INITIALIZED";
   public static String ERR_READING_CONFIG_FILE=
         "ERR_READING_CONFIG_FILE";
   
   public Object[][] getContents() {
      return new Object[][] {
         {ERR_CONFIG_PROPERTY_MISSING,"The configuration file does not have an entry for the \"{%0}\"property."},
         {ERR_INIT_FAILED,"The ServiceManager initialization process failed."},
         {ERR_NOT_INITIALIZED,"The ServiceManager has not been initialized."},
         {ERR_READING_CONFIG_FILE,"An error encountered processing the configuration file."}
      };      
   }
}