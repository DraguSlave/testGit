/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PoiUtil
 * Author:   Administrator
 * Date:     19/5/9/0009 13:35
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.zerf.demo.poi.util;

import org.apache.poi.ss.usermodel.Cell;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 〈一句话功能简述〉<br>
 * 〈poi工具类〉
 *
 * @author Administrator
 * @create 19/5/9/0009
 * @since 1.0.0
 */
public class PoiUtil {
    private final static int CELL_TYPE_NUMERIC = 0;
    private final static int CELL_TYPE_STRING = 1;
    private final static int CELL_TYPE_FORMULA = 2;
    private final static int CELL_TYPE_BLANK = 3;
    private final static int CELL_TYPE_BOOLEAN = 4;
    private final static int CELL_TYPE_ERROR = 5;

    /**
     * 得到单元格值
     *
     * @param cell 单元格
     * @return Object
     */
    public static Object getCellValue(Cell cell) {
        Object value = null;
        switch (cell.getCellType()) {
            case CELL_TYPE_NUMERIC:
                value = cell.getNumericCellValue();
                break;
            case CELL_TYPE_STRING:
                value = cell.getStringCellValue();
                break;
            case CELL_TYPE_FORMULA:
                try {
                    value = String.valueOf(cell.getStringCellValue());
                } catch (IllegalStateException e) {
                    String valueOf = String.valueOf(cell.getNumericCellValue());
                    BigDecimal bd = new BigDecimal(Double.valueOf(valueOf));
                    bd = bd.setScale(2, RoundingMode.HALF_UP);
                    value = bd;
                }
                break;
            case CELL_TYPE_BLANK:
                value = "";
                break;
            case CELL_TYPE_BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
            case CELL_TYPE_ERROR:
                value = cell.getErrorCellValue();
                break;
            default:
                break;
        }
        return value;
    }
}