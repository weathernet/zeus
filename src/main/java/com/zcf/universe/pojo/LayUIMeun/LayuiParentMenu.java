package com.zcf.universe.pojo.LayUIMeun;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class LayuiParentMenu {
    @JsonIgnore
    private Integer id;
    @JsonIgnore
    private Integer parentId;
    private String name;
    private String title;
    private String icon;

    private List<LayuiSubMenu> list;


}