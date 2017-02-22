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

import java.text.MessageFormat;
import java.util.Properties;

import org.testng.annotations.Test;

import com.wildstartech.dispatchtrack.ServiceManager.OperationType;

public class ServiceManagerEndpointTest {
   
   @Test
   public void testLoadProperties() {
      ServiceManager manager=null;
      ServiceManagerFactory factory=null;
      
      factory=new ServiceManagerFactory();
      manager=factory.getServiceManager();
      assert manager != null;
      assert manager.isInitialized();
   }
    
   @Test(dependsOnMethods={"testLoadProperties"})
   public void testGetServiceEndpointBulkImport() {
      Properties apiProps=null;
      Properties props=null;
      ServiceManager manager=null;
      ServiceManagerFactory factory=null;
      String fEndpoint=null;
      String tEndpoint=null;
      String template=null;
      String server=null;
      
      factory=new ServiceManagerFactory();
      manager=factory.getServiceManager();
      props=manager.loadProperties();
      apiProps=manager.loadAPIProperties();
      server=props.getProperty(ServiceManager._CONFIG_KEY_SERVER);
      assert server != null;
      template=apiProps.getProperty(ServiceManager._API_BULK_IMPORT_KEY);
      assert template != null;
      fEndpoint=manager.getServiceEndpoint(OperationType.BULK_IMPORT);
      assert fEndpoint != null;
      tEndpoint=MessageFormat.format(template, new Object[]{server});
      assert tEndpoint != null;
      assert fEndpoint.equals(tEndpoint);
   }
   
   @Test(dependsOnMethods={"testLoadProperties"})
   public void testGetServiceEndpointDelete() {
      Properties apiProps=null;
      Properties props=null;
      ServiceManager manager=null;
      ServiceManagerFactory factory=null;
      String fEndpoint=null;
      String tEndpoint=null;
      String template=null;
      String server=null;
      
      factory=new ServiceManagerFactory();
      manager=factory.getServiceManager();
      props=manager.loadProperties();
      apiProps=manager.loadAPIProperties();
      server=props.getProperty(ServiceManager._CONFIG_KEY_SERVER);
      assert server != null;
      template=apiProps.getProperty(ServiceManager._API_DELETE_KEY);
      assert template != null;
      fEndpoint=manager.getServiceEndpoint(OperationType.DELETE);
      assert fEndpoint != null;
      tEndpoint=MessageFormat.format(template, new Object[]{server});
      assert tEndpoint != null;
      assert fEndpoint.equals(tEndpoint);
   }
   
   @Test(dependsOnMethods={"testLoadProperties"})
   public void testGetServiceEndpointDeliveryReceipt() {
      Properties apiProps=null;
      Properties props=null;
      ServiceManager manager=null;
      ServiceManagerFactory factory=null;
      String fEndpoint=null;
      String tEndpoint=null;
      String template=null;
      String server=null;
      
      factory=new ServiceManagerFactory();
      manager=factory.getServiceManager();
      props=manager.loadProperties();
      apiProps=manager.loadAPIProperties();
      server=props.getProperty(ServiceManager._CONFIG_KEY_SERVER);
      assert server != null;
      template=apiProps.getProperty(ServiceManager._API_DELIVERY_RECEIPT_KEY);
      assert template != null;
      fEndpoint=manager.getServiceEndpoint(OperationType.DELIVERY_RECEIPT);
      assert fEndpoint != null;
      tEndpoint=MessageFormat.format(template, new Object[]{server});
      assert tEndpoint != null;
      assert fEndpoint.equals(tEndpoint);
   }
   
   @Test(dependsOnMethods={"testLoadProperties"})
   public void testGetServiceEndpointExport() {
      Properties apiProps=null;
      Properties props=null;
      ServiceManager manager=null;
      ServiceManagerFactory factory=null;
      String fEndpoint=null;
      String tEndpoint=null;
      String template=null;
      String server=null;
      
      factory=new ServiceManagerFactory();
      manager=factory.getServiceManager();
      props=manager.loadProperties();
      apiProps=manager.loadAPIProperties();
      server=props.getProperty(ServiceManager._CONFIG_KEY_SERVER);
      assert server != null;
      template=apiProps.getProperty(ServiceManager._API_EXPORT_KEY);
      assert template != null;
      fEndpoint=manager.getServiceEndpoint(OperationType.EXPORT);
      assert fEndpoint != null;
      tEndpoint=MessageFormat.format(template, new Object[]{server});
      assert tEndpoint != null;
      assert fEndpoint.equals(tEndpoint);
   }
   
   @Test(dependsOnMethods={"testLoadProperties"})
   public void testGetServiceEndpointManifestActivity() {
      Properties apiProps=null;
      Properties props=null;
      ServiceManager manager=null;
      ServiceManagerFactory factory=null;
      String fEndpoint=null;
      String tEndpoint=null;
      String template=null;
      String server=null;
      
      factory=new ServiceManagerFactory();
      manager=factory.getServiceManager();
      props=manager.loadProperties();
      apiProps=manager.loadAPIProperties();
      server=props.getProperty(ServiceManager._CONFIG_KEY_SERVER);
      assert server != null;
      template=apiProps.getProperty(ServiceManager._API_MANIFEST_KEY);
      assert template != null;
      fEndpoint=manager.getServiceEndpoint(OperationType.MANIFEST_ACTIVITY);
      assert fEndpoint != null;
      tEndpoint=MessageFormat.format(template, new Object[]{server});
      assert tEndpoint != null;
      assert fEndpoint.equals(tEndpoint);
   }
   
   @Test(dependsOnMethods={"testLoadProperties"})
   public void testGetServiceEndpointRouteStatistics() {
      Properties apiProps=null;
      Properties props=null;
      ServiceManager manager=null;
      ServiceManagerFactory factory=null;
      String fEndpoint=null;
      String tEndpoint=null;
      String template=null;
      String server=null;
      
      factory=new ServiceManagerFactory();
      manager=factory.getServiceManager();
      props=manager.loadProperties();
      apiProps=manager.loadAPIProperties();
      server=props.getProperty(ServiceManager._CONFIG_KEY_SERVER);
      assert server != null;
      template=apiProps.getProperty(ServiceManager._API_ROUTE_STATISTICS_KEY);
      assert template != null;
      fEndpoint=manager.getServiceEndpoint(OperationType.ROUTE_STATISTICS);
      assert fEndpoint != null;
      tEndpoint=MessageFormat.format(template, new Object[]{server});
      assert tEndpoint != null;
      assert fEndpoint.equals(tEndpoint);
   }
   
   @Test(dependsOnMethods={"testLoadProperties"})
   public void testGetServiceEndpointSet() {
      Properties apiProps=null;
      Properties props=null;
      ServiceManager manager=null;
      ServiceManagerFactory factory=null;
      String fEndpoint=null;
      String tEndpoint=null;
      String template=null;
      String server=null;
      
      factory=new ServiceManagerFactory();
      manager=factory.getServiceManager();
      props=manager.loadProperties();
      apiProps=manager.loadAPIProperties();
      server=props.getProperty(ServiceManager._CONFIG_KEY_SERVER);
      assert server != null;
      template=apiProps.getProperty(ServiceManager._API_ADD_KEY);
      assert template != null;
      fEndpoint=manager.getServiceEndpoint(OperationType.SET);
      assert fEndpoint != null;
      tEndpoint=MessageFormat.format(template, new Object[]{server});
      assert tEndpoint != null;
      assert fEndpoint.equals(tEndpoint);
   }
}