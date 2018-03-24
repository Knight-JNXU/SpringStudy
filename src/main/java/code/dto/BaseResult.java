package code.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * json返回结果
 * 
 * @author knightjxnu
 *
 * @param <T>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResult<T> implements Serializable{

    private static final long serialVersionUID = -4185151304730685014L;

    private boolean success;

    private T data;

    public BaseResult(boolean success, T data){
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess(){
        return success;
    }

    public void setSuccess(boolean success){
        this.success = success;
    }

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }

    @Override
    public String toString(){
        return "BaseResult [success=" + success + ", data=" + data + "]";
    }

}
