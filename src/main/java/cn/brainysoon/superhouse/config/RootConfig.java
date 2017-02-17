package cn.brainysoon.superhouse.config;

import cn.brainysoon.superhouse.dao.DataConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by brainy on 17-2-17.
 */
@Configuration
@Import(value = {DataConfig.class})
public class RootConfig {
}
