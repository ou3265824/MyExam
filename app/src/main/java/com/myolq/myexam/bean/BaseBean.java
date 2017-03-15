package com.myolq.myexam.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/15.
 */

public class BaseBean {


    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * createdAt : 2017-03-14 14:22:47
         * fraction : 1.0
         * objectId : VCxp000G
         * optionA : A. 3.0
         * optionB : B
         * optionC : C. 2.5
         * optionD : D. 2.0
         * result : B
         * titleId : 1
         * titleName : 1. 起立杆塔或其他构件的吊点固定绳(千斤绳)，钢丝绳安全系数K不小于(   )。 (1.0分)
         * type : 1
         * updatedAt : 2017-03-14 23:47:23
         */

        private String createdAt;
        private String fraction;
        private String objectId;
        private String optionA;
        private String optionB;
        private String optionC;
        private String optionD;
        private String result;
        private int titleId;
        private String titleName;

        @Override
        public String toString() {
            return "ResultsBean{" +
                    "createdAt='" + createdAt + '\'' +
                    ", fraction='" + fraction + '\'' +
                    ", objectId='" + objectId + '\'' +
                    ", optionA='" + optionA + '\'' +
                    ", optionB='" + optionB + '\'' +
                    ", optionC='" + optionC + '\'' +
                    ", optionD='" + optionD + '\'' +
                    ", result='" + result + '\'' +
                    ", titleId=" + titleId +
                    ", titleName='" + titleName + '\'' +
                    ", type=" + type +
                    ", updatedAt='" + updatedAt + '\'' +
                    '}';
        }

        private int type;
        private String updatedAt;

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
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

        public int getTitleId() {
            return titleId;
        }

        public void setTitleId(int titleId) {
            this.titleId = titleId;
        }

        public String getTitleName() {
            return titleName;
        }

        public void setTitleName(String titleName) {
            this.titleName = titleName;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }
    }
}
