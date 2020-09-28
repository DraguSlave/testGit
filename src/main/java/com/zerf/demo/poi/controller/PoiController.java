/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PoiController
 * Author:   Administrator
 * Date:     19/4/30/0030 8:58
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.poi.controller;

import com.zerf.demo.poi.entity.Staff;
import com.zerf.demo.poi.service.StaffService;
import com.zerf.demo.poi.util.PoiUtil;
import io.swagger.annotations.Api;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈poi导出导入实例〉
 *
 * @author Administrator
 * @create 19/4/30/0030
 * @since 1.0.0
 */
@Controller
public class PoiController {
    @Autowired
    private StaffService staffService;

    @RequestMapping(value = "/out")
    public void outStaff(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //声明一个工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();
        //自动换行
        XSSFCellStyle setBorder = workbook.createCellStyle();
        //生成一表格
        XSSFSheet sheet = workbook.createSheet("雇员名单");
        List<Staff> list = staffService.list();
        //行
        XSSFRow rowFirst = sheet.createRow(0);
        //列
        rowFirst.createCell(0).setCellValue("id");
        rowFirst.createCell(1).setCellValue("name");

        //循环遍历list,构建excel表格
        for (int i = 0; i < list.size(); i++) {
            //行
            XSSFRow row = sheet.createRow(i + 1);

            //列
            row.createCell(0).setCellValue(list.get(i).getId());
            row.createCell(1).setCellValue(list.get(i).getName());

        }

        //告诉浏览器什么文件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        //下载文件默认名称
        response.setHeader("Content-disposition", "attachment;filename=122.xlsx");
        workbook.write(response.getOutputStream());
    }

    @RequestMapping(value = "/import")
    public String importStaff(MultipartFile file) {
        System.out.println("------------------");
        System.out.println(file.getResource().getFilename());
        List<Staff> staffList = new ArrayList<>();

        try {
            Workbook workbook = WorkbookFactory.create(file.getInputStream());
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {
                Row row = sheet.getRow(i);
                if (row != null && row.getLastCellNum() != 0) {
                    Integer id = ((Double) PoiUtil.getCellValue(row.getCell(0))).intValue();
                    String name = (String) PoiUtil.getCellValue(row.getCell(1));
                    staffList.add(new Staff(id, name));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        System.out.println(staffList);
        System.out.println(staffService.saveByList(staffList) + "条记录导入成功");
        System.out.println(staffService.list());
        return "redirect:/index";
    }

    @RequestMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("staffList", staffService.list());
        return "import";
    }
}