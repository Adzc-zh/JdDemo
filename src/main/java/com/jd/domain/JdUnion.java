package com.jd.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Adzc
 * @date 2023/7/19 19:03
 */
@Component
@Data
public class JdUnion {

    @Value("${jdunion.appkey}")
    private String appKey;

    @Value("${jdunion.accesstoken}")
    private String accessToken;

}
