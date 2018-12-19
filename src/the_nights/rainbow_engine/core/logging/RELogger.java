/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the_nights.rainbow_engine.core.logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import the_nights.rainbow_engine.core.Engine;

/**
 *
 * @author Stephanie
 */
public class RELogger {

    private static DecimalFormat df2 = new DecimalFormat("[0000.00]");
    private static SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
    private static final long startTime = System.nanoTime();
    private static Date dNow = new Date( );   
    
    public static void writelog(String Message, Object caller)
    {
        writelog(Message, caller.getClass().getSimpleName());
    }
    public static void writelog(String Message, String caller)
    {         
        Message = Message.toLowerCase();
        Message = Message.trim();
        long time = System.nanoTime() - startTime;
        String msg = df2.format(time / Engine.NANOSEC_TO_SEC) + " [ " + caller + " ] : " + Message;
        writeToLog(msg);       
        System.out.println(msg);        
    }
    private static void writeToLog(String msg) {
        try {            
            FileWriter fw = new FileWriter(ft.format(dNow)+"run.rlog", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(msg);
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
