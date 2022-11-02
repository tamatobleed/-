package com.zkl.i_learn.Controller;

import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/calculate")
public class calculateController {
    @GetMapping("/get")
    public R get(){
        return R.failed("shibai");
    }
}
