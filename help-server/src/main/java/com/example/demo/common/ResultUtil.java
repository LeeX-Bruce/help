package com.example.demo.common;

/**
 * @author LMH
 * @date 2022/4/15 1:18
 * @description 通用返回状态码工具类
 */

public class ResultUtil {

    //成功并返回数据
    public static Result success(Object object){
        Result result = new Result();

        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);

        return result;
    }

    //成功但不带数据
    public static Result success(){
        return success(null);
    }

    //失败
    public static Result error(Integer code,String msg){
        Result result = new Result();

        result.setCode(code);
        result.setMsg(msg);

        return result;
    }
}