package com.li.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class GitLogHelper {

    public static ArrayList<String> getLogs(LocalDate date) throws IOException {
        ArrayList<String> logs = new ArrayList<>();
        try {
            Runtime runtime = Runtime.getRuntime();

            //获取git用户名
            Process nameProcess = runtime.exec("cmd /k git config user.name");
            BufferedReader nameReader = new BufferedReader(new InputStreamReader(nameProcess.getInputStream()));
            String name = nameReader.readLine();

            //查询日志
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String start = formatter.format(date.atStartOfDay());
            String end = formatter.format(date.atTime(23, 59, 59));
            Process p = runtime.exec(String.format("cmd /c git log --oneline --author=%s --after=\"%s\" --before=\"%s\" ", name, start, end));
            //取得命令结果的输出流
            InputStream fis = p.getInputStream();
            //用一个读输出流类去读
            InputStreamReader isr = new InputStreamReader(fis);
            //用缓冲器读行
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            //直到读完为止
            while ((line = br.readLine()) != null) {
                logs.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logs;
    }

    private static void print(LocalDate date, ArrayList<String> logs, int weekIndex) {
        Collections.reverse(logs);
        String pre = String.format("日期%s  星期%s  ", date, weekIndex);
        if (logs.isEmpty()) {
            System.out.println(pre.concat("没有提交记录"));
            return;
        }
        int count = 1;
        StringBuilder stringbuilder = new StringBuilder();
        for (String log : logs) {
            int index1 = log.indexOf(":");
            int index2 = log.indexOf("：");
            int index3 = log.indexOf(" ");
            log = count + log.substring(index1 > 0 ? index1 : index2 > 0 ? index2 : index3) + "\n";
            stringbuilder.append(log);
            count++;
        }
        System.out.println(pre.concat("生成的日志："));
        System.out.println(stringbuilder);
    }

    public static void main(String[] args) throws IOException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        LocalDate sunDate = LocalDate.now().minusDays(day);
        for (int i = 1; i < 8; i++) {
            LocalDate date = sunDate.plusDays(i);
            ArrayList<String> logs = getLogs(date);
            print(date, logs, i);
        }
    }

}
