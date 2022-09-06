package com.li.utils;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: lishengxiang
 * Date: 2022/3/1
 * Time: 11:03
 * Description:
 */
public class ExcelUitls {
    public static void main(String[] args) throws Exception {
        readAndWrite();
    }

    private static void readAndWrite() throws IOException, BiffException, WriteException {
        File xlsFile = new File("111.xls");
        File outputFile = new File("细类.xls");
        // 获得工作簿对象
        Workbook workbook = Workbook.getWorkbook(xlsFile);
        WritableWorkbook workbook2 = Workbook.createWorkbook(outputFile);
        // 创建一个工作表
        WritableSheet writeSheet = workbook2.createSheet("sheet1", 0);
        // 获得所有工作表
        Sheet[] sheets = workbook.getSheets();
        // 遍历工作表
        if (sheets != null)
        {
            for (Sheet sheet : sheets)
            {
                // 获得行数
                int rows = sheet.getRows();
                // 获得列数
                int cols = sheet.getColumns();
                // 读取数据
                int countRow=0;
                for (int row = 0; row < rows; row++)
                {
                    if ("".equals(sheet.getCell(7, row).getContents())){
                        continue;
                    }
                    for (int col = 0; col < cols; col++) {
                        writeSheet.addCell(new Label(col, countRow, sheet.getCell(col, row).getContents()));
                    }


                    try{
                        String contents = sheet.getCell(0, row).getContents();
                        String sub = contents.substring(0, 6) + "00";
                        writeSheet.addCell(new Label(cols, countRow, sub));
                    } catch (Exception e) {
                        System.out.println("第几行"+row);
                    }

                    countRow++;
                }
            }
        }
        workbook2.write();
        workbook2.close();
        workbook.close();
    }

    private static void excelWrite() throws IOException, WriteException {
        File xlsFile = new File("");
        // 创建一个工作簿
        WritableWorkbook workbook = Workbook.createWorkbook(xlsFile);
        // 创建一个工作表
        WritableSheet sheet = workbook.createSheet("sheet1", 0);
        for (int row = 0; row < 10; row++)
        {
            for (int col = 0; col < 10; col++)
            {
                // 向工作表中添加数据
                sheet.addCell(new Label(col, row, "data" + row + col));
            }
        }
        workbook.write();
        workbook.close();
    }

    private static void excelRead(String fileName) throws Exception {
        File xlsFile = new File(fileName);
        // 获得工作簿对象

        Workbook workbook = Workbook.getWorkbook(xlsFile);
        // 获得所有工作表
        Sheet[] sheets = workbook.getSheets();
        // 遍历工作表
        if (sheets != null)
        {
            for (Sheet sheet : sheets)
            {
                // 获得行数
                int rows = sheet.getRows();
                // 获得列数
                int cols = sheet.getColumns();
                // 读取数据
                for (int row = 0; row < rows; row++)
                {
                    for (int col = 0; col < cols; col++)
                    {
                        System.out.printf("%10s", sheet.getCell(col, row)
                                .getContents());
                    }
                    System.out.println();
                }
            }
        }
        workbook.close();
    }
}
