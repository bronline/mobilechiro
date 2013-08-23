/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.chiromobile.util;

import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;


/**
 *
 * @author rwandell
 */
public class BreadCrumb {
    public String page;
    public ArrayList paramList = new ArrayList();

    public BreadCrumb(String uri, HttpServletRequest request) {
        this.page = uri;
        setQueryString(request);

        for(Enumeration e=request.getParameterNames(); e.hasMoreElements();) {
            String param=(String)e.nextElement();
            String [] p = new String[2];
            p[0]=param;
            p[1]=request.getParameter(param);
            
            paramList.add(p);
        }
    }

    private void setQueryString(HttpServletRequest request) {
        java.util.ArrayList qsParm=new java.util.ArrayList();
        String queryString=request.getQueryString();
        String qsValue="";

        if(queryString != null) {
            while(queryString.contains("?") || queryString.contains("&") || queryString.length()>0 ) {
                if(queryString.indexOf("=")>-1) {
                    String [] p = new String[2];
                    String qParm=queryString.substring(0,queryString.indexOf("="));
                    queryString=queryString.substring(queryString.indexOf("=")+1);

                    p[0]=qParm;
                    if(!queryString.contains("&")) {
                         qsValue=queryString.substring(0);
                         queryString="";
                    } else {
                        qsValue=queryString.substring(0,queryString.indexOf("&"));
                        queryString=queryString.substring(queryString.indexOf("&")+1);
                    }

                    p[1]=qsValue;
                    paramList.add(p);
                } else {
                    queryString="";
                }
            }
        }
    }
}
