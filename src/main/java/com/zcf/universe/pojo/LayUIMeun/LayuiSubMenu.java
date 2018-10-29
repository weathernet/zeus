package com.zcf.universe.pojo.LayUIMeun;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class LayuiSubMenu {
    @JsonIgnore
    private Integer id;
    @JsonIgnore
    private Integer subMenuId;
    private String name;
    private String title;
    private String jump;

}