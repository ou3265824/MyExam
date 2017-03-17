package com.myolq.myexam.ormlite.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2017/3/15.
 */
@DatabaseTable(tableName = "many")
public class ManyBean {



    //主键：交易所编号+合约编号
    @DatabaseField(columnName = "manyId",id = true)
    private String objectId;
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

    @DatabaseField(columnName = "fraction")
    private String fraction;

    @DatabaseField(columnName = "updatedAt")
    private String updatedAt;


    public ManyBean() {
    }


    public String getFraction() {

        return fraction;
    }

    public void setFraction(String fraction) {
        this.fraction = fraction;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
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

}
