package com.example.poi.export;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Random;

public class ExportPassword {

    public static void main(String[] args) throws Exception {

        //PH80001
        //密码6个数字
        //数量 1万个

        XSSFWorkbook workbook = new XSSFWorkbook();
        // XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFSheet sheet = workbook.createSheet("卡号");
        int startLine = 1;
        XSSFCell cell = null;
        XSSFRow row = sheet.getRow(startLine);

        XSSFRow newRow = sheet.createRow(startLine);
        cell = newRow.createCell(0);
        cell.setCellValue("卡号");

        cell = newRow.createCell(1);
        cell.setCellValue("密码");

        String account = null;
        String password = null;

        int x = 1;
        int num = 80001;
        while (x < 10001) {

            account = "PH" + num;
            password = getPwd();

            newRow = sheet.createRow(startLine++);
            cell = newRow.createCell(0);
            cell.setCellValue(account);

            cell = newRow.createCell(1);
            cell.setCellValue(password);

            num++;
            x++;
        }

        File file = new File("t.xlsx");
        FileOutputStream fos = new FileOutputStream(file);

        workbook.write(fos);
        fos.close();

    }

    public static String getName(String i) {

        String x = "";
        StringBuilder sb = new StringBuilder(i);
        for (int j = 0; j < 6 - i.length(); j++) {
            sb.append("0");

        }

        return sb.toString();
    }

    public static String getPwd() {

        int pwd = (int) ((Math.random() * 9 + 1) * 100000);

        return String.valueOf(pwd);
    }

}
