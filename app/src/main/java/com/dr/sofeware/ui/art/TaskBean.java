package com.dr.sofeware.ui.art;

import java.io.Serializable;

/**
 * @Description TODO
 * @systemUser admin
 * @Author DR.LHXY
 * @Date 11-13-2022 周日 20:29
 */

public class TaskBean implements Serializable {

    /**
     * code : 0
     * msg : success
     * data : {"requestId":"c3e681050184c1c8d869bf22eb0562ff","taskId":8079623}
     */
    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * requestId : c3e681050184c1c8d869bf22eb0562ff
         * taskId : 8079623
         */

        private String requestId;
        private int taskId;

        public String getRequestId() {
            return requestId;
        }

        public void setRequestId(String requestId) {
            this.requestId = requestId;
        }

        public int getTaskId() {
            return taskId;
        }

        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }
    }
}
