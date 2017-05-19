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

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.wildstartech.dispatchtrack.Localization;

/**
 * <h1>Error Code Summary</h1>
 * <p>Below is a list of the general HTTP response codes you can expect to see
 * from the invocation of the web-based API request. These response codes are 
 * common to each of the different API requests you are performing.</p>
 *  
 * <table>
 *    <tr>
 *       <th>Response Code</th>
 *       <th>Description</th>
 *    </tr>
 *    <tr>
 *       <td>200</td>
 *       <td>
 *          Web API request completed successfully.
 *       </td>
 *    </tr>
 *    <tr>
 *       <td>401</td>
 *       <td>
 *           <p>Error condition caused by one or more of the following 
 *           scenarios.</p>
 *           <ul>
 *             <li>
 *                The <code>api_key</code> parameter was missing from the 
 *                query string associated with the web request. Or a value
 *                is specified for the parameter, but it is invalid.
 *             </li>
 *             <li>
 *                The <code>code</code> parameter was missing from the 
 *                query string associated with the web request. Or a value
 *                is specified for the parameter, but it is invalid. 
 *             </li>                
 *           </ul> 
 *       </td>
 *    </tr>
 * </table>
 * @author Derek Berube, Wildstar Technologies, LLC.
 * @version 0.1
 */
public class WebExportActivityWorker extends ExportActivityWorker {
   private static final String _CLASS=WebExportActivityWorker.class.getName();
   private static final Logger logger=Logger.getLogger(_CLASS);
   
   public static final String _RESOURCE_BUNDLE=
      "com.wildstartech.dispatchtrack.spi.xml.WebExportActivityWorkerMessages";
   
   private String apiKey="";
   private String code="";
   private String endpoint="";
   
   /**
    * Default, no-argument constructor.
    */
   public WebExportActivityWorker() {
      logger.entering(_CLASS, "WebWorkerBase()");
      logger.exiting(_CLASS, "WebWorkerBase()");      
   }
   
   public WebExportActivityWorker(String endpoint, String apiKey, String code) {
      logger.entering(_CLASS, "WebWorkerBase(String,String,String)",
            new Object[] {endpoint, apiKey, code});
      setEndPoint(endpoint);
      setApiKey(apiKey);
      setCode(code);
      logger.exiting(_CLASS, "WebWorkerBase(String,String,String)");
   }
   
   /* ********** BEGIN: Accessor Methods **********/
   /**
    * Store the endpoint template.
    * 
    * @param endpoint
    */
   public void setEndPoint(String endpoint) {
      this.endpoint=endpoint;
   }
   protected String getEndPoint() {
      logger.entering(_CLASS, "getEndPoint()");
      logger.exiting(_CLASS, "getEndPoint()",this.endpoint);
      return this.endpoint;
   }
   /**
    * Store the API Key
    * @param apiKey
    */
   public void setApiKey(String apiKey) {
      this.apiKey=apiKey;
   }
   protected String getApiKey() {
      logger.entering(_CLASS, "getApiKey()");
      logger.exiting(_CLASS, "getApiKey()",this.apiKey);
      return this.apiKey;
   }
   /**
    * Store the code
    * @param code
    */
   public void setCode(String code) {
      this.code=code;
   }
   protected String getCode() {
      logger.entering(_CLASS, "getCode()");
      logger.exiting(_CLASS, "getCode()",this.code);
      return this.code;
   }
   /* ********** END: Accessor Methods **********/
   
   /* ********** BEGIN: Utility Methods **********/
   /**
    * Builds a web address to be used by the web worker
    * 
    * @return the well-formed web address that should be used when invoking the
    * web-based API call.
    */
   public final URL buildURL() {
      logger.entering(_CLASS, "buildURL()");
      Map<String,String> parameters=null;
      String endpoint="";
      String msg="";
      String paramValue="";
      StringBuilder sb=null;
      URL webAddress=null;
      
      sb=new StringBuilder(80);
      sb.append(getEndPoint());
      sb.append("?api_key=").append(getApiKey());
      sb.append("&code=").append(getCode());
      parameters=getParameterMap();
      if (!parameters.isEmpty()) {
         for(String paramName: parameters.keySet()) {
            if (!paramName.isEmpty()) {
               // The parameter map is not empty
               paramValue=parameters.get(paramName);
               try {
                  // Encode the parameter names
                  paramName=URLEncoder.encode(paramName,"UTF-8");
                  // Encode the parameter values
                  if ((paramValue != null) && (!paramValue.isEmpty())) {
                     paramValue=URLEncoder.encode(paramValue,"UTF-8");
                  } // END if ((paramValue != null) && (!paramValue.isEmpty()))                  
               } catch (UnsupportedEncodingException ex) {
                  // No-Op
                  logger.severe("This shouldn't happen.");
               } // END try/catch
               sb.append("&").append(paramName).append("=").append(paramValue);               
            } // END if (!paramName.isEmpty())
         } // END for(String paramName: parameters.keySet())
      } // END if (!parameters.isEmpty())
      endpoint=sb.toString();
      try {
         webAddress=new URL(endpoint);         
      } catch (MalformedURLException ex) {
         msg=Localization.getString(
            "WebWorkerMessages", 
            WebExportActivityWorkerMessages.ERR_BAD_ENDPOINT, 
            null, 
            null, 
            new Object[] {endpoint});
         logger.log(Level.SEVERE,msg,ex);
      } // END try/catch
      
      logger.exiting(_CLASS, "buildURL()",webAddress);
      return webAddress;
   }
   
   // ********** parameterMap
   /**
    * Returns a list of additional parameters that should be included in the 
    * web address to which API calls are directed.
    * 
    * @return An empty {@code Map} of there are no additional parameters. 
    * Otherwise a {@code Map} containing {@code parameterName} and 
    * {@code parameterValue} pairs.
    */
   public Map<String,String> getParameterMap() {
      logger.entering(_CLASS, "getParameterMap()");
      Map<String,String> map=null;
      
      map=new TreeMap<String,String>();
      logger.entering(_CLASS, "getParameterMap()",map);
      return map;
   }
   // ********** doWork
   /**
    * Perform the work associated with the web service call.
    */
   public final void doWork() {
      logger.entering(_CLASS, "doWork()");
      HttpURLConnection connection=null;
      InputStream in=null;
      URL url=null;
      
      
      url=buildURL();
      try {
         connection=(HttpURLConnection) url.openConnection();
         in=connection.getInputStream();
         parse(in);
         System.out.println("HttpResponseCode: "+connection.getResponseCode());         
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
   
   //********** Temporary
   
}