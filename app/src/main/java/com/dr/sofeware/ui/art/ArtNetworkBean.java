package com.dr.sofeware.ui.art;

import java.io.Serializable;
import java.util.List;

/**
 * @Description TODO
 * @systemUser admin
 * @Author DR.LHXY
 * @Date 11-13-2022 周日 17:02
 */

public class ArtNetworkBean implements Serializable {

    /**
     * code : 0
     * msg : success
     * data : {"img":"","waiting":"1m","imgUrls":[],"createTime":"2022-11-13 16:31:58","requestId":"d2b2ad4e91eb2520342870d92af91dd9","style":"二次元","text":"宁静的乡村","resolution":"1024*1024","taskId":8063362,"status":0}
     */

    private int code;
    private String msg;
    private DataBean data;

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public DataBean getData() {
        return data;
    }

    public static class DataBean implements Serializable {
        /**
         * img :
         * waiting : 1m
         * imgUrls : []
         * createTime : 2022-11-13 16:31:58
         * requestId : d2b2ad4e91eb2520342870d92af91dd9
         * style : 二次元
         * text : 宁静的乡村
         * resolution : 1024*1024
         * taskId : 8063362
         * status : 0
         */

        private String img;
        private String waiting;
        private String createTime;
        private String requestId;
        private String style;
        private String text;
        private String resolution;
        private int taskId;
        private int status;
        private List<?> imgUrls;


        public void setImg(String img) {
            this.img = img;
        }

        public void setWaiting(String waiting) {
            this.waiting = waiting;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public void setText(String text) {
            this.text = text;
        }

        public void setResolution(String resolution) {
            this.resolution = resolution;
        }

        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public void setImgUrls(List<?> imgUrls) {
            this.imgUrls = imgUrls;
        }

        public String getImg() {
            return img;
        }

        public String getWaiting() {
            return waiting;
        }

        public String getCreateTime() {
            return createTime;
        }

        public String getRequestId() {
            return requestId;
        }

        public String getStyle() {
            return style;
        }

        public String getText() {
            return text;
        }

        public String getResolution() {
            return resolution;
        }

        public int getTaskId() {
            return taskId;
        }

        public int getStatus() {
            return status;
        }

        public List<?> getImgUrls() {
            return imgUrls;
        }
    }
}
