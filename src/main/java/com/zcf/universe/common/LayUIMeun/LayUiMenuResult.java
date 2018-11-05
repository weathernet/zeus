
package com.zcf.universe.common.LayUIMeun;

import lombok.Data;

import java.util.List;

@Data
public class LayUiMenuResult {
    private int code;
    private String msg;
    private List<LayuiParentMenu> data;

}