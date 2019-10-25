package entity;

import java.io.Serializable;

/**
 * @Classname Result
 * @Date 2019/8/29 22:06
 * @Created by StevenZsh
 * @Description 返回结果实体类
 */
public class Result implements Serializable {

    private boolean success;
    private String message;

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Result() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
