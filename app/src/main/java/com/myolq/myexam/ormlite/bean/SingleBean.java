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

    @DatabaseField(columnName = "fraction")
    private String fraction;
    @DatabaseField(columnName = "objectId")
    private String objectId;

    @DatabaseField(columnName = "updatedAt")
    private String updatedAt;


    public SingleBean() {
    }

    public SingleBean(Long titleId, String titleName, String optionA, String optionB, String optionC, String optionD, String result, String type, String fraction, String objectId, String updatedAt) {
        this.titleId = titleId;
        this.titleName = titleName;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.result = result;
        this.type = type;
        this.fraction = fraction;
        this.objectId = objectId;
        this.updatedAt = updatedAt;
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

    @Override
    public String toString() {
        return "SingleBean{" +
                "singleId=" + singleId +
                ", titleId=" + titleId +
                ", titleName='" + titleName + '\'' +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                ", result='" + result + '\'' +
                ", type='" + type + '\'' +
                ", fraction='" + fraction + '\'' +
                ", objectId='" + objectId + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
