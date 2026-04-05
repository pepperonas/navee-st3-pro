package com.uz.navee.ui.mine.bean;

import java.util.List;

/* loaded from: classes3.dex */
public class CarListBean {
    private int code;
    private List<Data> data;
    private String msg;

    public class Data {
        private int bindType;
        private String carNo;
        private String mac;
        private Model model;

        public Data() {
        }

        public int getBindType() {
            return this.bindType;
        }

        public String getCarNo() {
            return this.carNo;
        }

        public String getMac() {
            return this.mac;
        }

        public Model getModel() {
            return this.model;
        }

        public void setBindType(int i6) {
            this.bindType = i6;
        }

        public void setCarNo(String str) {
            this.carNo = str;
        }

        public void setMac(String str) {
            this.mac = str;
        }

        public void setModel(Model model) {
            this.model = model;
        }
    }

    public class Model {
        private String book;
        private String category;
        private int id;
        private String language;
        private String maxImg;
        private String minImg;
        private String model;
        private String name;
        private String series;
        private String subtitle;
        private String type;
        private String video;

        public Model() {
        }

        public String getBook() {
            return this.book;
        }

        public String getCategory() {
            return this.category;
        }

        public int getId() {
            return this.id;
        }

        public String getLanguage() {
            return this.language;
        }

        public String getMaxImg() {
            return this.maxImg;
        }

        public String getMinImg() {
            return this.minImg;
        }

        public String getModel() {
            return this.model;
        }

        public String getName() {
            return this.name;
        }

        public String getSeries() {
            return this.series;
        }

        public String getSubtitle() {
            return this.subtitle;
        }

        public String getType() {
            return this.type;
        }

        public String getVideo() {
            return this.video;
        }

        public void setBook(String str) {
            this.book = str;
        }

        public void setCategory(String str) {
            this.category = str;
        }

        public void setId(int i6) {
            this.id = i6;
        }

        public void setLanguage(String str) {
            this.language = str;
        }

        public void setMaxImg(String str) {
            this.maxImg = str;
        }

        public void setMinImg(String str) {
            this.minImg = str;
        }

        public void setModel(String str) {
            this.model = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setSeries(String str) {
            this.series = str;
        }

        public void setSubtitle(String str) {
            this.subtitle = str;
        }

        public void setType(String str) {
            this.type = str;
        }

        public void setVideo(String str) {
            this.video = str;
        }
    }

    public int getCode() {
        return this.code;
    }

    public List<Data> getData() {
        return this.data;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i6) {
        this.code = i6;
    }

    public void setData(List<Data> list) {
        this.data = list;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
