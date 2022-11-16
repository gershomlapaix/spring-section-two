package com.lapaix.javaconfig;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;

@Configurable
@ComponentScan("com.lapaix.javaconfig")        // like in component scan in xml
public class SportsConfig {

}
