package com.myolq.myexam.ormlite.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2017/3/15.
 */
@DatabaseTable(tableName = "single")
public class SingleBean {

    //主键：交易所编号+合约编号
    @DatabaseField(columnName = "singleId",id = true)
    private Long singleId;
    @DatabaseField(columnName = "titleId")
    private Long titleId;
    @DatabaseField(columnName = "titleName")
    private String titleName;
    @DatabaseField(columnName = "optionA")
    private String optionA;
    @DatabaseField(columnName = "optionB")
    private String optionB;
    @DatabaseField(columnName = "optionC")
    private String optionC;
    @DatabaseField(columnName = "optionD")
    private String optionD;
    @DatabaseField(columnName = "result")
    private String result;
    @DatabaseField(columnName = "type")
    private String type;
    @DatabaseField(columnName = "updateData")
    private String updateData;

    public Long getSingleId() {
        return singleId;
    }

    public void setSingleId(Long singleId) {
        this.singleId = singleId;
    }

    public Long getTitleId() {
        return titleId;
    }

    public void setTitleId(Long titleId) {
        this.titleId = titleId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdateData() {
        return updateData;
    }

    public void setUpdateData(String updateData) {
        this.updateData = updateData;
    }
}
