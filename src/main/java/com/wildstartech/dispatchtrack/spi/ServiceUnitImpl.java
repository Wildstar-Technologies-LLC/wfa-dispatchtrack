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

import com.wildstartech.dispatchtrack.ServiceUnit;

public class ServiceUnitImpl implements ServiceUnit {
   private static final String _CLASS=ServiceUnitImpl.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   private String login=null;
   private String name=null;

   /** 
    * Default, no-argument constructor.
    */
   public ServiceUnitImpl() {
      logger.entering(_CLASS, "ServiceUnitImpl()");
      logger.exiting(_CLASS, "ServiceUnitImpl()");
   }
   //***** login
   @Override
   public String getLogin() {
      logger.entering(_CLASS, "getLogin()");
      logger.exiting(_CLASS, "getLogin()",this.login);
      return this.login;
   }
   @Override
   public void setLogin(String login) {
      logger.entering(_CLASS, "setLogin(String)",login);
      this.login=login;
      logger.entering(_CLASS, "setLogin(String)");
   }
  //***** name
   @Override
   public String getName() {
      logger.entering(_CLASS, "getName()");
      logger.exiting(_CLASS, "getName()",this.name);
      return this.name;
   }
   @Override
   public void setName(String name) {
      logger.entering(_CLASS, "setName(String)",name);
      this.name=name;
      logger.exiting(_CLASS, "setName(String)");
   }
}