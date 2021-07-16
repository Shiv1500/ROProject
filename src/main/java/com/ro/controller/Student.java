package com.ro.controller;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Component
@Data
@JsonInclude(value = Include.NON_NULL)
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
private String sid;
private Integer ronum;
private String sname;
}
