/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.chiromobile.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import tools.utils.UserInfo;

/**
 *
 * @author rwandell
 */
public abstract class Error {

    public static void writeLog(HttpServletRequest request, UserInfo userInfo) {
        FileWriter fstream = null;
        String fileName = "medical.log";
        String blanks       = "                    ";
        try {
            if(userInfo != null) {
                fileName=userInfo.getDatabaseName() + ".log";
            }
            fstream = new FileWriter("C:\\medical_logs\\" + fileName, true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(userInfo.getDatabaseName() + blanks.substring(userInfo.getDatabaseName().length()) + " : " + new java.util.Date() + " - " + request.getRemoteAddr() + " - " + request.getRequestURI());
            for(Enumeration e=request.getParameterNames(); e.hasMoreElements();){
                String paramName=(String)e.nextElement();
                out.write(paramName + blanks.substring(paramName.length()) + ": " + request.getParameter(paramName));
            }
            out.write("");
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Error.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fstream.close();
            } catch (IOException ex) {
                Logger.getLogger(Error.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
