package com.nt.sbeans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("emp")
@ConfigurationProperties(prefix = "emp.info")
@Data
public class Employee {

    private Integer empId;
    private String empName;
    private String[] color;
    private List<String> nickName;
    private Set<Long> mobileNo;
    private Map<String, Object> idDetails;
    private Company company;
}
